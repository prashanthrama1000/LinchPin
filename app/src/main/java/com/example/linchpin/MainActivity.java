package com.example.linchpin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public SQLiteDatabase obj;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=openOrCreateDatabase("ManagerDB",MODE_PRIVATE,null);
        obj.execSQL("CREATE TABLE if not exists manager(id varchar2(20),password varchar2(20));");
        obj.execSQL("insert into manager values('MAN2020','PASSMAN2020');");
        obj.execSQL("insert into manager values('MAN2021','PASSMAN2021');");
        obj.execSQL("insert into manager values('MAN2022','PASSMAN2022');");
        obj.execSQL("insert into manager values('MAN2023','PASSMAN2023');");
    }

    public void login(View view)
    {
        user=(EditText)findViewById(R.id.userman);
        pass=(EditText)findViewById(R.id.passman);
        String u=user.getText().toString();
        String p=pass.getText().toString();
        Cursor c=obj.rawQuery("select * from manager;",null);
        c.moveToFirst();
        while(c.isLast()!=true)
        {
            if(u.equals(c.getString(0)) && p.equals(c.getString(1)))
            {
                Intent in=new Intent(MainActivity.this,ParameterActiivty.class);
                startActivity(in);
            }
            c.moveToNext();
        }
    }

}
