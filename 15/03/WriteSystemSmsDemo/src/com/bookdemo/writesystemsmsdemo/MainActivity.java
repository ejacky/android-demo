package com.bookdemo.writesystemsmsdemo;

import java.util.Date;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;

public class MainActivity extends Activity {
	private Button btnWriteSms;
	private final static String TAG = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnWriteSms = (Button) findViewById(R.id.btnWriteSms);
		btnWriteSms.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("content://sms/");
				ContentResolver resolver = getContentResolver();
				ContentValues values = new ContentValues();
				// ָ�����ŷ��ͷ�����
				values.put("address", "10000");
				// ָ�����Ž���ʱ��
				values.put("date", System.currentTimeMillis());
				// ָ����������Ϊ�ռ�
				values.put("type", 1);
				// ָ����������
				values.put("body", "����һ���Զ��ָ��Ķ��ţ�");
				// �Ѷ�����Ϣд�뵽ϵͳ����Ӧ��
				resolver.insert(uri, values);
				Toast.makeText(getApplicationContext(), "���Ų���ɹ�",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
