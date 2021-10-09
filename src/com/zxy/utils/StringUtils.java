package com.zxy.utils;

import java.util.UUID;

public class StringUtils {
public static String subString(String name){
	//获取name的后缀名
	/*int index = name.lastIndexOf(".");
	String str = name.substring(index);*///截取字符串
	//随机生成一个字符串
	String uuidString = UUID.randomUUID().toString().replace("-", "");
	String newsString = uuidString.substring(uuidString.length()-5, uuidString.length());
	System.out.println("uuid=="+uuidString);
	return newsString;
}
}
