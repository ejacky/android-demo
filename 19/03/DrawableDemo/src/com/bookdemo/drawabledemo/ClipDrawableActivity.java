package com.bookdemo.drawabledemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.app.Activity;
import android.graphics.drawable.ClipDrawable;

public class ClipDrawableActivity extends Activity {
	private final int MSG_SEND=0x1231;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clip);
		ImageView imageview = (ImageView) findViewById(R.id.image);
		// 获取ImageView上的ClipDrawable对象
		final ClipDrawable drawable = (ClipDrawable) imageview.getDrawable();
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {

				if (msg.what == MSG_SEND) {
					// 每次递增500
					drawable.setLevel(drawable.getLevel() + 500);
				}
			}
		};

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (drawable.getLevel() <= 10000) {
					Message msg = new Message();
					msg.what = MSG_SEND;
					handler.sendMessage(msg);
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
