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
	private final CharSequence[] items = { "����", "�Ϻ�", "����" };

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
				// ����һ��AlertDialog�Ĺ�������
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				// ΪAlertDialog�趨һ������
				builder.setTitle("��ʾ");
				// ΪAlertDialog�趨һ����Ϣ����
				builder.setMessage("����һ����ͨ�ĶԻ���");
				// ΪAlertDialog�趨һ��ͼ��
				builder.setIcon(R.drawable.ic_launcher);
				// �趨�Ի���Ϊģ̬
				builder.setCancelable(false);
				// ΪAlertDialog�趨һ����ť
				builder.setPositiveButton("֪���ˣ�", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// ȡ���Ի���
						dialog.cancel();
					}
				});
				// ����AlertDialog����ʾ��
				builder.create().show();
			}
		});

		btnButtons.setOnClickListener(new View.OnClickListener() {
			// ����һ���Ի���ť�ĵ���¼�������
			private DialogInterface.OnClickListener dialogButtonClick = new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case DialogInterface.BUTTON_POSITIVE:
						Toast.makeText(MainActivity.this, "ȷ�������" + which,
								Toast.LENGTH_SHORT).show();
						break;
					case DialogInterface.BUTTON_NEGATIVE:
						Toast.makeText(MainActivity.this, "�񶨱����" + which,
								Toast.LENGTH_SHORT).show();
						break;
					case DialogInterface.BUTTON_NEUTRAL:
						Toast.makeText(MainActivity.this, "���Ա����" + which,
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
				builder.setTitle("��ʾ");
				builder.setMessage("����һ���ఴť��ͨ�ĶԻ���");
				builder.setIcon(R.drawable.ic_launcher);
				// ΪAlertDialog���������ť
				builder.setPositiveButton("ȷ��", dialogButtonClick);
				builder.setNegativeButton("��", dialogButtonClick);
				builder.setNeutralButton("����", dialogButtonClick);
				// Builder���ṩshow()���������Ժ���create()����
				builder.show();
			}
		});

		btnListView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("��ѡ�����");
				// itemsʹ��ȫ�ֵ�finalCharSequenece��������
				builder.setItems(items, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String select_item = items[which].toString();
						Toast.makeText(MainActivity.this,
								"ѡ����--->>" + select_item, Toast.LENGTH_SHORT)
								.show();
					}
				});
				builder.show();
			}
		});

		btnListViewSingle.setOnClickListener(new View.OnClickListener() {
			// ��¼ѡ��������
			private int iwhich = 1;

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("��ѡ��һ������");
				builder.setSingleChoiceItems(items, iwhich,
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								iwhich = which;
							}
						});
				builder.setPositiveButton("ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (iwhich != -1) {
							String select_item = items[iwhich].toString();
							Toast.makeText(MainActivity.this,
									"ѡ����--->>" + select_item,
									Toast.LENGTH_SHORT).show();
						}
						dialog.dismiss();
					}
				});
				builder.show();
			}
		});

		btnListViewMulti.setOnClickListener(new View.OnClickListener() {
			// ��¼ѡ���������
			private boolean[] icheckedItems = new boolean[] { true, false, true };

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("��ѡ�����");
				builder.setMultiChoiceItems(items, icheckedItems,
						new OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which, boolean isChecked) {
								// ��¼��ǰѡ���Ƿ�ѡ��
								icheckedItems[which] = isChecked;

							}
						});
				builder.setPositiveButton("ȷ��", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// ѭ����ȡѡ����
						StringBuilder sbuilder = new StringBuilder();
						for (int i = 0; i < icheckedItems.length; i++) {
							if (icheckedItems[i]) {
								sbuilder.append(items[i] + "|");
							}
						}
						Toast.makeText(MainActivity.this,
								"ѡ����--->>" + sbuilder.toString(),
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
				// ����Layout��Դ��inflaterһ��View����
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
								"�û�����" + etus.getText().toString() + "\n���룺"
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
