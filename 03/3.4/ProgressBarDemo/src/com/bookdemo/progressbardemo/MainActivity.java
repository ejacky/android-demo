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
				// 初始进度条为0
				pb_Hor.setProgress(0);
				pb_Hor.setSecondaryProgress(0);
				// 使用多线程的方式增加进度
				new Thread(new Runnable() {
					@Override
					public void run() {
						boolean flag = true;
						while (flag) {
							try {
								if (pb_Hor.getProgress() < 100) {
									pb_Hor.incrementProgressBy(10);
								} else {
									// 如果第一进度到100了，就停止循环
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
						// 循环过后初始到页面启动时进度的值
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
				// 如果是增加按钮，因为进度条的最大值限制在100，第一刻度限制在90.
				// 在此限度内，以1.2倍递增
				// 使用setProgress(int)
				if (pb_Hor.getProgress() < 90) {
					pb_Hor.setProgress((int) (pb_Hor.getProgress() * 1.2));
				}
				if (pb_Hor.getSecondaryProgress() < 100) {
					pb_Hor.setSecondaryProgress((int) (pb_Hor
							.getSecondaryProgress() * 1.2));
				}
				break;
			case R.id.btn_reduce:
				// 如果是增加按钮，因为进度条的最大值限制在100，第一刻度限制在10.第二刻度限制在20
				// 在此限度内，以10点为基数进行递减。
				// 使用incrementXxxProgressBy(int)
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
