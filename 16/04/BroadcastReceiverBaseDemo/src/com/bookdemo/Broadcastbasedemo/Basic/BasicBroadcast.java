package com.bookdemo.Broadcastbasedemo.Basic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BasicBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// ���ܹ㲥
		Toast.makeText(context,
				"���յ�Broadcast����ϢΪ��" + intent.getStringExtra("msg"),
				Toast.LENGTH_SHORT).show();	
	}
}
