package com.example.linchpin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ParameterActiivty extends AppCompatActivity {

    EditText p1,p2,p3,p4,p5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter_actiivty);
        p1=(EditText)findViewById(R.id.p1);
        p2=(EditText)findViewById(R.id.p2);
        p3=(EditText)findViewById(R.id.p3);
        p4=(EditText)findViewById(R.id.p4);
        p5=(EditText)findViewById(R.id.p5);


    }

    public void compute(View view)
    {
        int a= Integer.parseInt(p1.getText().toString());
        int b= Integer.parseInt(p2.getText().toString());
        int c= Integer.parseInt(p3.getText().toString());
        int d= Integer.parseInt(p4.getText().toString());
        int e= Integer.parseInt(p5.getText().toString());
        int sum=a+b+c+d+e;
        TextView tobj=(TextView)findViewById(R.id.status);
        if(sum==100)
        {
           Intent employeeintent=new Intent(ParameterActiivty.this,ListEmployees.class);
            employeeintent.putExtra("a",a);
            employeeintent.putExtra("b",b);
            employeeintent.putExtra("c",c);
            employeeintent.putExtra("d",d);
            employeeintent.putExtra("e",e);
            startActivity(employeeintent);
        }
        else
        {
            tobj.setText("Sum of values must be equal to 100");
        }
    }
}
