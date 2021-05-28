package com.example.experience_3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint({ "SdCardPath", "SimpleDateFormat" })
public class Main extends Activity {
	MediaRecorder recorder1;	//¼����MediaRecorder
	Button startBtn1;
	Button stopBtn1;
	
	MediaRecorder recorder2;	//¼����MediaRecorder
	Button startBtn2;
	Button stopBtn2;
	
	SurfaceView view;	//¼��ʱԤ����ͼ
	SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initAudio();
        initVideo();
    }


    //¼��
	void initAudio() {
		recorder1=new MediaRecorder();
		startBtn1=(Button) findViewById(R.id.startBtn1);
		stopBtn1=(Button) findViewById(R.id.stopBtn1);
		
		//��ƵԴ����˷�
		recorder1.setAudioSource(MediaRecorder.AudioSource.MIC);
		//�����ʽAMR_NB
		recorder1.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		//����ļ�·��
		recorder1.setOutputFile("/sdcard/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".3gp");
		startBtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					recorder1.prepare(); //׼��¼��
					recorder1.start();	//��ʼ¼��
					startBtn1.setEnabled(false);
					stopBtn1.setEnabled(true);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		stopBtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				recorder1.stop();	//ֹͣ¼��
				recorder1.release();	//�ͷ���Դ
				startBtn1.setEnabled(true);
				stopBtn1.setEnabled(false);
			}
		});
	}

	void initVideo() {
		recorder2=new MediaRecorder();
		startBtn2=(Button) findViewById(R.id.startBtn2);
		stopBtn2=(Button) findViewById(R.id.stopBtn2);
		view=(SurfaceView) findViewById(R.id.view);
		holder=view.getHolder();
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		//ʹ��holder��surface��Ϊ¼��ʱ��Ԥ����ͼ
		recorder2.setPreviewDisplay(holder.getSurface());
		//��ƵԴ����˷�
		recorder2.setAudioSource(MediaRecorder.AudioSource.MIC);
		//��ƵԴ������ͷ
		recorder2.setVideoSource(MediaRecorder.VideoSource.CAMERA);
		//�����ʽMPEG_4
		recorder2.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		//��Ƶ�����ʽ
		recorder2.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		//��Ƶ�ֱ���
		recorder2.setVideoSize(320, 240);
		//��Ƶ֡��
		recorder2.setVideoFrameRate(20);
		//��Ƶ�����ʽH263
		recorder2.setOutputFile("/sdcard/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".mp4");
		startBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					recorder2.prepare();	//׼��¼��
					recorder2.start();	//��ʼ¼��
					startBtn2.setEnabled(false);
					stopBtn2.setEnabled(true);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		startBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					recorder2.prepare();
					recorder2.start();	//�ͷ���Դ
					startBtn2.setEnabled(true);
					stopBtn2.setEnabled(false);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	//ֹͣ¼��
			}
		});
		stopBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				recorder2.stop();	//ֹͣ¼��
				recorder2.release();	//�ͷ���Դ
				startBtn2.setEnabled(true);
				stopBtn2.setEnabled(false);
			}
		});
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
