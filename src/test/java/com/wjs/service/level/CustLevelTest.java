package com.wjs.service.level;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.BaseTest;
import com.wjs.test.dao.level.CustLevelCopyMapper;
import com.wjs.test.model.level.CustLevelCopyCriteria;

public class CustLevelTest extends BaseTest{
	
	@Autowired
	CustLevelCopyMapper mapper;
	
	@Test
	public void test(){
		System.out.println(mapper.selectByExample(new CustLevelCopyCriteria()));
	}

}
