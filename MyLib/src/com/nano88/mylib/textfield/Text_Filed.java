package com.nano88.mylib.textfield;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nano88.mylib.R;

public class Text_Filed extends Activity implements OnClickListener {
Button b1;
TextView nama;
EditText inama;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text__filed);
		
		b1 = (Button) findViewById(R.id.button1);
		nama = (TextView) findViewById(R.id.nama);
		inama =(EditText) findViewById(R.id.inama);
		
		b1.setOnClickListener(this);
}

	@Override
	public void onClick(View klik) {
		// TODO Auto-generated method stub
		nama.setText("Nama : "+inama.getText());
	}
}
/*

6. progress bar
9. ImageView
10. WebView
Hari Selasa :
2. GridView
3. ScrolView
4. TimePicker
5. DatePicker
6. timeAndDate Picker

*/