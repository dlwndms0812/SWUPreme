package com.example.swupreme;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener {

    private CheckBox mCheckBox, mCheckBox2, mCheckBox3;
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



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


        mCheckBox.setOnCheckedChangeListener(this);
        mCheckBox2.setOnCheckedChangeListener(this);
        mCheckBox3.setOnCheckedChangeListener(this);


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(mCheckBox.isChecked()) cnt+=30;
        if(mCheckBox2.isChecked()) cnt+=30;
        if(mCheckBox3.isChecked()) cnt+=30;

    }
}
