package latihanjson;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		  obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));

	      //buat objeck pegawai
	      JSONObject pegawai = new JSONObject();
	      pegawai.put("namaDepan", "Ahad");
	      pegawai.put("namaBelakang", "Habibi");
	      
	      //buat objeck pegawai2
	      JSONObject pegawai2 = new JSONObject();
	      pegawai2.put("namaDepan", "Ahmad");
	      pegawai2.put("namaBelakang", "HHH");
	      
	      //mamsukkan pegawai dan pegawai2 ke array
	      JSONArray jArray = new JSONArray();
	      jArray.add(pegawai);
	      jArray.add(pegawai2);
	      
	      //tambahkan json array ke json obj
	      obj.put("pegawai", jArray);
	      System.out.println(obj);
	      
	      System.out.println("key nama ->>"+obj.get("name"));
	      System.out.println("key double ->>"+obj.get("balance"));
	}

}
