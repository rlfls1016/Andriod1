package com.example.a04_listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

class MyData{
String title;
    String subTitle;
    int imgId;
    public MyData(String title, String subTitle,int imgId){
        this.title = title;
        this.subTitle =  subTitle;
        this.imgId = imgId;
    }
}




    ArrayList<MyData> list = new ArrayList<MyData>();


    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null ){
              convertView = getLayoutInflater().inflate(R.layout.item_row, null);  /*itemrow를 implement 하려고 'getLayoutInflater'사용.*/
            }

           MyData data = list.get(position);
            TextView textViewTitle = (TextView)convertView.findViewById(R.id.textViewSubTitle);
            TextView textViewSubTitle = (TextView)convertView.findViewById(R.id.textViewSubTitle);
            ImageView iconView = (ImageView)convertView.findViewById(R.id.iconView);
            textViewTitle.setText(data.title);
            textViewSubTitle.setText(data.subTitle);
            iconView.setImageResource(data.imgId);


            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<20; i++){
            list.add(new MyData("title"+ i, "subTitle" +i, R.mipmap.ic_launcher));

        }
        ListView listView = (ListView)findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }
}
