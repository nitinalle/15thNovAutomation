package com.vtiger.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.utility.FileUtility;

public class ExcelDataFetch {

	@Test
	public void dataFetch() throws IOException
	{
		System.out.println("start");
		FileUtility fUtil = new FileUtility();
		System.out.println(fUtil.getExceldata("Organizations", 2, 0));;
		System.out.println("end");
	}
}
