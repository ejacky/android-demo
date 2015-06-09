package com.bookdemo.colormatrixdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

public class ColorMatrixActivity extends Activity {
	private SeekBar sb_red, sb_green, sb_blue,sb_alpha;
	private ImageView iv_show;
	private Bitmap afterBitmap;
	private Paint paint;
	private Canvas canvas;
	private Bitmap baseBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		iv_show = (ImageView) findViewById(R.id.iv_show);
		sb_red = (SeekBar) findViewById(R.id.sb_red);
		sb_green = (SeekBar) findViewById(R.id.sb_green);
		sb_blue = (SeekBar) findViewById(R.id.sb_blue);
		sb_alpha = (SeekBar) findViewById(R.id.sb_alpha);
		
		sb_red.setOnSeekBarChangeListener(seekBarChange);
		sb_green.setOnSeekBarChangeListener(seekBarChange);
		sb_blue.setOnSeekBarChangeListener(seekBarChange);
		sb_alpha.setOnSeekBarChangeListener(seekBarChange);

		// ����Դ�ļ��л�ȡͼƬ
		baseBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.flower);
		// ��ȡһ����baseBitmap��Сһ�µĿɱ༭�Ŀ�ͼƬ
		afterBitmap = Bitmap.createBitmap(baseBitmap.getWidth(),
				baseBitmap.getHeight(), baseBitmap.getConfig());
		canvas = new Canvas(afterBitmap);
		paint = new Paint();
	}

	private SeekBar.OnSeekBarChangeListener seekBarChange = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// ��ȡÿ��SeekBar��ǰ��ֵ
			float progressR = sb_red.getProgress()/128f;
			float progressG = sb_green.getProgress()/128f;
			float progressB = sb_blue.getProgress()/128f;
			float progressA=sb_alpha.getProgress()/128f;
			Log.i("main", "R��G��B="+progressR+"��"+progressG+"��"+progressB);
			// ����SeekBar����RGBA�ľ���
			float[] src = new float[]{
					progressR, 0, 0, 0, 0, 
					0, progressG, 0, 0, 0,
					0, 0, progressB, 0, 0, 
					0, 0, 0, progressA, 0};
			// ����ColorMatrix����ָ��RGBA����
			ColorMatrix colorMatrix = new ColorMatrix();
			colorMatrix.set(src);
			// ����Paint����ɫ
			paint.setColorFilter(new ColorMatrixColorFilter(src));
			// ͨ��ָ����RGBA�����Paint��ԭͼ�����հ�ͼƬ��
			canvas.drawBitmap(baseBitmap, new Matrix(), paint);
			iv_show.setImageBitmap(afterBitmap);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
		}
	};
}
