package com.nano88.mylib.switchtoogle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.nano88.mylib.R;

public class Widget_Swicth extends Activity implements CompoundButton.OnCheckedChangeListener {
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_widget_switch);
        //komponen switch
        Switch s = (Switch) findViewById(R.id.monitored_switch);
        if (s != null) {
            s.setOnCheckedChangeListener(this);
        }
    }

    @Override
    //tempatkan action disini apabila switch on atau off
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       Toast.makeText(this, "Monitored switch is " + (isChecked ? "on" : "off"),
               Toast.LENGTH_SHORT).show();
    }
}
