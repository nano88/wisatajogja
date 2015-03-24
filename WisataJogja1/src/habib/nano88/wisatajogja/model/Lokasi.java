package habib.nano88.wisatajogja.model;

public class Lokasi {
	private int idLokasi;
	private String lokasiNama, lokasiGmabar, lokasiALamat, lokasiLatitude,
			lokasiLongitude, lokasiKeterangan,kategoriNama;


	public Lokasi(String lokasiNama, String lokasiKeterangan, String lokasiGmabar,
			String lokasiALamat, String lokasiLatitude, String lokasiLongitude, String kategoriNama) {
		// TODO Auto-generated constructor stub
		this.lokasiNama = lokasiNama;
		this.lokasiKeterangan = lokasiKeterangan;
		this.lokasiGmabar = lokasiGmabar;
		this.lokasiALamat = lokasiALamat;
		this.lokasiLatitude = lokasiLatitude;
		this.lokasiLongitude = lokasiLongitude;
		this.kategoriNama =kategoriNama;
	}
	
	public Lokasi(int idLokasi, String lokasiNama, String lokasiKeterangan, String lokasiGmabar,
			String lokasiALamat, String lokasiLatitude, String lokasiLongitude, String kategoriNama) {
		// TODO Auto-generated constructor stub
		this.idLokasi =idLokasi;
		this.lokasiNama = lokasiNama;
		this.lokasiKeterangan = lokasiKeterangan;
		this.lokasiGmabar = lokasiGmabar;
		this.lokasiALamat = lokasiALamat;
		this.lokasiLatitude = lokasiLatitude;
		this.lokasiLongitude = lokasiLongitude;
		this.kategoriNama =kategoriNama;
	}
	
	public Lokasi() {
		// TODO Auto-generated constructor stub
	}

	public int getIdLokasi() {
		return idLokasi;
	}
	public void setIdLokasi(int idLokasi) {
		this.idLokasi = idLokasi;
	}
	public String getLokasiNama() {
		return lokasiNama;
	}
	public void setLokasiNama(String lokasiNama) {
		this.lokasiNama = lokasiNama;
	}
	public String getLokasiGmabar() {
		return lokasiGmabar;
	}
	public void setLokasiGmabar(String lokasiGmabar) {
		this.lokasiGmabar = lokasiGmabar;
	}
	public String getLokasiALamat() {
		return lokasiALamat;
	}
	public void setLokasiALamat(String lokasiALamat) {
		this.lokasiALamat = lokasiALamat;
	}
	public String getLokasiLatitude() {
		return lokasiLatitude;
	}
	public void setLokasiLatitude(String lokasiLatitude) {
		this.lokasiLatitude = lokasiLatitude;
	}
	public String getLokasiLongitude() {
		return lokasiLongitude;
	}
	public void setLokasiLongitude(String lokasiLongitude) {
		this.lokasiLongitude = lokasiLongitude;
	}
	public String getLokasiKeterangan() {
		return lokasiKeterangan;
	}
	public void setLokasiKeterangan(String lokasiKeterangan) {
		this.lokasiKeterangan = lokasiKeterangan;
	}

	public String getKategoriNama() {
		// TODO Auto-generated method stub
		return kategoriNama;
	}
	public void setKategoriNama(String kategoriNama){
		this.kategoriNama = kategoriNama;
	}

}
