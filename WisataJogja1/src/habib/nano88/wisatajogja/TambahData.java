package habib.nano88.wisatajogja;

import java.util.ArrayList;
import java.util.List;

import habib.nano88.wisatajogja.database.Wisata;
import habib.nano88.wisatajogja.model.Lokasi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TambahData extends Activity implements 
OnClickListener {
	private EditText txtNama, txtKeterangan, txtKategori, txtAlamat, txtGambar,
			txtLatitudate, txtLongitudate;
	private ImageView imgGambar, imCancel;
	private Button btnCancel, btnSimpan;

	private Wisata db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tambah_data);
		db = Wisata.getInstance(this);
	
		// TODO Auto-generated method stub
		txtNama = (EditText) findViewById(R.id.txtNama);
		txtKeterangan = (EditText) findViewById(R.id.txtKeterangan);
		txtKategori = (EditText) findViewById(R.id.txtKategori);
		txtAlamat = (EditText) findViewById(R.id.txtAlamat);
		txtLatitudate = (EditText) findViewById(R.id.txtLatitudate);
		txtLongitudate = (EditText) findViewById(R.id.txtLongitudate);
		txtGambar =(EditText) findViewById(R.id.txtGambar);
		imgGambar =(ImageView)findViewById(R.id.imgGambar);
		imCancel = (ImageView) findViewById(R.id.imCancel);
		imCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		
		//action button cancel
		btnCancel = (Button) findViewById(R.id.btnCancel);
		//action button simpan
		btnSimpan = (Button) findViewById(R.id.btnSimpan);
		
		btnSimpan.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		
	}

public void onClick(View v){
	if (v == btnSimpan){
		if (!TextUtils.isEmpty(txtNama.getText().toString())
				&& !TextUtils.isEmpty(txtKeterangan.getText().toString()))
		{
			
			db.addWisata(new Lokasi(txtNama.getText().toString(), 
					txtKeterangan.getText().toString(), 
					txtAlamat.getText().toString(),
					txtGambar.getText().toString(), 
					txtLatitudate.getText().toString(), 
					txtLongitudate.getText().toString(), 
					txtKategori.getText().toString()));

			startActivity(new Intent(this, MainActivity.class));
			finish();
		} else
		{
			Toast.makeText(this, "Lengkapi Data", Toast.LENGTH_SHORT)
					.show();
		}
	} else if (v == btnCancel)
	{

		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
}
public void onBackPressed()
{
	// TODO Auto-generated method stub
	super.onBackPressed();
	finish();
	startActivity(new Intent(this, MainActivity.class));
}
	//mengambil gambar dari drawable
	private Drawable getImage(String name) {
		// TODO Auto-generated method stub

		return getResources().getDrawable(
				getResources().getIdentifier(name, "drawable",
						getPackageName()));

	}
}
