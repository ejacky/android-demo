package com.bookdemo.intentservicedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnDownload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDownload = (Button) findViewById(R.id.btnDownload);
		btnDownload.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 指定启动服务
				Intent service = new Intent(getApplicationContext(),
						IntentSer.class);
				// 开始服务
				startService(service);
				Toast.makeText(getApplicationContext(), "开始下载图片",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
