package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InnerClassActivity extends Activity {
	private Button btnClick1, btnClick2;
	private ButtonClick buttonClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		// �ҵ��¼�Դ
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);
		// ʵ�����¼�������
		buttonClick = new ButtonClick();
		// Ϊ�¼�Դע���¼�������
		btnClick1.setOnClickListener(buttonClick);
		btnClick2.setOnClickListener(buttonClick);
	}

	private class ButtonClick implements View.OnClickListener {
		// ʵ��View.OnClickListener ����¼�������
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnClick1:
				Toast.makeText(InnerClassActivity.this, "����˰�ť1",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.btnClick2:
				Toast.makeText(InnerClassActivity.this, "����˰�ť2",
						Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	}
}
