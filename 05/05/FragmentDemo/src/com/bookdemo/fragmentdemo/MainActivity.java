package com.bookdemo.fragmentdemo;

import com.bookdemo.fragmentSimple.FragmentOrientationActivity;
import com.bookdemo.fragmentSimple.FragmentSimple;
import com.bookdemo.fragmentTab.FragmentTabActivity;
import com.bookdemo.fragmentTurn.FragmentTurnActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnFragmentSimple, btnFragmentOrien, btnFragmentOfActivity,btnFragmentTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnFragmentSimple = (Button) findViewById(R.id.btnFragmentSimple);
		btnFragmentOrien = (Button) findViewById(R.id.btnFragmentOrien);
		btnFragmentOfActivity = (Button) findViewById(R.id.btnFragmentOfActivity);
		btnFragmentTab = (Button) findViewById(R.id.btnFragmentTab);
		btnFragmentTab.setOnClickListener(myClick);
		btnFragmentSimple.setOnClickListener(myClick);
		btnFragmentOrien.setOnClickListener(myClick);
		btnFragmentOfActivity.setOnClickListener(myClick);
	}

	private View.OnClickListener myClick = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
			case R.id.btnFragmentSimple:
				intent = new Intent(MainActivity.this, FragmentSimple.class);
				startActivity(intent);
				break;
			case R.id.btnFragmentTab:
				intent = new Intent(MainActivity.this, FragmentTabActivity.class);
				startActivity(intent);
				break;
			case R.id.btnFragmentOrien:
				intent = new Intent(MainActivity.this,
						FragmentOrientationActivity.class);
				startActivity(intent);
				break;
			case R.id.btnFragmentOfActivity:
				intent = new Intent(MainActivity.this,
						FragmentTurnActivity.class);
				startActivity(intent);
				break;
			}
		}
	};
}
