package com.wjs.common.util.excel.xmlImport.type;

public class ExcelStringAdapter implements IExcelTypeAdapter<String> {


	@Override
	public String getVal(String comment) {

		
		return comment;
	}

}

