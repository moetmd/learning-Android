package org.niit.myapp;

import org.niit.entity.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button login_bt = (Button)findViewById(R.id.button2);
		Button reset_bt = (Button)findViewById(R.id.button1);

		final EditText name_ui = (EditText)findViewById(R.id.editText1);
		final EditText password_ui = (EditText)findViewById(R.id.editText2);
		
		login_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = name_ui.getText().toString();
				String password = password_ui.getText().toString();
				Intent intent = null;
				
				
				if("xf".equalsIgnoreCase(name) && "123".equals(password)){
					Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
					
					//用键值对传递参数
					intent = new Intent(MainActivity.this,SuccessActivity.class);
//					intent.putExtra("username", name);
//					intent.putExtra("password", password);
					
					//用对象传递参数
					User user = new User();
					user.setName(name);
					user.setPassword(password);
					Bundle bundle = new Bundle();
					bundle.putSerializable("userinfo", user);
					
					intent.putExtras(bundle);
					
					
					
				}else{
					Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
					intent = new Intent(MainActivity.this,ErrorActivity.class);
				}
				startActivity(intent);
			}
		});
		
		
		reset_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				name_ui.setText("");
				password_ui.setText("");
				
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
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}


}
