package com.bookdemo.eventlistenerbasedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
	private Button btnEventBasePage, btnInnerClassPage, btnOuterClassPage,
			btnActivitySelfPage, btnActivitySelfListenerPage,
			btnAnonymousInnerClassPage, btnAnonymousInnerClassReusePage,
			btnBindingXMLAttrPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnEventBasePage = (Button) findViewById(R.id.btnEventBasePage);
		btnInnerClassPage = (Button) findViewById(R.id.btnInnerClassPage);
		btnOuterClassPage = (Button) findViewById(R.id.btnOuterClassPage);
		btnActivitySelfPage = (Button) findViewById(R.id.btnActivitySelfPage);
		btnActivitySelfListenerPage = (Button) findViewById(R.id.btnActivitySelfListenerPage);
		btnAnonymousInnerClassPage = (Button) findViewById(R.id.btnAnonymousInnerClassPage);
		btnAnonymousInnerClassReusePage = (Button) findViewById(R.id.btnAnonymousInnerClassReusePage);
		btnBindingXMLAttrPage = (Button) findViewById(R.id.btnBindingXMLAttrPage);
		btnEventBasePage.setOnClickListener(this);
		btnInnerClassPage.setOnClickListener(this);
		btnOuterClassPage.setOnClickListener(this);
		btnActivitySelfPage.setOnClickListener(this);
		btnActivitySelfListenerPage.setOnClickListener(this);
		btnAnonymousInnerClassPage.setOnClickListener(this);
		btnAnonymousInnerClassReusePage.setOnClickListener(this);
		btnBindingXMLAttrPage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btnEventBasePage:
			intent = new Intent(MainActivity.this, EventListenerActivity.class);
			startActivity(intent);
			break;
		case R.id.btnInnerClassPage:
			intent = new Intent(MainActivity.this, InnerClassActivity.class);
			startActivity(intent);
			break;
		case R.id.btnOuterClassPage:
			intent = new Intent(MainActivity.this, OuterClassActivity.class);
			startActivity(intent);
			break;
		case R.id.btnActivitySelfPage:
			intent = new Intent(MainActivity.this,
					ActivitySelfListenerActivity.class);
			startActivity(intent);
			break;
		case R.id.btnActivitySelfListenerPage:
			intent = new Intent(MainActivity.this,
					AnonymousInnerClassActivity.class);
			startActivity(intent);
			break;
		case R.id.btnAnonymousInnerClassPage:
			intent = new Intent(MainActivity.this,
					AnonymousInnerClassActivity.class);
			startActivity(intent);
			break;
		case R.id.btnAnonymousInnerClassReusePage:
			intent = new Intent(MainActivity.this,
					AnonymousInnerClassReuseActivity.class);
			startActivity(intent);
			break;
		case R.id.btnBindingXMLAttrPage:
			intent = new Intent(MainActivity.this, BindingXMLAttrActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
