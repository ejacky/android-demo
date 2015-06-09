package com.bookdemo.messengerservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MessengerSer extends Service {
	private final String TAG="main";
	static final int MSG_SAY_HELLO = 1;

	public class IncomingHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SAY_HELLO:
				Toast.makeText(getApplicationContext(), "Service say hello!",
						Toast.LENGTH_SHORT).show();
				Log.i(TAG, "Service say hello!");
				break;
			default:
				super.handleMessage(msg);
			}
		}
	}

	IncomingHandler incomingHandler=new IncomingHandler();
 	final Messenger mMessenger=new Messenger(new IncomingHandler());
 	
	@Override
	public IBinder onBind(Intent arg0) {
		// 返回服务的Handler
		return mMessenger.getBinder();
	}
}
