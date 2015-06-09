package com.bookdemo.startservicedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnSer1, btnSer2;
	private Intent service=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSer1 = (Button) findViewById(R.id.btnSer1);
		btnSer2 = (Button) findViewById(R.id.btnSer2);
		// 设置服务启动的Intent
		service=new Intent(getApplicationContext(),StartService.class);
		btnSer1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 启动服务
				startService(service);
			}
		});

		btnSer2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 停止服务
				stopService(service);
			}
		});		
	}
}
