package com.bookdemo.actionbardocdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class AddActionView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_menuview, menu);
		// ͨ��ID�ҵ�MenuItem����
		MenuItem item = menu.findItem(R.id.menu_search);
		// �ҵ���ǰѡ���ActionView
		SearchView view = (SearchView) item.getActionView();
		// ���ò�ѯ�¼�������
		view.setOnQueryTextListener(new OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String query) {
				Toast.makeText(AddActionView.this, query, 0)
				.show();
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) {				
				return false;
			}
		});

		return super.onCreateOptionsMenu(menu);
	}
}
