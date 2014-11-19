package com.niit.keyvaluedemo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import android.preference.Preference;

public class MainActivity extends Activity {
	
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText name_ui =(EditText) findViewById(R.id.et_name);
		final EditText pwd_ui =(EditText) findViewById(R.id.et_pwd);
		Button save_ui =(Button)findViewById(R.id.bt_save);
		Button read_ui =(Button)findViewById(R.id.bt_read);
		final TextView show_info = (TextView) findViewById(R.id.show_info);
		
		preferences = getSharedPreferences("info",Activity.MODE_ENABLE_WRITE_AHEAD_LOGGING);
		editor = preferences.edit();
		
		save_ui.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String name = name_ui.getText().toString();
				String pwd = pwd_ui.getText().toString();
				
				editor.putString("username", name);
				editor.putString("password", pwd);
				editor.commit();
				
				Toast.makeText(MainActivity.this, "�洢���", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
		read_ui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				show_info.setText(
						"�û�����"+preferences.getString("username",null)+"\t"+
						"���룺"+preferences.getString("password",null)
						);
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