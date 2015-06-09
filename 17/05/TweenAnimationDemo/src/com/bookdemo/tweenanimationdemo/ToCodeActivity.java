package com.bookdemo.tweenanimationdemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class ToCodeActivity extends Activity {
	private Button btn_Alpha, btn_Rotate, btn_Scale, btn_Translate,
			btn_setAnim;
	private ImageView iv_anim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tween);

		btn_Alpha = (Button) findViewById(R.id.btn_Alpha);
		btn_Rotate = (Button) findViewById(R.id.btn_Rotate);
		btn_Scale = (Button) findViewById(R.id.btn_Scale);
		btn_Translate = (Button) findViewById(R.id.btn_Translate);
		btn_setAnim = (Button) findViewById(R.id.btn_setAnim);
		iv_anim = (ImageView) findViewById(R.id.iv_anim);

		btn_Alpha.setOnClickListener(click);
		btn_Rotate.setOnClickListener(click);
		btn_Scale.setOnClickListener(click);
		btn_Translate.setOnClickListener(click);
		btn_setAnim.setOnClickListener(click);
	}

	View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.btn_Alpha:
				toAlpha();
				break;
			case R.id.btn_Rotate:
				toRotate();
				break;
			case R.id.btn_Scale:
				toScale();
				break;
			case R.id.btn_Translate:
				toTranslate();
				break;
			case R.id.btn_setAnim:
				toSetAnim();
				break;
			default:
				break;
			}
		}
	};

	/**
	 * ͸���ȱ仯
	 */
	protected void toAlpha() {
		// ������͸����Ϊ��͸��
		AlphaAnimation anim = new AlphaAnimation(1.0f, 0.5f);
		// �������β���ʱ��Ϊ2��
		anim.setDuration(2000);
		// �������Ŵ���
		anim.setRepeatCount(2);
		// ��������ģʽΪREVERSE
		anim.setRepeatMode(Animation.REVERSE);
		// �趨�������Ž����󱣳ֲ���֮���Ч��
		anim.setFillAfter(true);
		// ��ʼ���ţ�iv_anim��һ��ImageView�ؼ�
		iv_anim.startAnimation(anim);
	}

	/**
	 * ��϶���
	 */
	protected void toSetAnim() {
		AnimationSet animSet = new AnimationSet(false);
		// ����ͼƬ�����ģ���0����ת��360��
		RotateAnimation ra = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		ra.setDuration(2000);
		ra.setRepeatCount(2);
		ra.setRepeatMode(Animation.REVERSE);

		// ��ͼƬ������λ�ã���ԭͼ��20%��ʼ�Ŵ�ԭͼ��2��
		ScaleAnimation sa = new ScaleAnimation(0.2f, 2.0f, 0.2f, 2.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		sa.setDuration(2000);
		sa.setRepeatCount(2);
		sa.setRepeatMode(Animation.REVERSE);

		// ������͸����Ϊ��͸��
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.5f);
		// �������β���ʱ��Ϊ2��
		aa.setDuration(2000);
		// �������Ŵ���
		aa.setRepeatCount(2);
		// ��������ģʽΪREVERSE
		aa.setRepeatMode(Animation.REVERSE);
		// �趨�������Ž����󱣳ֲ���֮���Ч��
		aa.setFillAfter(true);

		animSet.addAnimation(sa);
		animSet.addAnimation(aa);
		animSet.addAnimation(ra);

		iv_anim.startAnimation(animSet);
	}

	/**
	 * ��ת�仯
	 */
	protected void toRotate() {
		// ����ͼƬ�����ģ���0����ת��360��
		RotateAnimation anim = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		anim.setDuration(2000);
		anim.setRepeatCount(2);
		anim.setRepeatMode(Animation.REVERSE);
		iv_anim.startAnimation(anim);
	}

	/**
	 * �������ű仯
	 */
	protected void toScale() {
		// ��ͼƬ������λ�ã���ԭͼ��20%��ʼ�Ŵ�ԭͼ��2��
		ScaleAnimation anim = new ScaleAnimation(0.2f, 2.0f, 0.2f, 2.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		anim.setDuration(2000);
		anim.setRepeatCount(2);
		anim.setRepeatMode(Animation.REVERSE);
		iv_anim.startAnimation(anim);
	}

	/**
	 * λ�Ʊ仯
	 */
	protected void toTranslate() {
		// �Ӹ����ڵģ�0.1,0.1����λ���ƶ�������X��20%Y��20%�ľ���
		TranslateAnimation anim = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.1f,
				Animation.RELATIVE_TO_PARENT, 0.2f,
				Animation.RELATIVE_TO_PARENT, 0.1f,
				Animation.RELATIVE_TO_PARENT, 0.2f);
		anim.setDuration(2000);
		anim.setRepeatCount(2);
		anim.setRepeatMode(Animation.REVERSE);
		iv_anim.startAnimation(anim);
	}

}
