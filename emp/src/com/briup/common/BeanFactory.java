package com.briup.common;

import java.io.IOException;
import java.util.Properties;

import com.briup.dao.impl.RegionDaoImpl;
import com.briup.service.impl.RegionServiceImpl;

public class BeanFactory {
	public static final String REGION_DAO = "regionDao";
	public static final String REGION_SERVICE = "regionService";
	private static Properties props = new Properties();
	static {
		try {
			props.load(BeanFactory.class.getResourceAsStream("/bean.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Object getBean(String name) {
		String clsName = props.getProperty(name);
		if(clsName!=null&&!"".equals(clsName)) {
			try {
				return Class.forName(clsName).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return null;
		/*if(name.equals(REGION_DAO)) {
			return new RegionDaoImpl();
		}else if(name.equals(REGION_SERVICE)) {
			return new RegionServiceImpl();
		}
		return null;*/
	}
}
