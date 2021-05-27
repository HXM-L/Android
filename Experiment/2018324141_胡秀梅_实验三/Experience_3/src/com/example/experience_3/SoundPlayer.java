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
        
        //����res/rawĿ¼�µ�fist_file�ļ�
        player=MediaPlayer.create(SoundPlayer.this, R.raw.first_file);
        startBtn = (Button) findViewById(R.id.startBtn);
        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        
        //��������¼�
        player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				startBtn.setEnabled(true);
				pauseBtn.setEnabled(false);
				stopBtn.setEnabled(false);
;			}
		});
        
        //��ʼ��ť
        startBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.start();	//��ʼ����
				startBtn.setEnabled(false);
				pauseBtn.setEnabled(true);
				stopBtn.setEnabled(true);
			}
		});
        
        //��ͣ���Ű�ť
        pauseBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.pause();	//��ͣ����
				startBtn.setEnabled(true);
				pauseBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			}
		});
        
      //ֹͣ���Ű�ť
        stopBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.stop();	//ֹͣ����
				startBtn.setEnabled(true);
				pauseBtn.setEnabled(false);
				stopBtn.setEnabled(false);
				try {
					player.prepare(); //Ϊ�´β�����׼��
					player.seekTo(0);	//�ص���Ƶ���
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
		player.release();	//�ͷ���Դ
	}
    
}
