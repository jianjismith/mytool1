package com.jijianji.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public class sqlservice {

	public static void main(String[] args) {
		String sql1="s?,d?";
		String sql2="146217(Long), RZRQJYXJRZC(String)";
		try {
			System.out.println(getsql(sql1,sql2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getsql(String sql1,String sql2) throws IOException{
		StringBuffer sb=new StringBuffer();
		String[] array=getsql1(sql2);
		int j=0;
		for(int i=0;i<sql1.length();i++)
		{
			char a=sql1.charAt(i);
			if(a=='?'){
				
				sb.append(array[j]);
				j++;
			}
			else
			{
				sb.append(a);
			}
		}
		
		return sb.toString();
		
		
		
	}

	public static String[] getsql1(String sql) throws IOException {
		String[] array=sql.split(",");
		for (int i = 0; i <array.length; i++) {
			int first = array[i].indexOf("(");
			int end = array[i].indexOf(")");
			String s1 = array[i].substring(first + 1, end);
			StringBuffer s2 = new StringBuffer();
			if ("String".equals(s1)) {
				s2.append("'").append(array[i].substring(1, first)).append("'");
				array[i] = s2.toString();

			} else {
				array[i] = array[i].substring(1, first);
			}

		}
		
		return array;
	}

}
