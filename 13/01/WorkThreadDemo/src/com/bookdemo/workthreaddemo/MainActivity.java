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
				// ����һ���̷߳�������
				new Thread(new Runnable() {
					@Override
					public void run() {
						// ��ȡ����·���µ�ͼƬ
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
						// ��ȡ����·���µ�ͼƬ
						final Bitmap btm = loadImageFromNetwork(PATH_URL);
						// ��UI�߳��ϲ���Bitmap���
						MainActivity.this.runOnUiThread(new Runnable() {
							@Override
							public void run() {
								imageView1.setImageBitmap(btm);
								Toast.makeText(getApplicationContext(), "������UI�߳���",
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
						// ������Bitmap�ķ�ʽ������UI�߳���
						imageView1.post(new Runnable() {

							@Override
							public void run() {
								imageView1.setImageBitmap(btm);
								Toast.makeText(getApplicationContext(), "��������UI�߳���",
										Toast.LENGTH_SHORT).show();
							}
						});
					}
				}).start();
			}
		});
	}

	private Bitmap loadImageFromNetwork(String uri) {
		// ����URI��ַ����ȡ���ַ��ͼƬ��Դ
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
