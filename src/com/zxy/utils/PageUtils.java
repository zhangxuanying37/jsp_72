package com.zxy.utils;

import java.util.List;

public class PageUtils<T> {
private int beginRows;//起始行
private int pageSize;//每页大小
private int indexPage;//当前页码
private int totalPage;//总页码数
private long countRows;//总记录数
private List<T> beanList;
public List<T> getOrderList(){
	return beanList;
}
public void setOrderList(List<T> beaList) {
	// TODO Auto-generated method stub
this.beanList = beaList;
}
@Override
public String toString() {
	return "PageUtils [beginRows=" + beginRows + ", pageSize=" + pageSize
			+ ", indexPage=" + indexPage + ", totalPage=" + totalPage
			+ ", countRows=" + countRows + "]";
}

public int getTotalPage() {
	totalPage = (int) (countRows%pageSize==0?countRows/pageSize:countRows/pageSize+1);
	return totalPage;
}

public long getCountRows() {
	return countRows;
}

public void setCountRows(long countRows) {
	this.countRows = countRows;
}

public PageUtils() {
	super();
	// TODO Auto-generated constructor stub
}

public PageUtils(int beginRows, int pageSize, int indexPage) {
	super();
	this.beginRows = beginRows;
	this.pageSize = pageSize;
	this.indexPage = indexPage;
}

public int getBeginRows() {
	//获得起始行的方法
	beginRows = (indexPage-1)*pageSize;
	return beginRows;
}
public void setBeginRows(int beginRows) {
	this.beginRows = beginRows;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getIndexPage() {
	return indexPage;
}
public void setIndexPage(int indexPage) {
	this.indexPage = indexPage;
}

}

