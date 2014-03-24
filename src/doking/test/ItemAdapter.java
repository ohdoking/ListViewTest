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
		//get�ý��ۿ��� ���� ���ÿ� ���־� !! 
		
		this.list = list;
		
		
	}
	
	
	@Override
	public int getCount() {// �������� ���� ����ִ��� 
		// TODO Auto-generated method stub
		return list.size();
		
	}

	@Override
	public Object getItem(int position) { // ��ġ ? 
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
		// ���� �߿�(���� , ��Ȱ�� , �θ� �� )
		// TODO Auto-generated method stub
		
		if(convertView == null){
			
			//inflater�� �̿��ؼ� view �� ����!! 
			
			convertView = inflater.inflate(R.layout.item, null);
		}
		
		TextView tvNameTextView = (TextView)convertView.findViewById(R.id.TvName);
		Item item = list.get(position);
		tvNameTextView.setText(item.getName());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//date �� ��Ʈ�� ������ �ƴϹǷ� string �������� �ٲ���!!!! 
		
		String date = sdf.format(item.getAddedDate());
		TextView tvDaTextView = (TextView)convertView.findViewById(R.id.TvAddedDate);
		tvDaTextView.setText(date);
		
		
		return convertView;
	}

	
}
