package com.bookdemo.activitybasereturncodedemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button btnOpenNewActivity;
	private final static int REQUEST_CODE = 101;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnOpenNewActivity = (Button) findViewById(R.id.btnOpenNewActivity);
		btnOpenNewActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ʵ����һ��ͼ��ָ����ǰ�����ĺ�Ŀ��Activity
				Intent intent = new Intent(MainActivity.this, NewActivity.class);
				// ����һ��ָ���������Activity
				startActivityForResult(intent, REQUEST_CODE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ͨ�����������Ӧ���ж��߼�
		if (requestCode == REQUEST_CODE) {
			if (resultCode == 1) {
				Toast.makeText(MainActivity.this, "��ѡ���ˣ�male��", Toast.LENGTH_SHORT)
						.show();
			} else if (resultCode == 0) {
				Toast.makeText(MainActivity.this, "��ѡ���ˣ�female��", Toast.LENGTH_SHORT)
						.show();
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
