package com.bookdemo.foregroundservicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class ForegroundSer extends Service {
	private Notification notification;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		// ����һ��֪ͨ�������������������
		NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(ForegroundSer.this)
		.setSmallIcon(R.drawable.ic_launcher)
		.setContentTitle("Foreground Service")
		.setContentText("Foreground Service Started.");
		// ����һ��Intent���������õ��֪ͨ������Activity
		Intent resuliIntent=new Intent(ForegroundSer.this, MainActivity.class);
		PendingIntent resultPendingIntent=PendingIntent.getActivity(ForegroundSer.this, 0, resuliIntent, PendingIntent.FLAG_CANCEL_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		notification=mBuilder.build();
		// �ѵ�ǰ�����趨Ϊǰ̨���񣬲�ָ����ʾ��֪ͨ��
		startForeground(1,notification);
	}
	
	@Override
	public void onDestroy() {		
		super.onDestroy();
		// �ڷ������ٵ�ʱ��ʹ��ǰ�����Ƴ�ǰ̨����������ʾ��֪ͨ
		stopForeground(false);
	}
}
