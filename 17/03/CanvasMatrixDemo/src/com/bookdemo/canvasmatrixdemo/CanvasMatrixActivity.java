package com.bookdemo.canvasmatrixdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class CanvasMatrixActivity extends Activity {
	private Button btn_scale, btn_rotate, btn_translate, btn_skew;
	private ImageView iv_base, iv_after;
	private Bitmap baseBitmap;
	private Paint paint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_scale = (Button) findViewById(R.id.btn_scale);
		btn_rotate = (Button) findViewById(R.id.btn_rotate);
		btn_translate = (Button) findViewById(R.id.btn_translate);
		btn_skew = (Button) findViewById(R.id.btn_skew);

		btn_scale.setOnClickListener(click);
		btn_rotate.setOnClickListener(click);
		btn_translate.setOnClickListener(click);
		btn_skew.setOnClickListener(click);

		iv_base = (ImageView) findViewById(R.id.iv_base);
		iv_after = (ImageView) findViewById(R.id.iv_after);

		baseBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		iv_base.setImageBitmap(baseBitmap);

		// 设置画笔，消除锯齿
		paint = new Paint();
		paint.setAntiAlias(true);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.btn_scale:
				bitmapScale(2.0f, 4.0f);
				break;
			case R.id.btn_rotate:
				bitmapRotate(180);
				break;
			case R.id.btn_translate:
				bitmapTranslate(20f, 20f);
				break;
			case R.id.btn_skew:
				bitmapSkew(0.2f, 0.4f);
				break;
			default:
				break;
			}

		}
	};

	/**
	 * 根据参数，对图片X轴与Y轴的方向进行缩放
	 * @param x X轴的缩放比例
	 * @param y Y轴的缩放比例
	 */
	protected void bitmapScale(float x, float y) {
		// 方法传入参数：bitmapScale(2.0f, 4.0f);
		// 因为要将图片放大，所以要根据放大的尺寸重新创建Bitmap
		Bitmap afterBitmap = Bitmap.createBitmap(
				(int) (baseBitmap.getWidth() * x),
				(int) (baseBitmap.getHeight() * y), baseBitmap.getConfig());
		// 初始化Canvas对象
		Canvas canvas = new Canvas(afterBitmap);
		// 初始化Matrix对象
		Matrix matrix = new Matrix();
		// 根据传入的参数设置缩放比例
		matrix.setScale(x, y);
		// 根据缩放比例，把图片draw到Canvas上
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

	/**
	 * 倾斜图片
	 * @param dx X轴方向的倾斜比例
	 * @param dy Y轴方向的倾斜比例
	 */
	protected void bitmapSkew(float dx, float dy) {
		// 方法传入参数：bitmapSkew(0.2f, 0.4f);
		// 根据图片的倾斜比例，计算变换后图片的大小，
		Bitmap afterBitmap = Bitmap.createBitmap(baseBitmap.getWidth()
				+ (int) (baseBitmap.getWidth() * dx), baseBitmap.getHeight()
				+ (int) (baseBitmap.getHeight() * dy), baseBitmap.getConfig());
		Canvas canvas = new Canvas(afterBitmap);
		Matrix matrix = new Matrix();
		// 设置图片倾斜的比例
		matrix.setSkew(dx, dy);
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

	/**
	 * 根据传入的参数，指定X轴与Y轴方向移动的距离
	 * @param dx
	 * @param dy
	 */
	protected void bitmapTranslate(float dx, float dy) {
		// 方法传入参数：bitmapTranslate(20f, 20f);
		// 需要根据移动的距离来创建图片的拷贝图大小
		Bitmap afterBitmap = Bitmap.createBitmap(
				(int) (baseBitmap.getWidth() + dx),
				(int) (baseBitmap.getHeight() + dy), baseBitmap.getConfig());
		Canvas canvas = new Canvas(afterBitmap);
		Matrix matrix = new Matrix();
		// 设置移动的距离
		matrix.setTranslate(dx, dy);
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

	/**
	 *  根据参数决定图片旋转的角度，并以其中心点为轴进行旋转
	 * @param degrees 图片旋转的角度
	 */
	protected void bitmapRotate(float degrees) {
		// 方法传入参数：bitmapRotate(180);
		// 创建一个和原图一样大小的图片
		Bitmap afterBitmap = Bitmap.createBitmap(baseBitmap.getWidth(),
				baseBitmap.getHeight(), baseBitmap.getConfig());
		Canvas canvas = new Canvas(afterBitmap);
		Matrix matrix = new Matrix();
		// 指定Matrix根据原图的中心位置旋转degrees的角度
		matrix.setRotate(degrees, baseBitmap.getWidth() / 2,
				baseBitmap.getHeight() / 2);
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

}
