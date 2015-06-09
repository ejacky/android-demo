package com.bookdemo.httpUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class httpClientUtils implements Runnable {
	private static final String TAG = "main";

	private String username;
	private String password;

	public httpClientUtils(String username, String password) {
		// ��ʼ���û���������
		this.username = username;
		this.password = password;
	}

	@Override
	public void run() {
		// ���÷��ʵ�Webվ��
		String path = "http://192.168.186.1:8888/bookdemo/Login";
		// ����Http�������
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);
		Log.i(TAG, "HttpClient���������username��" + username
				+ "---password��" + password);
		String result = sendHttpClientPost(path, params, "utf-8");
		// �ѷ��صĽӿ����
		Log.i(TAG, "HttpClient��������" + result);
	}

	/**
	 * ����Http����Webվ��
	 * 
	 * @param path
	 *            Webվ�������ַ
	 * @param map
	 *            Http�������
	 * @param encode
	 *            �����ʽ
	 * @return Webվ����Ӧ���ַ���
	 */
	private String sendHttpClientPost(String path, Map<String, String> map,
			String encode) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		if (map != null && !map.isEmpty()) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				// ����Map���ݵĲ�����ʹ��һ����ֵ�Զ���BasicNameValuePair���档
				list.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
		}
		try {
			// ʵ�ֽ����� �Ĳ�����װ��װ��HttpEntity�С�
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, encode);
			// ʹ��HttpPost����ʽ
			HttpPost httpPost = new HttpPost(path);
			// �������������Form�С�
			httpPost.setEntity(entity);
			// ʵ����һ��Ĭ�ϵ�Http�ͻ���
			DefaultHttpClient client = new DefaultHttpClient();
			// ִ�����󣬲������Ӧ����
			HttpResponse httpResponse = client.execute(httpPost);
			// �ж��Ƿ�����ɹ���Ϊ200ʱ��ʾ�ɹ����������������⡣
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				Log.i(TAG, "HttpClient����ɹ�");
				// ͨ��HttpEntity�����Ӧ��
				InputStream inputStream = httpResponse.getEntity().getContent();
				return changeInputStream(inputStream, encode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * ��Webվ�㷵�ص���Ӧ��ת��Ϊ�ַ�����ʽ
	 * 
	 * @param inputStream
	 *            ��Ӧ��
	 * @param encode
	 *            �����ʽ
	 * @return ת������ַ���
	 */
	private String changeInputStream(InputStream inputStream, String encode) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		String result = "";
		if (inputStream != null) {
			try {
				while ((len = inputStream.read(data)) != -1) {
					outputStream.write(data, 0, len);
				}
				result = new String(outputStream.toByteArray(), encode);
				Log.i(TAG, "HttpClient�����������ɹ�");		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
