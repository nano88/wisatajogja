package habib.nano88.wisatajogja;

import habib.nano88.wisatajogja.database.Wisata;
import habib.nano88.wisatajogja.model.Lokasi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends Activity {

private ImageView imGambar,map;
private TextView  tvNama,tvKategori, tvAlamat, tvKeterangan;
private Wisata db;
private int idLokasi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		initView();
	}
	private void initView() {
		db = Wisata.getInstance(this);
		// TODO Auto-generated method stub
		imGambar =(ImageView)findViewById(R.id.imGambar);
		tvNama=(TextView)findViewById(R.id.tvNama);
		tvAlamat=(TextView)findViewById(R.id.tvAlamat1);
		tvKategori=(TextView)findViewById(R.id.tvKategori);
		tvKeterangan=(TextView)findViewById(R.id.tvKeterangan);
		
		//untuk menyambungkan ke Maps.java
		map = (ImageView)findViewById(R.id.map);
		Bundle a = getIntent().getExtras();
		if(a!=null){
			idLokasi = a.getInt("idLokasi");
			tvNama.setText(a.getString("nama"));
			tvAlamat.setText(a.getString("alamat"));
			tvKategori.setText(a.getString("kategoriNama"));
			tvKeterangan.setText(a.getString("keterangan"));			
			
		}
		
	}
	public void onBackPressed()
	{
		super.onBackPressed();
		startActivity(new Intent(Detail.this, MainActivity.class));
		finish();
	}
}
