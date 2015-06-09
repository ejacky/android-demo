package com.bookdemo.intentactiondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener {
	private Button btnImplicit1, btnImplicit2, btnImplicit3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnImplicit1 = (Button) findViewById(R.id.btnImplicit1);
		btnImplicit2 = (Button) findViewById(R.id.btnImplicit2);
		btnImplicit3 = (Button) findViewById(R.id.btnImplicit3);
		btnImplicit1.setOnClickListener(this);
		btnImplicit2.setOnClickListener(this);
		btnImplicit3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btnImplicit1:
			// 指定Action和Category
			intent.setAction("com.bookdemo.intentactiondemo.MyAction");
			intent.addCategory("com.bookdemo.intentactiondemo.OneCategory");
			// 判断系统中是否存在此Intent
			if (intent.resolveActivity(getPackageManager()) != null) {
				startActivity(intent);
			}
			break;
		case R.id.btnImplicit2:
			intent.setAction("com.bookdemo.intentactiondemo.MyAction");
			intent.addCategory("com.bookdemo.intentactiondemo.TwoCategory");
			if (intent.resolveActivity(getPackageManager()) != null) {
				startActivity(intent);
			}
			break;
		case R.id.btnImplicit3:
			intent.setAction("com.bookdemo.intentactiondemo.MyAction");	
			//如果存在多个匹配的组件，增加一个选择框
			Intent choose=Intent.createChooser(intent, "请选择一个Activity");
			if (choose.resolveActivity(getPackageManager()) != null) {
				startActivity(choose);
			}
			break;
		default:
			break;
		}
	}
}
