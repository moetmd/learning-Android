package com.niit.netdemo2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private  AccessNet  accessNet=new AccessNet();
	private EditText  t1,t2;
	private TextView  title;
	private  String result;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				title.setText(result);
			}
		};
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bnt=(Button)findViewById(R.id.button1);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		title=(TextView)findViewById(R.id.textView1);
		
		
		//����¼�  ���� tomcat  http://192.168.43.2:8888/web_android_server/check
		bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				//����һ���߳�
				new Thread(){
					public void run() {
						//get�ύ����
//						String result=accessNet.get(
//									"http://192.168.43.2:8888/"
//									+ "web_android_server/check?name=niit&pwd=123");
						
						
						//POST�ύ �ֱ�����url �� ����
						String url="http://192.168.43.2:8888/web_android_server/check";
						String params="name="+t1.getText()+"&pwd="+t2.getText();
						
						//����
						result=accessNet.post(url,params);
						
						//֪ͨ
						handler.sendEmptyMessage(1);
						
						Looper.prepare();
						Toast.makeText(MainActivity.this,
								result
								, Toast.LENGTH_LONG).show();
						
						Looper.loop();
					};
				}.start();
				
			}
		});
	}
	
	private  class  AccessNet{
		
		
		/**
		 * ʹ��  URLConnection  POST�ύ
		 * @param url
		 * @return
		 */
		public  String  post(String url,String params){
			StringBuffer s=new StringBuffer();
			try {
				URL urls=new URL(url);
				URLConnection conn=urls.openConnection();
				
				
				conn.setReadTimeout(5000);
				//�����������ͷ
				conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 5.2; rv:22.0) Gecko/20100101 Firefox/22.0");
				conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8 ");
				conn.setRequestProperty("accept-language", "zh-cn");
				conn.setRequestProperty("accept-encoding", "gzip, deflate");
				conn.setRequestProperty("connection", "keep-alive");
				
				//����������� POST
				conn.setDoInput(true);
				conn.setDoOutput(true);
				
				//���ݲ���ʹ�������
				PrintWriter out=new PrintWriter(conn.getOutputStream());
				out.print(params);
				out.flush(); 
				
				
				//�õ�����ķ��ص�������
				InputStream  in=conn.getInputStream();
				InputStreamReader reader=new InputStreamReader(in);
				BufferedReader br=new BufferedReader(reader);
				//ѭ����ȡ
				String line=null;
				while((line=br.readLine())!=null){
					s.append("\n"+line);
				}
				
				
				//�ر�
				if(out!=null)out.close();
				if(br!=null)br.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return s.toString();
		}
		
		/**
		 * ʹ��  URLConnection  GET�ύ
		 * @param url
		 * @return
		 */
		public  String  get(String url){
			StringBuffer s=new StringBuffer();
			try {
				URL urls=new URL(url);
				URLConnection conn=urls.openConnection();
				
				conn.setReadTimeout(5000);
				//�����������ͷ
				conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 5.2; rv:22.0) Gecko/20100101 Firefox/22.0");
				conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8 ");
				conn.setRequestProperty("accept-language", "zh-cn");
				conn.setRequestProperty("accept-encoding", "gzip, deflate");
				conn.setRequestProperty("connection", "keep-alive");
				
				
				InputStream  in=conn.getInputStream();
				InputStreamReader reader=new InputStreamReader(in);
				BufferedReader br=new BufferedReader(reader);
				//ѭ����ȡ
				String line=null;
				while((line=br.readLine())!=null){
					s.append("\n"+line);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return s.toString();
		}
		
		
		
		
		
		/**
		 * ʹ��URLֱ�ӷ�������
		 * @param url
		 * @return
		 */
		public  String  reader(String url){
			StringBuffer s=new StringBuffer();
			try {
				URL urls=new URL(url);
				InputStream  in=urls.openStream();
				InputStreamReader reader=new InputStreamReader(in);
				BufferedReader br=new BufferedReader(reader);
				//ѭ����ȡ
				String line=null;
				while((line=br.readLine())!=null){
					s.append("\n"+line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return s.toString();
		}
	}
}
