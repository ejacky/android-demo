package com.bookdemo.contentobserverdemo;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final String TAG = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://sms/");

		// ע���Sms��Uri�ļ�����Ϊģ��ƥ�䣬��������վ�������
		resolver.registerContentObserver(uri, true, new MyObserver(
				new Handler()));
	}

	private class MyObserver extends ContentObserver {

		public MyObserver(Handler handler) {
			super(handler);
		}

		@Override
		public void onChange(boolean selfChange) {
			// �������ݷ����仯�ˡ�
			super.onChange(selfChange);
			Toast.makeText(MainActivity.this, "��Ϣ�ط����仯��", Toast.LENGTH_SHORT)
					.show();
			// ���»�ȡ��������
			Uri uri = Uri.parse("content://sms/");
			ContentResolver resolver = getContentResolver();
			// ��ѯ������Ϣ��ֻ��ȡ��ַ������
			Cursor cursor = resolver.query(uri, new String[] { "address",
					"body" }, null, null, null);
			// ��ȡ��һ�����ݣ�SmsӦ�õ�SQLite���ݿ�Ķ����ǵ��������
			if (cursor.moveToFirst()) {
				String address = cursor.getString(0);
				String body = cursor.getString(1);
				Log.i(TAG, "���룺" + address);
				Log.i(TAG, "���ݣ�" + body);
			}
			// �ر�Cursor
			cursor.close();
		}
	}
}
