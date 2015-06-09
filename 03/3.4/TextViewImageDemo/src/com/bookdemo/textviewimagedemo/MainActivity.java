package com.bookdemo.textviewimagedemo;

import java.lang.reflect.Field;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.R.color;
import android.app.Activity;
import android.graphics.drawable.Drawable;

public class MainActivity extends Activity {
	private TextView textViewImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textViewImg = (TextView) findViewById(R.id.textImg);
		textViewImg.setTextColor(color.white);
		textViewImg.setBackgroundColor(color.black);
		textViewImg.setTextSize(20);
		// �趨HTML��ǩ��ʽ��ͼƬ3Ϊһ�������ӱ�ǩa
		String html = "ͼ��1<img src='image1'/>ͼ��2<img src='image2'/>";
		html += "ͼ��3<a href='http://www,baidu.com'><img src='image3'/></a>";
		// fromHtml��ImageGetterѡ��html��<img>��ͼƬ��Դ
		CharSequence cs = Html.fromHtml(html, new ImageGetter() {

			public Drawable getDrawable(String source) {
				// sourceΪhtml�ַ����ж����<img>�е�src������
				// ����ֵDrawable���Ƕ�Ӧ��<img>��ʾ��ͼƬ��Դ
				Drawable draw = null;
				if (source.equals("image1")) {
					draw = getResources().getDrawable(R.drawable.image1);
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				} else if (source.equals("image2")) {
					// �趨image2�ߴ�ȱ���С
					draw = getResources().getDrawable(R.drawable.image2);
					draw.setBounds(0, 0, draw.getIntrinsicWidth() / 2,
							draw.getIntrinsicHeight() / 2);
				} else {
					// ʹ�÷�������㣬����֪��src����ԴId�Ķ�Ӧ��ϵ
					draw = getResources().getDrawable(getResourceId(source));
					draw.setBounds(0, 0, draw.getIntrinsicWidth()/ 3,
							draw.getIntrinsicHeight()/ 3);
				}
				return draw;
			}
		}, null);
		textViewImg.setText(cs);
		textViewImg.setMovementMethod(LinkMovementMethod.getInstance());
	}

	public int getResourceId(String source) {
		try {
			// ʹ�÷�����ƣ�ͨ���������ƣ��õ����ڵ�ֵ
			Field field = R.drawable.class.getField(source);
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
