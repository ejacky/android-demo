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
		// 设定HTML标签样式，图片3为一个超链接标签a
		String html = "图像1<img src='image1'/>图像2<img src='image2'/>";
		html += "图像3<a href='http://www,baidu.com'><img src='image3'/></a>";
		// fromHtml中ImageGetter选择html中<img>的图片资源
		CharSequence cs = Html.fromHtml(html, new ImageGetter() {

			public Drawable getDrawable(String source) {
				// source为html字符串中定义的<img>中的src的内容
				// 返回值Drawable就是对应的<img>显示的图片资源
				Drawable draw = null;
				if (source.equals("image1")) {
					draw = getResources().getDrawable(R.drawable.image1);
					draw.setBounds(0, 0, draw.getIntrinsicWidth(),
							draw.getIntrinsicHeight());
				} else if (source.equals("image2")) {
					// 设定image2尺寸等比缩小
					draw = getResources().getDrawable(R.drawable.image2);
					draw.setBounds(0, 0, draw.getIntrinsicWidth() / 2,
							draw.getIntrinsicHeight() / 2);
				} else {
					// 使用反射会更简便，无需知道src与资源Id的对应关系
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
			// 使用反射机制，通过属性名称，得到其内的值
			Field field = R.drawable.class.getField(source);
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
