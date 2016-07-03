package com.example.a08_thread;
// 독립적으로 돌아가는 코드를 '스레드' 라고 한다.
//메인 프로그램과는 별도로 독립적으로 돌아가는 프로그램.
//스레드 여러개에 핸들러 하나를 보통 사용.
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ProgressBar progressBar;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == THREAD_TEST){
                btn.setText("count:" +msg.arg1);
                progressBar.setProgress(msg.arg1);
            }
        }
    };
private static final int THREAD_TEST = 100;
    class MyThread extends Thread{

        public void run(){
            //0.1초마다 로그를 찍어보는 부븐
            for(int i=0; i<100; i++){
                Log.d("ThreadTest", "count: "+i);
               // btn.setText("Count" +i);
                Message msg = new Message();
                msg.what= THREAD_TEST;
                msg.arg1 = i;
                handler.sendMessage(msg);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
    }



    public void onBtnClick(View v){
        MyThread th = new MyThread();
        th.start();
    }
}
