package com.wjs.common.util.excel;	
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	
import com.wjs.common.context.SpringContext;
import com.wjs.common.exception.BaseException;
import com.wjs.common.util.excel.ExcelUtils;
import com.wjs.common.util.excel.MyCSVReader;
import com.wjs.common.util.excel.xmlImport.type.IExcelTypeAdapter;

/**
 * Excel模板导入
 * xml文件定义excel的导入格式，导入的数据库
 * @author Silver
 * @date 2017年8月17日 下午2:42:48 
 */
public class ExcelXmlImport {
	
	public static final String TYPE_CELLS = "cells";
	public static final String TYPE_ROWS = "rows";

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelXmlImport.class);
	
	
	
	public void importCSV(Document doc, InputStream inStream){


		//根据上述创建的输入流 创建工作簿对象
		MyCSVReader csv = null;
		try {
			csv = new MyCSVReader(inStream, Charset.forName("UTF-8"));
			
		} catch (Exception e) {
			LOGGER.error("xlsx read error", e);
			throw new BaseException(e.getMessage());
		}
		Element root = doc.getRootElement();

		List<Element> tables = root.elements();
		for (Element table : tables) {
			// xlsx格式的文件
			importCSV(table, csv);
		}
	
	}
	

	public void importCSV(Element xmlElement, MyCSVReader csv) {


		
//		System.out.println(xmlElement.asXML());
		String type = xmlElement.attributeValue("type");
		String object = xmlElement.attributeValue("object");
		String namespace = xmlElement.attributeValue("namespace");
		String sheetNo = xmlElement.attributeValue("sheetno");
		if(StringUtils.isEmpty(sheetNo)){
			sheetNo = "0";
		}
		
		
        //得到第sheetNum页 的sheet数据
		if(TYPE_CELLS.equals(type)){
			Class<?> claz = null; 
			Object obj = null;
			try {
				claz = Class.forName(object);
				obj = claz.newInstance(); 
			} catch (Exception e1) {
				LOGGER.error("无法反射对象:{}", object, e1);
				throw new BaseException("unknow object:" + object);
			}
			
			// 按单元格读取
			List<Element> propertys = xmlElement.elements();
			for (Element property : propertys) {
				Integer col = Integer.valueOf(property.attributeValue("col"));
				Integer row = Integer.valueOf(property.attributeValue("row"));
				String name = property.attributeValue("name");
				String adapter = property.attributeValue("adapter");
				String comment = csv.getCellStrValue(row, col);
				try {
					PropertyDescriptor pdDest = new PropertyDescriptor(name, claz);
					Method rM = pdDest.getWriteMethod();
					rM.invoke(obj, getAdapterVal(adapter, comment));
					
				} catch (Exception e) {
					LOGGER.error("属性设置异常:{}", name, e);
				}
//				System.out.println("name:" + name +" , val:"+ comment);
			}
//			System.out.println(obj);
			// 调用数据操作（mybatis） .insertSelective(CustLevel level);
			try {
				invokeInsert(namespace, claz, obj);
			} catch (Exception e) {
				LOGGER.error("反射dao操作失败", e);
				throw new BaseException("反射dao操作失败" + e.getMessage());
			}
			
		}else if(TYPE_ROWS.equals(type)){
			// 按行读取
			String startStr = xmlElement.attributeValue("start");
			Integer start = 0;
			if(StringUtils.isNotEmpty(startStr)){
				start = Integer.parseInt(startStr);
			}
			List<Element> propertys = xmlElement.elements();
			for (int row = start;; row++) {
				boolean breakTag = false;
				Class<?> claz = null; 
				Object obj = null;
				try {
					claz = Class.forName(object);
					obj = claz.newInstance(); 
				} catch (Exception e1) {
					LOGGER.error("无法反射对象:{}", object, e1);
					throw new BaseException("unknow object:" + object);
				}
				for (Element property : propertys) {
					Integer col = Integer.valueOf(property.attributeValue("col"));
					String name = property.attributeValue("name");
					String primary = property.attributeValue("primary");

					String comment = null;
					try {
						comment = csv.getCellStrValue(row, col);
					} catch (Exception e) {
						// cell not exist ingore
					}
					if ("true".equals(primary) && StringUtils.isEmpty(comment)) {
						breakTag = true;
						break;
					}
					
					String adapter = property.attributeValue("adapter");
					try {
						PropertyDescriptor pdDest = new PropertyDescriptor(name, claz);
						Method rM = pdDest.getWriteMethod();
						rM.invoke(obj, getAdapterVal(adapter, comment));
					} catch (Exception e) {
						LOGGER.error("属性设置异常:{}", name, e);
					}
					
//					System.out.print( name + ":" + comment +" \t");
				}
				
//				System.out.println();
				if(breakTag){
					break;
				}
				try {
					invokeInsert(namespace, claz, obj);
				} catch (Exception e) {
					LOGGER.error("反射dao操作失败", e);
					throw new BaseException("反射dao操作失败" + e.getMessage());
				}
			}
			
			
			
		}else{
			throw new BaseException("Unknow table type:" + type);
		}
		
	
		
	}


	public void importXLS(Document doc, InputStream inStream) {

		//根据上述创建的输入流 创建工作簿对象
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inStream);
		} catch (Exception e) {
			LOGGER.error("xlsx read error", e);
			throw new BaseException(e.getMessage());
		}
		Element root = doc.getRootElement();

		List<Element> tables = root.elements();
		for (Element table : tables) {
			// xlsx格式的文件
			importXLS(table, wb);
		}
	}
	
	
	public void importXLS(Element xmlElement ,Workbook wb){
		
//		System.out.println(xmlElement.asXML());
		String type = xmlElement.attributeValue("type");
		String object = xmlElement.attributeValue("object");
		String namespace = xmlElement.attributeValue("namespace");
		String sheetNo = xmlElement.attributeValue("sheetno");
		if(StringUtils.isEmpty(sheetNo)){
			sheetNo = "0";
		}
		
		
        //得到第sheetNum页 的sheet数据
        Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetNo));
		if(TYPE_CELLS.equals(type)){
			Class<?> claz = null; 
			Object obj = null;
			try {
				claz = Class.forName(object);
				obj = claz.newInstance(); 
			} catch (Exception e1) {
				LOGGER.error("无法反射对象:{}", object, e1);
				throw new BaseException("unknow object:" + object);
			}
			
			// 按单元格读取
			List<Element> propertys = xmlElement.elements();
			for (Element property : propertys) {
				Integer col = Integer.valueOf(property.attributeValue("col"));
				Integer row = Integer.valueOf(property.attributeValue("row"));
				String name = property.attributeValue("name");
				String adapter = property.attributeValue("adapter");
				String comment = ExcelUtils.getCellStrValue(sheet.getRow(row).getCell(col));
				try {
					PropertyDescriptor pdDest = new PropertyDescriptor(name, claz);
					Method rM = pdDest.getWriteMethod();
					rM.invoke(obj, getAdapterVal(adapter, comment));
					
				} catch (Exception e) {
					LOGGER.error("属性设置异常:{}", name, e);
				}
//				System.out.println("name:" + name +" , val:"+ comment);
			}
//			System.out.println(obj);
			// 调用数据操作（mybatis） .insertSelective(CustLevel level);
			try {
				invokeInsert(namespace, claz, obj);
			} catch (Exception e) {
				LOGGER.error("反射dao操作失败", e);
				throw new BaseException("反射dao操作失败" + e.getMessage());
			}
			
		}else if(TYPE_ROWS.equals(type)){
			// 按行读取
			String startStr = xmlElement.attributeValue("start");
			Integer start = 0;
			if(StringUtils.isNotEmpty(startStr)){
				start = Integer.parseInt(startStr);
			}
			List<Element> propertys = xmlElement.elements();
			for (int row = start;; row++) {
				boolean breakTag = false;
				Class<?> claz = null; 
				Object obj = null;
				try {
					claz = Class.forName(object);
					obj = claz.newInstance(); 
				} catch (Exception e1) {
					LOGGER.error("无法反射对象:{}", object, e1);
					throw new BaseException("unknow object:" + object);
				}
				for (Element property : propertys) {
					Integer col = Integer.valueOf(property.attributeValue("col"));
					String name = property.attributeValue("name");
					String primary = property.attributeValue("primary");

					String comment = null;
					try {
						comment = ExcelUtils.getCellStrValue(sheet.getRow(row).getCell(col));
					} catch (Exception e) {
						// cell not exist ingore
					}
					if ("true".equals(primary) && StringUtils.isEmpty(comment)) {
						breakTag = true;
						break;
					}
					
					String adapter = property.attributeValue("adapter");
					try {
						PropertyDescriptor pdDest = new PropertyDescriptor(name, claz);
						Method rM = pdDest.getWriteMethod();
						rM.invoke(obj, getAdapterVal(adapter, comment));
					} catch (Exception e) {
						LOGGER.error("属性设置异常:{}", name, e);
					}
					
//					System.out.print( name + ":" + comment +" \t");
				}
				
//				System.out.println();
				if(breakTag){
					break;
				}
				try {
					invokeInsert(namespace, claz, obj);
				} catch (Exception e) {
					LOGGER.error("反射dao操作失败", e);
					throw new BaseException("反射dao操作失败" + e.getMessage());
				}
			}
			
			
			
		}else{
			throw new BaseException("Unknow table type:" + type);
		}
		
	}

	private void invokeInsert(String namespace, Class<?> claz, Object obj) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		Class daoClaz = Class.forName(namespace);
		Object daoObject = SpringContext.getBean(daoClaz);
		Method method = daoClaz.getMethod("insertSelective", claz);
		method.invoke(daoObject, obj);
	}
	
	/**
	 * 获取属性值，类型转换
	 * @param adapter
	 * @param comment
	 * @return
	 * @author Silver 
	 * @date 2017年8月18日 上午9:45:08
	 */
	private Object getAdapterVal(String adapter, String comment) {

		if(StringUtils.isEmpty(adapter)){
			adapter ="com.wjs.common.util.excel.xmlImport.type.ExcelStringAdapter";
		}
		IExcelTypeAdapter typeAdapter;
		try {
			Class clz = Class.forName(adapter);
			typeAdapter = (IExcelTypeAdapter)clz.newInstance();
		} catch (Exception e) {
			LOGGER.error("属性值获取失败", e);
			throw new BaseException("属性获取失败:"+ e.getMessage());
		}
		
		return typeAdapter.getVal(comment);
	}

	public void importExcel(File xmlFile ,File excelFile){
		
		
		SAXReader reader = new SAXReader();   
		Document doc = null;
		try {
			doc = reader.read(xmlFile);
		} catch (DocumentException e) {
			LOGGER.error("xml template read error:{}", e.getMessage());
			throw new BaseException(e.getMessage());
		}   
		
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			LOGGER.error("excel file read error", e);
			throw new BaseException(e.getMessage());
		}
		
		if (excelFile.getName().toLowerCase().endsWith("xlsx") || excelFile.getName().toLowerCase().endsWith("xls")) {

			importXLS(doc, inStream);
		}else if(excelFile.getName().toLowerCase().endsWith("csv")){
			importCSV(doc, inStream);
		}
	}


	
	public void importExcel(String xmlFilePath ,String excelFilePath){
		
		importExcel(new File(xmlFilePath), new File(excelFilePath));
	}
	
	

}

