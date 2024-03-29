package com.niit.servicedemo2;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bt = (Button)findViewById(R.id.bt1);
		
		
		//调用  任务栏   调用系统服务
		bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,TestActivity.class);
				PendingIntent pending = PendingIntent.getActivity(
						MainActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
				
				//定义了一条通知
				Notification notification =
						new Notification
						.Builder(MainActivity.this)
						.setContentTitle("通知")
						.setContentText("您的内存已经很久没有清理了")
						.setContentIntent(pending)
						.setSmallIcon(R.drawable.ic_launcher)
						.build();
				
				//管理    调用系统任务栏通知服务
				NotificationManager notificationManager=
						(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				
				//发送通知
				notificationManager.notify(1,notification);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
