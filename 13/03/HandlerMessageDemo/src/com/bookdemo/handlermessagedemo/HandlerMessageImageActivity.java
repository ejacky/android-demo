package com.bookdemo.handlermessagedemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HandlerMessageImageActivity extends Activity {
	private Button btnDown;
	private ImageView ivImage;
	private static String image_path = "http://images.cnblogs.com/cnblogs_com/plokmju/550907/o_hand.jpg";
	private ProgressDialog dialog;
	private static int IS_FINISH = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDown = (Button) findViewById(R.id.btnDown);
		ivImage = (ImageView) findViewById(R.id.ivSinaImage);

		dialog = new ProgressDialog(this);
		dialog.setTitle("��ʾ��Ϣ");
		dialog.setMessage("�������أ����Ժ�...");
		dialog.setCancelable(false);

		btnDown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new MyThread()).start();
				dialog.show();
			}
		});

	}

	private Handler handler = new Handler() {
		// ��Handler�л�ȡ��Ϣ����дhandleMessage()����
		@Override
		public void handleMessage(Message msg) {
			// �ж���Ϣ���Ƿ�Ϊ1
			if (msg.what == IS_FINISH) {
				byte[] data = (byte[]) msg.obj;
				Bitmap bmp = BitmapFactory
						.decodeByteArray(data, 0, data.length);
				ivImage.setImageBitmap(bmp);
				dialog.dismiss();
			}
		}
	};

	public class MyThread implements Runnable {

		@Override
		public void run() {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(image_path);
			HttpResponse httpResponse = null;
			try {
				httpResponse = httpClient.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					byte[] data = EntityUtils.toByteArray(httpResponse
							.getEntity());
					// ��ȡһ��Message��������whatΪ1
					Message msg = Message.obtain();
					msg.obj = data;
					msg.what = IS_FINISH;
					// ���������Ϣ����Ϣ������
					handler.sendMessage(msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
