package com.bookdemo.eventlistenerbasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnonymousInnerClassReuseActivity extends Activity {
	private Button btnClick1, btnClick2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		// 找到事件源
		btnClick1 = (Button) findViewById(R.id.btnClick1);
		btnClick2 = (Button) findViewById(R.id.btnClick2);

		// 为事件源注册事件监听器
		btnClick1.setOnClickListener(click);
		btnClick2.setOnClickListener(click);
	}
	// 匿名内部类对象 可以被复用
	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnClick1:
				Toast.makeText(AnonymousInnerClassReuseActivity.this, "点击了按钮1",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.btnClick2:
				Toast.makeText(AnonymousInnerClassReuseActivity.this, "点击了按钮2",
						Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	};
}
