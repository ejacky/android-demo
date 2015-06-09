package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class OuterClassActivity extends Activity {
	private Button btnClick1, btnClick2;
	private ButtonClickListener buttonClickListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		// 找到事件源
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);
		// 实例化外部类定义的事件监听器
		buttonClickListener = new ButtonClickListener(OuterClassActivity.this);
		// 为事件源注册事件监听器
		btnClick1.setOnClickListener(buttonClickListener);
		btnClick2.setOnClickListener(buttonClickListener);
	}
}
