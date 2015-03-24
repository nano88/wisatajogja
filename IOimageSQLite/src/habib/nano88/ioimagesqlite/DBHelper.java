package habib.nano88.ioimagesqlite;

import java.io.ByteArrayOutputStream;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
 
public class DBHelper {
 public static final String KEY_ID = "id";
 public static final String KEY_NAME = "nama";
 public static final String KEY_SAIYA = "saiya";
 public static final String KEY_VERSI = "versi";
 public static final String KEY_IMG = "gambar";
 
 private DatabaseHelper mDBHelper;
 private SQLiteDatabase mDb;
 
 private static final String DATABASE_NAME = "DBtesting";
 private static final int DATABASE_VERSION = 1;
 
 private static final String DRAGONBALL_TABLE = "dragonball";
 
 private static final String CREATE_DRAGONBALL_TABLE = "create table " + DRAGONBALL_TABLE 
		 +" ("
		 +KEY_ID  +" integer primary key autoincrement, "
		 +KEY_IMG +" blob not null, "
		 +KEY_NAME +" text not null, "
		 +KEY_SAIYA +" text not null, "
		 +KEY_VERSI +" text not null"+
		 ");";
 
 private final Context mCtx;
 
 private static class DatabaseHelper extends SQLiteOpenHelper {
 DatabaseHelper(Context context) {
 super(context, DATABASE_NAME, null,DATABASE_VERSION);
 }
 
 public void onCreate(SQLiteDatabase db) {
 db.execSQL(CREATE_DRAGONBALL_TABLE);
 }
 
 public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) {
 db.execSQL("DROP TABLE IF EXISTS " + DRAGONBALL_TABLE);
 onCreate(db);
 }
 }
 
 public void Reset() { mDBHelper.onUpgrade(this.mDb, 1, 1); }
 
 public DBHelper(Context ctx) {
 mCtx = ctx;
 mDBHelper = new DatabaseHelper(mCtx);
 }
 
 public DBHelper open() throws SQLException {
 mDb = mDBHelper.getWritableDatabase();
 return this;
 }
 
 public void close() { mDBHelper.close(); }
 
 public void DragonBallEntry(DragonBall testTokoh) {
 ByteArrayOutputStream out = new ByteArrayOutputStream();
 testTokoh.getBitmap().compress(Bitmap.CompressFormat.PNG, 100, out);
 ContentValues cv = new ContentValues();
 cv.put(KEY_IMG, out.toByteArray());
 cv.put(KEY_NAME, testTokoh.getNama());
 cv.put(KEY_SAIYA, testTokoh.getSaiya());
 cv.put(KEY_VERSI, testTokoh.getVersi());
 mDb.insert(DRAGONBALL_TABLE, null, cv);
 }
 
 public DragonBall getFirstDragonBallFromDB() throws SQLException {
 Cursor cur = mDb.query(true,
 DRAGONBALL_TABLE,
 new String[] {KEY_IMG, KEY_NAME, KEY_SAIYA, KEY_VERSI},
 null, null,null, null, null, null);
 if(cur.moveToLast()) {
 byte[] blob = cur.getBlob(cur.getColumnIndex(KEY_IMG));
 Bitmap bmp = BitmapFactory.decodeByteArray(blob, 0, blob.length);
 String name = cur.getString(cur.getColumnIndex(KEY_NAME));
 String saiya = cur.getString(cur.getColumnIndex(KEY_SAIYA));
 String versi =cur.getString(cur.getColumnIndex(KEY_VERSI));
 cur.close();
 return new DragonBall(bmp,name,saiya,versi);
 }
 cur.close();
 return null;
 }
 
 public void deleteRow(String nilai)
 {
 
    try{
        mDb.delete(DRAGONBALL_TABLE, KEY_ID +"= " +3, null);
    }catch(Exception e){
        e.printStackTrace();
    }
 
 }
}