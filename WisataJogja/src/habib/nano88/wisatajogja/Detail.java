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
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends Activity {

	private ImageView imGambar, map;
	private TextView tvNama, tvKategori, tvAlamat, tvKeterangan;
	private Wisata db;
	private int posisi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		initView();
		posisi = getIntent().getIntExtra("posisiKlik", 0);
		db = Wisata.getInstance(this);

		Lokasi lokasi = db.getAllWisata().get(posisi);
		tvNama.setText(lokasi.getLokasiNama());
		tvAlamat.setText(lokasi.getLokasiALamat());
		tvKategori.setText(lokasi.getKategoriNama());
		tvKeterangan.setText(lokasi.getLokasiKeterangan());
		
	}

	// menampilkan data dari SplashScreenActivity
	private void initView() {
		// TODO Auto-generated method stub

		db = Wisata.getInstance(this);
		imGambar = (ImageView) findViewById(R.id.imGambar);
		tvNama = (TextView) findViewById(R.id.tvNama);
		tvAlamat = (TextView) findViewById(R.id.tvAlamat);
		tvKategori = (TextView) findViewById(R.id.tvKategori);
		tvKeterangan = (TextView) findViewById(R.id.tvKeterangan);

		// untuk menyambungkan ke Maps.java
		map = (ImageView) findViewById(R.id.map);
		map.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent m = new Intent(getApplicationContext(), Maps.class);
				m.putExtra("posisi", posisi);
				startActivity(m);
			}
		});

	}

	// mengambil data gambar dari drawable
	private Drawable getImage(String name) {
		// TODO Auto-generated method stub

		return getResources().getDrawable(
				getResources()
						.getIdentifier(name, "drawable", getPackageName()));

	}
}
