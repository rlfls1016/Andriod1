package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //액티비티에서 새로운 액티비티로 값 전달
        Intent intent = getIntent();
                intent.getStringExtra("id");
        Toast.makeText(NewActivity.this, "str :" + str, Toast.LENGTH_SHORT).show();

    }

    public void onOkClick(View v){
        Intent intent = new Intent();
        intent.putExtra("myResult", "myResult value");
        setResult(RESULT_OK, intent);

        finish();

    }
}
