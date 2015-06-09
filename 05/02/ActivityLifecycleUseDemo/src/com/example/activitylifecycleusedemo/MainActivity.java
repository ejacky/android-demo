package com.example.activitylifecycleusedemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity {
	private EditText etUsername;
	private String middleUsername;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etUsername = (EditText) findViewById(R.id.etUsername);
	}

	@Override
	protected void onPause() {
		// ��Activity��ͣ��ʱ�򱣴�����
		if (etUsername != null) {
			String username = etUsername.getText().toString();
			if (!TextUtils.isEmpty(username)) {
				middleUsername = username;
			}
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		// ��Activity�ָ���ʱ��ָ�����
		if (etUsername != null) {
			if (!TextUtils.isEmpty(middleUsername)) {
				etUsername.setText(middleUsername);
			}
		}
		super.onResume();
	}
}
