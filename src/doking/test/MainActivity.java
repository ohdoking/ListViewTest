package doking.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	EditText etName;
	Button btnAdd;
	ListView lvItems;
	BaseAdapter adapter; 
	List<Item> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
		
		//이벤트 지정해주는것 
		setListeners();
		
	}
	
	void setListeners(){
		
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = etName.getText().toString();
				
				if(name.length() == 0){
					
					return;
				}
				Date date = new Date();
				
				list.add(new Item(name, date));
				
				etName.setText("");
				adapter.notifyDataSetChanged();
			}
		});
		
		//list view의 아이템을 long click 하면 아이템 삭제 !! 
		
		lvItems.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> lv, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				
				list.remove(position);
				adapter.notifyDataSetChanged();
				return true;//이벤트 처리됫다 !! false 처리안됨 !! 
				
			}
		});
	}
	
	void init(){
		
		etName = (EditText)findViewById(R.id.EtName);
		btnAdd = (Button)findViewById(R.id.BtnAdd);
		lvItems = (ListView)findViewById(R.id.lvItems);
		list = new ArrayList<Item>();
		adapter = new ItemAdapter(this, list);
		
		lvItems.setAdapter(adapter);
		
		
	}
	
	
	
}
