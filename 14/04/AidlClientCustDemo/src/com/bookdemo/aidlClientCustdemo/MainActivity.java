package com.bookdemo.aidlClientCustdemo;

import java.util.List;
import java.util.Random;

import com.bookdemo.aidlservicecustdemo.domain.IGetMsg;
import com.bookdemo.aidlservicecustdemo.domain.Message;
import com.bookdemo.aidlservicecustdemo.domain.User;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_startService, btn_endService, btn_getServiceData;
	private IGetMsg getMsg;
	private String TAG="main";
	private static User[] users = new User[] {
			new User(0, "jack0", "99999999990"),
			new User(0, "jack1", "99999999991"),
			new User(0, "jack2", "99999999992") };

	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			getMsg = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			getMsg = IGetMsg.Stub.asInterface(service);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		btn_startService = (Button) findViewById(R.id.btn_startService);
		btn_endService = (Button) findViewById(R.id.btn_endService);
		btn_getServiceData = (Button) findViewById(R.id.btn_getServiceData);
		btn_startService.setOnClickListener(click);
		btn_endService.setOnClickListener(click);
		btn_getServiceData.setOnClickListener(click);
	}

	private View.OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.btn_startService:
				startService();
				break;
			case R.id.btn_endService:
				endService();
				break;
			case R.id.btn_getServiceData:
				getServiceDate();
				break;
			}

		}
	};
	

	/**
	 * 获取其他进程服务数据
	 */
	private void getServiceDate() {
		try {
			Random random = new Random();
			int nextInt = random.nextInt(2);
			List<Message> msgs = getMsg.getMes(users[nextInt]);
			StringBuilder sBuilder = new StringBuilder();
			for (Message msg : msgs) {
				sBuilder.append(msg.toString() + "\n");
			}
			Toast.makeText(getApplicationContext(), sBuilder.toString(),
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "获取数据出错",
					Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}

	/**
	 * 开始服务
	 */
	private void startService() {
		Intent service = new Intent();
		Log.i(TAG, "Client：准备绑定AIDL服务");
		service.setAction("com.bookdemo.Service.CUSTOM_TYPE_SERVICE");
		bindService(service, conn, BIND_AUTO_CREATE);
		Toast.makeText(getApplicationContext(), "绑定服务成功", Toast.LENGTH_SHORT)
				.show();
	}

	/**
	 * 停止服务
	 */
	private void endService() {
		Log.i(TAG, "Client：准备解除绑定AIDL服务");
		unbindService(conn);
		getMsg=null;
		Toast.makeText(getApplicationContext(), "解除绑定服务成功", Toast.LENGTH_SHORT)
				.show();
	}
}
