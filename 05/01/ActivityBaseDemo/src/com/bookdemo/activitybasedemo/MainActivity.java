package com.bookdemo.activitybasedemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button btnOpenNewActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnOpenNewActivity=(Button) findViewById(R.id.btnOpenNewActivity);
		btnOpenNewActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 开启一个Activity，指定当前上下文和目标Activity
				Intent intent=new Intent(MainActivity.this, NewActivity.class);
				startActivity(intent);
			}
		});		
	}	
}
