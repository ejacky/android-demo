package com.bookdemo.activitybasereturncodedemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button btnOpenNewActivity;
	private final static int REQUEST_CODE = 101;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnOpenNewActivity = (Button) findViewById(R.id.btnOpenNewActivity);
		btnOpenNewActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 实例化一意图，指定当前上下文和目标Activity
				Intent intent = new Intent(MainActivity.this, NewActivity.class);
				// 启动一个指定请求码的Activity
				startActivityForResult(intent, REQUEST_CODE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// 通过请求码和响应码判断逻辑
		if (requestCode == REQUEST_CODE) {
			if (resultCode == 1) {
				Toast.makeText(MainActivity.this, "您选择了：male！", Toast.LENGTH_SHORT)
						.show();
			} else if (resultCode == 0) {
				Toast.makeText(MainActivity.this, "您选择了：female！", Toast.LENGTH_SHORT)
						.show();
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
