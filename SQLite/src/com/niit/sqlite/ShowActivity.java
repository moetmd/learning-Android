package com.niit.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * ��ʾ��ѯ������
 */
public class ShowActivity extends Activity {
	
	private SQLiteDatabase db;
	private ListView  listview;
	private EditText  searchtxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		listview=(ListView)findViewById(R.id.listView1);
		searchtxt=(EditText)findViewById(R.id.search_txt);
		Button  bnt=(Button)findViewById(R.id.search_bnt);
		
		//�����ݿ�
		String path=getFilesDir().toString()+"/niit.db3";
		db=SQLiteDatabase.openOrCreateDatabase(path, null);
		
		
		//��ѯ��ť
		bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				String txtname="%"+searchtxt.getText().toString()+"%";
				
				//ִ�в�ѯ
				Cursor  cursor=db.rawQuery(
						"select * from user where name like '"+txtname+"'"
						, null);
				List<Object>  itemList=new ArrayList<Object>();
				//ѭ��ȡֵ
				while(cursor.moveToNext()){
					int id=cursor.getInt(0);
					String name=cursor.getString(1);
					int age=cursor.getInt(2);
					
					itemList.add("���:"+id+"\t����:"+name+"\t����:"+age);
				}
				
				Object[] arr=itemList.toArray();
				//����������
				ArrayAdapter<Object>  adapter=new ArrayAdapter<Object>(
						ShowActivity.this,R.layout.show_item,arr);
				//������ʾ
				listview.setAdapter(adapter);
			}
		});
		
	}
}