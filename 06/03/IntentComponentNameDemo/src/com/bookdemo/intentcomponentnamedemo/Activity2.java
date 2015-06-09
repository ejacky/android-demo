package com.bookdemo.intentcomponentnamedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity {
	private TextView tvShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page);
		tvShow = (TextView) findViewById(R.id.tvShow);
		// 从Intent中获取其中的ComponentName对象
		ComponentName componentName = getIntent().getComponent();
		// 在TextView上输出包名和类名
		tvShow.setText("组件包名为：" + componentName.getPackageName() + "\n"
				+ "组件类名：" + componentName.getClassName());
	}
}
