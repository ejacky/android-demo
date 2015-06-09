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
		// ʹ��һ��SimpleCursorAdapter������ʹ��android�Դ��Ĳ�����Դsimple_list_item_1��
		// android.R.id.text1 Ϊsimple_list_item_1��TextView��Id
		mAdapter = new SimpleCursorAdapter(LoaderActivity.this,
				android.R.layout.simple_list_item_1, null,
				new String[] { "name" }, new int[] { android.R.id.text1 }, 0);

		// ��ȡLoader��������
		manager = getLoaderManager();
		// ��ʼ��������һ��Loader���趨��ʶΪ1000�����ƶ�һ���ص�������
		manager.initLoader(1000, null, callbacks);

		// ΪListViewע��һ�������Ĳ˵�
		registerForContextMenu(listview);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// ����һ�������Ĳ˵���contentmenu�������������˵�����Ӻ�ɾ��
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.contentmenu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_add:
			// ����һ���Ի���
			AlertDialog.Builder builder = new AlertDialog.Builder(
					LoaderActivity.this);
			// ����һ���Զ��岼�֣�add_name����һ��EditText��Button�ؼ���
			final View view = LayoutInflater.from(LoaderActivity.this).inflate(
					R.layout.add_name, null);
			Button btnAdd = (Button) view.findViewById(R.id.btnAdd);
			btnAdd.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					EditText etAdd = (EditText) view
							.findViewById(R.id.username);
					String name = etAdd.getText().toString();
					// ʹ��ContentResolver����ɾ������������name�ֶΡ�
					ContentResolver contentResolver = getContentResolver();
					ContentValues contentValues = new ContentValues();
					contentValues.put("name", name);
					Uri uri = Uri
							.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
					Uri result = contentResolver.insert(uri, contentValues);
					if (result != null) {
						// result��Ϊ��֤��ɾ���ɹ�����������Loader��ע���ʶ��Ҫ��֮ǰinit�ı�ʶһ�¡�
						manager.restartLoader(1000, null, callbacks);
					}
					// �رնԻ���
					alertDialog.dismiss();

					Log.i(TAG, "������ݳɹ���name=" + name);
				}
			});
			builder.setView(view);
			alertDialog = builder.show();
			return true;
		case R.id.menu_delete:
			// ��ȡ�˵�ѡ�����Ϣ
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			// ��ȡ��ѡ���TextView�ؼ������õ�ѡ�������ô
			TextView tv = (TextView) info.targetView;
			String name = tv.getText().toString();
			// ʹ��ContentResolver����ɾ������
			Uri url = Uri
					.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
			ContentResolver contentResolver = getContentResolver();
			String where = "name=?";
			String[] selectionArgs = { name };
			int count = contentResolver.delete(url, where, selectionArgs);
			if (count == 1) {
				// ���������ɾ��������¼�����ɾ����Ϊ1 ������������Loader
				manager.restartLoader(1000, null, callbacks);
			}
			Log.i(TAG, "ɾ�����ݳɹ���name=" + name);
			return true;
		default:
			return super.onContextItemSelected(item);
		}

	}

	// Loader�Ļص��ӿ�
	private LoaderManager.LoaderCallbacks<Cursor> callbacks = new LoaderCallbacks<Cursor>() {

		@Override
		public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
			// ��Loader������ʱ�򱻵��ã�����ʹ��һ��ContentProvider��ȡ���ݣ�����ʹ��CursorLoader��������
			Uri uri = Uri
					.parse("content://com.example.loadermanagerdemo.StudentContentProvider/student");
			CursorLoader loader = new CursorLoader(LoaderActivity.this, uri,
					null, null, null, null);
			Log.i(TAG, "onCreateLoader��ִ�С�");
			return loader;
		}

		@Override
		public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
			// ˢ��SimpleCursorAdapter������
			mAdapter.swapCursor(cursor);
			// �����趨������
			listview.setAdapter(mAdapter);
			Log.i(TAG, "onLoadFinished��ִ�С�");
		}

		@Override
		public void onLoaderReset(Loader<Cursor> loader) {
			// ��Loader����LoaderManager���Ƴ���ʱ�򣬱�ִ�У����SimpleCursorAdapter��������Cursor
			mAdapter.swapCursor(null);
			Log.i(TAG, "onLoaderReset��ִ�С�");
		}
	};
}
