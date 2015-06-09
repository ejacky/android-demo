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
		// ��Intent�л�ȡ���е�ComponentName����
		ComponentName componentName = getIntent().getComponent();
		// ��TextView���������������
		tvShow.setText("�������Ϊ��" + componentName.getPackageName() + "\n"
				+ "���������" + componentName.getClassName());
	}
}
