package com.briup.model;

//信息载体，用来在各个模块和对象之间进行信息传递。
public class Region {
	private int id;
	private String name;
	public Region() {
	}
	public Region(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
