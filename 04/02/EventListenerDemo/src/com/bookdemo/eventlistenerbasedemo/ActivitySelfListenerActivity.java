package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivitySelfListenerActivity extends Activity implements
		View.OnClickListener {
	private Button btnClick1, btnClick2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		// �ҵ��¼�Դ
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);

		// Ϊ�¼�Դע���¼�������
		// ��Ϊ��ǰActivity�����¼������������Դ���this����
		btnClick1.setOnClickListener(this);
		btnClick2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnClick1:
			Toast.makeText(this, "����˰�ť1", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnClick2:
			Toast.makeText(this, "����˰�ť2", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}
