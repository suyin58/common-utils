package com.wjs.common.context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.Assert;

import com.wjs.common.exception.BaseException;
import com.wjs.common.exception.ExNo;

/**
 * 功能说明: Spring上下文<br>
 * @author kanxh
 */
public class SpringContext extends ApplicationObjectSupport implements InitializingBean {

	/** bean存取器 */
	private static ApplicationContext beanAccessor = null;
	/** 消息存取器 */
	private static MessageSourceAccessor messageAccessor = null;
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception{
		SpringContext.beanAccessor = super.getApplicationContext();
		SpringContext.messageAccessor = super.getMessageSourceAccessor();
		Assert.notNull(beanAccessor, "ApplicationContext不能为空!");
		Assert.notNull(messageAccessor, "messageSourceAccessor不能为空!");
	}
	
	

	/**
	 * 根据名称获取Bean
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		try {
			return beanAccessor.getBean(beanName);
		}
		catch (Exception e) {
			throw new BaseException(ExNo.SYS_ERROR, e, "获取bean[" + beanName + "]失败");
		}
	}
	

	public static Object getBean(Class<?> daoClaz) {

		try {
			return beanAccessor.getBean(daoClaz);
		}
		catch (Exception e) {
			throw new BaseException(ExNo.SYS_ERROR, e, "获取bean[" + daoClaz + "]失败");
		}
	}

	/**
	 * 根据名称，类型获取Bean
	 * 
	 * @param beanName
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(String beanName, Class<T> requiredType) {
		try {
			return beanAccessor.getBean(beanName, requiredType);
		}
		catch (Exception e) {
			throw new BaseException(ExNo.SYS_ERROR, e, "获取bean[" + beanName + "]失败,指定type[" + requiredType + "]");
		}
	}

	/**
	 * 根据类型获取Bean Map
	 * 
	 * @param type
	 * @return
	 */
	public static <T> Map<String, T> getBeanMapOfType(Class<T> type) {
		try {
			return beanAccessor.getBeansOfType(type);
		}
		catch (Exception e) {
			throw new BaseException(ExNo.SYS_ERROR, e, "获取bean失败,指定type[" + type + "]");
		}
	}

	/**
	 * 根据类型获取Bean List
	 * 
	 * @param type
	 * @return
	 */
	public static <T> List<T> getBeanListOfType(Class<T> type) {
		Map<String, T> beanMap = getBeanMapOfType(type);
		List<T> list = new ArrayList<T>();
		if (MapUtils.isNotEmpty(beanMap)) {
			list.addAll(beanMap.values());
		}
		return list;
	}

	/**
	 * 根据类型获取Bean Array
	 * 
	 * @param type
	 * @return
	 */
	public static <T> T[] getBeanArrayOfType(Class<T> type) {
		List<T> list = getBeanListOfType(type);
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(type, list.size());
		array = list.toArray(array);
		return array;
	}

	/**
	 * 获取消息
	 * 
	 * @param code
	 *              消息编码
	 * @return
	 */
	public static String getMessage(String code) {
		return getMessage(code, new Object[] {});
	}

	/**
	 * 获取消息
	 * 
	 * @param code
	 *              消息编码
	 * @param args
	 *              消息参数
	 * @return
	 */
	public static String getMessage(String code, Object[] args) {
		try {
			return getMessage(code, args, code);
		}
		catch (Exception e) {
			throw new BaseException(ExNo.SYS_ERROR, e, "获取消息失败，编码[" + code + "]");
		}
	}

	/**
	 * 获取消息
	 * 
	 * @param code
	 *              消息编码
	 * @param args
	 *              消息参数
	 * @param defaultMessage
	 *              默认消息
	 * @return
	 */
	public static String getMessage(String code, Object[] args, String defaultMessage) {
		try {
			return messageAccessor.getMessage(code, args, defaultMessage);
		}
		catch (Exception e) {
			throw new BaseException(ExNo.SYS_ERROR, e, "获取消息失败，编码[" + code + "]，默认消息[" + defaultMessage + "]");
		}
	}



}
