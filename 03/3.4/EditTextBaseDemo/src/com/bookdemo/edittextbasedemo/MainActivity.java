package com.bookdemo.edittextbasedemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private EditText et_edit;
	private Button btn_gettext, btn_settext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_edit = (EditText) findViewById(R.id.ev_edit);
		btn_gettext = (Button) findViewById(R.id.btn_gettext);
		btn_settext = (Button) findViewById(R.id.btn_settext);

		btn_gettext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 获取EditText输入的值
				String text = et_edit.getText().toString();
				if (!TextUtils.isEmpty(text)) {
					Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MainActivity.this, "请在文本框中输入值",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		btn_settext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				et_edit.setText("Hello Android!");
			}
		});
	}
}
