package com.bookdemo.Http;

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
		try {
			URL url=new URL(path);
			if(url!=null)
			{
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				connection.setConnectTimeout(3000);
				connection.setDoInput(true);
				connection.setRequestMethod("GET");
				 int requestCode=connection.getResponseCode();
				 if(requestCode==200)
				 {
					 Log.i(TAG, "成功获取网络XML数据流");
					 return connection.getInputStream();					 
				 }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
