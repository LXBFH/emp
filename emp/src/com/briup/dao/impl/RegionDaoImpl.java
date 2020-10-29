package com.briup.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.briup.common.DBUtils;
import com.briup.dao.IRegionDao;
import com.briup.model.Region;

public class RegionDaoImpl implements IRegionDao {
	QueryRunner qr = new QueryRunner();
	public int count() {
		try(Connection conn = DBUtils.getConnection()){
			return qr.query(conn, "select count(*) from s_region", 
						new ScalarHandler<BigDecimal>(1)).intValue();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Region> findByPage(int pageSize,int pageNum){
try(Connection conn = DBUtils.getConnection()){
		return	qr.query(conn, "select id,name from ("
							+ " select id,name,rownum r "
							+ " from s_region) region"
							+ " where region.r between ? and ?",
					new BeanListHandler<Region>(Region.class),
					(pageNum-1)*pageSize+1,pageNum*pageSize);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
