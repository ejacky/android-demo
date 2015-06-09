package com.bookdemo.notificationdemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends Activity {
	private static String TAG = "mian";
	private Button btnSimpleNotification, btnCancelNotification,btnResponseNotification,
			btnNotification, btnProgreNotification, btnProNotification,
			btnCustomNotification, btnBigViewNotification;
	private NotificationManager manager;
	private Notification.Builder builder;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSimpleNotification = (Button) findViewById(R.id.btnSimpleNotification);
		btnCancelNotification = (Button) findViewById(R.id.btnCancelNotification);
		btnResponseNotification = (Button) findViewById(R.id.btnResponseNotification);
		btnNotification = (Button) findViewById(R.id.btnNotification);
		btnProgreNotification = (Button) findViewById(R.id.btnProgreNotification);
		btnProNotification = (Button) findViewById(R.id.btnProNotification);
		btnCustomNotification = (Button) findViewById(R.id.btnCustomNotification);
		btnBigViewNotification = (Button) findViewById(R.id.btnBigViewNotification);

		btnSimpleNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ʵ����һ��Notification�Ĺ�����
				Notification.Builder mBuilder = new Notification.Builder(
						MainActivity.this).setSmallIcon(R.drawable.msg)
						.setContentTitle("5 new message")
						.setContentText("plokmju@sina.com");
				// ��ȡ֪ͨ����������
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				// ��ʾNotification֪ͨ��ָ��IDΪ0
				mNotificationManager.notify(0, mBuilder.build());
			}
		});

		btnCancelNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ȡ֪ͨ����������
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				// ȡ��IDΪ0��Notification֪ͨ
				mNotificationManager.cancel(0);
			}
		});
		
		btnResponseNotification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ʵ����һ��Notification�Ĺ�����
				Notification.Builder mBuilder = new Notification.Builder(
						MainActivity.this).setSmallIcon(R.drawable.msg)
						.setContentTitle("5 new message")
						.setContentText("plokmju@sina.com");
				
				// ����һ��Intent
				Intent resultIntent = new Intent(MainActivity.this,
						ResultActivity.class);
				// ��װһ��PendingIntent
				PendingIntent resultPendingIntent = PendingIntent.getActivity(
						MainActivity.this, 0, resultIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
				// ����֪ͨ�������ͼ
				mBuilder.setContentIntent(resultPendingIntent);
				
				// ��ȡ֪ͨ����������
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				// ��ʾNotification֪ͨ��ָ��IDΪ0
				mNotificationManager.notify(0, mBuilder.build());
			}
		});

		btnNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��Drawable��Դ�л�ȡһ��Bitmap����
				Bitmap btm = BitmapFactory.decodeResource(getResources(),
						R.drawable.msg);
				Notification.Builder mBuilder = new Notification.Builder(
						MainActivity.this).setSmallIcon(R.drawable.msg)
						.setContentTitle("5 new message")
						.setContentText("plokmju@sina.com");
				// ��һ����ʾ��Ϣ��ʱ����ʾ��֪ͨ����
				mBuilder.setTicker("New message");
				mBuilder.setNumber(12);
				mBuilder.setLargeIcon(btm);
				// �Լ�ά��֪ͨ����ʧ
				mBuilder.setAutoCancel(true);
				mBuilder.setDefaults(Notification.DEFAULT_ALL);

				// ��ȡ֪ͨ����������
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, mBuilder.build());
			}
		});
		
		btnBigViewNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Bitmap btm = BitmapFactory.decodeResource(getResources(),
						R.drawable.msg);
				// ����һ��Intent����װ��PendingIntent��
				Intent intent = new Intent(MainActivity.this,
						ResultActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(
						MainActivity.this, 0, intent,
						PendingIntent.FLAG_CANCEL_CURRENT);

				// ����Notification���趨��StyleΪInboxStyle
				Notification noti = new Notification.Builder(
						MainActivity.this)
						.setSmallIcon(R.drawable.msg)
						.setLargeIcon(btm)
						.setNumber(13)
						.setContentIntent(pendingIntent)
						.setStyle(
								new Notification.InboxStyle()
										.addLine(
												"M.Twain (Google+) Haiku is more than a cert...")
										.addLine("M.Twain Reminder")
										.addLine("M.Twain Lunch?")
										.addLine("M.Twain Revised Specs")
										.addLine("M.Twain ")
										.addLine(
												"Google Play Celebrate 25 billion apps with Goo..")
										.addLine(
												"Stack Exchange StackOverflow weekly Newsl...")
										.setBigContentTitle("6 new message")
										.setSummaryText("plokmju@sina.com"))
						.build();

				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, noti);
			}
		});

		btnProgreNotification.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				builder = new Notification.Builder(MainActivity.this)
						.setSmallIcon(R.drawable.ic_launcher)
						.setContentTitle("Picture Download")
						.setContentText("Download in progress");
				builder.setAutoCancel(true);
				// ͨ��һ�����̣߳���̬���ӽ������̶�
				new Thread(new Runnable() {
					@Override
					public void run() {
						int incr;
						for (incr = 0; incr <= 100; incr += 5) {
							// ����Notification�Ľ���
							builder.setProgress(100, incr, false);
							manager.notify(0, builder.build());
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								Log.i(TAG, "sleep failure");
							}
						}
						// ָ��������ɺ���ʾ���ı�
						builder.setContentText("Download complete")
								.setProgress(0, 0, false);
						// ���·���Notification��idһ�����滻֮ǰ��Notification
						manager.notify(0, builder.build());
					}
				}).start();
			}
		});

		btnProNotification.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				builder = new Notification.Builder(MainActivity.this)
						.setSmallIcon(R.drawable.ic_launcher)
						.setContentTitle("Picture Download")
						.setContentText("Download in progress");
				// ����Ϊtrue����ʾ�޿̶ȵ�ѭ������
				builder.setProgress(0, 0, true);
				manager.notify(0, builder.build());

				// 5��֮��ֹͣ����
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						builder.setProgress(100, 100, false);
						// ���·���Notification��idһ�����滻֮ǰ��Notification
						manager.notify(0, builder.build());
					}
				}).start();
			}
		});

		btnCustomNotification.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RemoteViews contentViews = new RemoteViews(getPackageName(),
						R.layout.custom_notification);
				// ͨ���ؼ���Id��������
				contentViews
						.setImageViewResource(R.id.imageNo, R.drawable.btm1);
				contentViews.setTextViewText(R.id.titleNo, "�Զ���֪ͨ����");
				contentViews.setTextViewText(R.id.textNo, "�Զ���֪ͨ����");

				Intent intent = new Intent(MainActivity.this,
						ResultActivity.class);

				PendingIntent pendingIntent = PendingIntent.getActivity(
						MainActivity.this, 0, intent,
						PendingIntent.FLAG_CANCEL_CURRENT);
				Notification.Builder mBuilder = new Notification.Builder(
						MainActivity.this).setSmallIcon(R.drawable.ic_launcher)
						.setContentTitle("My notification")
						.setTicker("new message");
				mBuilder.setAutoCancel(true);

				mBuilder.setContentIntent(pendingIntent);
				mBuilder.setContent(contentViews);
				mBuilder.setAutoCancel(true);
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, mBuilder.build());
			}
		});
	}
}
