package habib.nano88.ioimagesqlite;

import android.graphics.Bitmap;

public class DragonBall {
	private Bitmap gambar;
	private String nama;
	private String saiya;
	private String versi;

	public DragonBall (Bitmap d, String n, String s, String v)
	{
		gambar = d;
		nama = n ; saiya = s; versi = v;

	}

	public Bitmap getBitmap(){return gambar;}
	public String getNama(){return nama;}
	public String getSaiya(){return saiya;}
	public String getVersi(){return versi;}
}
