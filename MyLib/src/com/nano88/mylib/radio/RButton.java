package com.nano88.mylib.radio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.nano88.mylib.R;

public class RButton extends Activity implements OnClickListener {

 /*
  * RadioGroup tidak perlu dilakukan pada coding, karena secara otomatis
  * masing-masing radioButton sudah dikelompokkan oleh xml
  */
 RadioButton radioButtonAndroid, radioButtonJava, radioButtonPHP;
 Button buttonPilih;
 TextView textviewPilihan;

 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_rbutton);

  radioButtonAndroid = (RadioButton) findViewById(R.id.radioAndroid);
  radioButtonJava = (RadioButton) findViewById(R.id.radioJava);
  radioButtonPHP = (RadioButton) findViewById(R.id.radioPHP);

  buttonPilih = (Button) findViewById(R.id.buttonPilih);
  textviewPilihan = (TextView) findViewById(R.id.textViewPilihan);

  buttonPilih.setOnClickListener(this);

 }

 @Override
 public void onClick(View view) {
  if (view.getId() == R.id.buttonPilih) {

   String hasil = "";

   // jika yang diseleksi adalah Android
   if (radioButtonAndroid.isChecked()) {
    // toString berfungsi mengkonversi ke string
    hasil = radioButtonAndroid.getText().toString();
   }
   // jika yang diseleksi adalah Java
   else if (radioButtonJava.isChecked()) {
    hasil = radioButtonJava.getText().toString();
   }
   // jika yang diseleksi adalah PHP
   else if (radioButtonPHP.isChecked()) {
    hasil = radioButtonPHP.getText().toString();
   }

   textviewPilihan.setText(hasil);
  }
 }
}