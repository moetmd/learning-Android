package com.niit.contentproviderdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.provider.ContactsContract;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ȡcontentresolver 
		ContentResolver contentResolver = getContentResolver();
		
		//����������ϵ��
		Cursor cursor = contentResolver.query(
				ContactsContract.Contacts.CONTENT_URI, null,null,null,null);
		
		List<Object>  itemList=new ArrayList<Object>();
		
		System.out.println("��ϵ����Ϣ��");
		
		while(cursor.moveToNext()){
			
			
			
			//�õ���ϵ�˵ı��
			String id = cursor.getString(
					cursor.getColumnIndex(ContactsContract.Contacts._ID)
					);
			//�õ���ϵ������
			String name = cursor.getString(
					cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
					);
			
			System.out.println("��ţ�"+id+"\t����"+name);
			
			//�õ�ָ���û��ĵ绰      ������ϵ��ID��ѯ
			Cursor phone = contentResolver.query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI
					, null, 
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+id
					, null, null);
			
			//�������û��绰
			while(phone.moveToNext()){
				String tel = phone.getString(phone.getColumnIndex(
						ContactsContract.CommonDataKinds.Phone.NUMBER
						));
				System.out.println("\t�绰��"+tel);
			}
			
			
			
		}

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