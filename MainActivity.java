package com.example.asus.belajarsound;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    MediaPlayer player;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playsound(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playsound(2);
            }
        });
    }

    @Override
    public void onPause(){
        try{
            super.onPause();
            player.pause();
        }catch (Exception e){
            Toast.makeText(this,"Masuk Exception",Toast.LENGTH_LONG).show();
        }
    }

    private void playsound(int arg){
        try {
            if (player.isPlaying()){
                player.stop();
                player.release();
            }
        }catch (Exception e){
            Toast.makeText(this,"Masuk Exception",Toast.LENGTH_LONG).show();
        }
        if (arg==1){
            Toast.makeText(this,"sedang mainkan lagu 1",Toast.LENGTH_LONG).show();
            player=MediaPlayer.create(this,R.raw.lagu);
        }else if (arg==2){
            Toast.makeText(this,"sedang mainkan lagu 2",Toast.LENGTH_LONG).show();
            player=MediaPlayer.create(this,R.raw.lagu2);
        }
        player.setLooping(false);
        player.start();
    }
}
