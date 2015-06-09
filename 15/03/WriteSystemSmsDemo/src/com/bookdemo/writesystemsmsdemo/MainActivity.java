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
				// 指定短信发送方号码
				values.put("address", "10000");
				// 指定短信接收时间
				values.put("date", System.currentTimeMillis());
				// 指定短信类型为收件
				values.put("type", 1);
				// 指定短信内容
				values.put("body", "这是一条自动恢复的短信！");
				// 把短信信息写入到系统短信应用
				resolver.insert(uri, values);
				Toast.makeText(getApplicationContext(), "短信插入成功",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
