package com.wjs.common.util.excel.xmlImport.type;

public class ExcelIntegerAdapter implements IExcelTypeAdapter<Integer> {


	@Override
	public Integer getVal(String comment) {

		
		return Double.valueOf(comment).intValue();
	}

}

