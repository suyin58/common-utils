package com.wjs.common.util.excel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class MyCSVReader extends CsvReader{
	
	private List<List<String>> data = new ArrayList<List<String>>(64);

	public MyCSVReader(InputStream inStream, Charset charSet) {
		
		super(inStream, charSet);
		try {
			while(readRecord()){
				List<String> rows = new ArrayList<String>(16);
				for (int i = 0; i < getColumnCount(); i++) {
					rows.add(get(i));
				}
				data.add(rows);
			}
		} catch (IOException e) {
			throw new RuntimeException("csv文件读取失败", e);
		}
	}
	
	public String getCellStrValue(int row, int col){
		
		return data.get(row).get(col);
	}


}

