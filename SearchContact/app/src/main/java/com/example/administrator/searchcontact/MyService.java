package com.example.administrator.searchcontact;

import android.app.Service;

/**
 * Created by Administrator on 2018/11/6 0006.
 */

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.widget.Toast;
import  com.example.administrator.searchcontact.MyContact;


public class MyService extends Service {
    private final ISearchContact.Stub mBinder = new ISearchContact.Stub()
    {
        @Override
        public MyContact SearchContact(String contactName) throws RemoteException
        {
            String[] cols = {ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols, null, null, null);
            for (int i = 0; i < cursor.getCount(); i++)
            {
                cursor.moveToPosition(i);
                // 取得联系人名字
                int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
                int numberFieldColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String name = cursor.getString(nameFieldColumnIndex);
                String number = cursor.getString(numberFieldColumnIndex);
                if(contactName.equals(name))
                {
                    return new MyContact(name, number);
                }
            }

            return  new MyContact(contactName , "手机号码未保存");
        }
    };
    public MyService()
    {
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        Toast.makeText(this, "远程绑定", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        Toast.makeText(this, "取消远程绑定", Toast.LENGTH_SHORT).show();
        return false;
    }
}
