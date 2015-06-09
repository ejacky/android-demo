package com.bookdemo.readsystemsmsdemo;

import java.util.Date;

import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;

public class MainActivity extends Activity {
	private Button btnReadSms;
	private final static String TAG = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnReadSms = (Button) findViewById(R.id.btnReadSms);
		btnReadSms.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("content://sms/");
				ContentResolver resolver = getContentResolver();
				// address：短信发送或接收的号码
				// date：短信发送或接收的时间
				// type：短信的类型，1：接收，2：发送
				// body：短信的内容
				Cursor cursor = resolver.query(uri, new String[] { "address",
						"date", "type", "body" }, null, null, null);
				while (cursor.moveToNext()) {
					String address = cursor.getString(0);
					String date = cursor.getString(1);
					String type = cursor.getString(2);
					String body = cursor.getString(3);
					Log.i(TAG, "--------Sms Start--------------");
					Log.i(TAG, (type.equals("1") ? "收件人：" : "发件人：") + address);
					Log.i(TAG, "日期：" + new Date(Long.parseLong(date)));
					Log.i(TAG, "内容：" + body);
					Log.i(TAG, "--------Sms End--------------");
				}
				cursor.close();
			}
		});
	}
}
