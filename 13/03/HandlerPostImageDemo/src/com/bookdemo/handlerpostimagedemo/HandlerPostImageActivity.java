package com.bookdemo.handlerpostimagedemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HandlerPostImageActivity extends Activity {
	private Button btnDown;
	private ImageView ivImage;
	private static String image_path = "http://images.cnblogs.com/cnblogs_com/plokmju/550907/o_hand.jpg";
	private ProgressDialog dialog;
	// һ����̬��Handler��Handler��������Ϊ��̬��
	private static Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDown = (Button) findViewById(R.id.btnDown);
		ivImage = (ImageView) findViewById(R.id.ivSinaImage);

		// ʵ����һ���������Ի���
		dialog = new ProgressDialog(this);
		dialog.setTitle("��ʾ");
		dialog.setMessage("�������أ����Ժ�...");
		dialog.setCancelable(false);

		btnDown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ����һ�����̣߳���������ͼƬ
				new Thread(new MyThread()).start();
				// ��ʾ�Ի���
				dialog.show();
			}
		});
	}

	public class MyThread implements Runnable {

		@Override
		public void run() {
			// ����һ��ͼƬ
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(image_path);
			HttpResponse httpResponse = null;
			try {
				httpResponse = httpClient.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					byte[] data = EntityUtils.toByteArray(httpResponse
							.getEntity());
					// �õ�һ��Bitmap���󣬲���Ϊ��ʹ����post�ڲ����Է��ʣ���������Ϊfinal
					final Bitmap bmp = BitmapFactory.decodeByteArray(data, 0,
							data.length);
					handler.post(new Runnable() {
						@Override
						public void run() {
							// ��Post�в���UI���ImageView
							ivImage.setImageBitmap(bmp);
						}
					});
					// ���ضԻ���
					dialog.dismiss();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
