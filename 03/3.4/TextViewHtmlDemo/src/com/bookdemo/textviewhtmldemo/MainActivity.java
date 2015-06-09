package com.bookdemo.textviewhtmldemo;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ͨ��Id�������TextView�ؼ�
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);

		// ������Ҫ��ʾ���ַ���
		String html = "<font color ='red'>Hello android</font><br/>";
		html += "<font color='#0000ff'><big><i>Hello android</i></big></font><p>";
		html += "<big><a href='http://www.baidu.com'>�ٶ�</a></big>";
		// ʹ��Html.fromHtml,�Ѻ�HTML��ǩ���ַ���ת���ɿ���ʾ���ı���ʽ
		CharSequence charSequence = Html.fromHtml(html);
		// ͨ��setText��TextView��ֵ
		textView1.setText(charSequence);
		// �趨һ���������Ӧ
		textView1.setMovementMethod(LinkMovementMethod.getInstance());

		String text = "�ҵ�URL:http://www.cnblogs.com/plokmju/\n";
		text += "�ҵ�email:plokmju@sina.com\n";
		text += "�ҵĵ绰��+86 010-12345678";
		// ��ΪtextView2����autoLink=��all���������趨�����Ի��Զ�ʶ���Ӧ�����ӣ����������Ӧ��Android����
		textView2.setText(text);
	}
}
