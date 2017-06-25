package cn.chenhuanran.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.chenhuanran.app.bean.BreakFast;
import cn.chenhuanran.app.dao.BreakFastDao;
import cn.chenhuanran.app.dao.BreakFastDaoImpl;
import cn.chenhuanran.app.dao.MyHellper;



import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Helpers;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class RecodeFragment extends Fragment {

	 ListView listView;
	 ListAdapter listAdapter;
	 List<String> data = new ArrayList<String>();
	 
	 BreakFast breakf;
	 
	 
	 
	 TextView text_breakfast;
	 TextView text_from;
	 TextView text_time;
	 
	 EditText new_breakfast;
	 EditText new_way;
	 EditText new_time;
	 
	 BreakFastDao breakdao;
	 
	 String meal;
	    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		breakdao=new BreakFastDaoImpl(getActivity());
		//breakf=breakdao.query(meal);
		//breakdao.insert();
		
		//BreakFast breakf = new BreakFast(1, "周一", "原味松饼+牛奶", "7:00");
		//breakdao.insert(breakf);
		 
		View  view= inflater.inflate(R.layout.page2, container, false);
		
		//text_breakfast =(TextView) view.findViewById(R.id.getup_time);
		text_from =(TextView) view.findViewById(R.id.breakfast_time);
		text_time =(TextView) view.findViewById(R.id.breakfast_contain);
		
		new_breakfast=(EditText) view.findViewById(R.id.ed_breakfast);
		new_way=(EditText) view.findViewById(R.id.ed_from);
		new_time=(EditText) view.findViewById(R.id.ed_time);
		
		listView = (ListView) view.findViewById(R.id.MyListView); 
		//listView=(ListView) view.findViewById(R.id.linearLayout1);
		SimpleAdapter adapter = new SimpleAdapter(getActivity(),getData(),R.layout.page2_listitem,  
				new String[]{"getup_time","breakfast_contain","breakfast_time"}, 
	    		new int[]{R.id.getup_time,R.id.breakfast_contain,R.id.breakfast_time});  
	    listView.setAdapter(adapter);
	    
	   
	    
	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
		        TextView textView = (TextView)view.findViewById(R.id.breakfast_contain); 
		        TextView textView2 = (TextView)view.findViewById(R.id.breakfast_time); 
		        TextView textView3 = (TextView)view.findViewById(R.id.getup_time); 
				String breakfast = (String) textView.getText();
				String from = (String) textView2.getText();
				String time = (String) textView3.getText();
				Intent intent = null;
				
				
			     switch(position){
		            case 0 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle=new Bundle();
		                bundle.putString("breakfast",breakfast);
		                bundle.putString("from",from);
		                bundle.putString("time",time);
		                intent.putExtras(bundle);
		                break;
		            case 1 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle2=new Bundle();
		                bundle2.putString("breakfast",breakfast);
		                bundle2.putString("from",from);
		                bundle2.putString("time",time);
		                intent.putExtras(bundle2);
		                break;
		            case 2 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle3=new Bundle();
		                bundle3.putString("breakfast",breakfast);
		                bundle3.putString("from",from);
		                bundle3.putString("time",time);
		                intent.putExtras(bundle3);
		                break;
		            case 3 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle4=new Bundle();
		                bundle4.putString("breakfast",breakfast);
		                bundle4.putString("from",from);
		                bundle4.putString("time",time);
		                intent.putExtras(bundle4);
		                break;
		            case 4 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle5=new Bundle();
		                bundle5.putString("breakfast",breakfast);
		                bundle5.putString("from",from);
		                bundle5.putString("time",time);
		                intent.putExtras(bundle5);
		                break;
		            case 5 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle6=new Bundle();
		                bundle6.putString("breakfast",breakfast);
		                bundle6.putString("from",from);
		                bundle6.putString("time",time);
		                intent.putExtras(bundle6);
		                break;
		            case 6 :
		            	Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                intent = new Intent(parent.getContext(), indexActivity.class);
		                Bundle bundle7=new Bundle();
		                bundle7.putString("breakfast",breakfast);
		                bundle7.putString("from",from);
		                bundle7.putString("time",time);
		                intent.putExtras(bundle7);
		                break;
		           default:
		        	    intent = new Intent(parent.getContext(), indexActivity.class);
		        	    Bundle bundle8=new Bundle();
		        	    
		        	    
		        	
		                bundle8.putString("breakfast",breakdao.query(meal).getMeal());
		                bundle8.putString("from",breakdao.query(meal).getWay());
		                bundle8.putString("time",breakdao.query(meal).getTime());
		                intent.putExtras(bundle8);
		        	    Log.i("66", breakfast);
		            	Log.i("66", from);
		            	Log.i("66", time);
		                break;
		        }
		        startActivity(intent);
				
			}
	    	
	    });
	    
		return view;
	}



	private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		//添加列表内容
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("getup_time", "起床时间7：30");
		map.put("breakfast_contain", "原味松饼+牛奶");
		map.put("breakfast_time", "来源自己做");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("getup_time", "下单时间7：00");
		map.put("breakfast_contain", "皮蛋瘦肉粥");
		map.put("breakfast_time", "来源厦门蚝干粥");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("getup_time", "下单时间7：30");
		map.put("breakfast_contain", "金牌煎包+豆浆");
		map.put("breakfast_time", "来源壹号煎包");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("getup_time", "下单时间7：10");
		map.put("breakfast_contain", "皮蛋瘦肉粥");
		map.put("breakfast_time", "来源厦门蚝干粥");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("getup_time", "下单时间7：30");
		map.put("breakfast_contain", "金牌煎包+豆浆");
		map.put("breakfast_time", "来源壹号煎包");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("getup_time", "下单时间7：30");
		map.put("breakfast_contain", "金牌煎包+豆浆");
		map.put("breakfast_time", "来源壹号煎包");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("getup_time", "下单时间7：30");
		map.put("breakfast_contain", "金牌煎包+豆浆");
		map.put("breakfast_time", "来源壹号煎包");
		list.add(map);
		
		
		
		
	//	map = new HashMap<String, Object>();
	//	BreakFast breakf = new BreakFast(1, "bao", "1", "1");
	//	breakdao.insert(breakf);
	//	meal="bao";
	//	BreakFast br = breakdao.query(meal);
	//	if (br != null) {

	//		map.put("getup_time", breakdao.query(meal).getTime());
	//		map.put("breakfast_contain", breakdao.query(meal).getMeal());
	//		map.put("breakfast_time", breakdao.query(meal).getWay());

	//		list.add(map);
	//	}
		
		return list;
		
	}
	
	
	
}
