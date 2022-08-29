package com.naver.home.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.home.MyAbstractTest;
import com.naver.start.util.FileManager;

public class FileManagerTest extends MyAbstractTest
{
	@Autowired
	private FileManager fileManager;

	@Test
	public void setFileTest() throws Exception
	{
		// fileManager.saveFile("resources/upload/test");
		// System.out.println("--Finish--");
	}
}
