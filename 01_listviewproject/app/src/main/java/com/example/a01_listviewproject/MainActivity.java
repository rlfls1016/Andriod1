package com.example.a01_listviewproject;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String   dirPath = Environment.getExternalStorageDirectory()+"/Downloads";
        File dir = new File(dirPath);
        File[] files = dir.listFiles(); //디렉토리가 갖고 있는 파일 배열 리턴
        ArrayList<String > list = new ArrayList<String>();
        for(int i = 0; i<files.length; i++)
            list.add(files[i].getName()); //데이터 셋팅

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
