package com.bookdemo.checkboxdemo;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_new, btn_inflate, btn_check;
	private LinearLayout ll_checkgroup;
	private String[] checkboxCN = new String[] { "红色", "黄色", "蓝色", "绿色" };
	private String[] checkboxEN = new String[] { "red", "yellow", "blue",
			"green" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_new = (Button) findViewById(R.id.btn_new);
		btn_inflate = (Button) findViewById(R.id.btn_inflate);
		btn_check = (Button) findViewById(R.id.btn_check);
		ll_checkgroup = (LinearLayout) findViewById(R.id.ll_checkgroup);

		btn_new.setOnClickListener(click);
		btn_inflate.setOnClickListener(click);
		btn_check.setOnClickListener(click);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_new:
				// 在添加前确保布局为空
				if (ll_checkgroup.getChildCount() > 0) {
					ll_checkgroup.removeAllViews();
				}
				for (String cn : checkboxCN) {
					// 实例化一个CheckBox
					CheckBox checkbox = new CheckBox(MainActivity.this);
					checkbox.setText(cn);
					// 把实例化的CheckBox对象加到布局中
					ll_checkgroup.addView(checkbox);
				}
				break;
			case R.id.btn_inflate:
				if (ll_checkgroup.getChildCount() > 0) {
					ll_checkgroup.removeAllViews();
				}
				for (String en : checkboxEN) {
					// 加载XML资源，得到一个CheckBox对象
					CheckBox checkbox = (CheckBox) getLayoutInflater().inflate(
							R.layout.checkboxtemp, null);
					checkbox.setText(en);
					ll_checkgroup.addView(checkbox);
				}
				break;
			case R.id.btn_check:
				String msg = "";
				if (ll_checkgroup.getChildCount() > 0) {
					for (int i = 0; i < ll_checkgroup.getChildCount(); i++) {
						View view = ll_checkgroup.getChildAt(i);
						// 判断子View是否是ChechBox
						if (view instanceof CheckBox) {
							CheckBox box = (CheckBox) view;
							// 当前CheckBox是否被选中
							if (box.isChecked()) {
								msg += box.getText() + "\n";
							}
						}
					}
					if (TextUtils.isEmpty(msg)) {
						Toast.makeText(MainActivity.this, "请选择您喜欢的颜色",
								Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(MainActivity.this, "您喜欢的颜色有：\n" + msg,
								Toast.LENGTH_SHORT).show();

					}
				} else {
					Toast.makeText(MainActivity.this, "请生成颜色选择列表",
							Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		}
	};
}
