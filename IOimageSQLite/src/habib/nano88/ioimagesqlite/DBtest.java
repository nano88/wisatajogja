package habib.nano88.ioimagesqlite;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
 
public class DBtest extends Activity {
 private DBHelper DBHelper;
 
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 //LinearLayout layout = new LinearLayout(this);
 //ImageView image = new ImageView(this);
 //TextView text = new TextView(this);
 ImageView imageku;
 DBHelper = new DBHelper(this);
 
 DragonBall testTokoh = new DragonBall(
 BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher),
 "Goku", "1", "DragonBall Z");
 DBHelper.open();
 // DBHelper.deleteRow("1");
 
 DBHelper.DragonBallEntry(testTokoh);
 // DBHelper.createFruitEntry(testFruit);
 DBHelper.close();
 
 testTokoh = null;
 
 DBHelper.open();
 testTokoh = DBHelper.getFirstDragonBallFromDB();
 DBHelper.close();
 
 imageku = (ImageView)findViewById(R.id.ImageView01);
 imageku.setImageBitmap(testTokoh.getBitmap());
 TextView textnama, textsaiya, textversi;
 textnama = (TextView)findViewById(R.id.TextNama);
 textsaiya = (TextView)findViewById(R.id.TextSaiya);
 textversi = (TextView)findViewById(R.id.TextVersi);
 textnama.setText("Nama : " +testTokoh.getNama());
 textsaiya.setText("Saiya ke : " +testTokoh.getSaiya());
 textversi.setText("Versi : " +testTokoh.getVersi());
 }
}