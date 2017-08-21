package com.wjs.member.service.level;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjs.member.BaseTest;
import com.wjs.member.dao.level.CustLevelMapper;
import com.wjs.member.model.level.CustLevelCriteria;

public class CustLevelTest extends BaseTest{
	
	@Autowired
	CustLevelMapper mapper;
	
	@Test
	public void test(){
		System.out.println(mapper.selectByExample(new CustLevelCriteria()));
	}

}
