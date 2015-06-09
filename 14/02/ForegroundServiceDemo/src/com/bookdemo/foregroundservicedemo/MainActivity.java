package com.bookdemo.foregroundservicedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnForeStart, btnForeStop;
	private Intent service;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);

		btnForeStart = (Button) findViewById(R.id.btnForeStart);
		btnForeStop = (Button) findViewById(R.id.btnForeStop);
		service = new Intent(getApplicationContext(), ForegroundSer.class);
		btnForeStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 开始服务
				startService(service);
				Toast.makeText(getApplication(), "开始服务", Toast.LENGTH_SHORT)
						.show();
			}
		});
		btnForeStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 停止服务
				stopService(service);
				Toast.makeText(getApplication(), "停止服务", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}
