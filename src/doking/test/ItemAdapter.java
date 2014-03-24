package doking.test;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter{

	List<Item> list;
	LayoutInflater inflater;
	
	public ItemAdapter(Context context, List<Item> list){
		
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//get시스템에서 서비스 사용시에 자주씀 !! 
		
		this.list = list;
		
		
	}
	
	
	@Override
	public int getCount() {// 아이템이 뭐가 들어있는지 
		// TODO Auto-generated method stub
		return list.size();
		
	}

	@Override
	public Object getItem(int position) { // 위치 ? 
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 가장 중요(숫자 , 재활용 , 부모 뷰 )
		// TODO Auto-generated method stub
		
		if(convertView == null){
			
			//inflater를 이용해서 view 를 만들어냄!! 
			
			convertView = inflater.inflate(R.layout.item, null);
		}
		
		TextView tvNameTextView = (TextView)convertView.findViewById(R.id.TvName);
		Item item = list.get(position);
		tvNameTextView.setText(item.getName());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//date 는 스트링 형식이 아니므로 string 형식으로 바꿔줌!!!! 
		
		String date = sdf.format(item.getAddedDate());
		TextView tvDaTextView = (TextView)convertView.findViewById(R.id.TvAddedDate);
		tvDaTextView.setText(date);
		
		
		return convertView;
	}

	
}
