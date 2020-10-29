package com.briup.model;

import java.util.List;

public class PageInfo<T>{
	private int total; //记录的总条数。
	private int pageSize = 5; // 每页显示的条数
	private int currentPage; //当前页码。
	private int pages;// 总页数。
	private int firstPage = 1; //首页
	private int lastPage;  //最后一页页码
	private int prePage; //上一页页码
	private int nextPage; //下一页页码
	private boolean hasPrePage; 
	private boolean hasNextPage;
	private List<T> datas;
	public PageInfo(int total,int pageSize,
			int currentPage,List<T> datas) {
		this.total = total;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.datas = datas;
		this.pages = 
			total%pageSize==0?total/pageSize:total/pageSize+1;
		this.nextPage = currentPage>=pages?pages:currentPage+1;
		this.prePage = currentPage<=1?1:currentPage-1;
		this.hasNextPage = currentPage<pages;
		this.hasPrePage = currentPage>1;
		this.firstPage = 1;
		this.lastPage = pages;
	}
	
	public int getTotal() {
		return total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPages() {
		return pages;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public List<T> getDatas() {
		return datas;
	}
	
}
