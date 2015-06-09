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

		// ���û��ʣ��������
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
	 * ���ݲ�������ͼƬX����Y��ķ����������
	 * @param x X������ű���
	 * @param y Y������ű���
	 */
	protected void bitmapScale(float x, float y) {
		// �������������bitmapScale(2.0f, 4.0f);
		// ��ΪҪ��ͼƬ�Ŵ�����Ҫ���ݷŴ�ĳߴ����´���Bitmap
		Bitmap afterBitmap = Bitmap.createBitmap(
				(int) (baseBitmap.getWidth() * x),
				(int) (baseBitmap.getHeight() * y), baseBitmap.getConfig());
		// ��ʼ��Canvas����
		Canvas canvas = new Canvas(afterBitmap);
		// ��ʼ��Matrix����
		Matrix matrix = new Matrix();
		// ���ݴ���Ĳ����������ű���
		matrix.setScale(x, y);
		// �������ű�������ͼƬdraw��Canvas��
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

	/**
	 * ��бͼƬ
	 * @param dx X�᷽�����б����
	 * @param dy Y�᷽�����б����
	 */
	protected void bitmapSkew(float dx, float dy) {
		// �������������bitmapSkew(0.2f, 0.4f);
		// ����ͼƬ����б����������任��ͼƬ�Ĵ�С��
		Bitmap afterBitmap = Bitmap.createBitmap(baseBitmap.getWidth()
				+ (int) (baseBitmap.getWidth() * dx), baseBitmap.getHeight()
				+ (int) (baseBitmap.getHeight() * dy), baseBitmap.getConfig());
		Canvas canvas = new Canvas(afterBitmap);
		Matrix matrix = new Matrix();
		// ����ͼƬ��б�ı���
		matrix.setSkew(dx, dy);
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

	/**
	 * ���ݴ���Ĳ�����ָ��X����Y�᷽���ƶ��ľ���
	 * @param dx
	 * @param dy
	 */
	protected void bitmapTranslate(float dx, float dy) {
		// �������������bitmapTranslate(20f, 20f);
		// ��Ҫ�����ƶ��ľ���������ͼƬ�Ŀ���ͼ��С
		Bitmap afterBitmap = Bitmap.createBitmap(
				(int) (baseBitmap.getWidth() + dx),
				(int) (baseBitmap.getHeight() + dy), baseBitmap.getConfig());
		Canvas canvas = new Canvas(afterBitmap);
		Matrix matrix = new Matrix();
		// �����ƶ��ľ���
		matrix.setTranslate(dx, dy);
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

	/**
	 *  ���ݲ�������ͼƬ��ת�ĽǶȣ����������ĵ�Ϊ�������ת
	 * @param degrees ͼƬ��ת�ĽǶ�
	 */
	protected void bitmapRotate(float degrees) {
		// �������������bitmapRotate(180);
		// ����һ����ԭͼһ����С��ͼƬ
		Bitmap afterBitmap = Bitmap.createBitmap(baseBitmap.getWidth(),
				baseBitmap.getHeight(), baseBitmap.getConfig());
		Canvas canvas = new Canvas(afterBitmap);
		Matrix matrix = new Matrix();
		// ָ��Matrix����ԭͼ������λ����תdegrees�ĽǶ�
		matrix.setRotate(degrees, baseBitmap.getWidth() / 2,
				baseBitmap.getHeight() / 2);
		canvas.drawBitmap(baseBitmap, matrix, paint);
		iv_after.setImageBitmap(afterBitmap);
	}

}
