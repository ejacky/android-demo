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
	// ��ģ�����ϣ�ͨ��DDMS���Ͷ��Ż�������룬����ʹ��ƴ������
	//������ϲ��������������
	private final String[] blackKeyWord = new String[] { "baoxian", "chuxiao",
			"jiangjia" };

	@Override
	public void onReceive(Context context, Intent intent) {
		// �жϵ�ǰ���յ���Broadcast�Ƿ����յ����ŵ�action
		if (intent.getAction()
				.equals("android.provider.Telephony.SMS_RECEIVED")) {
			StringBuilder sb = new StringBuilder();
			// ��ȡBroadcast���ݵ�����
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Object[] pdus = (Object[]) bundle.get("pdus");
				for (Object p : pdus) {
					byte[] pud = (byte[]) p;
					// ����һ��SmsMessage�����ڽ������ŵ�byte[]����
					SmsMessage message = SmsMessage.createFromPdu(pud);
					boolean flag = false;
					for (String str : blackKeyWord) {
						if (message.getMessageBody().contains(str) ) {
							// ���ֺ������ؼ��֣�����Ϊtrue
							flag = true;
							break;
						}
					}
					if (flag) {
						sb.append("�����ˣ�\n");
						sb.append(message.getOriginatingAddress());
						sb.append("\n����ʱ�䣺\n");
						Date date = new Date(message.getTimestampMillis());
						SimpleDateFormat format = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						sb.append(format.format(date));
						sb.append("\n�������ݣ�\n");
						sb.append(message.getMessageBody());

						Toast.makeText(context, sb.toString(),
								Toast.LENGTH_SHORT).show();
						// ������ں������ؼ������ݣ�ֹͣBroadcast����
						abortBroadcast();
					}
					
				}
			}
		}
	}
}
