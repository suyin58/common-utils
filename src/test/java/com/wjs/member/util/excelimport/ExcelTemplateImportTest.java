package com.wjs.member.util.excelimport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.wjs.common.util.excel.ExcelXmlImport;
import com.wjs.member.BaseTest;
import com.wjs.member.dao.level.CustLevelMapper;

/**
 * 将当前目录下的资源文件，放到D盘下进行测试
 * 
 * spring.xml中需要增加bean的声明
 * <bean id="excelXmlImport" class="com.wjs.common.util.excel.ExcelXmlImport" />
   <bean id="springContext" class="com.wjs.common.context.SpringContext" lazy-init="false"/>
	
 * 
 * @author Silver
 * @date 2017年8月18日 下午5:12:02 
 * 
 *
 */
public class ExcelTemplateImportTest extends BaseTest {

	@Autowired
	ExcelXmlImport excel;

	@Autowired
	CustLevelMapper mapper;

	@Test
	@Rollback(false)
	public void test() {

		//		excel.importExcel("D:\\excel_table.xml", "D:\\excel_table.xls");

		//		excel.importExcel("D:\\excel_table.xml", "D:\\excel_table.csv");
	}

	@Test
	@Rollback(false)
	public void testExcel() {

		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new File("D:\\excel_table.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		InputStream inStream = null;
		try {
			inStream = new FileInputStream("D:\\excel_table.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		excel.importXLS(doc, inStream);

	}

	@Test
	@Rollback(false)
	public void testCSV() {

		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new File("D:\\excel_table.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		InputStream inStream = null;
		try {
			inStream = new FileInputStream("D:\\excel_table.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		excel.importCSV(doc, inStream);

	}
	


}
