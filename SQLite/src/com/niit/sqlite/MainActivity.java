package com.niit.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
		
		final EditText txt=(EditText)findViewById(R.id.et_dbname);//�����ı���
		Button bnt=(Button)findViewById(R.id.bt_createdb);//�������ݿⰴť
		Button bnt2=(Button)findViewById(R.id.bt_createtable);//����������������
		Button bnt3=(Button)findViewById(R.id.bt_search);//��ʾ����
		
		
		//�������ݿ�
		bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String path=MainActivity.this.getFilesDir().toString();
				
				//.this.getFilesDir().toString()
				//�õ�·��  data/data/org.niit.sqlitedemo/files
				path+="/"+txt.getText().toString()+".db3";
				
				//�򿪻��ߴ������ݿ�
				SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(path, null);
				
				if(db.isDatabaseIntegrityOk()){
					Toast.makeText(MainActivity.this, 
							"�����ɹ�!"
							+ "\n"+path, Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(MainActivity.this, 
							"����ʧ��!"
							+ "\n"+path, Toast.LENGTH_LONG).show();
				}
				
//				Toast.makeText(MainActivity.this, 
//						"·��:"+path, Toast.LENGTH_LONG).show();
				
				//System.out.println("·��:"+path);
			}
		});
		
		//����������������
		bnt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String path=MainActivity.this.getFilesDir().toString();
				path+="/"+txt.getText().toString()+".db3";
				//�򿪻��ߴ������ݿ�
				SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(path, null);
				
				
				//ִ�����
				String sql="CREATE TABLE user("
						+"id  integer  primary key  autoincrement,"
						+"name  varchar(20),"
						+"age   int  default 0"
						+")";
				//ִ�д�����
				db.execSQL(sql);
				
				//�����������
				db.execSQL("insert  into  user(name,age) values('����',18)");
				db.execSQL("insert  into  user(name,age) values('niit',30)");
				db.execSQL("insert  into  user(name,age) values('����',25)");
				db.execSQL("insert  into  user(name,age) values('����',5)");
				
				Toast.makeText(MainActivity.this, 
						"������������������ɹ���", Toast.LENGTH_LONG).show();
			}
		});
		
		
		
		//��ת����ʾ ���ݵ�ҳ��
		bnt3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent  intent=new Intent(MainActivity.this,ShowActivity.class);
				
				EditText txt = (EditText)findViewById(R.id.textView1);
				String dbname = txt.getText().toString();
				
				intent.putExtra("dbname", dbname);
				
				startActivity(intent);
			}
		});
		
	}

}