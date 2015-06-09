package com.bookdemo.handlermsgdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class SendMessageActivity extends Activity {
	private Button btn1, btn2, btn3, btn4,btn5;
    private static TextView tvMes;
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 3||msg.what==5) {
                tvMes.setText("what=" + msg.what + "������һ������Ϣ");
            } else {
                tvMes.setText("what=" + msg.what + "," + msg.obj.toString());
            }

        };
    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvMes = (TextView) findViewById(R.id.tvMes);
        btn1 = (Button) findViewById(R.id.btnMessage1);
        btn2 = (Button) findViewById(R.id.btnMessage2);
        btn3 = (Button) findViewById(R.id.btnMessage3);
        btn4 = (Button) findViewById(R.id.btnMessage4);
        btn5 = (Button) findViewById(R.id.btnMessage5);
        
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ʹ��Message.Obtain+Hander.sendMessage()������Ϣ
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = Message.obtain();
                        msg.what = 1;
                        msg.obj = "ʹ��Message.Obtain+Hander.sendMessage()������Ϣ";
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // ʹ��Message.sendToTarget������Ϣ
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = Message.obtain(handler);
                        msg.what = 2;
                        msg.obj = "ʹ��Message.sendToTarget������Ϣ";
                        msg.sendToTarget();
                    }
                }).start();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            // ����һ���ӳ���Ϣ
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(3);
                    }
                }).start();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = Message.obtain();
                        msg.what =4;
                        msg.obj = "ʹ��Message.Obtain+Hander.sendMessage()�����ӳ���Ϣ";
                        handler.sendMessageDelayed(msg, 3000);
                    }
                }).start();
            }
        });
        
        btn5.setOnClickListener(new View.OnClickListener() {
            // ����һ���ӳٵĿ���Ϣ
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessageDelayed(5, 3000);
                    }
                }).start();
            }
        });
	}
}
