package com.wjs.common.util.excel.xmlImport.type;

import java.math.BigDecimal;

public class ExcelBigDecimalAdapter implements IExcelTypeAdapter<BigDecimal> {


	@Override
	public BigDecimal getVal(String comment) {

		
		return new BigDecimal(comment);
	}

}

