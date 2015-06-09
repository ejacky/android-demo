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
				// �����µ����߳���UI�̷߳�����Ϣ
				new Thread() {
					@Override
					public void run() {

						super.run();
						// ʹ��Activity�ڲ���Looper����
						Message msg = Message.obtain();
						msg.what = 1;
						msg.obj = "Ĭ��Looper";
						handler.sendMessage(msg);
					}
				}.start();

			}
		});
		btnSendToUI2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ��ȡ��ǰ�̵߳�Looper
				Looper looper = Looper.myLooper();
				handler = new MyHandler(looper);
				// �����µ����߳���UI�̷߳�����Ϣ
				new Thread() {
					@Override
					public void run() {
						Message msg = Message.obtain();
						msg.what = 2;
						msg.obj = "ʹ�õ�ǰ�̵߳�Looper";
						handler.sendMessage(msg);
					}
				}.start();
			}
		});
	}

	// �����Handler��
	public class MyHandler extends Handler {

		public MyHandler() {
		}

		public MyHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// ����UI�ؼ������Ϣ����
			tvSendMes1.setText("what=" + msg.what + "," + msg.obj);
		}
	}
}
