package com.bookdemo.gridviewbaseadapterdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private ImageView imageView;
	// ����һ��Drawable ID����
	private int[] resIds = new int[] { R.drawable.bmp1, R.drawable.bmp2,
			R.drawable.bmp3, R.drawable.bmp4, R.drawable.bmp5, R.drawable.bmp6 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gridView = (GridView) findViewById(R.id.gridview);
		imageView = (ImageView) findViewById(R.id.iamgeview);		

		// ΪGridViewָ��Adapter
		gridView.setAdapter(new ImageAdapter(this));
		// ΪGridViewָ��������¼�������
		gridView.setOnItemClickListener(itemClick);
		imageView.setImageResource(resIds[0]);
	}

	private OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// ������޸�Ԥ��ͼ
			imageView.setImageResource(resIds[position]);
		}
	};

	public class ImageAdapter extends BaseAdapter {

		Context context;

		public ImageAdapter(Context c) {
			this.context = c;
		}

		@Override
		public int getCount() {
			// ����Դ����������
			return resIds.length;
		}

		@Override
		public Object getItem(int position) {
			// positionλ�õ�����
			return resIds[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageview;
			// ���convertViewΪnull��ʹ������Դ������
			// ������������ʾ��View
			if (convertView == null) {
				imageview = new ImageView(context);
				imageview.setImageResource(resIds[position]);
				imageview.setScaleType(ImageView.ScaleType.FIT_XY);
			} else {
				imageview = (ImageView) convertView;
			}
			return imageview;
		}
	}
}
