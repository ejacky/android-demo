package com.bookdemo.workthreaddemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnError2, btnRunOnUiThread, btnPost;
	private ImageView imageView1;
	private static final String PATH_URL = "http://images.cnblogs.com/cnblogs_com/plokmju/550907/o_hand.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView1 = (ImageView) findViewById(R.id.imageView1);
		btnRunOnUiThread = (Button) findViewById(R.id.btnRunOnUiThread);
		btnError2 = (Button) findViewById(R.id.btnError2);
		btnPost = (Button) findViewById(R.id.btnPost);

		btnError2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 增加一个线程访问网络
				new Thread(new Runnable() {
					@Override
					public void run() {
						// 获取网络路径下的图片
						Bitmap btm = loadImageFromNetwork(PATH_URL);
						imageView1.setImageBitmap(btm);
					}
				}).start();

			}
		});

		btnRunOnUiThread.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// 获取网络路径下的图片
						final Bitmap btm = loadImageFromNetwork(PATH_URL);
						// 在UI线程上操作Bitmap组件
						MainActivity.this.runOnUiThread(new Runnable() {
							@Override
							public void run() {
								imageView1.setImageBitmap(btm);
								Toast.makeText(getApplicationContext(), "运行在UI线程上",
										Toast.LENGTH_SHORT).show();
							}
						});
					}
				}).start();
			}
		});

		btnPost.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						final Bitmap btm = loadImageFromNetwork(PATH_URL);
						// 将操作Bitmap的方式发布到UI线程上
						imageView1.post(new Runnable() {

							@Override
							public void run() {
								imageView1.setImageBitmap(btm);
								Toast.makeText(getApplicationContext(), "发布到在UI线程上",
										Toast.LENGTH_SHORT).show();
							}
						});
					}
				}).start();
			}
		});
	}

	private Bitmap loadImageFromNetwork(String uri) {
		// 根据URI地址，获取其地址的图片资源
		Bitmap bitmap = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(uri);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				byte[] data = EntityUtils.toByteArray(httpResponse.getEntity());
				bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}
