package com.naver.start.test;

import java.sql.Connection;

import com.naver.start.util.DBConnector;

public class DBConnectionTest
{
	// DBConnection을 호출하여 테스트
	public static void main(String[] args)
	{
		try
		{
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
