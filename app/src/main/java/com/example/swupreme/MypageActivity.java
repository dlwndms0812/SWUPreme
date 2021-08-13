package com.example.swupreme;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.Date;
import java.util.stream.Collectors;

public class MypageActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private TextView tx;
    private CheckBox mCheckBox, mCheckBox2, mCheckBox3;
    private int cnt=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

    mCheckBox=findViewById(R.id.cb_complete);
    mCheckBox2=findViewById(R.id.cb_complete2);
    mCheckBox3=findViewById(R.id.cb_complete3);
    tx=findViewById(R.id.tx);

    mCheckBox.setOnCheckedChangeListener(this);
    mCheckBox2.setOnCheckedChangeListener(this);
    mCheckBox3.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        String result="";
        int cnt=0;
        if(mCheckBox.isChecked()) cnt+=30;
        if(mCheckBox2.isChecked()) cnt+=30;
        if(mCheckBox3.isChecked()) cnt+=30;
        result=String.valueOf(cnt);
        tx.setText(result);
    }
}
