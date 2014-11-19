package org.niit.myapp;

import org.niit.entity.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success);
		
		Button back_bt = (Button)findViewById(R.id.success_back_bt);
		TextView name_tv = (TextView)findViewById(R.id.show_username);
		TextView pass_tv = (TextView)findViewById(R.id.show_password);
		
		//获取参数
		Intent intent = getIntent();
//		Bundle bundle = intent.getExtras();
//		
//		name_tv.setText(bundle.getString("username"));
//		pass_tv.setText(bundle.getString("password"));
		
		//从对象中获取
		User user = (User)intent.getSerializableExtra("userinfo");
		name_tv.setText(user.getName());
		pass_tv.setText(user.getPassword());
		
		back_bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SuccessActivity.this,MainActivity.class);
				startActivity(intent);
				
				SuccessActivity.this.finish();
			}
		});
	}

}
