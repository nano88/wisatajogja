package com.example.tmasangga;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class Habib extends Activity {
	private RelativeLayout habib;
	private Button tambah, kurang;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.habib);
		habib =(RelativeLayout)findViewById(R.id.habib);
		tambah = (Button)findViewById(R.id.button1);
		kurang = (Button)findViewById(R.id.button2);
		
		tambah.setOnClickListener(btnTambah);
		kurang.setOnClickListener(btnMin);
	}
	
	OnClickListener btnTambah = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			setHeightWeight("plus");
		}

	
	};
	
OnClickListener btnMin = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			setHeightWeight("min");
		}
	};
	
private void setHeightWeight(String param) {
	LayoutParams laParams =(LayoutParams) habib.getLayoutParams();
	
	if (param.equalsIgnoreCase("plus")){
		laParams.height = laParams.height + 10;
	}else if(param.equalsIgnoreCase("min")){
		laParams.height = laParams.height - 10;
	}
	habib.setLayoutParams(laParams);
	}
	
}
