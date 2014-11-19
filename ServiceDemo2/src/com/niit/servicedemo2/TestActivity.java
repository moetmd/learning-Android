package com.niit.servicedemo2;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

public class TestActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.test);
		
		//得到服务
		NotificationManager notificationManager=
				(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		
		//取消通知
		notificationManager.cancel(1);
		
		
	}
}
