package com.bookdemo.intentcomponentnamedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnCompomentName, btnIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnCompomentName = (Button) findViewById(R.id.btnCompomentName);
		btnIntent = (Button) findViewById(R.id.btnIntent);

		btnCompomentName.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 实例化一个ComponentName对象，指定开启的组件
				ComponentName componentName = new ComponentName(
						MainActivity.this, Activity2.class);
				Intent intent = new Intent();
				// 为Intent指定Component
				intent.setComponent(componentName);
				// 根据Intent对象开启一个Activity
				startActivity(intent);
			}
		});

		btnIntent.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, Activity2.class);
				startActivity(intent);
			}
		});
	}
}
