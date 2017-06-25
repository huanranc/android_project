package cn.chenhuanran.app;

import cn.chenhuanran.app.bean.BreakFast;
import cn.chenhuanran.app.dao.BreakFastDao;
import cn.chenhuanran.app.dao.BreakFastDaoImpl;


import android.R.transition;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class indexActivity extends Activity{
	
	private Button onback;
	private Button onexit;
	
	 EditText txt_breakfast;
	 EditText txt_from;
	 EditText txt_time;
	 
	 EditText new_breakfast;
	 EditText new_way;
	 EditText new_time;
	 
	 BreakFastDao breakdao;
	 BreakFast breakf;
	 
	 String meal;
	 String breakfast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.page2_exit);
	    
	  
	    
	    onback= (Button) findViewById(R.id.id_back);
	    onexit= (Button) findViewById(R.id.id_exit);
	    txt_breakfast =(EditText) findViewById(R.id.ed_breakfast);
		txt_from =(EditText)findViewById(R.id.ed_from);
		txt_time =(EditText)findViewById(R.id.ed_time);
		
		new_breakfast=(EditText)findViewById(R.id.ed_breakfast);
		new_way=(EditText) findViewById(R.id.ed_from);
		new_time=(EditText) findViewById(R.id.ed_time);
		
		Intent intent=this.getIntent();
		Bundle bundle=intent.getExtras();
		breakfast=bundle.getString("breakfast");
		String from=bundle.getString("from");
		String time=bundle.getString("time");
		
		txt_breakfast.setText(breakfast);
		txt_from.setText(from);
		txt_time.setText(time);
		
		  breakdao=new BreakFastDaoImpl(this);
		  meal=breakfast;
		  breakf=breakdao.query(meal);
		
	    
	   onback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(indexActivity.this,MainActivity.class);
				intent.putExtra("back",1);
				startActivity(intent); 
				finish();

				
			}
		});
	   
	   onexit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//meal=breakfast;
			//Log.i("66",meal);
			//breakf.setMeal(new_breakfast.getText().toString().trim());
           // breakf.setWay(new_way.getText().toString().trim());
           // breakf.setTime(new_time.getText().toString().trim());
           // breakdao.update(meal, breakf);
            
            Log.i("68", new_breakfast.getText().toString().trim());
       
            Toast.makeText(indexActivity.this, "暂无更新功能", 0).show();
     
            Intent intent = new Intent(indexActivity.this,MainActivity.class);
			intent.putExtra("back",1);
			intent.putExtra("meal", meal);
			startActivity(intent); 
			finish();
			
		}
	});
	   
	   
	    
	}
	
	
}
