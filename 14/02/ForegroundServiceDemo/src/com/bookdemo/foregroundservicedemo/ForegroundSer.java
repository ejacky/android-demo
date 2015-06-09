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
		// 声明一个通知，并对其进行属性设置
		NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(ForegroundSer.this)
		.setSmallIcon(R.drawable.ic_launcher)
		.setContentTitle("Foreground Service")
		.setContentText("Foreground Service Started.");
		// 声明一个Intent，用于设置点击通知后开启的Activity
		Intent resuliIntent=new Intent(ForegroundSer.this, MainActivity.class);
		PendingIntent resultPendingIntent=PendingIntent.getActivity(ForegroundSer.this, 0, resuliIntent, PendingIntent.FLAG_CANCEL_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		notification=mBuilder.build();
		// 把当前服务设定为前台服务，并指定显示的通知。
		startForeground(1,notification);
	}
	
	@Override
	public void onDestroy() {		
		super.onDestroy();
		// 在服务销毁的时候，使当前服务推出前台，并销毁显示的通知
		stopForeground(false);
	}
}
