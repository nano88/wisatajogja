package habib.nano88.wisatajogja.model;

public class Kategori {
//membuat setter dan getter.
//setter untuk memberikan nilai
//getter untuk mengambil nilai
//cara membuatnya deklarasika dulu variabel dan tipe datanya
//kemudian pada menu source -> generate getters and setters
	
	private int idKategori;
	protected String kategoriNama;
	
	public void setIdKategori(int id){
		idKategori = id;
	}
	
	public int getIdKategori(){
		return idKategori;
	}
	
	public void setKategoriNama(String nama){
		kategoriNama = nama;
	}

}
