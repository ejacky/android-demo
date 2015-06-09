package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AnonymousInnerClassActivity extends Activity {
	private Button btnClick1, btnClick2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		// 找到事件源
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);

		// 为事件源注册事件监听器
		btnClick1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(AnonymousInnerClassActivity.this, "点击了按钮1",
						Toast.LENGTH_SHORT).show();
			}
		});
		btnClick2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(AnonymousInnerClassActivity.this, "点击了按钮2",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
