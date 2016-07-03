package com.example.a11_alertdialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final int DIALOG_TEST = 100;
    public void onBtnClick(View v){
        showDialog(DIALOG_TEST);
            }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==DIALOG_TEST){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
           builder.setTitle("TITLE");
            builder.setMessage("MESSAGE");
            builder.setCancelable(false);  //다이얼로그 외부에 까맣게 된 부분
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            //정보가 잘 세팅 되었다면
            return builder.create();
        }
        return null;
    }
}
