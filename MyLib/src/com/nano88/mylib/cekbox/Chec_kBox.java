package com.nano88.mylib.cekbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.nano88.mylib.R;


public class Chec_kBox extends Activity{
    private CheckBox cb_menu1, cb_menu2, cb_menu3;
    private TextView txt_tampil;
    private Button btn_tampil;
    private StringBuilder str;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chec_k_box);
       
        cb_menu1 = (CheckBox) findViewById(R.id.cb_menu1);
        cb_menu2 = (CheckBox) findViewById(R.id.cb_menu2);
        cb_menu3 = (CheckBox) findViewById(R.id.cb_menu3);
        txt_tampil = (TextView) findViewById(R.id.txt_tampil);
        btn_tampil = (Button) findViewById(R.id.btn_tampil);
       
        btn_tampil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                str = new StringBuilder();
               
                if(cb_menu1.isChecked()){
                    str.append("Teh, ");
                }
                if(cb_menu2.isChecked()){
                    str.append("Kopi, ");
              }
                if(cb_menu3.isChecked()){
                    str.append("Susu, ");
                }
               
                txt_tampil.setText(str);
            }
        });
    }
}