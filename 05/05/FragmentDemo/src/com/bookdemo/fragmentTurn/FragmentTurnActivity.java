package com.bookdemo.fragmentTurn;


import com.bookdemo.fragmentdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentTurnActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragmentturn);
		// ����1����Activity�в�������Fragment�еĿؼ�
		Button btn=(Button)findViewById(R.id.btnGetText);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TextView tv=(TextView)findViewById(R.id.tvFragment1);
				tv.setText("Activity�ж�̬�޸�");
			}
		});
	}
}
