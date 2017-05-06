package eparking.entity;

public class entityParkir {
	String nopol, jenis, durasi, status,waktu_masuk,waktu_keluar;
	double total_tarif;
	int tiket;
	
	public int getTiket() {
        return tiket;
    }

    public void setTiket(int tiket) {
        this.tiket = tiket;
    }
    
    public void setNopol(String nopol) {
        this.nopol = nopol;
    }
    
    public String getNopol() {
        return nopol;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public String getJenis() {
        return jenis;
    }
    
    public String getWaktu_masuk() {
        return waktu_masuk;
    }

    public void setWaktu_masuk(String waktu_masuk) {
        this.waktu_masuk = waktu_masuk;
    }
    
    public String getWaktu_keluar() {
        return waktu_keluar;
    }

    public void setWaktu_keluar(String waktu_keluar) {
        this.waktu_keluar = waktu_keluar;
    }
    
    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }
    
    public double getTotal_tarif() {
        return total_tarif;
    }

    public void setTotal_tarif(double d) {
        this.total_tarif = d;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
