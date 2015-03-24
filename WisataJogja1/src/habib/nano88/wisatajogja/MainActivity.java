package habib.nano88.wisatajogja;
//jogja1
import habib.nano88.wisatajogja.database.Wisata;
import habib.nano88.wisatajogja.model.Lokasi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements 
OnItemClickListener {
	private ListView lvWisata;
	private Wisata db;
	private WisataAdapter	 adapter;
	private int			idLokasi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = Wisata.getInstance(this);

		lvWisata = (ListView) findViewById(R.id.lvWisatax);

		lvWisata.setEmptyView(findViewById(R.id.lvWisatax));

		 //Generate ListView from SQLite Database		 
		initView();
		
		lvWisata.setOnItemClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		if (db.isWisataHasData())
		{
			adapter = new WisataAdapter(this, db.getAllWisata());
			lvWisata.setAdapter(adapter);
		}
		lvWisata.setOnItemClickListener(this);
		lvWisata.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int posisi, long id) {
				dialogEdit(posisi);
				return false;
			}
			//Constructor dari dialogEdit onItemClokListener
			private void dialogEdit(final int posisi) {
				// TODO Auto-generated method stub
				//menambahkan mennu pada dialog
				String opsidialog[] = { "Edit Lokasi", "Hapus Lokasi" };
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setNeutralButton("Tutup",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

								dialog.dismiss();

							}
						});
				//judul pada dialog
				builder.setTitle("Edit or Delete");
				builder.setItems(opsidialog,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								switch (which) {
								//apabbila Pilih Edit makan akan menuju TambahDataActivity dan data ditampilkan disana
								//untuk kemudian kita edit dan simpan kembali
								case 0:
									Bundle b = new Bundle();
									b.putInt("idLokasi",	((Lokasi)adapter.getItem(posisi)).getIdLokasi());
									b.putString("nama", ((Lokasi)adapter.getItem(posisi)).getLokasiNama());
									b.putString("keterangan", ((Lokasi)adapter.getItem(posisi)).getLokasiKeterangan());
									b.putString("gambar", ((Lokasi)adapter.getItem(posisi)).getLokasiGmabar());
									b.putString("alamat", ((Lokasi)adapter.getItem(posisi)).getLokasiALamat());
									b.putString("latitude", ((Lokasi)adapter.getItem(posisi)).getLokasiLatitude());
									b.putString("longitudate", ((Lokasi)adapter.getItem(posisi)).getLokasiLongitude());
									b.putString("kategoriNama", ((Lokasi)adapter.getItem(posisi)).getKategoriNama());
									
									
									Intent a = new Intent(getApplicationContext(), EditData.class);
									a.putExtras(b);
									startActivity(a);
									break;
								case 1:
									showSettingsAlert();
									break;
								}
							}

						});
				builder.show();//untuk menampilkan Dialog
				
			}

		});
	}

	private void showSettingsAlert()
	{
		
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Delete");
		alert.setMessage("Contact akan dihapus");

		alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int posisi)
			{
				db.deleteWisata(posisi);
				finish();
			}

		});
		alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				dialog.cancel();
			}
		});

		alert.show();

	}
	
	//memanggil menu
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//memberikan action pada menu
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.menuq) {
			Intent i = new Intent(getBaseContext(), TambahData.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, Detail.class);
		i.putExtra("posisiKlik", position);

		i.putExtras(i);
		startActivity(i);
		finish();
	}


}


