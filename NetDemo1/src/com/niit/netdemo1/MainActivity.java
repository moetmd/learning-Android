package com.niit.netdemo1;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;


/**
 * 网络访问
 * 网络访问必须在线程中，不允许使用主线程
 * @author Administrator
 */
public class MainActivity extends Activity {

	private ImageView img;
	private Bitmap bm;
	
	
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			if(msg.what == 1){
				img.setImageBitmap(bm);
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		img = (ImageView)findViewById(R.id.imageView1);
		
		//线程
		new Thread(){
			public void run(){
				try{
					
					URL url = new URL("http://ww.chniit.com/NIITbrand/images/logo.jpg");
					
					InputStream in = url.openStream();
					
					bm = BitmapFactory.decodeStream(in);
					
					handler.sendEmptyMessage(1);
					
					if(in!= null)in.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();
	
	}

	

}
