package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private static final int ACTIVITY_TEST = 100;  //값이 변하지 않는 상수



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //버튼클릭해서 시작하는 코드
    public void onBtnClick(View v){
        //intent 설정
        Intent intent = new Intent(MainActivity.this, NewActivity.class);
        //엑티비티정보를 더해줄때
        intent.putExtra("id", "abcd");
       // startActivity(intent);
        //ACTIVITY_TEST : Request code
        startActivityForResult(intent, ACTIVITY_TEST);
    }

    //Result를 받는부분
//Result 코드는 어떤 activity에서 오는지 보여주는 것. 구분하기 위한 int값을 넣어서 사용
    //다른 어플리케이션에서 결과값을 받아올 수도있음.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if(requestCode == ACTIVITY_TEST){
            if(resultCode ==RESULT_OK){
               String str =  data.getStringExtra("myResult");
                Toast.makeText(MainActivity.this, "res:" +str, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
