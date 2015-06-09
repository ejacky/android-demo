package com.bookdemo.Broadcastbasedemo.Basic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BasicBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// 接受广播
		Toast.makeText(context,
				"接收到Broadcast，消息为：" + intent.getStringExtra("msg"),
				Toast.LENGTH_SHORT).show();	
	}
}
