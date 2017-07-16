package com.example.linchpin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListEmployees extends AppCompatActivity {
    public SQLiteDatabase obj;
    int a,b,c,d,e;
    public int i;
    ListView employeelist;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> emlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);
        a=getIntent().getIntExtra("a",20);
        b=getIntent().getIntExtra("b",20);
        c=getIntent().getIntExtra("c",20);
        d=getIntent().getIntExtra("d",20);
        e=getIntent().getIntExtra("e",20);
        employeelist=(ListView)findViewById(R.id.lv);
        emlist=new ArrayList<>();
        obj=openOrCreateDatabase("EmployeeDB",MODE_PRIVATE,null);
        obj.execSQL("drop table if exists employee;");
        obj.execSQL("CREATE TABLE if not exists employee(name vaarchar2(20),p1 number(3),p2 number(3),p3 number(3),p4 number(3),p5 number(3));");
        obj.execSQL("insert into employee values('Prashanth',50,60,70,80,20);");
        obj.execSQL("insert into employee values('Sreeram',90,80,40,80,70);");
        obj.execSQL("insert into employee values('Sreenath',60,60,60,80,60);");
        obj.execSQL("insert into employee values('Ram',55,75,95,40,98);");
        obj.execSQL("insert into employee values('Elavarasan',65,45,95,85,85);");
        obj.execSQL("insert into employee values('Gowtham',100,90,90,62,75);");
        obj.execSQL("insert into employee values('Prem',70,70,80,80,80);");
    }
    public void proceed(View view)
    {
        Intent obj=new Intent(ListEmployees.this,IncentiveChoice.class);
        startActivity(obj);
    }
    public void assess(View view) {
        if(i==0) {
            i=1;
            Cursor c2 = obj.rawQuery("select * from employee;", null);
            c2.moveToFirst();
            try {
                while (true) {
                    String name = c2.getString(0);
                    int pv1 = c2.getInt(1);
                    int pv2 = c2.getInt(2);
                    int pv3 = c2.getInt(3);
                    int pv4 = c2.getInt(4);
                    int pv5 = c2.getInt(5);
                    float result1 = 0;
                    float result2 = 0;
                    float result3 = 0;
                    float result4 = 0;
                    float result5 = 0;

                    if (a != 0) {
                        float temp = (pv1 * a);
                        result1 = temp / 10000;
                        //result1 = result1 / a;
                    }
                    if (b != 0) {
                        float temp = (pv2 * b);
                        result2 = temp / 10000;
                    }
                    if (c != 0) {
                        float temp = (pv3 * c);
                        result3 = temp / 10000;
                    }
                    if (d != 0) {
                        float temp = (pv4 * d);
                        result4 = temp / 10000;
                    }
                    if (e != 0) {
                        float temp = (pv5 * e);
                        result5 = temp / 10000;
                    }
                    float score = 100 * (result1 + result2 + result3 + result4 + result5);
                    String s = name + " : " + String.valueOf(score);
                    emlist.add(s);
                    c2.moveToNext();
                }

            } catch (Exception E) {
                arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, emlist);
                employeelist.setAdapter(arrayAdapter);
            }
        }
    }
}
