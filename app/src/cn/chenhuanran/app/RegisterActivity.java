package cn.chenhuanran.app;




import cn.chenhuanran.app.bean.User;
import cn.chenhuanran.app.dao.UserDao;
import cn.chenhuanran.app.dao.UserDaoImpl;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.page4_list);
	    
	    Button btn_register_ok= (Button) findViewById(R.id.btn_register_ok);
		Button btn_register_cancel= (Button) findViewById(R.id.btn_register_cancel);
		
		
	
		btn_register_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText et_register_username =	(EditText) findViewById(R.id.et_register_username);
				EditText et_register_password =	(EditText) findViewById(R.id.et_register_password);
				EditText password2=(EditText)findViewById(R.id.editText3);
			
				if(et_register_username.getText().toString().trim().length()==0||et_register_password.toString().trim().length()==0||password2.toString().trim().length()==0)
		    	{
		    		Toast.makeText(RegisterActivity.this, "�û���������Ϊ��", Toast.LENGTH_SHORT).show();
		    		return ;
		    	}
				if(et_register_password.getText().toString().equals(password2.getText().toString())){
				String username =et_register_username.getText().toString().trim();
				String password =et_register_password.getText().toString().trim();
	
			//	Intent intent= new Intent();
			//	intent.putExtra("username", username);
			//	intent.putExtra("password", password);
				
			//	setResult(RESULT_OK,intent);
			//	finish();
				UserDao user=new UserDaoImpl(RegisterActivity.this);
				  
				//������ݿ�����û�
			    if(user.query(username)!=null){
			    	Toast.makeText(RegisterActivity.this, "���û��Ѿ�����", Toast.LENGTH_LONG).show();
			    	return;
			    }
			    user.insert(new User(username, password));
			    
			    Intent intent= new Intent();
				intent.putExtra("username", username);
			    intent.putExtra("password", password);	
				setResult(RESULT_OK,intent);
				finish();
				
				}
				else{
					   Toast.makeText(RegisterActivity.this, "�����������벻һ�£������ԣ�", 0).show();
					 }
				
			}
		});
		
		btn_register_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	
	}
	
	
}
