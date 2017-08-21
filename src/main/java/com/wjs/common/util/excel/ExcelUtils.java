package com.wjs.common.util.excel;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanMap;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;

import com.wjs.common.util.excel.xmlImport.type.IExcelTypeAdapter;

/**
 * 
 * @author liqiang05
 * 
 */
public class ExcelUtils {

	/**
	 * logger
	 */
	private static final Logger logger = Logger.getLogger(ExcelUtils.class);

	/**
	 * 设置列格式
	 * 
	 * @param sheet
	 * @param columnWidthList
	 */
	public static boolean setSheetStyle(Sheet sheet, List<Integer> columnWidthList) {
		if (sheet == null || columnWidthList == null) {
			return false;
		}
		// 设置所有列的宽度
		for (int indx = 0, iMax = columnWidthList.size(); indx < iMax; indx++) {
			Integer columnWidth = columnWidthList.get(indx);
			if (columnWidth == null) {
				continue;
			}
			sheet.setColumnWidth(indx, columnWidth.intValue() * 256);
		}
		return true;
	}

	/**
	 * 设置行信息
	 * 
	 * @param row
	 * @param rowObj
	 * @return
	 */
	public static boolean setRowInfo(Row row, Collection<Object> rowObj) {
		if (row == null || rowObj == null) {
			if (logger.isInfoEnabled()) {
				logger.info("Row:" + row + ",rowObj" + rowObj);
			}
			return false;
		}
		// 填充每一列数据
		int indxColumn = 0;
		for (Object object : rowObj) {
			Cell cell = row.createCell(indxColumn++);
			if (object == null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Row:" + row + ",Column:" + indxColumn + ",is empty");
				}
				continue;
			}
			String columnValue = object.toString();
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(columnValue);
		}
		return true;
	}

	/**
	 * 设置行信息
	 * 
	 * @param row
	 * @param rowObj
	 * @param convert
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean setRowInfo(Row row, Object rowObj, IExcelConvert convert) {
		if (row == null || rowObj == null) {
			if (logger.isInfoEnabled()) {
				logger.info("Row:" + row + ",rowObj" + rowObj);
			}
			return false;
		}
		try {
			Collection<Object> rowContent = null;
			if (convert != null) {
				rowContent = convert.convert(rowObj);
			} else if (rowObj instanceof Map) {
				rowContent = ((Map) rowObj).values();
			} else if (rowObj instanceof Collection) {
				rowContent = (Collection) rowObj;
			} else {
				rowContent = (new BeanMap(rowObj)).values();
			}
			if (rowContent == null || rowContent.isEmpty()) {
				if (logger.isDebugEnabled()) {
					logger.debug("Row:" + row + ",is empty");
				}
				return false;
			}
			return setRowInfo(row, rowContent);
		} catch (Throwable e) {
			logger.info(rowObj + "convertFailed,row:" + row, e);
			return false;
		}

	}

	/**
	 * 将数据写入excel
	 * 
	 * @param sheet
	 * @param columnWidth
	 * @param header
	 * @param content
	 * @return
	 */
	public static boolean setExcelInfo(Sheet sheet, List<Integer> columnWidth, List<String> header, List<?> rows) {
		return setExcelInfo(sheet, columnWidth, header, rows, null);
	}

	/**
	 * 将数据写入excel
	 * 
	 * @param sheet
	 * @param columnWidth
	 * @param header
	 * @param content
	 * @param converter
	 * @return
	 */
	public static boolean setExcelInfo(Sheet sheet, List<Integer> columnWidth, List<String> header, List<?> content, IExcelConvert converter) {
		if (sheet == null) {
			logger.info("sheet is null");
			return false;
		}
		// 设置sheet格式
		setSheetStyle(sheet, columnWidth);

		// 设置头信息
		int indxRow = 0;
		Row row = sheet.createRow(indxRow++);
		setRowInfo(row, header, null);

		// 如果内容为空 则退出
		if (content == null || content.isEmpty()) {
			logger.info("content is null,cannot write excel");
			return true;
		}
		for (Object rowContent : content) {
			row = sheet.createRow(indxRow++);
			setRowInfo(row, rowContent, converter);
		}
		return true;
	}

	/**
	 * 導出到excel
	 * 
	 * @param title
	 *        sheet Title
	 * @param columnWidthList
	 *        所有列的寬度,可以不指定
	 * @param content
	 *        內容, 每一項為一行,每一行內是List代表所有列
	 * @return
	 */
	public static Workbook setupXls(String title, List<Integer> columnWidthList, List<List<String>> content) {

		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet(title);
		if (columnWidthList != null) {
			// 设置所有列的宽度
			for (int indx = 0, iMax = columnWidthList.size(); indx < iMax; indx++) {
				Integer columnWidth = columnWidthList.get(indx);
				if (columnWidth == null) {
					continue;
				}
				sheet.setColumnWidth(indx, columnWidth.intValue() * 256);
			}
		}

		if (content == null || content.isEmpty()) {
			if (logger.isInfoEnabled()) {
				logger.info("content is null,cannot write excel,title:" + title);
			}
			return wb;
		}

		// 遍歷一行
		for (int indxRow = 0, iMaxRow = content.size(); indxRow < iMaxRow; indxRow++) {
			Row row = sheet.createRow(indxRow);
			List<String> rowContent = content.get(indxRow);
			if (rowContent == null || rowContent.isEmpty()) {
				if (logger.isDebugEnabled()) {
					logger.debug("Row:" + indxRow + ",is empty,title:" + title);
				}
				continue;
			}
			// 填充每一列数据
			for (int indxColumn = 0, iMaxColumn = rowContent.size(); indxColumn < iMaxColumn; indxColumn++) {
				Cell cell = row.createCell(indxColumn);
				String columnValue = rowContent.get(indxColumn);
				if (columnValue == null || columnValue.length() == 0) {
					if (logger.isDebugEnabled()) {
						logger.debug("Row:" + indxRow + ",Column:" + indxColumn + ",is empty,title:" + title);
					}
					continue;
				}
				cell.setCellValue(columnValue);
			}
		}
		return wb;
	}

	/**
	 * 加載Excel 默認實現方式
	 * 
	 * @param wb
	 * @return
	 */
	public static List<List<String>> loadXls(Workbook wb) {
		// 默認 只讀第一個sheet, 且從第二行開始遍歷,默认读取到最大列
		return loadXls(wb, 0, 1, 0);
	}

	/**
	 * 加载excel
	 * 
	 * @param wb
	 * @param sheetIndx
	 *        要加载excel的sheet页的index
	 * @param startRowIndx
	 *        要加载Row的index
	 * @param iMaxColumn
	 *        最大读到Cloumn的index
	 * @return List<List<>>
	 */
	public static List<List<String>> loadXls(Workbook wb, int sheetIndx, int startRowIndx, int iMaxColumn) {
		List<List<String>> resList = new ArrayList<List<String>>();
		if (wb == null || sheetIndx < 0 || startRowIndx < 0 || iMaxColumn < 0) {
			logger.error("param error,return empty list,Workbook:" + wb + ",sheetIndex:" + sheetIndx + ",startRowNo:" + startRowIndx + ",iMaxColumn:" + iMaxColumn);
			return resList;
		}
		Sheet sheet = wb.getSheetAt(sheetIndx);
		if (sheet == null) {
			logger.error("sheet is null,return empty list,Workbook:" + wb + ",sheetIndex:" + sheetIndx + ",startRowNo:" + startRowIndx);
			return resList;
		}

		// 從指定行開始遍歷
		for (int indxRow = startRowIndx, iMaxRow = sheet.getLastRowNum(); indxRow <= iMaxRow; indxRow++) {
			Row row = sheet.getRow(indxRow);
			if (row == null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Row is null,sheetIndex:" + sheetIndx + ",RowNo:" + indxRow);
				}
				continue;
			}
			List<String> rowContent = new ArrayList<String>();
			// 當最大列為0時 讀取最大CellNum
			if (iMaxColumn == 0) {
				iMaxColumn = row.getLastCellNum();
			}
			boolean hasContent = false;
			for (int indxColumn = 0; indxColumn < iMaxColumn; indxColumn++) {
				String cellValue = null;
				Cell cell = row.getCell(indxColumn);
				if (cell == null) {
					if (logger.isDebugEnabled()) {
						logger.debug("Cell is null,sheetIndex:" + sheetIndx + ",RowNo:" + indxRow + ",CellNo:" + indxColumn);
					}
				} else {
					cellValue = getCellStrValue(cell);
				}
				// 如果 读到的内容不是空 代表这行有数据
				if (cellValue != null && cellValue.length() > 0) {
					hasContent = true;
				}
				// 不论当前格是否有数据都加入.
				rowContent.add(cellValue);
			}
			// 这一行有内容 则加入
			if (hasContent) {
				resList.add(rowContent);
			}
		}
		return resList;
	}

	public static String getCellStrValue(Cell cell) {
		String res = "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			res = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			res = String.valueOf(cell.getBooleanCellValue());
			break;

		case Cell.CELL_TYPE_NUMERIC:
			// 日期格式也是存储
			if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式  
				Date date = cell.getDateCellValue();
				res = new SimpleDateFormat(IExcelTypeAdapter.DATE_PATTERN).format(date);
				
//				res = cell.getStringCellValue();
			} else if (cell.getCellStyle().getDataFormat() == 58) {
				// 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
				double value = cell.getNumericCellValue();
				Date date = org.apache.poi.ss.usermodel.DateUtil
								.getJavaDate(value);
				res = new SimpleDateFormat(IExcelTypeAdapter.DATE_PATTERN).format(date);
				
//				res = cell.getStringCellValue();
			} else {

				res = String.valueOf(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_FORMULA:
			res = String.valueOf(cell.getNumericCellValue());
			break;
		default:
			res = "";
			break;
		}
		return res;
	}

	/**
	 * 
	 * @Description: 将集合转换成字符串输出
	 * @param coll
	 * @return 设定文件
	 * @throws 异常说明
	 * @author albert.su suzy@malam.com
	 * @date 2014年5月7日 下午12:35:55
	 */
	public static String collectionToCsvString(Collection<?> coll) {
		if (CollectionUtils.isEmpty(coll)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<?> it = coll.iterator();
		while (it.hasNext()) {
			Object object = it.next();
			if (String.valueOf(object).matches("[0-9,\\.]+") || String.valueOf(object).contains(",")) {
				sb.append("\"\t");
				sb.append(object);
				sb.append("\"");
			} else {
				sb.append("\t");
				sb.append(object);
			}
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	// 以下为糯米的代码, 建议少用

	/**
	 * 从InputStream读取Excel workbook
	 * 
	 * @param ins
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static HSSFWorkbook readWorkbook(InputStream ins) throws IOException, FileNotFoundException {
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		BufferedInputStream bis = new BufferedInputStream(ins);
		byte[] by = new byte[512];
		int t = bis.read(by, 0, by.length);
		while (t > 0) {
			byteOS.write(by, 0, 512); // read 512
			t = bis.read(by, 0, by.length);
		}
		byteOS.close();
		InputStream byteIS = new ByteArrayInputStream(byteOS.toByteArray());
		HSSFWorkbook wbDest = new HSSFWorkbook(byteIS);
		return wbDest;
	}

	public static void writeToResponse(HttpServletResponse response, HSSFWorkbook wb, String fileName) throws IOException {
		response.setContentType("application/ms-download");
		response.setCharacterEncoding("gb2312");
		response.setHeader("Content-Disposition", "filename=" + fileName);
		OutputStream out = response.getOutputStream();
		wb.write(out);
		out.flush();
		out.close();
	}

	/**
	 * 判断单元格的格式
	 * 
	 * @param cell
	 *        单元格
	 * @return String 将excel各种单元格的类型转换为String类型
	 */
	public static String getCellStringValue(HSSFCell cell) {
		// 转换后单元格的值
		String value = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				value = cell.getRichStringCellValue().getString();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					value = sdf.format(date);
				} else {
					DecimalFormat formatter = new DecimalFormat("########");
					value = formatter.format(cell.getNumericCellValue());
				}
				break;

			case HSSFCell.CELL_TYPE_FORMULA:
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				value = String.valueOf(cell.getNumericCellValue());
				break;

			case HSSFCell.CELL_TYPE_BLANK:
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				break;
			default:
				break;
			}
		}
		return value;
	}

	/**
	 * 到出excel的Helper类
	 * 
	 * @author Administrator
	 * 
	 */
	public static class ExcelRowBuilder {

		private HSSFRow row;

		private short index = 0;

		public ExcelRowBuilder(HSSFRow row) {
			this.row = row;
		}

		@SuppressWarnings("deprecation")
		public ExcelRowBuilder addCell(String str) {
			HSSFCell cell = row.createCell(index++);
			cell.setCellValue(new HSSFRichTextString(str));
			return this;
		}

		@SuppressWarnings("deprecation")
		public ExcelRowBuilder addCell(long value) {
			HSSFCell cell = row.createCell(index++);
			cell.setCellValue(value);
			return this;
		}

		@SuppressWarnings("deprecation")
		public ExcelRowBuilder addCell(double value) {
			HSSFCell cell = row.createCell(index++);
			cell.setCellValue(value);
			return this;
		}
	}
}
