package com.example.experience_3;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends Activity {
	
	VideoView videoView;
	MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //����ʾ����
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //ȫ��
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        //����
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.video);
        
        videoView=(VideoView) findViewById(R.id.videoView);
        controller = new MediaController(this);
        //���ò����ļ�
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.first));
        //����VideoView��MediaController
        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
        //��ʼ����
        videoView.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
