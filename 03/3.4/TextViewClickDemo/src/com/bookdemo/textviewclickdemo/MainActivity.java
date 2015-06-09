package com.bookdemo.textviewclickdemo;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private TextView clickTextView1, clickTextView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		clickTextView1 = (TextView) this.findViewById(R.id.clickTextView1);
		clickTextView2 = (TextView) this.findViewById(R.id.clickTextView2);
		// ʹ��SpannableString��װ�ַ���
		SpannableString spannableString1 = new SpannableString(
				"��Ӧ����TextView�ĵ���¼�");
		SpannableString spannableString2 = new SpannableString(
				"��Ӧ����TextView��click�¼�");
		// ͨ��setSpan�趨�ı�����Ӧ�ĵ���¼�
		spannableString1.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				// ��ʾ��Ϣ
				Toast.makeText(MainActivity.this, "��TextView��\n�������",
						Toast.LENGTH_SHORT).show();
			}
		}, 4, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		spannableString2.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "��click��\n�������",
						Toast.LENGTH_SHORT).show();
			}
		}, 13, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// ��TextView�ı����и�ֵ
		clickTextView1.setText(spannableString1);
		// ���õ����Ӧ
		clickTextView1.setMovementMethod(LinkMovementMethod.getInstance());
		clickTextView2.setText(spannableString2);
		clickTextView2.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
