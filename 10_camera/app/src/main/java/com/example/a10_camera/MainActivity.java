package com.example.a10_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private static final int CAMERA_TEST = 100;
    public void onBtnClick(View v){
        String path = Environment.getDownloadCacheDirectory()+"/t10.jpg";

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  //어떤게 무엇을 실행시킨다는것을 짚어주었다.
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));
      //  startActivity(intent);
        startActivityForResult(intent, CAMERA_TEST );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_TEST){
            if(requestCode == RESULT_OK){
                String path = Environment.getDownloadCacheDirectory()+"/t10.jpg";
                Bitmap bitmap;
                bitmap = BitmapFactory.decodeFile(path);  //비트맵을 이용해 jpg를 rgbrgb 타입으로 바꿔서 가져옴
                ImageView imageView = (ImageView)findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);

            }
        }
    }
}
