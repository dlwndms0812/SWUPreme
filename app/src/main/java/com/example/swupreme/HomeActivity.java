package com.example.swupreme;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener {

    private CheckBox mCheckBox, mCheckBox2, mCheckBox3;
    String str;
    static int cnt=0;
    int num=0;
    Button btn_check,btn_update;
    TextView tv;

    final static String dbName="t3.db";
    final static int dbVersion=2;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        dbHelper=new DBHelper(this,dbName,null,dbVersion);


        PieChart mPieChart = (PieChart) findViewById(R.id.tab1_chart_1);

        mPieChart.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Sleep", 25, Color.parseColor("#56B7F1")));

        mPieChart.startAnimation();

        PieChart mPieChart2 = (PieChart) findViewById(R.id.tab1_chart_2);

        mPieChart2.addPieSlice(new PieModel("흑", cnt, Color.parseColor("#FE6DA8")));
        mPieChart2.addPieSlice(new PieModel("ㅎ흑",100-cnt,Color.parseColor("#CDA67F")));
        mPieChart2.startAnimation();

        mCheckBox=findViewById(R.id.cb_complete);
        mCheckBox2=findViewById(R.id.cb_complete2);
        mCheckBox3=findViewById(R.id.cb_complete3);
        btn_check=findViewById(R.id.btn_check);
        btn_update=findViewById(R.id.btn_update);
        tv=findViewById(R.id.tv);

        mCheckBox.setOnCheckedChangeListener(this);
        mCheckBox2.setOnCheckedChangeListener(this);
        mCheckBox3.setOnCheckedChangeListener(this);

        mCheckBox.setText("살려줘");

        //num=Integer.parseInt(str);

        btn_check.setOnClickListener(this::mOnClick);
        btn_update.setOnClickListener(this::mOnClick);

        if(cnt>50){
            mCheckBox.setText("언제다해언제다해");
        }
        else if(cnt>80){
            mCheckBox.setText("하...교수님 살려주세요");
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(mCheckBox.isChecked()) cnt+=30;
        if(mCheckBox2.isChecked()) cnt+=30;
        if(mCheckBox3.isChecked()) cnt+=30;

    }


    public void mOnClick(View v){
        SQLiteDatabase db;
        String sql;

        switch (v.getId()){
            case R.id.btn_check: {
                String result=Integer.toString(cnt);
                db = dbHelper.getWritableDatabase();
                sql=String.format("INSERT INTO t3 VALUES("+result+");");
                db.execSQL(sql);
                break;
            }
            case R.id.btn_update:{

                db=dbHelper.getReadableDatabase();
                sql="SELECT*FROM t3";
                Cursor cursor=db.rawQuery(sql,null);
                if(cursor.getCount()>0){
                    while(cursor.moveToNext()){
                        tv.setText(String.format("%s",cursor.getString(0)));
                        str=cursor.getString(0);
                    }
                }
                else
                    tv.setText("조회결과가 없습니다.");
                cursor.close();
                break;
            }



        }dbHelper.close();
    }


}
