package com.nano88.mylib.Spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nano88.mylib.R;

public class SpinnerSample extends Activity {
	private String[] Habib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);

		// dapatkan data arraystring dari resource
		Habib = this.getResources().getStringArray(R.array.Habib);

		// buat object spinner
		Spinner spinner = (Spinner) findViewById(R.id.spinnerHabib);

		// buat arrayadapter dengan isi_spinner di dalamnya, dan style
		// simple_spinner_dropdown_item
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.Habib,
				android.R.layout.simple_spinner_dropdown_item);

		// set spinner adapter
		spinner.setAdapter(adapter);

		// berikan action pada saat spinner terpilih
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int position, long id) {
				// tampilkan isi spinner dari array string yg terpilih
				// berdasarkan position
				Toast.makeText(SpinnerSample.this, Habib[position],
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
	}
}
