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

		// 注册对Sms的Uri的监听，为模糊匹配，发送与接收均被监听
		resolver.registerContentObserver(uri, true, new MyObserver(
				new Handler()));
	}

	private class MyObserver extends ContentObserver {

		public MyObserver(Handler handler) {
			super(handler);
		}

		@Override
		public void onChange(boolean selfChange) {
			// 短信数据发生变化了。
			super.onChange(selfChange);
			Toast.makeText(MainActivity.this, "消息池发生变化了", Toast.LENGTH_SHORT)
					.show();
			// 重新获取短信数据
			Uri uri = Uri.parse("content://sms/");
			ContentResolver resolver = getContentResolver();
			// 查询短信信息，只获取地址与内容
			Cursor cursor = resolver.query(uri, new String[] { "address",
					"body" }, null, null, null);
			// 获取第一条数据，Sms应用的SQLite数据库的短信是倒序排序的
			if (cursor.moveToFirst()) {
				String address = cursor.getString(0);
				String body = cursor.getString(1);
				Log.i(TAG, "号码：" + address);
				Log.i(TAG, "内容：" + body);
			}
			// 关闭Cursor
			cursor.close();
		}
	}
}
