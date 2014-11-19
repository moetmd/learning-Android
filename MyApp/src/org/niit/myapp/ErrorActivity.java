package org.niit.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ErrorActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.error);
		
		Button back_bt = (Button)findViewById(R.id.error_back_bt);
		back_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ErrorActivity.this,MainActivity.class);
				startActivity(intent);
				ErrorActivity.this.finish();
			}
		});
		
		
	}
}
