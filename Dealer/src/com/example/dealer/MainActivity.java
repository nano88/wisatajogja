package com.example.dealer;

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

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dealer.models.Dealer;

public class MainActivity extends ActionBarActivity {
	private ListView lvDealer;
	private ArrayList<Dealer> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupView();
		
		String url = "http://astra.jasaprogrammer.com/android/getCabang";
		new GetDataAsynTask().execute(url);
	}

	private void setupView() {
		lvDealer = (ListView) findViewById(R.id.lvDealer);
		
	}
	
	private class GetDataAsynTask extends AsyncTask<String, String, JSONObject> {
		
		
		@Override
		protected void onPreExecute() {
			
		}

		@Override
		protected JSONObject doInBackground(String... params) {
			InputStream is = null;
			String url = params[0];
			String jsonString = null;
			JSONObject jObj = null;
			
			try {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);

				HttpResponse httpResponse = httpClient.execute(httpPost);
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
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						is, "utf-8"), 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				is.close();
				jsonString = sb.toString();
			} catch (Exception e) {
				Log.e("Buffer Error", "Error converting result " + e.toString());
			}

			try {
				jObj = new JSONObject(jsonString);
			} catch (JSONException e) {
				Log.e("JSON Parser", "Error parsing data " + e.toString());
			}

			System.out.println(jObj.toString());
			return jObj;
		}

		@Override
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
						d.setDealerNama(jObj2.getString("cabang_area"));
						d.setDealerAlamat(jObj2.getString("cabang_alamat"));
						d.setDealerHp(jObj2.getString("cabang_telp"));
						
						
						
						data.add(d);
					}
					
					//masukkan kedalam custom adapter
				}else{
					Toast.makeText(getBaseContext(), "data tidak ada", Toast.LENGTH_LONG).show();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			
		}

	}

	
}
