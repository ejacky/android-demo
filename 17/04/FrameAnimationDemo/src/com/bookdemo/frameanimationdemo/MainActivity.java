package com.bookdemo.frameanimationdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btn_toxml, btn_tocode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_tocode = (Button) findViewById(R.id.btn_tocode);
		btn_toxml = (Button) findViewById(R.id.btn_toxml);

		btn_tocode.setOnClickListener(click);
		btn_toxml.setOnClickListener(click);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.btn_tocode:
				intent=new Intent(MainActivity.this,ToCodeActivity.class);
				startActivity(intent);
				break;
			case R.id.btn_toxml:
				intent=new Intent(MainActivity.this,ToXMLActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}

		}
	};
}
