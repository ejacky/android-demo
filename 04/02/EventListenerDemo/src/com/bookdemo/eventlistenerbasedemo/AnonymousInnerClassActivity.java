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

		// �ҵ��¼�Դ
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);

		// Ϊ�¼�Դע���¼�������
		btnClick1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(AnonymousInnerClassActivity.this, "����˰�ť1",
						Toast.LENGTH_SHORT).show();
			}
		});
		btnClick2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(AnonymousInnerClassActivity.this, "����˰�ť2",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
