package com.wjs.util.excelimport.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wjs.common.util.excel.xmlImport.type.IExcelTypeAdapter;

public class CsvDateAdapter implements IExcelTypeAdapter<Date> {

	@Override
	public Date getVal(String comment) {

		
		try {
			return new SimpleDateFormat("yyyy/M/D hh:mm").parse(comment);
		} catch (ParseException e) {
			return null;
		}
	}
	public static void main(String[] args) {
		try {
			System.out.println(new SimpleDateFormat("yyyy/M/D hh:mm").parse("2013/1/1  1:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
