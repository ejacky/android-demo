package com.bookdemo.menudemo;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActionModeMenu extends Activity {
	private ListView listview;
	private List<String> dataList;
	private ActionMode mActionMode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contextmenu1);
		listview=(ListView)findViewById(R.id.listView1);
		dataList=getData();
		ArrayAdapter<String> adapter=new  ArrayAdapter<String>(ActionModeMenu.this,android.R.layout.simple_list_item_1, dataList);
		listview.setAdapter(adapter);
		listview.setOnItemLongClickListener(new OnItemLongClickListener() {
			@SuppressLint("NewApi")
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {		
				if (mActionMode != null) {
		            return false;
		        }
				//��ʾActionMode
		        mActionMode = startActionMode(mActionModeCallback);
		        //���ѡ������±�
		        mActionMode.setTag(position);
		        //���ListViewΪ��ѡ״̬
		        view.setSelected(true);
		        return true;
			}
		});
	}
	public List<String> getData()
	{
		List<String> data=new ArrayList<String>();
		for(int i=0;i<8;i++)
		{
			data.add("item"+i);
		}
		return data;
	}
	
	@SuppressLint("NewApi")
	private ActionMode.Callback mActionModeCallback=new Callback() {
		
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			//ˢ�²˵��б��ʱ�򱻵��ã�����һ������ˢ��
			return false;
		}
		
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			//����ActionMode
			mActionMode = null;
		}
		
		@SuppressLint("NewApi")
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			//����ActionMode
			//ʹ����Դ�ļ����
			MenuInflater inflater = mode.getMenuInflater();
	        inflater.inflate(R.menu.contextmenu, menu);
	        return true;
		}

		@SuppressLint("NewApi")
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			//��ȡѡ�����±�
			int position=(Integer)mode.getTag();
			switch (item.getItemId()) {
            case R.id.context_copy:
    			Toast.makeText(ActionModeMenu.this, "copy "+dataList.get(position), Toast.LENGTH_SHORT).show();
    			//finish�˳�ActionModeģʽ
    			mode.finish();
    			return true;
    		case R.id.context_delete:
    			Toast.makeText(ActionModeMenu.this, "delete "+dataList.get(position), Toast.LENGTH_SHORT).show();
    			mode.finish();
    			return true;
    		case R.id.context_edit:
    			Toast.makeText(ActionModeMenu.this, "edit " +dataList.get(position), Toast.LENGTH_SHORT).show();
    			mode.finish();
    			return true;
            default:
                return false;
        }
		}
	};	
}
