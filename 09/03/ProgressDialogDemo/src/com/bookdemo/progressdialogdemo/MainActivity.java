package com.bookdemo.progressdialogdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnProgressDialog, btnProgressDialogH;
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnProgressDialog = (Button) findViewById(R.id.btnProgressDialog);
		btnProgressDialogH = (Button) findViewById(R.id.btnProgressDialogH);

		btnProgressDialog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 第一种方法，使用ProgressDialog构造函数
				progressDialog = new ProgressDialog(MainActivity.this);
				progressDialog.setIcon(R.drawable.ic_launcher);
				progressDialog.setTitle("等待");
				progressDialog.setMessage("正在加载....");
				progressDialog.show();
				// 第二种方法，使用静态的show方法
				// progressDialog=ProgressDialog.show(MainActivity.this, "等待",
				// "正在加载....", false, false);
				new Thread(new Runnable() {

					@Override
					public void run() {
						// 等待五秒关闭对话框
						try {
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							progressDialog.dismiss();
						}
					}
				}).start();
			}
		});

		btnProgressDialogH.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				progressDialog = new ProgressDialog(MainActivity.this);
				progressDialog.setIcon(R.drawable.ic_launcher);
				progressDialog.setTitle("等待");
				progressDialog
						.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressDialog.setMax(100);
				progressDialog.show();
				new Thread(new Runnable() {

					@Override
					public void run() {
						int mCount = 0;
						try {
							while (mCount <= 100) {
								progressDialog.setProgress(mCount++);
								Thread.sleep(100);
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							progressDialog.dismiss();
						}

					}
				}).start();
			}
		});	

	}
}
