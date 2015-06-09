package com.bookdemo.frameanimationdemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ToXMLActivity extends Activity {

	private Button btn_start, btn_stop;
	private ImageView iv_frame;
	private AnimationDrawable frameAnim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frameanim);

		btn_start = (Button) findViewById(R.id.btn_start);
		btn_stop = (Button) findViewById(R.id.btn_stop);

		btn_start.setOnClickListener(click);
		btn_stop.setOnClickListener(click);

		iv_frame = (ImageView) findViewById(R.id.iv_frame);

		// ͨ����֡��������ԴID���AnimationDrawableʵ��
		frameAnim = (AnimationDrawable) getResources().getDrawable(
				R.drawable.bullet_anim);
		// ��AnimationDrawable����ΪImageView�ı���
		iv_frame.setBackgroundDrawable(frameAnim);
	}

	private View.OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_start:
				start();
				break;
			case R.id.btn_stop:
				stop();
				break;
			default:
				break;
			}
		}
	};

	/**
	 * ��ʼ������֡����
	 */
	protected void start() {
		// �ж���֡���������Ƿ�Ϊ���Լ���ǰ�Ƿ����ڲ���
		if (frameAnim != null && !frameAnim.isRunning()) {
			// ��ʼ����
			frameAnim.start();
			Toast.makeText(ToXMLActivity.this, "��ʼ����", 0).show();
		}
	}

	/**
	 * ֹͣ������֡����
	 */
	protected void stop() {
		// �ж���֡���������Ƿ�Ϊ���Լ���ǰ�Ƿ����ڲ���
		if (frameAnim != null && frameAnim.isRunning()) {
			// ֹͣ����
			frameAnim.stop();
			Toast.makeText(ToXMLActivity.this, "ֹͣ����", 0).show();
		}
	}
}
