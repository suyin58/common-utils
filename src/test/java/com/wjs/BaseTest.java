package com.wjs;

import java.lang.reflect.Proxy;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 单元测试基类
 * 
 * @author suzhy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/test-spring-service-applicationContext.xml" })
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false) //可选，默认就是这个
@org.springframework.transaction.annotation.Transactional
public class BaseTest {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/test-spring-service-applicationContext.xml");
		String[] str = context.getBeanDefinitionNames();
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		for (String beanName : str) {
			//			System.out.println("beanName --> "+beanName);
			Object obj = context.getBean(beanName);
			if (obj instanceof Proxy) {
				Proxy proxyBean = (Proxy) obj;
				String beanClaz = proxyBean.toString();
				//				if (beanClaz.startsWith("com.hundsun.wjs.service.")) {
				String className = beanClaz.substring(0, beanClaz.indexOf("@"));
				//					System.out.println("className --> "+className);
				try {
					Class clz = Class.forName(className);
					Class[] clzInters = clz.getInterfaces();
					for (Class class1 : clzInters) {
						String papaName = class1.getName();
						if (papaName.startsWith("com.hundsun.wjs.service")) {
							//								  System.out.println("beanName --> "+beanName);
							// System.out.println("'s papa is "+ papaName);
							String papasNickName = papaName.substring(papaName.lastIndexOf(".") + 1);
							//								String shortName = papasNickName.substring(0, 1).toLowerCase() + papasNickName.substring(1, 2).toUpperCase() + papasNickName.substring(2);
							String shortName = papasNickName.substring(0, 1).toLowerCase() + papasNickName.substring(1);
							// System.out.println("'s papa nickname is "+ papasNickName);
							System.out.println("<dubbo:service interface=\"" + papaName + "\" ref=\"" + shortName + "\" registry=\"asRegistry\" timeout=\"10000\"/>");
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		//		}
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");
		System.out.println("***********************************************************");

	}

}
