package com.nano88.mylib;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nano88.mylib.Spinner.SpinnerSample;
import com.nano88.mylib.actionbar.Action_Bar;
import com.nano88.mylib.cekbox.Chec_kBox;
import com.nano88.mylib.listview.List_View;
import com.nano88.mylib.listview.WeatherList;
import com.nano88.mylib.progressbar.Progress_Bar;
import com.nano88.mylib.radio.RButton;
import com.nano88.mylib.ratingbar.Rating_Bar;
import com.nano88.mylib.switchtoogle.Widget_Swicth;
import com.nano88.mylib.textfield.Text_Filed;
import com.nano88.mylib.webview.Web_View;

public class Menu extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] values = new String[] { "Check Box", "Radio Button",
				"Rating Bar", "Spinner" ,"Switch Togle Button","List View","Text Field","Web View"
				,"Action Bar","Progress Bar","Weather List"};
		ArrayAdapter adapter = new ArrayAdapter(Menu.this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		
		//script untuk menhubugkan menu ke activity lainnya
		switch (position) {
		case 0:
			Intent newActivity = new Intent(this, Chec_kBox.class);
			startActivity(newActivity);
			break;
		case 1:
			Intent newActivity1 = new Intent(this, RButton.class);
			startActivity(newActivity1);
			break;
		case 2:
			Intent rb = new Intent(this, Rating_Bar.class);
			startActivity(rb);
			break;
		case 3:
			Intent sp = new Intent(this, SpinnerSample.class);
			startActivity(sp);
			break;
		case 4:
			Intent sw = new Intent(this, Widget_Swicth.class);
			startActivity(sw);
		case 5:
			Intent lv = new Intent(this, List_View.class);
			startActivity(lv);
		case 6:
			Intent tf = new Intent(this, Text_Filed.class);
			startActivity(tf);
		case 7:
			Intent wv = new Intent(this, Web_View.class);
			startActivity(wv);
		case 8:
			Intent ab = new Intent(this, Action_Bar.class);
			startActivity(ab);
		case 9:
			Intent pb = new Intent(this, Progress_Bar.class);
			startActivity(pb);
		case 10:
			Intent wl = new Intent(this, WeatherList.class);
			startActivity(wl);
			}
	}

}