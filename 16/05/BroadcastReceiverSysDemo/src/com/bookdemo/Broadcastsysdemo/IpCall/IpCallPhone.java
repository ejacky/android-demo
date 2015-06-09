package com.bookdemo.Broadcastsysdemo.IpCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class IpCallPhone extends BroadcastReceiver {
	private final String STARTS="17951";
	@Override
	public void onReceive(Context context, Intent intent) {
		// 获取当前拨号的号码
		String number=getResultData();
		// 此号码没有被加IP拨号的前缀
		if(!number.startsWith(STARTS)){
			// 设置加了IP号码的号码
			String newnumber=STARTS+number;
			// 把新号码增加到返回结果数据中，用于传递给后面的Receiver
			setResultData(newnumber);
		}		
	}
}