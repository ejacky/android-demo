package com.bookdemo.soundpooldemo;

import java.util.HashMap;
import java.util.Map;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SoundPoolActivity extends Activity {
	private Button btn_newqqmsg, btn_newweibontf, btn_newweibotoast;
	private SoundPool pool;
	private Map<String, Integer> poolMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_newqqmsg = (Button) findViewById(R.id.btn_newqqmsg);
		btn_newweibontf = (Button) findViewById(R.id.btn_newweibontf);
		btn_newweibotoast = (Button) findViewById(R.id.btn_newweibotoast);

		poolMap = new HashMap<String, Integer>();
		// ʵ����SoundPool���󣬴�СΪ3
		pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		// װ����Ƶ����Ƶ�أ����Ұ�ID��¼��Map��
		poolMap.put("newqqmsg", pool.load(this, R.raw.qqmsg, 1));
		poolMap.put("newweibontf", pool.load(this, R.raw.notificationsound, 1));
		poolMap.put("newweibotoast", pool.load(this, R.raw.newblogtoast, 1));

		pool.setOnLoadCompleteListener(new OnLoadCompleteListener() {

			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId,
					int status) {
				// ÿ��װ����ɾ���ص�
				Log.i("main", "��Ƶ����ԴidΪ��" + sampleId + "����Դװ�����");
				// ��ǰװ�����IDΪmap�����ֵ����Ϊ���һ��װ�����
				if (sampleId == poolMap.size()) {
					Toast.makeText(SoundPoolActivity.this, "�������������!",
							Toast.LENGTH_SHORT).show();
					btn_newqqmsg.setOnClickListener(click);
					btn_newweibontf.setOnClickListener(click);
					btn_newweibotoast.setOnClickListener(click);
					// ����Ӧ�ò����Ĵ�����
					pool.play(poolMap.get("newweibotoast"), 1.0f, 1.0f, 0, 3,
							1.0f);
				}
			}
		});
	}

	private View.OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.btn_newqqmsg:
				if (pool != null) {
					pool.play(poolMap.get("newqqmsg"), 1.0f, 1.0f, 0, 0, 1.0f);
				}
				break;
			case R.id.btn_newweibontf:
				if (pool != null) {
					pool.play(poolMap.get("newweibontf"), 1.0f, 1.0f, 0, 0,
							1.0f);
				}
				break;
			case R.id.btn_newweibotoast:
				if (pool != null) {
					pool.play(poolMap.get("newweibotoast"), 1.0f, 1.0f, 0, 0,
							1.0f);
				}
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onDestroy() {
		// ���ٵ�ʱ���ͷ�SoundPool��Դ
		if (pool != null) {
			pool.release();
			pool = null;
		}
		super.onDestroy();
	}
}
