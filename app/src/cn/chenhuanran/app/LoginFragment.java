package cn.chenhuanran.app;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

	Button bt_login;
	TextView login_text;
	String username;
	boolean flag;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view= inflater.inflate(R.layout.page4, container, false);
		
		bt_login =(Button) view.findViewById(R.id.id_login);
		login_text=(TextView) view.findViewById(R.id.login_text);
		 
		 
		Intent intent=getActivity().getIntent();
	    
	    username=intent.getStringExtra("username");
	    flag=false;
	    if(username!=null){
	    	login_text.setText(username);
	    	bt_login.setText("×¢Ïú"); 
	    	flag=true;
	 
	    }
	   
	    
		bt_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    if(flag==false){
				Intent intent = new Intent(getActivity(), LoginActivity.class);
				startActivity(intent);
			    }
			    else if(flag==true){
			    	Toast.makeText(getActivity(), "×¢Ïú³É¹¦", 0).show();
			    	login_text.setText("Î´µÇÂ¼");
			    	bt_login.setText("µÇÂ¼»ò×¢²á"); 
			    	flag=false;
			    	username=null;
			    	
			    }
							
						
							
			    }
		});
		
		return view;
	}
	
}
