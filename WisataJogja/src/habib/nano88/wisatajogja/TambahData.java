package habib.nano88.wisatajogja;

import java.util.List;

import habib.nano88.wisatajogja.database.Wisata;
import habib.nano88.wisatajogja.model.Lokasi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TambahData extends Activity {
	private EditText txtNama, txtKeterangan, txtAlamat, txtGambar,
			txtLatitudate, txtLongitudate, txtKategori;

	private ImageView imgGambar, imCancel;
	private Button btnCancel, btnSimpan;
	private Wisata db;
	private int posisi;
	private int idLokkasi;
	private boolean isEdit;

	private List<Lokasi> editData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tambah_data);
		initview();
		db = Wisata.getInstance(this);
		posisi = getIntent().getIntExtra("posisi", 0);
		isEdit = getIntent().getBooleanExtra("isEdit", false);
		// cek posisi edit

		// apabila kita menggunakan tambah_data_activity maka data yg sudah ada
		// akan ditampilkan
		// kemudian kita edit untuk di simpan kembali
		if (isEdit) {

			Lokasi lokasi = db.getAllWisata().get(posisi);
			idLokkasi = lokasi.getIdLokasi();		
			txtGambar.setText(lokasi.getLokasiGmabar());
			txtNama.setText(lokasi.getLokasiNama());
			txtAlamat.setText(lokasi.getLokasiALamat());
			txtKategori.setText(lokasi.getKategoriNama());
			txtKeterangan.setText(lokasi.getLokasiKeterangan());
			txtLongitudate.setText(lokasi.getLokasiLongitude());
			txtLatitudate.setText(lokasi.getLokasiLatitude());

		}

	}

	// menghubungkan dengan id yg ada di file xml
	private void initview() {
		// TODO Auto-generated method stub
		txtNama = (EditText) findViewById(R.id.txtNama);
		txtKeterangan = (EditText) findViewById(R.id.txtKeterangan);
		txtKategori = (EditText) findViewById(R.id.txtKategori);
		txtAlamat = (EditText) findViewById(R.id.txtAlamat);
		txtLatitudate = (EditText) findViewById(R.id.txtLatittudate);
		txtLongitudate = (EditText) findViewById(R.id.txtLongitudate);
		txtGambar = (EditText) findViewById(R.id.txtGambar);
		imgGambar = (ImageView) findViewById(R.id.imgGambar);
		imCancel = (ImageView) findViewById(R.id.imCancel);
		imCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});

		// action button cancel
		btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});

		// action button simpan
		btnSimpan = (Button) findViewById(R.id.btnSimpan);
		btnSimpan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simpanData();
			}

			private void simpanData() {
				// TODO Auto-generated method stub
				// membuat check untuk beberapa item yang harus diisi
				// apabila tidak diisi maka tidak bisa disimpan
				if (!(txtNama.getText().length() > 0)) {
					Toast.makeText(getApplicationContext(), "nama harus diisi",
							Toast.LENGTH_LONG).show();
				} else if (!(txtKategori.getText().length() > 0)) {
					Toast.makeText(getApplicationContext(),
							"kategori harus diisi", Toast.LENGTH_LONG).show();

				} else {

					Lokasi lokasi = new Lokasi();
					lokasi.setKategoriNama(txtKategori.getText().toString());
					lokasi.setLokasiNama(txtNama.getText().toString());
					lokasi.setLokasiALamat(txtAlamat.getText().toString());
					lokasi.setLokasiGmabar(txtGambar.getText().toString());
					lokasi.setLokasiKeterangan(txtKeterangan.getText()
							.toString());
					lokasi.setLokasiLatitude(txtLatitudate.getText().toString());
					lokasi.setLokasiLongitude(txtLongitudate.getText()
							.toString());

					if (isEdit) {
						// set(posisi, dataBaru)
						if(db.editWisata(lokasi, idLokkasi)){
							Toast.makeText(getApplicationContext(),
									"Berhasil dirubah", Toast.LENGTH_LONG)
									.show();
						}else{
							Toast.makeText(getApplicationContext(),
									"gagal dirubah ", Toast.LENGTH_LONG)
									.show();
						}
						
					
					} else {
						if (db.addWisata(lokasi)) {

							Toast.makeText(getApplicationContext(),
									"Berhasil ditambahkan", Toast.LENGTH_LONG)
									.show();
						} else {
							Toast.makeText(getApplicationContext(),
									"gagal menambahkan data!!",
									Toast.LENGTH_LONG).show();
						}

						// toast ketika berhasil menambahkan data

					}

					// redirect ke MainActivity ketika berhasil mengedit atau
					// menambahkan data
					Intent i = new Intent(getBaseContext(), MainActivity.class);
					startActivity(i);
					finish();
				}
			}
		});
	}

	// mengambil gambar dari drawable

}
