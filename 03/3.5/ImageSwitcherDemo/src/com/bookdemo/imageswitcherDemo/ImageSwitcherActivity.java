package com.bookdemo.imageswitcherDemo;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherActivity extends Activity {
	private Button btnAdd, btnSub;
	private ImageSwitcher imageSwitcher;
	private int index = 0;
	private List<Drawable> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		putData();
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		btnAdd = (Button) findViewById(R.id.btnadd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnAdd.setOnClickListener(myClick);
		btnSub.setOnClickListener(myClick);

		// ͨ�������趨���󻺽������һ�����Ч����
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(
				ImageSwitcherActivity.this, android.R.anim.slide_in_left));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(
				ImageSwitcherActivity.this, android.R.anim.slide_out_right));
		imageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				// makeView���ص��ǵ�ǰ��Ҫ��ʾ��ImageView�ؼ�����������ImageSwitcher�С�
				return new ImageView(ImageSwitcherActivity.this);
			}
		});
		imageSwitcher.setImageDrawable(list.get(0));
	}

	private View.OnClickListener myClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnadd:
				index--;
				if (index < 0) {
					// ����ѭ����ʾͼƬ
					index = list.size() - 1;
				}
				// �趨ImageSwitcher��ʾ��ͼƬ
				imageSwitcher.setImageDrawable(list.get(index));
				break;

			case R.id.btnSub:
				index++;
				if (index >= list.size()) {
					// ����ѭ����ʾͼƬ
					index = 0;
				}
				imageSwitcher.setImageDrawable(list.get(index));
				break;
			}
		}
	};

	private void putData() {
		// ���ͼƬ��Drawable��Դ����
		list = new ArrayList<Drawable>();
		list.add(getResources().getDrawable(R.drawable.bmp1));
		list.add(getResources().getDrawable(R.drawable.bmp2));
		list.add(getResources().getDrawable(R.drawable.bmp3));
		list.add(getResources().getDrawable(R.drawable.bmp4));
		list.add(getResources().getDrawable(R.drawable.bmp5));
	}
}
