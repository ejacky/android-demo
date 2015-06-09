package com.bookdemo.tweenanimationdemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_tocode, btn_toxml;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_tocode = (Button) findViewById(R.id.btn_tocode);
		btn_toxml = (Button) findViewById(R.id.btn_toxml);

		btn_tocode.setOnClickListener(this);
		btn_toxml.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_tocode:
			intent=new Intent(MainActivity.this, ToCodeActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_toxml:
			intent=new Intent(MainActivity.this, ToXMLActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
