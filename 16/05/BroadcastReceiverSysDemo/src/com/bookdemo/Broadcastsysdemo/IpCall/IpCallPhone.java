package com.bookdemo.Broadcastsysdemo.IpCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class IpCallPhone extends BroadcastReceiver {
	private final String STARTS="17951";
	@Override
	public void onReceive(Context context, Intent intent) {
		// ��ȡ��ǰ���ŵĺ���
		String number=getResultData();
		// �˺���û�б���IP���ŵ�ǰ׺
		if(!number.startsWith(STARTS)){
			// ���ü���IP����ĺ���
			String newnumber=STARTS+number;
			// ���º������ӵ����ؽ�������У����ڴ��ݸ������Receiver
			setResultData(newnumber);
		}		
	}
}