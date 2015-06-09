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

		// �ҵ��¼�Դ
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);
		// ʵ�����ⲿ�ඨ����¼�������
		buttonClickListener = new ButtonClickListener(OuterClassActivity.this);
		// Ϊ�¼�Դע���¼�������
		btnClick1.setOnClickListener(buttonClickListener);
		btnClick2.setOnClickListener(buttonClickListener);
	}
}
