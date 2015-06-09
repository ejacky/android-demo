package com.bookdemo.uriconnectionpostdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity {
	private static final String TAG = "main";
	private static String PATH = "http://192.168.1.103:8888/bookdemo/Login";
	private static URL url;
	private EditText etUsername, etPassword;
	private Button btnLogin;
	static {
		try {
			url = new URL(PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etUsername = (EditText) findViewById(R.id.etUsername);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);

		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String username = etUsername.getText().toString().trim();
				String password = etPassword.getText().toString().trim();
				// ����һ���µ��߳�
				new LoginThread(username, password).start();

			}
		});
	}

	/**
	 * �µ��̣߳�ģ���¼Ч��
	 *
	 */
	public class LoginThread extends Thread {
		private Map<String, String> params = new HashMap<String, String>();

		LoginThread(String username, String password) {
			// ͨ��Map���������ַ�����
			params.put("username", username);
			params.put("password", password);
		}

		@Override
		public void run() {
			super.run();
			String result = sendPostMessage(params, "utf-8");
			Log.i(TAG, "��¼״̬��" + result);
		}
	}

	/**
	 * ͨ����������������ͱ����ʽ����ȡ���������ص�����
	 * 
	 * @param params
	 *            �������
	 * @param encode
	 *            �����ʽ
	 * @return ��õ��ַ���
	 */
	public static String sendPostMessage(Map<String, String> params,
			String encode) {
		StringBuffer buffer = new StringBuffer();
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				try {
					// ����Ĳ���֮��ʹ��&�ָ�
					buffer.append(entry.getKey())
							.append("=")
							.append(URLEncoder.encode(entry.getValue(), encode))
							.append("&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			buffer.deleteCharAt(buffer.length() - 1);
			Log.i(TAG, "POST���������" + buffer.toString());
			try {
				HttpURLConnection urlConnection = (HttpURLConnection) url
						.openConnection();
				// �������ӳ�ʱʱ��
				urlConnection.setConnectTimeout(3000);
				// ���������������
				urlConnection.setDoInput(true);
				urlConnection.setDoOutput(true);
				byte[] mydata = buffer.toString().getBytes();
				// ����������ͷ���趨������������
				urlConnection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				// �����������ݳ���
				urlConnection.setRequestProperty("Content-Length",
						String.valueOf(mydata.length));
				// ����POST��ʽ��������
				urlConnection.setRequestMethod("POST");
				OutputStream outputStream = urlConnection.getOutputStream();
				outputStream.write(mydata);
				int responseCode = urlConnection.getResponseCode();
				if (responseCode == 200) {
					return changeInputStream(urlConnection.getInputStream(),
							encode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * �ѷ���˷��ص�������ת�����ַ�����ʽ
	 * 
	 * @param inputStream
	 *            ���������ص�������
	 * @param encode
	 *            �����ʽ
	 * @return ��������ַ���
	 */
	private static String changeInputStream(InputStream inputStream,
			String encode) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
