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
				Log.v(TAG,"����һ��Verbose�������־!");
				Log.d(TAG,"����һ��Debug�������־!");
				Log.i(TAG,"����һ��Info�������־!");
				Log.w(TAG,"����һ��Warn�������־!");
				Log.e(TAG,"����һ��Error�������־!");
			}
		});
		
		btnSysLog=(Button) findViewById(R.id.btnSysLog);
		btnSysLog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("����һ��SystemOut��־");
				System.err.println("����һ��SystemError��־");				
			}
		});
	}
}
