package habib.nano88.wisatajogja;

import habib.nano88.wisatajogja.model.Lokasi;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//untuk dapat menampilkan google maps anda harus membuat API KEY
//API Key di masukkan ke android manifest
//selain memasukkan API KEy anda juga diminta untuk menggunakan beberpa permission
@SuppressLint("NewApi")
public class Maps extends Activity {
	private Lokasi lokasi;
	private MapFragment myMap;
	private ImageView imBack, imHome;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);

		// action untuk tombol kembali
		imBack = (ImageView) findViewById(R.id.imBack);
		imBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
				finish();
			}
		});

		// action untuk tombol home
		imHome = (ImageView) findViewById(R.id.imHome);
		imHome.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a = new Intent(getBaseContext(), MainActivity.class);
				startActivity(a);
				finish();
			}
		});

		// mengambil data dari SplashScreenActivity
		int posisi = getIntent().getExtras().getInt("posisi", 0);
		lokasi = SplashScreenActivity.data.get(posisi);

		// menentukan posisi kita saat ini
		// berdasarkan Latitudate dan Longitudate
		myMap = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
		Log.d("debug",
				lokasi.getLokasiLatitude() + " - "
						+ lokasi.getLokasiLongitude());

		LatLng posisiWisata = new LatLng(Double.parseDouble(lokasi
				.getLokasiLatitude()), Double.parseDouble(lokasi
				.getLokasiLongitude()));

		myMap.getMap().setMyLocationEnabled(true);
		myMap.getMap().moveCamera(
				CameraUpdateFactory.newLatLngZoom(posisiWisata, 13));

		myMap.getMap()
				.addMarker(
						new MarkerOptions()
								.title(lokasi.getKategoriNama())
								.snippet(
										lokasi.getKategoriNama() + "-"
												+ lokasi.getLokasiALamat())
								.position(posisiWisata)).showInfoWindow();
	}
}
