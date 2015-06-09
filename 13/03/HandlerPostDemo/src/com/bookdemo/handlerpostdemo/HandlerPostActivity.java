package com.bookdemo.handlerpostdemo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerPostActivity extends Activity {
	private Button btnMes1, btnMes2;
	private TextView tvMessage;
	// ����һ��Handler����
    private static Handler handler=new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnMes1 = (Button) findViewById(R.id.btnMes1);
		btnMes2 = (Button) findViewById(R.id.btnMes2);
		tvMessage = (TextView) findViewById(R.id.tvMessage);
		btnMes1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ������һ�����߳�
				new Thread(new Runnable() {
					@Override
					public void run() {
						// tvMessage.setText("...");
						// ���ϲ����ᱨ���޷������߳��з���UI�����UI��������Ա�����UI�߳��з���
						// ʹ��post��ʽ�޸�UI���tvMessage��Text����
						handler.post(new Runnable() {
							@Override
							public void run() {
								tvMessage
										.setText("ʹ��Handler.post�ڹ����߳��з���һ��ִ�е���Ϣ�����У������߳���ִ�С�");
							}
						});
					}
				}).start();
			}
		});

		btnMes2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						// ʹ��postDelayed��ʽ�޸�UI���tvMessage��Text����ֵ
						// �����ӳ�3Sִ��
						handler.postDelayed(new Runnable() {

							@Override
							public void run() {
								tvMessage
										.setText("ʹ��Handler.postDelayed�ڹ����߳��з���һ��ִ�е���Ϣ�����У������߳����ӳ�3Sִ�С�");

							}
						}, 3000);
					}
				}).start();

			}
		});
	}
}
