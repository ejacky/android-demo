package com.bookdemo.messengerservicedemo;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
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
	private Messenger mService = null;

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// ʹ�÷���˵�IBinder����ʵ����һ��Messenger����
			mService = new Messenger(service);
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
						MessengerSer.class), mConnection,
						Service.BIND_AUTO_CREATE);
				Toast.makeText(getApplicationContext(), "�󶨷���ɹ�",
						Toast.LENGTH_SHORT).show();
				Log.i(TAG, "�󶨷���ɹ�");
				break;
			case R.id.btnInvokeMethod:
				if (mService == null) {
					Toast.makeText(getApplicationContext(), "���Ȱ󶨷���",
							Toast.LENGTH_SHORT).show();
					return;
				}
				// ʵ����һ��Message����
				Message msg = Message.obtain(null, MessengerSer.MSG_SAY_HELLO,
						0, 0);
				try {
					// ��Message�����ݸ�����˴���
					mService.send(msg);					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
			case R.id.btnStopSer:				
				unbindService(mConnection);
				mService = null;
				Toast.makeText(getApplicationContext(), "��������",
						Toast.LENGTH_SHORT).show();
				Log.i(TAG, "��������");
				break;
			default:
				break;
			}
		}
	};
}
