package com.bookdemo.fragmentTab;

import com.bookdemo.fragmentSimple.Fragment1;
import com.bookdemo.fragmentSimple.Fragment2;
import com.bookdemo.fragmentSimple.Fragment3;
import com.bookdemo.fragmentdemo.R;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FragmentTabActivity extends Activity {
	private TextView tabfgt1, tabfgt2, tabfgt3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragmenttab);

		tabfgt1 = (TextView) findViewById(R.id.tabfgt1);
		tabfgt2 = (TextView) findViewById(R.id.tabfgt2);
		tabfgt3 = (TextView) findViewById(R.id.tabfgt3);

		tabfgt1.setOnClickListener(click);
		tabfgt2.setOnClickListener(click);
		tabfgt3.setOnClickListener(click);

	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			tabfgt1.setBackgroundColor(Color.GRAY);
			tabfgt2.setBackgroundColor(Color.GRAY);
			tabfgt3.setBackgroundColor(Color.GRAY);
			// ��ȡFragmentManager����
			FragmentManager fm = getFragmentManager();
			// ��������
			FragmentTransaction ft = fm.beginTransaction();
			switch (v.getId()) {
			case R.id.tabfgt1:
				tabfgt1.setBackgroundColor(Color.GREEN);
				// �滻R.id.content�е�Fragment
				ft.replace(R.id.content, new Fragment1());
				break;
			case R.id.tabfgt2:
				tabfgt2.setBackgroundColor(Color.YELLOW);
				ft.replace(R.id.content, new Fragment2());
				break;
			case R.id.tabfgt3:
				tabfgt3.setBackgroundColor(Color.RED);
				ft.replace(R.id.content, new Fragment3());
				break;
			default:
				break;
			}
			// �ύ����
			ft.commit();
		}
	};
}
