package habibi.nano88.jsonlatihan;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class Coba extends BaseAdapter {
	private class Holder {
		TextView namaDeler, alamt, telpon;
	}

	private static Context context;
	private LayoutInflater inflanter;
	private ArrayList<Dealer> data;

	public Coba(Context c, ArrayList<Dealer> dataz) {
		// TODO Auto-generated constructor stub
		context = c;
		this.data = dataz;
		inflanter = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int posisi) {
		// TODO Auto-generated method stub
		return posisi;
	}

	@Override
	public long getItemId(int posisi) {
		// TODO Auto-generated method stub
		return posisi;
	}

	@Override
	public View getView(int posisi, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder;
		if (convertView == null) {
			convertView = inflanter.inflate(R.layout.activity_dealer_adapter, null);

			holder = new Holder();
			holder.namaDeler = (TextView) convertView.findViewById(R.id.txtArea);
			holder.alamt = (TextView) convertView.findViewById(R.id.txtAlamat);
			holder.telpon = (TextView) convertView.findViewById(R.id.txtTelpon);

			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.namaDeler.setText(data.get(posisi).getNamaDealer());
		holder.alamt.setText(data.get(posisi).getAlamatDealer());
		holder.telpon.setText(data.get(posisi).getTelpDealer());
		return convertView;
	}

}