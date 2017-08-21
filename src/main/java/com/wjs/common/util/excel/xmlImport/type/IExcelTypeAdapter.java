package com.wjs.common.util.excel.xmlImport.type;

public interface IExcelTypeAdapter<T> {
	
	public final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";
	
	public T getVal(String comment) ;
}

