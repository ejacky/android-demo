package com.bookdemo.loadermanagerdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class LoaderActivity extends Activity {
	private LoaderManager manager;
	private ListView listview;
	private AlertDialog alertDialog;
	private SimpleCursorAdapter mAdapter;
	private final String TAG = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listView1);
		// 使用一个SimpleCursorAdapter，布局使用android自带的布局资源simple_list_item_1，
		// android.R.id.text1 为simple_list_item_1中TextView的Id
		mAdapter = new SimpleCursorAdapter(LoaderActivity.this,
				android.R.layout.simple_list_item_1, null,
				new String[] { "name" }, new int[] { android.R.id.text1 }, 0);

		// 获取Loader管理器。
		manager = getLoaderManager();
		// 初始化并启动一个Loader，设定标识为1000，并制定一个回调函数。
		manager.initLoader(1000, null, callbacks);

		// 为ListView注册一个上下文菜单
		registerForContextMenu(listview);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// 声明一个上下文菜单，contentmenu中声明了两个菜单，添加和删除
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.contentmenu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_add:
			// 声明一个对话框
			AlertDialog.Builder builder = new AlertDialog.Builder(
					LoaderActivity.this);
			// 加载一个自定义布局，add_name中有一个EditText和Button控件。
			final View view = LayoutInflater.from(LoaderActivity.this).inflate(
					R.layout.add_name, null);
			Button btnAdd = (Button) view.findViewById(R.id.btnAdd);
			btnAdd.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					EditText etAdd = (EditText) view
							.findViewById(R.id.username);
					String name = etAdd.getText().toString();
					// 使用ContentResolver进行删除操作，根据name字段。
					ContentResolver contentResolver = getContentResolver();
					ContentValues contentValues = new ContentValues();
					contentValues.put("name", name);
					Uri uri = Uri
							.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
					Uri result = contentResolver.insert(uri, contentValues);
					if (result != null) {
						// result不为空证明删除成功，重新启动Loader，注意标识需要和之前init的标识一致。
						manager.restartLoader(1000, null, callbacks);
					}
					// 关闭对话框
					alertDialog.dismiss();

					Log.i(TAG, "添加数据成功，name=" + name);
				}
			});
			builder.setView(view);
			alertDialog = builder.show();
			return true;
		case R.id.menu_delete:
			// 获取菜单选项的信息
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			// 获取到选项的TextView控件，并得到选中项的那么
			TextView tv = (TextView) info.targetView;
			String name = tv.getText().toString();
			// 使用ContentResolver进行删除操作
			Uri url = Uri
					.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
			ContentResolver contentResolver = getContentResolver();
			String where = "name=?";
			String[] selectionArgs = { name };
			int count = contentResolver.delete(url, where, selectionArgs);
			if (count == 1) {
				// 这个操作仅删除单挑记录，如果删除行为1 ，则重新启动Loader
				manager.restartLoader(1000, null, callbacks);
			}
			Log.i(TAG, "删除数据成功，name=" + name);
			return true;
		default:
			return super.onContextItemSelected(item);
		}

	}

	// Loader的回调接口
	private LoaderManager.LoaderCallbacks<Cursor> callbacks = new LoaderCallbacks<Cursor>() {

		@Override
		public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
			// 在Loader创建的时候被调用，这里使用一个ContentProvider获取数据，所以使用CursorLoader返回数据
			Uri uri = Uri
					.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
			CursorLoader loader = new CursorLoader(LoaderActivity.this, uri,
					null, null, null, null);
			Log.i(TAG, "onCreateLoader被执行。");
			return loader;
		}

		@Override
		public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
			// 刷新SimpleCursorAdapter的数据
			mAdapter.swapCursor(cursor);
			// 重新设定适配器
			listview.setAdapter(mAdapter);
			Log.i(TAG, "onLoadFinished被执行。");
		}

		@Override
		public void onLoaderReset(Loader<Cursor> loader) {
			// 当Loader被从LoaderManager中移除的时候，被执行，清空SimpleCursorAdapter适配器的Cursor
			mAdapter.swapCursor(null);
			Log.i(TAG, "onLoaderReset被执行。");
		}
	};
}
