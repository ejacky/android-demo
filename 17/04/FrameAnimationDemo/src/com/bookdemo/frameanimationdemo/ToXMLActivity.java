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

		// 通过逐帧动画的资源ID获得AnimationDrawable实例
		frameAnim = (AnimationDrawable) getResources().getDrawable(
				R.drawable.bullet_anim);
		// 把AnimationDrawable设置为ImageView的背景
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
	 * 开始播放逐帧动画
	 */
	protected void start() {
		// 判断逐帧动画对象是否为空以及当前是否正在播放
		if (frameAnim != null && !frameAnim.isRunning()) {
			// 开始播放
			frameAnim.start();
			Toast.makeText(ToXMLActivity.this, "开始播放", 0).show();
		}
	}

	/**
	 * 停止播放逐帧动画
	 */
	protected void stop() {
		// 判断逐帧动画对象是否为空以及当前是否正在播放
		if (frameAnim != null && frameAnim.isRunning()) {
			// 停止播放
			frameAnim.stop();
			Toast.makeText(ToXMLActivity.this, "停止播放", 0).show();
		}
	}
}
