package com.wjs.common.util.excel.xmlImport.type;

public class ExcelDoubleAdapter implements IExcelTypeAdapter<Double> {


	@Override
	public Double getVal(String comment) {

		
		return Double.valueOf(comment);
	}

}

