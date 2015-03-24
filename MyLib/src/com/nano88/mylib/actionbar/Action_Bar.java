package com.nano88.mylib.actionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nano88.mylib.R;

public class Action_Bar extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action__bar);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.yes:
			homeActivity();
			return true;
		case R.id.home:
			javaActivity();
			return true;

		case R.id.no:

			androidActivity();

			return true;

		default:

			return super.onOptionsItemSelected(item);

		}

	}

	public void homeActivity() {
		Toast.makeText(this, "Yes Option Selexted", Toast.LENGTH_SHORT).show();
	}

	public void javaActivity() {

		Toast.makeText(this, "Home Option Selexted", Toast.LENGTH_SHORT).show();

	}

	public void androidActivity() {
		Toast.makeText(this, "No Option Selexted", Toast.LENGTH_SHORT)
				.show();
	}

}
