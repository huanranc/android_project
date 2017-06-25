package cn.chenhuanran.app;


import java.util.ArrayList;
import java.util.List;

import cn.chenhuanran.app.dao.MyHellper;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{

	 private ViewPager pager;	//使用的ViewPager
	 private FragmentPagerAdapter Adapter;	//适配器
	 private List<Fragment> mFragments;
	
	 private LinearLayout text1;
	 private LinearLayout text2;
	 private LinearLayout text3;
	 private LinearLayout text4;
	 
	 private TextView txt1;
	 private TextView txt2;
	 private TextView txt3;
	 private TextView txt4;
	 
	 
	 private Fragment  page1;
	 private Fragment  page2;
	 private Fragment  page3;
	 private Fragment  page4;
	 

	
	    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        
        initView();	
        initEvents();
        
        
        
        
        // 设置默认的Fragment  
       setDefaultFragment();  
       
       
       Intent intert=getIntent();
       int id = intert.getIntExtra("back",-1);
       String username=  intert.getStringExtra("username");
       if(id>0){
    	   restText();
    	   System.out.println("返回的编号"+id);
       if(id==1){
    	       FragmentManager fm=getFragmentManager();
    	       FragmentTransaction transaction=fm.beginTransaction();
    		   transaction.replace(R.id.id_content, page2); //这里是指定跳转到指定的fragment
    		   txt2.setTextColor(Color.parseColor("#449efe"));
    		   transaction.commit();
    		  finish();
    	   }
       else  if(id==2){
	       FragmentManager fm=getFragmentManager();
	       FragmentTransaction transaction=fm.beginTransaction();
	       Log.i("66", username);
	       
		   transaction.replace(R.id.id_content, page4); //这里是指定跳转到指定的fragment
		   txt4.setTextColor(Color.parseColor("#449efe"));
		   transaction.commit();
		//finish();
	   }
    	   }
    }
    
	private void setDefaultFragment() {
		// TODO Auto-generated method stub
		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction=fm.beginTransaction();
		page1=new indexFragment();
		transaction.replace(R.id.id_content, page1);
		transaction.commit();
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		text1.setOnClickListener( this);
		text2.setOnClickListener( this);
		text3.setOnClickListener( this);
		text4.setOnClickListener( this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		
		//pager=(ViewPager) findViewById(R.id.id_viewpager);
		
		text1=(LinearLayout) findViewById(R.id.text1);
    	text2=(LinearLayout) findViewById(R.id.text2);
    	text3=(LinearLayout) findViewById(R.id.text3);
    	text4=(LinearLayout) findViewById(R.id.text4);
	    
    	txt1=(TextView) findViewById(R.id.txt1);
    	txt2=(TextView) findViewById(R.id.txt2);
    	txt3=(TextView) findViewById(R.id.txt3);
    	txt4=(TextView) findViewById(R.id.txt4);
    	
    	//mFragments=new ArrayList<Fragment>();
    	
    	page1=new indexFragment();
    	page2=new RecodeFragment();
    	page3=new EveryFragment();
    	page4=new LoginFragment();
	
    /*	
    	mFragments.add(page1);
    	mFragments.add(page2);
    	mFragments.add(page3);
    	mFragments.add(page4);*/
    	
	}
	
	private void setSelect(int i) {
		// TODO Auto-generated method stub
		//设置区域内容 和文字颜色切换
		
		FragmentManager fm=getFragmentManager();
		//开启Fragment事务
		FragmentTransaction transaction=fm.beginTransaction();
		//hideFragment(transaction);
		
		switch (i) {
		case 0:
			if(page1==null){
				page1=new indexFragment();
			}
			transaction.replace(R.id.id_content, page1);
			txt1.setTextColor(Color.parseColor("#449efe"));
			break;
		case 1:
			if(page2==null){
				page2=new RecodeFragment();
			}
			transaction.replace(R.id.id_content, page2);
			txt2.setTextColor(Color.parseColor("#449efe"));
			break;
		case 2:
			if(page3==null){
				page3=new EveryFragment();
			}
			transaction.replace(R.id.id_content, page3);
			txt3.setTextColor(Color.parseColor("#449efe"));
			break;	
		case 3:
			if(page4==null){
				page4=new LoginFragment();
			}
			transaction.replace(R.id.id_content, page4);
			txt4.setTextColor(Color.parseColor("#449efe"));
			break;
		default:
			break;
		}
		
		transaction.commit();
	}
	/*
	private void hideFragment(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if(page1!=null){
			
		}
	}*/

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		restText();
		switch (v.getId()) {
		case R.id.text1:
			setSelect(0);
			//txt1.setTextColor(Color.parseColor("#449efe"));
			break;
		case R.id.text2:
			setSelect(1);
			//txt2.setTextColor(Color.parseColor("#449efe"));
			break;
		case R.id.text3:
			setSelect(2);
			//txt3.setTextColor(Color.parseColor("#449efe"));
			break;
		case R.id.text4:
			setSelect(3);
			//txt4.setTextColor(Color.parseColor("#449efe"));
			break;

		}
	}
	
	/**
	 * 切换文字至暗色
	 */

	private void restText() {
		// TODO Auto-generated method stub
		txt1.setTextColor(Color.parseColor("#7f8393"));
		txt2.setTextColor(Color.parseColor("#7f8393"));
		txt3.setTextColor(Color.parseColor("#7f8393"));
		txt4.setTextColor(Color.parseColor("#7f8393"));
	}

   
}
