package com.bookdemo.handlerlooperdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainThreadActivity extends Activity {
	private Button btnSendToUI1, btnSendToUI2;
	private TextView tvSendMes1;
	private static MyHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.looper_activity);
		tvSendMes1 = (TextView) findViewById(R.id.tvSendMes1);
		btnSendToUI1 = (Button) findViewById(R.id.btnSendToUI1);
		btnSendToUI2 = (Button) findViewById(R.id.btnSendToUI2);

		btnSendToUI1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				handler = new MyHandler();
				// 开启新的子线程向UI线程发送消息
				new Thread() {
					@Override
					public void run() {

						super.run();
						// 使用Activity内部的Looper对象
						Message msg = Message.obtain();
						msg.what = 1;
						msg.obj = "默认Looper";
						handler.sendMessage(msg);
					}
				}.start();

			}
		});
		btnSendToUI2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获取当前线程的Looper
				Looper looper = Looper.myLooper();
				handler = new MyHandler(looper);
				// 开启新的子线程向UI线程发送消息
				new Thread() {
					@Override
					public void run() {
						Message msg = Message.obtain();
						msg.what = 2;
						msg.obj = "使用当前线程的Looper";
						handler.sendMessage(msg);
					}
				}.start();
			}
		});
	}

	// 定义个Handler类
	public class MyHandler extends Handler {

		public MyHandler() {
		}

		public MyHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// 控制UI控件输出消息内容
			tvSendMes1.setText("what=" + msg.what + "," + msg.obj);
		}
	}
}
