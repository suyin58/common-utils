package com.wjs.common.util.excel.xmlImport.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelDateAdapter implements IExcelTypeAdapter<Date> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelDateAdapter.class);
	
	@Override
	public Date getVal(String comment) {

		
		try {
			return new SimpleDateFormat(IExcelTypeAdapter.DATE_PATTERN).parse(comment);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("日期格式转化错误:" + comment);
			return null;
		}
	}

}

