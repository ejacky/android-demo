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
	// 方法名必须和标签属性设定的一致，并且方法签名也必须规范
	public void OnClick1(View view) {
		Toast.makeText(BindingXMLAttrActivity.this, "点击了按钮1",
				Toast.LENGTH_SHORT).show();
	}

	public void OnClick2(View view) {
		Toast.makeText(BindingXMLAttrActivity.this, "点击了按钮2",
				Toast.LENGTH_SHORT).show();
	}
}
