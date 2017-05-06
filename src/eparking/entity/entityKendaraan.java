package eparking.entity;



public class entityKendaraan {
	String jenis; 
	int id, kapasitas;
	double tjp, tjb;
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTjp(double tjp) {
        this.tjp = tjp;
    }
    
    public double getTjp() {
        return tjp;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public String getJenis() {
        return jenis;
    }
    
    public void setTjb(double tjb) {
        this.tjb = tjb;
    }
    
    public double getTjb() {
        return tjb;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    public int getKapasitas() {
        return kapasitas;
    }
    



}
