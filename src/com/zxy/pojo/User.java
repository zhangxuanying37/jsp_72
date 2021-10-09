package com.zxy.pojo;

import java.io.Serializable;

public class User implements Serializable{
private int id;//需要对应表里面的字段
private String username;
private String userpwd;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String username, String userpwd) {
	super();
	this.id = id;
	this.username = username;
	this.userpwd = userpwd;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpwd() {
	return userpwd;
}
public void setUserpwd(String userpwd) {
	this.userpwd = userpwd;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", userpwd=" + userpwd
			+ "]";
}

}
