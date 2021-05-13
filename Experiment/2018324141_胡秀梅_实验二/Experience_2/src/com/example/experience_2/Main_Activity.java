package com.example.experience_2;

import java.util.Calendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ViewSwitcher.ViewFactory;

public class Main_Activity extends Activity {
	//six
	Button startBtn1;
	Button startBtn2;
	ProgressDialog pd1;
	ProgressDialog pd2;
	
	/*//five
	ImageSwitcher imgSwt;
	Gallery glr;
	//��Ҫ��ʾ��ͼƬ��Դ,������drawableĿ¼��
	int[] imgs={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
	//����ײ���Galley��ʹ�õ�ImageView
	ImageView[] galleryViews=new ImageView[imgs.length];
	*/
	
	/*//three
	ProgressBar pb1;
	ProgressBar pb2;
	ProgressBar pb3;
	ProgressBar pb4;
	Button startBtn;*/
	
	/*//second
	DatePicker dp;
	TimePicker tp;
	DigitalClock dc;
	AnalogClock ac;
	TextView tv;*/
	
	
	
	/*//first
	 private static final String[] phonenumberStr=new String[]{
		"88888888888","86668888","77777777","66666666","861434129","861238888"
	};*/

	
	@SuppressLint("HandlerLeak") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//six
		setContentView(R.layout.progress_dialog);
		startBtn1=(Button) findViewById(R.id.startBtn1);
		startBtn2=(Button) findViewById(R.id.startBtn2);
		
		pd1=new ProgressDialog(this);
		pd2=new ProgressDialog(this);
		pd1.setMessage("���Ժ�......");
		pd2.setMessage("���Ժ�......");
		pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //���ý�����Ϊ����
		final int max=100;	//�������ֵ
		final Handler handler=new Handler(){
			public void handleMessage(Message msg){
				int p=msg.what;
				//�����ﵽ���ֵ,���ؽ�����
				if(p==max){
					pd1.hide();
					pd2.hide();
				}
				//�޸����ν������Ի���Ľ���
				pd2.setProgress(p);
			};
		};
		
		startBtn1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				pd1.show();
				new Thread(){
					@Override
					public void run(){
						for(int i=1;i<=max;i++){
							try{
								Thread.sleep(50);
								Message msg=new Message();
								msg.what=i;
								handler.sendMessage(msg);	//������Ϣ
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				}.start();
				
			}
			
		});
		startBtn2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				pd2.show();
				new Thread(){
					@Override
					public void run(){
						for(int i=1;i<=max;i++){
							try{
								Thread.sleep(50);
								Message msg=new Message();
								msg.what=i;
								handler.sendMessage(msg);	//������Ϣ
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				}.start();
				
			}
			
		});
		
		/*//five
		setContentView(R.layout.image_switcher);
		imgSwt=(ImageSwitcher) findViewById(R.id.imgSwt);
		glr=(Gallery) findViewById(R.id.glr);
		//����ImageSwitcher��ʾͼƬ�Ĺ���
		imgSwt.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				ImageView iv=new ImageView(Main_Activity.this);
				iv.setBackgroundColor(0xFF000000);
				iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
				return iv;
			}
		});
		//����ImageSwitcher�Ľ��붯��
		imgSwt.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		//����ImageSwitcher���˳�����
		imgSwt.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		//��ʼ������Galleryʹ�õ�ImageView
		for(int i=0;i<galleryViews.length;i++){
			ImageView iv=new ImageView(Main_Activity.this);
			iv.setImageResource(imgs[i]);
			iv.setAdjustViewBounds(true);
			iv.setLayoutParams(new Gallery.LayoutParams(android.widget.Gallery.LayoutParams.WRAP_CONTENT,android.widget.Gallery.LayoutParams.WRAP_CONTENT));
			galleryViews[i]=iv;
		}
		//����Gallery��������
		glr.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				return galleryViews[position];
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				return imgs.length;
			}
		});
		//����Gallery��ѡ�е��¼�
		glr.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				imgSwt.setImageResource(imgs[arg2]);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		*/
		
		/*//four
		setContentView(R.layout.seekbar);
		sb=(SeekBar) findViewById(R.id.sb);
		stv=(TextView) findViewById(R.id.stv);
		final int max=sb.getMax();
		
		sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				dragging=false;	//ֹͣ
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				dragging=true;	//��ʼ�϶�
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				int p=sb.getProgress();
				stv.setText("����:"+p*100/max+"%");
				if(p==max){
					finshed=true;
				}
			}
		});
		new Thread(){
			public void run(){
				while(!finshed){
					if(!dragging){
						try{
							Thread.sleep(50);
							sb.incrementProgressBy(1);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		*/
		/*//three
		setContentView(R.layout.progress);
		pb1=(ProgressBar) findViewById(R.id.pb1);
		pb2=(ProgressBar) findViewById(R.id.pb2);
		pb3=(ProgressBar) findViewById(R.id.pb3);
		pb4=(ProgressBar) findViewById(R.id.pb4);
		startBtn=(Button) findViewById(R.id.starBtn);
		final int max = pb4.getMax(); //���ֵ
		final Handler handler = new Handler(){
			public void handleMessage(Message msg){
				int p=msg.what;
				//�����ﵽ���ֵ,����Բ�ν�����
				if(p==max){
					pb1.setVisibility(View.GONE);
					pb2.setVisibility(View.GONE);
					pb3.setVisibility(View.GONE);
				}
				pb4.setProgress(p);	//�޸Ľ������ľ���
				pb4.setSecondaryProgress(p*2);	//�޸����ν������ĵڶ�����
			};
		};
		startBtn.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				//��ʾ�ĸ�������
				pb1.setVisibility(View.VISIBLE);
				pb2.setVisibility(View.VISIBLE);
				pb3.setVisibility(View.VISIBLE);
				pb4.setVisibility(View.VISIBLE);
				
				//ģ���ʱ����
				new Thread(){
					public void run(){
						for(int i=1;i<=max;i++){
							try{
								Thread.sleep(50);
								Message msg=new Message();
								msg.what=i;
								handler.sendMessage(msg);
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				}.start();
			}
		});
		*/
		/*//second
		setContentView(R.layout.date_picker);
		
		dp=(DatePicker) findViewById(R.id.dp);
		tp=(TimePicker) findViewById(R.id.tp);
		dc=(DigitalClock) findViewById(R.id.dc);
		ac=(AnalogClock) findViewById(R.id.ac);
		tv=(TextView) findViewById(R.id.tv);
		
		Calendar c=Calendar.getInstance();
		dp.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				display();
				
			}
		});
		tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				display();
			}
		});*/
		
		/*//first
		setContentView(R.layout.activity_main);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, phonenumberStr);
		AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoTextView);
		autoCompleteTextView.setAdapter(adapter);*/
	}
	
	
	/*//second
	void display(){
		int y=dp.getYear();
		int m=dp.getMonth();
		int d=dp.getDayOfMonth();
		int h=tp.getCurrentHour();
		int mi=tp.getCurrentMinute();
		int s=Calendar.getInstance().get(Calendar.SECOND);
		tv.setText(y+"-"+m+"-"+d+" "+h+":"+":"+mi+":"+s);
	}*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_, menu);
		return true;
	}

}
