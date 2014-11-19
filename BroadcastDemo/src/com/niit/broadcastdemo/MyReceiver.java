package com.niit.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String msg = intent.getStringExtra("msg");
		String action = intent.getAction();
		
		Toast.makeText(
				context, "�㲥��Ϣ��"+msg+"  Action��"+action, Toast.LENGTH_SHORT).show();
	}

}