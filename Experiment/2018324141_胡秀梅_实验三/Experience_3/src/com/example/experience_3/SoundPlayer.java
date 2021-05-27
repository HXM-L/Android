package com.example.experience_3;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SoundPlayer extends Activity {
	MediaPlayer player;
	
	Button startBtn;
	Button pauseBtn;
	Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound);
        
        //播放res/raw目录下的fist_file文件
        player=MediaPlayer.create(SoundPlayer.this, R.raw.first_file);
        startBtn = (Button) findViewById(R.id.startBtn);
        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        
        //播放完成事件
        player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				startBtn.setEnabled(true);
				pauseBtn.setEnabled(false);
				stopBtn.setEnabled(false);
;			}
		});
        
        //开始按钮
        startBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.start();	//开始播放
				startBtn.setEnabled(false);
				pauseBtn.setEnabled(true);
				stopBtn.setEnabled(true);
			}
		});
        
        //暂停播放按钮
        pauseBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.pause();	//暂停播放
				startBtn.setEnabled(true);
				pauseBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			}
		});
        
      //停止播放按钮
        stopBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.stop();	//停止播放
				startBtn.setEnabled(true);
				pauseBtn.setEnabled(false);
				stopBtn.setEnabled(false);
				try {
					player.prepare(); //为下次播放做准备
					player.seekTo(0);	//回到音频起点
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    protected void OnDestory() {
		super.onDestroy();
		player.release();	//释放资源
	}
    
}
