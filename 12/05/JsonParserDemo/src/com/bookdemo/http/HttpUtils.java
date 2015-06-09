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
	 * ͨ��Uri��ַ����ȡ��������Json���ݡ�
	 * @param url_path JSON���������Uri��ַ
	 * @return JSON����
	 */
	public static String getJsonContent(String url_path) {
		try {
			URL url = new URL(url_path);
			// ʹ��HttpUrLConnection��ȡ����������
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(3000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			int code = connection.getResponseCode();
			if (200 == code) {
				Log.i(TAG, "��ȡ������JSON�������ɹ�");
				return changeJsonString(connection.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �ѷ�������ȡ��JSON������ת����JSON�ַ�������
	 * @param inputStream JSON������
	 * @return JSON�ַ�������
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
