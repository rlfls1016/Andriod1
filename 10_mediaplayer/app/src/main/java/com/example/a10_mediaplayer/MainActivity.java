
package com.example.a10_mediaplayer;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onBtnPlayClick(View v){
        String path = Environment.getExternalStorageDirectory()+
                "/Downloads/Cannon.mp3";
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();//버퍼링 해주는 뜻으로 해석
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onBtnStopClick(View v){

        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
