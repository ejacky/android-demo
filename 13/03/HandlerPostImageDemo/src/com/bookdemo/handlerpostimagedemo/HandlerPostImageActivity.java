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
	// 一个静态的Handler，Handler建议声明为静态的
	private static Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDown = (Button) findViewById(R.id.btnDown);
		ivImage = (ImageView) findViewById(R.id.ivSinaImage);

		// 实例化一个进度条对话框
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在下载，请稍后...");
		dialog.setCancelable(false);

		btnDown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 开启一个子线程，用于下载图片
				new Thread(new MyThread()).start();
				// 显示对话框
				dialog.show();
			}
		});
	}

	public class MyThread implements Runnable {

		@Override
		public void run() {
			// 下载一个图片
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(image_path);
			HttpResponse httpResponse = null;
			try {
				httpResponse = httpClient.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					byte[] data = EntityUtils.toByteArray(httpResponse
							.getEntity());
					// 得到一个Bitmap对象，并且为了使其在post内部可以访问，必须声明为final
					final Bitmap bmp = BitmapFactory.decodeByteArray(data, 0,
							data.length);
					handler.post(new Runnable() {
						@Override
						public void run() {
							// 在Post中操作UI组件ImageView
							ivImage.setImageBitmap(bmp);
						}
					});
					// 隐藏对话框
					dialog.dismiss();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
