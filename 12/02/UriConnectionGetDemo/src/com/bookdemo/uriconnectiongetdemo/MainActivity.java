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
	// 下载的图片地址
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
						Log.i(TAG, "开启一条新的线程执行下载图片并保存的操作");
						saveImageToSD();
					}
				}.start();
			}
		});
	}

	/**
	 * 通过URL_PATH的地址访问图片并保存到本地
	 */
	public static void saveImageToSD() {
		InputStream inputStream = getInputStream();
		byte[] data = new byte[1024];
		int len = 0;
		File file = new File(Environment.getExternalStorageDirectory(),
				"test.png");

		FileOutputStream fileOutputStream = null;
		try {
			// 把图片文件保存在SD卡上
			fileOutputStream = new FileOutputStream(file);
			while ((len = inputStream.read(data)) != -1) {
				// 向本地文件中写入图片流
				fileOutputStream.write(data, 0, len);
			}
			Log.i(TAG, "把互联网图片资源写入文件流中，下载完成");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 最后关闭流
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
	 * 通过URL获取图片
	 * 
	 * @return URL地址图片的输入流。
	 */
	public static InputStream getInputStream() {
		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;

		try {
			Log.i(TAG, "准备开始下载网络图片");
			// 根据URL地址实例化一个URL对象，用于创建HttpURLConnection对象。
			URL url = new URL(image_path);

			if (url != null) {
				// openConnection获得当前URL的连接
				httpURLConnection = (HttpURLConnection) url.openConnection();
				// 设置3秒的响应超时
				httpURLConnection.setConnectTimeout(3000);
				// 设置允许输入
				httpURLConnection.setDoInput(true);
				// 设置为GET方式请求数据
				httpURLConnection.setRequestMethod("GET");
				// 获取连接响应码，200为成功，如果为其他，均表示有问题
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode == 200) {
					// getInputStream获取服务端返回的数据流。
					inputStream = httpURLConnection.getInputStream();
					Log.i(TAG, "顺利获取网络图片资源流");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
