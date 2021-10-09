package com.zxy.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
private int id;
private double price;
private int uid;
private String uname;
private Date time;
private String status;
private String pic;


public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public Order(int id, double price, int uid, String uname,
		Date time, String status) {
	super();
	this.id = id;
	this.price = price;
	this.uid = uid;
	this.uname = uname;
	this.time = time;
	this.status = status;
}
public Order(int id, double price, int uid, String uname,
		Date time, String status,String pic) {
	super();
	this.id = id;
	this.price = price;
	this.uid = uid;
	this.uname = uname;
	this.time = time;
	this.status = status;
	this.pic = pic;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getprice() {
	return price;
}
public void setprice(double price) {
	this.price = price;
}
public int getuid() {
	return uid;
}
public void setuid(int uid) {
	this.uid = uid;
}
public String getuname() {
	return uname;
}
public void setuname(String uname) {
	this.uname = uname;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Order [id=" + id + ", price=" + price + ", uid=" + uid + ", uname="
			+ uname + ", time=" + time + ", status=" + status + ", pic=" + pic
			+ "]";
}



}
