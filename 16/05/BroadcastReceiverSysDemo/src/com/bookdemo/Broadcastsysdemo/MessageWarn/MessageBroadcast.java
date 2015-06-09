package com.bookdemo.Broadcastsysdemo.MessageWarn;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MessageBroadcast extends BroadcastReceiver {
	// 在模拟器上，通过DDMS发送短信会产生乱码，所以使用拼音代替
	//在真机上不存在乱码的问题
	private final String[] blackKeyWord = new String[] { "baoxian", "chuxiao",
			"jiangjia" };

	@Override
	public void onReceive(Context context, Intent intent) {
		// 判断当前接收到的Broadcast是否是收到短信的action
		if (intent.getAction()
				.equals("android.provider.Telephony.SMS_RECEIVED")) {
			StringBuilder sb = new StringBuilder();
			// 获取Broadcast传递的数据
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Object[] pdus = (Object[]) bundle.get("pdus");
				for (Object p : pdus) {
					byte[] pud = (byte[]) p;
					// 声明一个SmsMessage，用于解析短信的byte[]数组
					SmsMessage message = SmsMessage.createFromPdu(pud);
					boolean flag = false;
					for (String str : blackKeyWord) {
						if (message.getMessageBody().contains(str) ) {
							// 发现黑名单关键字，则标记为true
							flag = true;
							break;
						}
					}
					if (flag) {
						sb.append("发件人：\n");
						sb.append(message.getOriginatingAddress());
						sb.append("\n发送时间：\n");
						Date date = new Date(message.getTimestampMillis());
						SimpleDateFormat format = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						sb.append(format.format(date));
						sb.append("\n短信内容：\n");
						sb.append(message.getMessageBody());

						Toast.makeText(context, sb.toString(),
								Toast.LENGTH_SHORT).show();
						// 如果存在黑名单关键字内容，停止Broadcast传播
						abortBroadcast();
					}
					
				}
			}
		}
	}
}
