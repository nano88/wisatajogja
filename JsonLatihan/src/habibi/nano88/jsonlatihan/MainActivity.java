package habibi.nano88.jsonlatihan;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	ArrayList<Dealer> data;
	ListView lvDealer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();

		String url = "http://astra.jasaprogrammer.com/android/getCabang";
		new GetDataAsynTask().execute(url);
		
	}

	private void setupView() {
		// TODO Auto-generated method stub
	lvDealer = (ListView) findViewById(R.id.lvDealer);
	
	}

	private class GetDataAsynTask extends AsyncTask<String, String, JSONObject> {

		public void onPreExecute() {
			// TODO Auto-generated method stub

		}
		
		//parser
		@Override
		protected JSONObject doInBackground(String... params) {
			// TODO Auto-generated method stub
			InputStream is = null;
			String url = params[0];
			String jsonString = null;
			JSONObject jObj = null;

			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httPost = new HttpPost(url);

				HttpResponse httpResponse = httpClient.execute(httPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "utf-8"), 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}

				is.close();
				jsonString = sb.toString();

			} catch (Exception e) {
				Log.e("Buffer Error", "Error Converting Result" + e.toString());
			}

			try {
				jObj = new JSONObject(jsonString);
			} catch (JSONException e) {
				Log.e("JSON Parser", "Error parsing data " + e.toString());
			}

			System.out.println(jObj.toString());
			return jObj;
		}

		protected void onPostExecute(JSONObject result) {
			try {
				String hasil = result.getString("result");
				if(hasil.equalsIgnoreCase("true")){
					data = new ArrayList<Dealer>();
					//untuk proses masuk ke adapter listview via arraylist
					JSONArray jArray = result.getJSONArray("data");
					//loopng dan masukkan ke dalam array list
					for (int i = 0; i < jArray.length(); i++) {
						//ambil satu2 data dealernya
						JSONObject jObj2 = (JSONObject) jArray.get(i);
						
						Log.i("nama dealer", jObj2.getString("cabang_area"));
						
						Dealer d =new Dealer();
						d.setIdDealer(jObj2.getString("id_cabang"));
						d.setNamaDealer(jObj2.getString("cabang_area"));
						d.setAlamatDealer(jObj2.getString("cabang_alamat"));
						d.setTelpDealer(jObj2.getString("cabang_telp"));
						
						data.add(d);
					}
					
					//masukkan kedalam custom adapter
					
					DealerAdapter a = new DealerAdapter(MainActivity.this, data);
					lvDealer.setAdapter(a);
					
					lvDealer.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent, View view,
								int position, long id_cabang) {
							// TODO Auto-generated method stub
							String idCabang = ((TextView) view.findViewById(R.id.tveventID))
									.getText().toString();
							
							Intent d = new Intent(getApplicationContext(),
									Detail.class);
							d.putExtra("posisiKlik", idCabang);
							
							startActivityForResult(d, 100);
						}
					
					});
				}else{
					Toast.makeText(getBaseContext(), "data tidak ada", Toast.LENGTH_LONG).show();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			
		}

	}

	
}