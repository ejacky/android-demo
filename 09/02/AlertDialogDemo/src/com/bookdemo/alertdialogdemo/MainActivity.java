package com.bookdemo.alertdialogdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnGeneral, btnButtons, btnListView, btnListViewSingle,
			btnListViewMulti, btnCustomDialog;
	private AlertDialog alertDialog;
	private final CharSequence[] items = { "北京", "上海", "深圳" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnGeneral = (Button) findViewById(R.id.btnGeneral);
		btnButtons = (Button) findViewById(R.id.btnButtons);
		btnListView = (Button) findViewById(R.id.btnListView);
		btnListViewSingle = (Button) findViewById(R.id.btnListViewSingle);
		btnListViewMulti = (Button) findViewById(R.id.btnListViewMulti);
		btnCustomDialog = (Button) findViewById(R.id.btnCustomDialog);

		btnGeneral.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 构建一个AlertDialog的构造器类
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				// 为AlertDialog设定一个标题
				builder.setTitle("提示");
				// 为AlertDialog设定一个消息内容
				builder.setMessage("这是一个普通的对话框！");
				// 为AlertDialog设定一个图标
				builder.setIcon(R.drawable.ic_launcher);
				// 设定对话框为模态
				builder.setCancelable(false);
				// 为AlertDialog设定一个按钮
				builder.setPositiveButton("知道了！", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// 取消对话框
						dialog.cancel();
					}
				});
				// 构建AlertDialog并显示它
				builder.create().show();
			}
		});

		btnButtons.setOnClickListener(new View.OnClickListener() {
			// 声明一个对话框按钮的点击事件监听器
			private DialogInterface.OnClickListener dialogButtonClick = new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case DialogInterface.BUTTON_POSITIVE:
						Toast.makeText(MainActivity.this, "确定被点击" + which,
								Toast.LENGTH_SHORT).show();
						break;
					case DialogInterface.BUTTON_NEGATIVE:
						Toast.makeText(MainActivity.this, "否定被点击" + which,
								Toast.LENGTH_SHORT).show();
						break;
					case DialogInterface.BUTTON_NEUTRAL:
						Toast.makeText(MainActivity.this, "忽略被点击" + which,
								Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
					}
					dialog.dismiss();
				}
			};

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("提示");
				builder.setMessage("这是一个多按钮普通的对话框！");
				builder.setIcon(R.drawable.ic_launcher);
				// 为AlertDialog添加三个按钮
				builder.setPositiveButton("确定", dialogButtonClick);
				builder.setNegativeButton("否定", dialogButtonClick);
				builder.setNeutralButton("忽略", dialogButtonClick);
				// Builder类提供show()方法，可以忽略create()过程
				builder.show();
			}
		});

		btnListView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("请选择城市");
				// items使用全局的finalCharSequenece数组声明
				builder.setItems(items, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String select_item = items[which].toString();
						Toast.makeText(MainActivity.this,
								"选择了--->>" + select_item, Toast.LENGTH_SHORT)
								.show();
					}
				});
				builder.show();
			}
		});

		btnListViewSingle.setOnClickListener(new View.OnClickListener() {
			// 记录选中项的序号
			private int iwhich = 1;

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("请选择一个城市");
				builder.setSingleChoiceItems(items, iwhich,
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								iwhich = which;
							}
						});
				builder.setPositiveButton("确定", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (iwhich != -1) {
							String select_item = items[iwhich].toString();
							Toast.makeText(MainActivity.this,
									"选择了--->>" + select_item,
									Toast.LENGTH_SHORT).show();
						}
						dialog.dismiss();
					}
				});
				builder.show();
			}
		});

		btnListViewMulti.setOnClickListener(new View.OnClickListener() {
			// 记录选中项的数组
			private boolean[] icheckedItems = new boolean[] { true, false, true };

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("请选择城市");
				builder.setMultiChoiceItems(items, icheckedItems,
						new OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which, boolean isChecked) {
								// 记录当前选项是否被选中
								icheckedItems[which] = isChecked;

							}
						});
				builder.setPositiveButton("确定", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// 循环获取选中项
						StringBuilder sbuilder = new StringBuilder();
						for (int i = 0; i < icheckedItems.length; i++) {
							if (icheckedItems[i]) {
								sbuilder.append(items[i] + "|");
							}
						}
						Toast.makeText(MainActivity.this,
								"选择了--->>" + sbuilder.toString(),
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});
				builder.show();
			}
		});

		btnCustomDialog.setOnClickListener(new View.OnClickListener() {
			View view;

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				// 根据Layout资源，inflater一个View对象
				view = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.dialog_signin, null);
				Button btn = (Button) view.findViewById(R.id.btnCustom);
				btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						EditText etus = (EditText) view
								.findViewById(R.id.username);
						EditText etpwd = (EditText) view
								.findViewById(R.id.password);
						Toast.makeText(
								MainActivity.this,
								"用户名：" + etus.getText().toString() + "\n密码："
										+ etpwd.getText().toString(),
								Toast.LENGTH_SHORT).show();
						alertDialog.dismiss();
					}
				});
				builder.setView(view);
				alertDialog = builder.show();

			}
		});

	}
}
