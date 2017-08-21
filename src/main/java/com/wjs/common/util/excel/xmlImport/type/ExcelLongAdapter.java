package com.wjs.common.util.excel.xmlImport.type;

public class ExcelLongAdapter implements IExcelTypeAdapter<Long> {


	@Override
	public Long getVal(String comment) {

		
		return Double.valueOf(comment).longValue();
	}

	
}

