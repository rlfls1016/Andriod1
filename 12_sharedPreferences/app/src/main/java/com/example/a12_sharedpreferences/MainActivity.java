package com.example.a12_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    editText = (EditText)findViewById(R.id.editText);
        SharedPreferences pref = getSharedPreferences("HellowWorld", MODE_PRIVATE);
        String str = pref.getString("myText","");
        Toast.makeText(MainActivity.this, "str: " +str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    String str = editText.getText().toString();
        SharedPreferences pref = getSharedPreferences("HellowWorld", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("myText", str);
        editor.commit();  //sharedpreferences에 저장된 값이 넘어와서 저장된다.
    }
}
