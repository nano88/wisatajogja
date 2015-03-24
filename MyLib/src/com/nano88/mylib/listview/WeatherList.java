package com.nano88.mylib.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.nano88.mylib.R;

public class WeatherList extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        
        Weather weather_data[] = new Weather[]
        {
            new Weather(R.drawable.yes, "Cloudy"),
            new Weather(R.drawable.yes, "Showers"),
            new Weather(R.drawable.no, "Snow"),
            new Weather(R.drawable.n88, "Storm"),
            new Weather(R.drawable.no, "Sunny")
        };
        
        WeatherAdapter adapter = new WeatherAdapter(this, 
                R.layout.item_wether_list, weather_data);
        
        
        listView1 = (ListView)findViewById(R.id.listView1);
         
        View header = (View)getLayoutInflater().inflate(R.layout.list_view_weather_header, null);
        listView1.addHeaderView(header);
        
        listView1.setAdapter(adapter);
    }
}