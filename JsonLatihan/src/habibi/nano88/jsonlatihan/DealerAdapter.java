package habibi.nano88.jsonlatihan;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DealerAdapter extends BaseAdapter {

	private LayoutInflater	inflater;
	private ArrayList<Dealer> data;
	private Context context;
	
	static class Holder
	{
		TextView	namaCabang, alamatCabang, telpCabang;
	}
	
	
	public DealerAdapter(Context c, ArrayList<Dealer> dataz) {
		context = c;
		this.data = dataz;
		inflater = LayoutInflater.from(context);
	} 
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Holder holder;
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.activity_dealer_adapter, null);

			holder = new Holder();
			holder.namaCabang = (TextView) convertView
					.findViewById(R.id.txtArea);
			holder.alamatCabang= (TextView)convertView
					.findViewById(R.id.txtAlamat);
			holder.telpCabang=(TextView)convertView
					.findViewById(R.id.txtTelpon);

			convertView.setTag(holder);
		} else
		{
			holder = (Holder) convertView.getTag();
		}
		
		holder.namaCabang.setText(data.get(position).getNamaDealer());
		holder.alamatCabang.setText(data.get(position).getAlamatDealer());
		holder.telpCabang.setText(data.get(position).getTelpDealer());
	
		return convertView;
	}
	
}
