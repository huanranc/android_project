package cn.chenhuanran.app;

import cn.chenhuanran.app.dao.UserDao;
import cn.chenhuanran.app.dao.UserDaoImpl;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity{
		
		String username;
		String password;
		
		EditText et_main_username;
		EditText et_main_password;
		private CheckBox cb_flag;
		private SharedPreferences sp;
		protected static final String PREFS_NAME="MyPrefsFile";
		
		TextView login_text;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		    setContentView(R.layout.page4_login);
		    
		    login_text=(TextView)findViewById(R.id.login_text);
		    
		    Button btn_main_login=(Button) findViewById(R.id.btn_main_login);
		    Button btn_main_register=(Button) findViewById(R.id.btn_main_register);
		    et_main_username= (EditText) findViewById(R.id.et_main_username);
		    et_main_password= (EditText) findViewById(R.id.et_main_password);
		    cb_flag=(CheckBox) findViewById(R.id.cb_flag);
		    
		    sp =  getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		    boolean flag=sp.getBoolean("flag", false);
		    if(flag){
		    	  String username=sp.getString("username", "");
		    	  String pwd=sp.getString("pwd", "");
		          et_main_username.setText(username);
		          et_main_password.setText(pwd);
		          cb_flag.setChecked(flag); 
		      }
		      
		   
		      btn_main_login.setOnClickListener(new OnClickListener() {
		  		
		  		public void onClick(View v) {
		  			// TODO Auto-generated method stub
		  		
		  			String username =et_main_username.getText().toString().trim();
					String pwd = et_main_password.getText().toString().trim();
					
					Editor editor = sp.edit();
					if(cb_flag.isChecked()){
						
						editor.putString("username", username);
						editor.putString("pwd",pwd);
						editor.putBoolean("flag", true);
					}else{
						editor.putString("username", "");
						editor.putString("pwd","");
						editor.putBoolean("flag", false);
					}
					editor.commit();
		  			if(username.length()==0)
		  	    	{
		  	    		Toast.makeText(LoginActivity.this, "用户名空", Toast.LENGTH_SHORT).show();
		  	    		return ;
		  	    	}
		  			UserDao userdao=new UserDaoImpl(getApplicationContext());
		  			if(userdao.query(username)==null){
		  				Toast.makeText(LoginActivity.this, "用户不存在", 0).show();
		  			}else if (et_main_password.getText().toString().trim().equals(userdao.query(username).getPassword())) {
		  				Intent intent= new Intent(LoginActivity.this, MainActivity.class);
		  				intent.putExtra("back",2);
		  				intent.putExtra("username", username);
		  				startActivity(intent);
		  				//finish();
		  			}else{
		  				Toast.makeText(LoginActivity.this, "密码错误", 0).show();
		  			}
		  			
		  		}
		  	 	
		  	});
		        
		         btn_main_register.setOnClickListener(new OnClickListener() {
		  		
		  		@Override
		  		public void onClick(View v) {
		  			// TODO Auto-generated method stub
		  			Intent intent =new Intent(LoginActivity.this, RegisterActivity.class);
		  			startActivityForResult(intent , 2);
		  		}
		  	});
		      }
		      
		      
		      
		      @Override
		      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		      	// TODO Auto-generated method stub
		      	super.onActivityResult(requestCode, resultCode, data);
		      	if(requestCode==2)
		      		switch(resultCode){
		      		case RESULT_OK:
		      			username = data.getStringExtra("username");
		      			password = data.getStringExtra("password");
		      			et_main_username.setText(username);
		      			et_main_password.requestFocus();
		      			break;
		      		case RESULT_CANCELED:
		      			Toast.makeText(LoginActivity.this, "注册失败", 0).show();
		      			break;
		      		}
		      		
		  	  }
		      
		    }
