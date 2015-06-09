package com.bookdemo.ibinderservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class IBinderSer extends Service {
	private final String TAG="main";
	private final int MULTIPLE=1024;	
	public  final IBinder mBinder=new LocalBinder();
	
	public class LocalBinder extends Binder{
		// ��Binder�ж���һ���Զ���Ľӿ��������ݽ���
		// ����ֱ�Ӱѵ�ǰ�ķ��񴫻ظ�����
	    public IBinderSer getService(){
			return IBinderSer.this;
		}				
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i(TAG, "The service is binding!");
		// �󶨷��񣬰ѵ�ǰ�����IBinder��������ô��ݸ�����
		return mBinder;
	}
	
	public int getMultipleNum(int num){
		// ����һ������ �������ݽ���
		return MULTIPLE*num;
	}
}
