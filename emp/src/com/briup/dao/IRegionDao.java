package com.briup.dao;

import java.util.List;

import com.briup.model.Region;

public interface IRegionDao {
	int count() ;
	List<Region> findByPage(int pageSize,int pageNum);
}
