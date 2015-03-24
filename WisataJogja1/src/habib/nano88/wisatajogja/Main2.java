package habib.nano88.wisatajogja;

//jogja
import habib.nano88.wisatajogja.database.Wisata;
import habib.nano88.wisatajogja.model.Lokasi;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2 extends Activity implements OnItemClickListener {
	private ListView lvWisata;
	private Wisata db;
	private WisataAdapter adapter;
	private int idLokasi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		db = Wisata.getInstance(this);

		lvWisata = (ListView) findViewById(R.id.lvWisatax);

		lvWisata.setEmptyView(findViewById(R.id.lvWisatax));

		// Generate ListView from SQLite Database
		initView();

		lvWisata.setOnItemClickListener(this);
	}

	// memanggil menu
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// memberikan action pada menu
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.menuq) {
			Intent i = new Intent(getBaseContext(), TambahData.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initView() {
		// TODO Auto-generated method stub
		lvWisata = (ListView) findViewById(R.id.lvWisatax);// menyambunkan
															// listview di xml
															// ke class

		if (db.isWisataHasData()) {
			adapter = new WisataAdapter(this, db.getAllWisata());
			lvWisata.setAdapter(adapter);
		}

		lvWisata.setOnItemClickListener(new OnItemClickListener() {
			// ketika list item di klik akan mengarah ke detail. detail yang
			// ditampilkan berdasarkan list item
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int posisi,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Detail.class);
				i.putExtra("posisiKlik", posisi);
				startActivity(i);

			}
		});

		// ketika list item disentuh lama maka akan muncul dialog edit atau
		// delete
		lvWisata.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int posisi, long id) {
				// TODO Auto-generated method stub
				dialogEdit(posisi);
				return false;
			}

			// Constructor dari dialogEdit onItemClokListener
			private void dialogEdit(final int posisi) {
				// TODO Auto-generated method stub
				// menambahkan mennu pada dialog
				String opsidialog[] = { "Edit Lokasi", "Hapus Lokasi" };
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Main2.this);
				builder.setNeutralButton("Tutup",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

								dialog.dismiss();

							}
						});
				// judul pada dialog
				builder.setTitle("Edit or Delete");
				builder.setItems(opsidialog,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								switch (which) {
								// apabbila Pilih Edit makan akan menuju
								// TambahDataActivity dan data ditampilkan
								// disana
								// untuk kemudian kita edit dan simpan kembali
								case 0:
									Intent a = new Intent(
											getApplicationContext(),
											TambahData.class);
									a.putExtra("posisi", posisi);
									a.putExtra("isEdit", true);
									startActivity(a);
									break;
								case 1:
									// apabila hapus maka data akan terhapus dan
									// refresh MainActivity.java
									// karena disini tidak menggunakan database
									// maka ketika kita restart aplikasi
									// maka data kembali seperti semula
									
									
									Toast.makeText(getApplicationContext(),
											"data dihapus", Toast.LENGTH_LONG)
											.show();
									// Toast
									// refresh MainActivity
									Intent i = new Intent(
											getApplicationContext(),
											MainActivity.class);
									startActivity(i);
									break;
								}
							}

						});
				builder.show();// untuk menampilkan Dialog

			}

		});

	}

	/*
	 * Adapter adalah class yang mengatur item-item pada ListView. Adapter
	 * mengatur resource view pada setiap item dari ListView. pada kasus ini
	 * adapter berguna untuk menampilkkan item_listview ke listview
	 */

	private class CustomAdapter extends BaseAdapter {
		private Context context;
		private ArrayList<Lokasi> data;
		private LayoutInflater inflater = null;

		public CustomAdapter(Context c, ArrayList<Lokasi> dataz) {
			// TODO Auto-generated constructor stub
			context = c;
			this.data = dataz;
			inflater = (LayoutInflater) context
					.getSystemService(LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		private class ViewHolder {
			TextView txtNama;
			TextView txtKategori;
			ImageView imgGambar;
		}

		// Custom ListView dimana didalam ListView terdapat item_list_view.xml
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// TODO Auto-generated method stub
			View vi = view;
			ViewHolder holder = null;

			if (vi == null) {
				vi = inflater.inflate(R.layout.item_list_view, null);

				holder = new ViewHolder();
				holder.txtNama = (TextView) vi.findViewById(R.id.txtNama);
				holder.txtKategori = (TextView) vi
						.findViewById(R.id.txtKategori);
				holder.imgGambar = (ImageView) vi.findViewById(R.id.imgGambar);

				vi.setTag(holder);
			} else {
				holder = (ViewHolder) vi.getTag();
			}

			Lokasi lokasi = this.data.get(position);
			holder.txtNama.setText(lokasi.getLokasiNama());
			holder.txtKategori.setText(lokasi.getKategoriNama());

			Drawable gambar = getImage(lokasi.getLokasiGmabar());
			holder.imgGambar.setImageDrawable(gambar);
			return vi;

		}

		// untuk menampilkan gambar yang berasal dari drawable
		private Drawable getImage(String name) {
			// TODO Auto-generated method stub

			return getResources().getDrawable(
					getResources().getIdentifier(name, "drawable",
							getPackageName()));

		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
