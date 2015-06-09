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
	 * 透明度变化
	 */
	protected void toAlpha() {
		// 动画从透明变为不透明
		AlphaAnimation anim = new AlphaAnimation(1.0f, 0.5f);
		// 动画单次播放时长为2秒
		anim.setDuration(2000);
		// 动画播放次数
		anim.setRepeatCount(2);
		// 动画播放模式为REVERSE
		anim.setRepeatMode(Animation.REVERSE);
		// 设定动画播放结束后保持播放之后的效果
		anim.setFillAfter(true);
		// 开始播放，iv_anim是一个ImageView控件
		iv_anim.startAnimation(anim);
	}

	/**
	 * 组合动画
	 */
	protected void toSetAnim() {
		AnimationSet animSet = new AnimationSet(false);
		// 依照图片的中心，从0°旋转到360°
		RotateAnimation ra = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		ra.setDuration(2000);
		ra.setRepeatCount(2);
		ra.setRepeatMode(Animation.REVERSE);

		// 以图片的中心位置，从原图的20%开始放大到原图的2倍
		ScaleAnimation sa = new ScaleAnimation(0.2f, 2.0f, 0.2f, 2.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		sa.setDuration(2000);
		sa.setRepeatCount(2);
		sa.setRepeatMode(Animation.REVERSE);

		// 动画从透明变为不透明
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.5f);
		// 动画单次播放时长为2秒
		aa.setDuration(2000);
		// 动画播放次数
		aa.setRepeatCount(2);
		// 动画播放模式为REVERSE
		aa.setRepeatMode(Animation.REVERSE);
		// 设定动画播放结束后保持播放之后的效果
		aa.setFillAfter(true);

		animSet.addAnimation(sa);
		animSet.addAnimation(aa);
		animSet.addAnimation(ra);

		iv_anim.startAnimation(animSet);
	}

	/**
	 * 旋转变化
	 */
	protected void toRotate() {
		// 依照图片的中心，从0°旋转到360°
		RotateAnimation anim = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		anim.setDuration(2000);
		anim.setRepeatCount(2);
		anim.setRepeatMode(Animation.REVERSE);
		iv_anim.startAnimation(anim);
	}

	/**
	 * 比例缩放变化
	 */
	protected void toScale() {
		// 以图片的中心位置，从原图的20%开始放大到原图的2倍
		ScaleAnimation anim = new ScaleAnimation(0.2f, 2.0f, 0.2f, 2.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		anim.setDuration(2000);
		anim.setRepeatCount(2);
		anim.setRepeatMode(Animation.REVERSE);
		iv_anim.startAnimation(anim);
	}

	/**
	 * 位移变化
	 */
	protected void toTranslate() {
		// 从父窗口的（0.1,0.1）的位置移动父窗口X轴20%Y轴20%的距离
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
