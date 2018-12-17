package com.example.eren.a12bir;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView) findViewById(R.id.bgvideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bgvideo);

        Log.d("hata", "onCreate: ");
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(false);
            }
        });
        final Button button2 = (Button) findViewById(R.id.Giris);
        final EditText uyeMail = (EditText) findViewById(R.id.username);
        final EditText uyePassword = (EditText) findViewById(R.id.password);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String mail = uyeMail.getText().toString();
                String password = uyePassword.getText().toString();

                Log.e("Veri",mail);
                Log.e("Veri",password);

                Database vt = new Database(MainActivity.this);

                if(vt.checkUser(mail,password)){
                    Log.d("Check","Yes");
                    Intent myIntent = new Intent(v.getContext(), MapsActivity.class);
                    startActivityForResult(myIntent, 0);

                }else{
                    Log.d("Check","No");

                }





            }
        });

        final Button button = (Button) findViewById(R.id.uye);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), uyeActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    protected void onStart() {
        mVideoView = (VideoView) findViewById(R.id.bgvideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bgvideo);
        Log.d("hata", "onCreate: ");
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(false);
            }
        });
        super.onStart();
    }
}
