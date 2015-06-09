package com.bookdemo.junit;

import android.test.AndroidTestCase;
import android.util.Log;


import com.bookdemo.service.ProgressService;

public class ProgressServiceJUnit extends AndroidTestCase {
	private final String TAG="main";
	
	public ProgressServiceJUnit() {
	}
	
	public void getCurrentProgerssTest() throws Exception{
		ProgressService progressService=new ProgressService();
		int pro=progressService.getCurrentProgerss(20, 70);
		assertEquals(28, pro);
		
	}
}
