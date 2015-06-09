package com.bookdemo.logdemo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnLog, btnSysLog;
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLog=(Button) findViewById(R.id.btnLog);
		btnLog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG,"这是一个Verbose级别的日志!");
				Log.d(TAG,"这是一个Debug级别的日志!");
				Log.i(TAG,"这是一个Info级别的日志!");
				Log.w(TAG,"这是一个Warn级别的日志!");
				Log.e(TAG,"这是一个Error级别的日志!");
			}
		});
		
		btnSysLog=(Button) findViewById(R.id.btnSysLog);
		btnSysLog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("这是一个SystemOut日志");
				System.err.println("这是一个SystemError日志");				
			}
		});
	}
}
