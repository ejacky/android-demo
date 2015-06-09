package com.bookdemo.http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpUtils {
	private static final String TAG="main";
	public HttpUtils() {
	}
	public static InputStream getXML(String path) {
		try {
			URL url=new URL(path);
			if(url!=null)
			{
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				connection.setDoInput(true);
				connection.setConnectTimeout(3000);
				connection.setRequestMethod("GET");
				int requesetCode=connection.getResponseCode();
				if(requesetCode==200)
				{
					Log.i(TAG, "�ɹ���ȡ����XML������");
					//���ִ�гɹ�������HTTP��Ӧ��
					return connection.getInputStream();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
}
