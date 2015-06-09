package com.bookdemo.progressbardemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.app.Activity;

public class MainActivity extends Activity {
	private Button btn_add, btn_reduce, btn_run;
	private ProgressBar pb_Hor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_reduce = (Button) findViewById(R.id.btn_reduce);
		btn_run = (Button) findViewById(R.id.btn_run);
		pb_Hor = (ProgressBar) findViewById(R.id.pb_Hor);

		btn_add.setOnClickListener(mathClick);
		btn_reduce.setOnClickListener(mathClick);
		btn_run.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ʼ������Ϊ0
				pb_Hor.setProgress(0);
				pb_Hor.setSecondaryProgress(0);
				// ʹ�ö��̵߳ķ�ʽ���ӽ���
				new Thread(new Runnable() {
					@Override
					public void run() {
						boolean flag = true;
						while (flag) {
							try {
								if (pb_Hor.getProgress() < 100) {
									pb_Hor.incrementProgressBy(10);
								} else {
									// �����һ���ȵ�100�ˣ���ֹͣѭ��
									flag = false;
								}
								if (pb_Hor.getSecondaryProgress() < 100) {
									pb_Hor.incrementSecondaryProgressBy(20);
								}
								Thread.sleep(300);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						// ѭ�������ʼ��ҳ������ʱ���ȵ�ֵ
						pb_Hor.setProgress(20);
						pb_Hor.setSecondaryProgress(60);
					}
				}).start();

			}
		});
	}

	private View.OnClickListener mathClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_add:
				// ��������Ӱ�ť����Ϊ�����������ֵ������100����һ�̶�������90.
				// �ڴ��޶��ڣ���1.2������
				// ʹ��setProgress(int)
				if (pb_Hor.getProgress() < 90) {
					pb_Hor.setProgress((int) (pb_Hor.getProgress() * 1.2));
				}
				if (pb_Hor.getSecondaryProgress() < 100) {
					pb_Hor.setSecondaryProgress((int) (pb_Hor
							.getSecondaryProgress() * 1.2));
				}
				break;
			case R.id.btn_reduce:
				// ��������Ӱ�ť����Ϊ�����������ֵ������100����һ�̶�������10.�ڶ��̶�������20
				// �ڴ��޶��ڣ���10��Ϊ�������еݼ���
				// ʹ��incrementXxxProgressBy(int)
				if (pb_Hor.getProgress() > 10) {
					pb_Hor.incrementProgressBy(-5);
				}
				if (pb_Hor.getSecondaryProgress() > 20) {
					pb_Hor.incrementSecondaryProgressBy(-10);
				}
				break;
			}
		}
	};

}
