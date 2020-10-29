package com.briup.service.impl;

import java.util.List;

import com.briup.common.BeanFactory;
import com.briup.dao.IRegionDao;
import com.briup.dao.impl.RegionDaoImpl;
import com.briup.model.PageInfo;
import com.briup.model.Region;
import com.briup.service.IRegionService;

public class RegionServiceImpl implements IRegionService{
	IRegionDao dao = (IRegionDao)BeanFactory.getBean(
			BeanFactory.REGION_DAO);
	public PageInfo<Region> findByPage(int pageSize,int pageNum){
		int total = dao.count();
		List<Region> list = 
				dao.findByPage(pageSize, pageNum);
		return new PageInfo<>(total, pageSize, pageNum, list);
	}
}
