package com.bookdemo.frameanimationdemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ToCodeActivity extends Activity {
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

		frameAnim =new AnimationDrawable();
		// ΪAnimationDrawable��Ӷ���֡
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img0), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img1), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img2), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img3), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img4), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img5), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img6), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img7), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img8), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img9), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img10), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img11), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img12), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img13), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img14), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img15), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img16), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img17), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img18), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img19), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img20), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img21), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img22), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img23), 50);
		frameAnim.addFrame(getResources().getDrawable(R.drawable.img24), 50);
		// ����Ϊѭ������
		frameAnim.setOneShot(false);
		
		// ����ImageView�ı���ΪAnimationDrawable
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
			Toast.makeText(ToCodeActivity.this, "��ʼ����", 0).show();
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
			Toast.makeText(ToCodeActivity.this, "ֹͣ����", 0).show();
		}
	}

}
