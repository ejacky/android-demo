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
	// 构建一个Drawable ID数组
	private int[] resIds = new int[] { R.drawable.bmp1, R.drawable.bmp2,
			R.drawable.bmp3, R.drawable.bmp4, R.drawable.bmp5, R.drawable.bmp6 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gridView = (GridView) findViewById(R.id.gridview);
		imageView = (ImageView) findViewById(R.id.iamgeview);		

		// 为GridView指定Adapter
		gridView.setAdapter(new ImageAdapter(this));
		// 为GridView指定点击项事件监听器
		gridView.setOnItemClickListener(itemClick);
		imageView.setImageResource(resIds[0]);
	}

	private OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 点击后，修改预览图
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
			// 数据源的数据总数
			return resIds.length;
		}

		@Override
		public Object getItem(int position) {
			// position位置的数据
			return resIds[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageview;
			// 如果convertView为null，使用数据源的数据
			// 构造数据项显示的View
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
