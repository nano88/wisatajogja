package habib.nano88.wisatajogja;

import habib.nano88.wisatajogja.R;
import habib.nano88.wisatajogja.model.Lokasi;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WisataAdapter extends BaseAdapter
{
	static class Holder
	{
		TextView	nama, kategori;
		ImageView	ivGambar;
	}

	private LayoutInflater	inflater;
	private List<Lokasi>	listWisata;

	public WisataAdapter(Context context, List<Lokasi> listWisata)
	{
		inflater = LayoutInflater.from(context);
		this.listWisata = listWisata;
	}

	@Override
	public int getCount()
	{
		return listWisata.size();
	}

	@Override
	public Object getItem(int position)
	{
		return listWisata.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Holder holder;
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.item_list_view, null);

			holder = new Holder();
			holder.ivGambar = (ImageView) convertView
					.findViewById(R.id.imGambar);
			holder.nama = (TextView) convertView
					.findViewById(R.id.txtNama);
			holder.kategori = (TextView)convertView
					.findViewById(R.id.txtKategori);

			convertView.setTag(holder);
		} else
		{
			holder = (Holder) convertView.getTag();
		}
		
		
		holder.nama.setText(listWisata.get(position).getLokasiNama());
		holder.kategori.setText(listWisata.get(position).getKategoriNama());
	
		return convertView;
	}
	
}


