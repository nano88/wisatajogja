package habib.nano88.wisatajogja.database;

import habib.nano88.wisatajogja.model.Lokasi;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

@SuppressLint("NewApi")
public class Wisata extends SQLiteOpenHelper {

	private static Wisata dbInstance;
	private static SQLiteDatabase db;

	private static final String DB_NAME = "db_wisata";
	private static final int DB_VERSION = 1;
	private static final String TB_WISATA = "wisata";

	interface COLUMN {
		String idLokasi = "idLokasi";
		String nama = "nama";
		String keterangan = "keterangan";
		String gambar = "gambar";
		String alamat = "alamat";
		String latitudate = "latitudate";
		String longitudate = "longitudate";
		String kategoriNama = "kategoriNama";
	}

	// membuat tabel
	private static final String CREATE_WISATA_TABLE = "CREATE TABLE "
			+ TB_WISATA + "(" + COLUMN.idLokasi + " INTEGER PRIMARY KEY,"
			+ COLUMN.nama + " TEXT," + COLUMN.keterangan + " TEXT,"
			+ COLUMN.gambar + " TEXT," + COLUMN.alamat + " TEXT,"
			+ COLUMN.latitudate + " TEXT," + COLUMN.longitudate + " TEXT,"
			+ COLUMN.kategoriNama + " TEXT" + ")";

	private Wisata(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	public static Wisata getInstance(Context context) {
		if (dbInstance == null) {
			dbInstance = new Wisata(context);
			db = dbInstance.getWritableDatabase();
		}
		return dbInstance;
	}

	@Override
	public synchronized void close() {
		super.close();
		if (dbInstance != null)
			dbInstance.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Utils.TRACE("Wisata", "" + CREATE_WISATA_TABLE);
		db.execSQL(CREATE_WISATA_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXIST" + TB_WISATA);
		onCreate(db);
	}

	public List<Lokasi> getAllWisata() {
		List<Lokasi> listWisata = new ArrayList<Lokasi>();
		// Select All Query

		Cursor cursor = db.query(TB_WISATA, new String[] { COLUMN.idLokasi,
				COLUMN.nama, COLUMN.keterangan, COLUMN.gambar, COLUMN.alamat,
				COLUMN.latitudate, COLUMN.longitudate, COLUMN.kategoriNama },
				null, null, null, null, null, null);
		cursor.moveToFirst();
		do {
			listWisata.add(new Lokasi(cursor.getInt(cursor
					.getColumnIndexOrThrow(COLUMN.idLokasi)), cursor
					.getString(cursor.getColumnIndexOrThrow(COLUMN.nama)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(COLUMN.keterangan)), cursor
							.getString(cursor
									.getColumnIndexOrThrow(COLUMN.alamat)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(COLUMN.gambar)), cursor
							.getString(cursor
									.getColumnIndexOrThrow(COLUMN.latitudate)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(COLUMN.longitudate)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(COLUMN.kategoriNama))));
		} while (cursor.moveToNext());
		return listWisata;
	}

	public boolean isWisataHasData() {
		Cursor cursor = db.query(false, TB_WISATA,
				new String[] { COLUMN.idLokasi }, null, null, null, null, null,
				null,null);
		return (cursor.getCount() > 0) ? true : false;
	}

	public boolean addWisata(Lokasi wisata) {
		ContentValues values = new ContentValues();
		values.put(COLUMN.nama, wisata.getLokasiNama());
		values.put(COLUMN.keterangan, wisata.getLokasiKeterangan());
		values.put(COLUMN.gambar, wisata.getLokasiGmabar());
		values.put(COLUMN.alamat, wisata.getLokasiALamat());
		values.put(COLUMN.latitudate, wisata.getLokasiLatitude());
		values.put(COLUMN.longitudate, wisata.getLokasiLongitude());
		values.put(COLUMN.kategoriNama, wisata.getKategoriNama());

		return ((db.insert(TB_WISATA, null, values)) != -1) ? true : false;
	}

	// Updating single wisata
	public boolean editWisata(Lokasi wisata) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN.nama, wisata.getLokasiNama());
		values.put(COLUMN.keterangan, wisata.getLokasiKeterangan());
		values.put(COLUMN.gambar, wisata.getLokasiGmabar());
		values.put(COLUMN.alamat, wisata.getLokasiALamat());
		values.put(COLUMN.latitudate, wisata.getLokasiLatitude());
		values.put(COLUMN.longitudate, wisata.getLokasiLongitude());
		values.put(COLUMN.kategoriNama, wisata.getKategoriNama());

		// updating row
		return ((db.update(TB_WISATA, values, COLUMN.idLokasi + "=?",
				new String[] { String.valueOf(wisata.getIdLokasi()) })) == 1) ? true
				: false;
	}

	public void deleteWisata(int idLokasi) {
		db.delete(TB_WISATA, COLUMN.idLokasi + "=?",
				new String[] { String.valueOf(idLokasi) });
	}
}