package com.bookdemo.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;

public class HttpUtils {
	private static final String TAG="main";
	public HttpUtils() {

	}

	/**
	 * 通过Uri地址，获取服务器的Json数据。
	 * @param url_path JSON数据请求的Uri地址
	 * @return JSON数据
	 */
	public static String getJsonContent(String url_path) {
		try {
			URL url = new URL(url_path);
			// 使用HttpUrLConnection获取服务器数据
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(3000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			int code = connection.getResponseCode();
			if (200 == code) {
				Log.i(TAG, "获取服务器JSON数据流成功");
				return changeJsonString(connection.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把服务器获取的JSON数据流转换成JSON字符串数据
	 * @param inputStream JSON数据流
	 * @return JSON字符串数据
	 */
	private static String changeJsonString(InputStream inputStream) {
		String jsonString = "";
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			int len = 0;
			byte[] data = new byte[1024];
			while ((len = inputStream.read(data)) != -1) {
				outputStream.write(data, 0, len);
			}
			jsonString = new String(outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
