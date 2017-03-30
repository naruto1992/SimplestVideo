package com.zxwl.simplestvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        final VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("http://125.39.142.86/data2/video09/2016/03/01/3871799-102-1615.mp4"); //设置播放路径
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vv.start();
            }
        });
        // 设置video的控制器
        vv.setMediaController(new MediaController(this));
    }
}
