package com.bookdemo.http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpUtils {
	private static final String TAG="main";
	public HttpUtils() {
		
	}
	
	public static InputStream getXML(String path)
	{
		InputStream inputStream=null;
		try {
			URL url=new URL(path);
			if(url!=null)
			{
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				connection.setConnectTimeout(3000);
				connection.setDoInput(true);
				connection.setRequestMethod("GET");
				int code=connection.getResponseCode();
				if(code==200)
				{
					Log.i(TAG, "成功获取网络XML数据流");
					inputStream=connection.getInputStream();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inputStream;
	}

}
