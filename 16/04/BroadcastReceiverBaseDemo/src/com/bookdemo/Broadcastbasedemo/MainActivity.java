package com.bookdemo.Broadcastbasedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnBasicSendNormal, btnBasicSendOrdered;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic);
		btnBasicSendNormal = (Button) findViewById(R.id.btnBasicSendNormal);
		btnBasicSendOrdered = (Button) findViewById(R.id.btnBasicSendOrdered);
		btnBasicSendNormal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent broadcast=new Intent();
				// 指定此广播的接受者
				broadcast.setAction("com.bookdemo.Broadcastbasedemo.Basic.broadcast");
				broadcast.putExtra("msg", "这是一个普通广播");
				sendBroadcast(broadcast);
			}
		});

		btnBasicSendOrdered.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent broadcast=new Intent();
				broadcast.setAction("com.bookdemo.Broadcastbasedemo.Basic.broadcast");
				broadcast.putExtra("msg", "这是一个有序广播");
				sendOrderedBroadcast(broadcast, null);
			}
		});
	}	
}
