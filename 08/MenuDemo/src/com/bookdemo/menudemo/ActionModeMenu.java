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
				//显示ActionMode
		        mActionMode = startActionMode(mActionModeCallback);
		        //标记选中项的下表
		        mActionMode.setTag(position);
		        //标记ListView为可选状态
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
			//刷新菜单列表的时候被调用，但是一般无需刷新
			return false;
		}
		
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			//销毁ActionMode
			mActionMode = null;
		}
		
		@SuppressLint("NewApi")
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			//创建ActionMode
			//使用资源文件填充
			MenuInflater inflater = mode.getMenuInflater();
	        inflater.inflate(R.menu.contextmenu, menu);
	        return true;
		}

		@SuppressLint("NewApi")
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			//获取选项中下表
			int position=(Integer)mode.getTag();
			switch (item.getItemId()) {
            case R.id.context_copy:
    			Toast.makeText(ActionModeMenu.this, "copy "+dataList.get(position), Toast.LENGTH_SHORT).show();
    			//finish退出ActionMode模式
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
