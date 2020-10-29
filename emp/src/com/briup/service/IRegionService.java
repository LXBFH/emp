package com.briup.service;

import com.briup.model.PageInfo;
import com.briup.model.Region;

public interface IRegionService {
	PageInfo<Region> findByPage(int pageSize,int pageNum);
}
