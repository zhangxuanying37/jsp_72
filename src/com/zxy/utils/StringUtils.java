package com.zxy.utils;

import java.util.UUID;

public class StringUtils {
public static String subString(String name){
	//��ȡname�ĺ�׺��
	/*int index = name.lastIndexOf(".");
	String str = name.substring(index);*///��ȡ�ַ���
	//�������һ���ַ���
	String uuidString = UUID.randomUUID().toString().replace("-", "");
	String newsString = uuidString.substring(uuidString.length()-5, uuidString.length());
	System.out.println("uuid=="+uuidString);
	return newsString;
}
}
