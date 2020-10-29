package com.briup.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtils {
	private static Properties props = new Properties();
	private static DataSource ds;
	static {
		try {
			props.load(DBUtils.class.getResourceAsStream(
					"/db.properties"));
			ds = DruidDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
