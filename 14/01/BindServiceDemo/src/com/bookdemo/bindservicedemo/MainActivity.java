package com.bookdemo.bindservicedemo;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final String TAG = "main";
	Button bind, unbind, getServiceStatus;
	BindService.MyBinder binder;
	private ServiceConnection conn = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {			
			Log.i(TAG, "--Service Disconnected--");
		}
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "--Service Connected--");
			// 取得Service对象中的Binder对象
			binder = (BindService.MyBinder) service;
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bind = (Button) findViewById(R.id.bind);
		unbind = (Button) findViewById(R.id.unbind);
		getServiceStatus = (Button) findViewById(R.id.getServiceStatus);
		
		final Intent intent = new Intent(getApplicationContext(),BindService.class);
		
		bind.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 绑定服务到当前activity中
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});
		unbind.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 解除绑定
				binder=null;
				unbindService(conn);
			}
		});
		getServiceStatus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(binder!=null)
				{
					// 通过绑定服务传递的Binder对象，获取Service暴露出来的数据
					Toast.makeText(getApplicationContext(),
							"Service的Count值为" + binder.getCount(),
							Toast.LENGTH_SHORT).show();
					Log.i(TAG, "Service的Count值为" + binder.getCount());
				}
				else
				{
					Toast.makeText(getApplicationContext(),
							"还没绑定呢，先绑定。",
							Toast.LENGTH_SHORT).show();
				}				
			}
		});
	}
}
