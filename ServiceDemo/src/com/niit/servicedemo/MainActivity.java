package com.niit.servicedemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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

	
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//����intent
		intent = new Intent();
		intent.setAction("com.niit.MyService");
		
		//�ҵ����
		Button bnt1 = (Button)findViewById(R.id.bt1);
		Button bnt2 = (Button)findViewById(R.id.bt2);
		
		//��������
		bnt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startService(intent);
			}
		});
		
		//�رշ���
		bnt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				stopService(intent);
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