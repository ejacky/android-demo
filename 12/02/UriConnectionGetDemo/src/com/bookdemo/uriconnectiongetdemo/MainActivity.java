package com.bookdemo.uriconnectiongetdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private static final String TAG = "main";
	private Button btnDown;
	// ���ص�ͼƬ��ַ
	private static String image_path = "http://images.cnblogs.com/cnblogs_com/plokmju/550907/o_hand.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnDown = (Button) findViewById(R.id.btnDown);

		btnDown.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread() {

					@Override
					public void run() {
						super.run();
						Log.i(TAG, "����һ���µ��߳�ִ������ͼƬ������Ĳ���");
						saveImageToSD();
					}
				}.start();
			}
		});
	}

	/**
	 * ͨ��URL_PATH�ĵ�ַ����ͼƬ�����浽����
	 */
	public static void saveImageToSD() {
		InputStream inputStream = getInputStream();
		byte[] data = new byte[1024];
		int len = 0;
		File file = new File(Environment.getExternalStorageDirectory(),
				"test.png");

		FileOutputStream fileOutputStream = null;
		try {
			// ��ͼƬ�ļ�������SD����
			fileOutputStream = new FileOutputStream(file);
			while ((len = inputStream.read(data)) != -1) {
				// �򱾵��ļ���д��ͼƬ��
				fileOutputStream.write(data, 0, len);
			}
			Log.i(TAG, "�ѻ�����ͼƬ��Դд���ļ����У��������");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ���ر���
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ͨ��URL��ȡͼƬ
	 * 
	 * @return URL��ַͼƬ����������
	 */
	public static InputStream getInputStream() {
		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;

		try {
			Log.i(TAG, "׼����ʼ��������ͼƬ");
			// ����URL��ַʵ����һ��URL�������ڴ���HttpURLConnection����
			URL url = new URL(image_path);

			if (url != null) {
				// openConnection��õ�ǰURL������
				httpURLConnection = (HttpURLConnection) url.openConnection();
				// ����3�����Ӧ��ʱ
				httpURLConnection.setConnectTimeout(3000);
				// ������������
				httpURLConnection.setDoInput(true);
				// ����ΪGET��ʽ��������
				httpURLConnection.setRequestMethod("GET");
				// ��ȡ������Ӧ�룬200Ϊ�ɹ������Ϊ����������ʾ������
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode == 200) {
					// getInputStream��ȡ����˷��ص���������
					inputStream = httpURLConnection.getInputStream();
					Log.i(TAG, "˳����ȡ����ͼƬ��Դ��");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
