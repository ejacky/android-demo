package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BindingXMLAttrActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demotoxml);

	}
	// ����������ͱ�ǩ�����趨��һ�£����ҷ���ǩ��Ҳ����淶
	public void OnClick1(View view) {
		Toast.makeText(BindingXMLAttrActivity.this, "����˰�ť1",
				Toast.LENGTH_SHORT).show();
	}

	public void OnClick2(View view) {
		Toast.makeText(BindingXMLAttrActivity.this, "����˰�ť2",
				Toast.LENGTH_SHORT).show();
	}
}
