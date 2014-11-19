package com.niit.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("创建服务");
		super.onCreate();
		
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("开始执行");
		return super.onStartCommand(intent, flags, startId);
	}
	
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁服务");
		super.onDestroy();
	}
	

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		System.out.println("绑定服务");
		return null;
	}

}
