package com.bookdemo.ibinderservicedemo;

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
	protected static final String TAG = "main";
	private Button btnStart, btnInvoke, btnStop;
	IBinderSer mService = null;
	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// 获取服务上的IBinder对象，调用IBinder对象中定义的自定义方法，获取Service对象
			IBinderSer.LocalBinder binder = (IBinderSer.LocalBinder) service;
			mService = binder.getService();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnStart = (Button) findViewById(R.id.btnStartSer);
		btnInvoke = (Button) findViewById(R.id.btnInvokeMethod);
		btnStop = (Button) findViewById(R.id.btnStopSer);

		btnStart.setOnClickListener(onclick);
		btnInvoke.setOnClickListener(onclick);
		btnStop.setOnClickListener(onclick);
	}

	View.OnClickListener onclick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnStartSer:

				bindService(new Intent(getApplicationContext(),
						IBinderSer.class), mConnection,
						Service.BIND_AUTO_CREATE);
				Toast.makeText(getApplicationContext(), "绑定服务成功",
						Toast.LENGTH_SHORT).show();
				Log.i(TAG, "绑定服务成功");
				break;
			case R.id.btnInvokeMethod:
				if (mService == null) {
					Toast.makeText(getApplicationContext(), "请先绑定服务",
							Toast.LENGTH_SHORT).show();
					return;
				}
				// 调用绑定服务上的方法，进行数据交互
				int iResult = mService.getMultipleNum(10);
				Toast.makeText(getApplicationContext(), "服务计算结果为：" + iResult,
						Toast.LENGTH_SHORT).show();
				Log.i(TAG, "服务计算结果为：" + iResult);
				break;
			case R.id.btnStopSer:
				
				unbindService(mConnection);
				mService = null;
				Toast.makeText(getApplicationContext(), "服务解除绑定",
						Toast.LENGTH_SHORT).show();
				Log.i(TAG, "服务解除绑定");
				break;
			default:
				break;
			}
		}
	};
}
