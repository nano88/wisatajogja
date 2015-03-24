package habibi.nano88.jsonlatihan;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Detail extends Activity {
	public String kode;
	ArrayList<Dealer> data;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);
        
        Bundle b = getIntent().getExtras(); 
		kode = b.getString("posisiKlik");
			
		try{
		data = new ArrayList<Dealer>();
		//untuk proses masuk ke adapter listview via arraylist
		JSONArray jArray = getJSONArray("data");
		String isi="";
		TextView view =(TextView)findViewById(R.id.textView1);
		//loopng dan masukkan ke dalam array list
		for (int i = 0; i < jArray.length(); i++) {
			//ambil satu2 data dealernya
			JSONObject jObj2 = jArray.getJSONObject(i);
			isi+="id_lokasi"+jObj2.getString("id_cabang");
		} 
		view.setText(isi);
		}catch (JSONException e) {
			e.printStackTrace(); 
		}

	}

	private JSONArray getJSONArray(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
