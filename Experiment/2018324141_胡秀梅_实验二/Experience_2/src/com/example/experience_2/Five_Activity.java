package com.example.experience_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;

public class Five_Activity extends Activity{
	//five
	ImageSwitcher imgSwt;
	Gallery glr;
	//��Ҫ��ʾ��ͼƬ��Դ,������drawableĿ¼��
	int[] imgs={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
	//����ײ���Galley��ʹ�õ�ImageView
	ImageView[] galleryViews=new ImageView[imgs.length];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//five
		setContentView(R.layout.image_switcher);
		imgSwt=(ImageSwitcher) findViewById(R.id.imgSwt);
		glr=(Gallery) findViewById(R.id.glr);
		//����ImageSwitcher��ʾͼƬ�Ĺ���
		imgSwt.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				ImageView iv=new ImageView(Five_Activity.this);
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
			ImageView iv=new ImageView(Five_Activity.this);
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
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_, menu);
		return true;
	}
}
