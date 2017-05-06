package eparking.method;

import eparking.GUI.*;
import eparking.entity.entityParkir;
import eparking.entity.entityKendaraan;
import eparking.konfigurasi.*;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class metUtama {
	
	String durasiwaktu;
	public Koneksi db=null;
	public metUtama(){
		db=new Koneksi();
    }	    
	
    public List tampil_parkir(){
        List logParkir = new ArrayList();       
        String perintah="select * from parkir_kendaraan order by tiket desc";
        try{
            db.ambilData(perintah);

            while(db.rss.next()){
                entityParkir ep=new entityParkir();
                ep.setTiket(db.rss.getInt("tiket"));
                ep.setNopol(db.rss.getString("nopol"));
                ep.setJenis(db.rss.getString("jenis"));
                ep.setWaktu_masuk(db.rss.getString("waktu_masuk"));
                ep.setWaktu_keluar(db.rss.getString("waktu_keluar"));
                ep.setDurasi(db.rss.getString("durasi"));
                ep.setTotal_tarif(db.rss.getDouble("total_tarif"));
                ep.setStatus(db.rss.getString("status"));
                logParkir.add(ep);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logParkir;
    }
    
    public List tampil_kendaraan(){
        List logKendaraan = new ArrayList();       
        String perintah="select * from kendaraan order by id asc";
        try{
        	db.ambilData(perintah);

            while(db.rss.next()){
                entityKendaraan ek=new entityKendaraan();
                ek.setId(db.rss.getInt("id"));
                ek.setJenis(db.rss.getString("jenis"));
                ek.setTjp(db.rss.getDouble("tarif_jam_pertama"));
                ek.setTjb(db.rss.getDouble("tarif_jam_berikut"));
                ek.setKapasitas(db.rss.getInt("kapasitas"));
                logKendaraan.add(ek);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logKendaraan;
    }
    
    public List<entityKendaraan> tjptjb(String jenis){
    	List logTjptjb = new ArrayList();
    	String perintah ="SELECT tarif_jam_pertama,tarif_jam_berikut from kendaraan where jenis='"+jenis+"'";
    	try{
            db.ambilData(perintah);

            while(db.rss.next()){
            	entityKendaraan ek=new entityKendaraan();
                ek.setTjp(db.rss.getDouble("tarif_jam_pertama"));
                ek.setTjb(db.rss.getDouble("tarif_jam_berikut"));
                
                logTjptjb.add(ek);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logTjptjb;
    
    }
    

    
    public List<entityParkir> cari_data(String nopol){
    	
    	List<entityParkir> logCari = new ArrayList<entityParkir>();       
        String perintah="select tiket,nopol,jenis,waktu_masuk,waktu_keluar,durasi,total_tarif,status from parkir_kendaraan where nopol like '%"+nopol+"%'";
        try{
            db.ambilData(perintah);

            while(db.rss.next()){
            	entityParkir ep=new entityParkir();
                ep.setTiket(db.rss.getInt("tiket"));
                ep.setNopol(db.rss.getString("nopol"));
                ep.setJenis(db.rss.getString("jenis"));
                ep.setWaktu_masuk(db.rss.getString("waktu_masuk"));
                ep.setWaktu_keluar(db.rss.getString("waktu_keluar"));
                ep.setDurasi(db.rss.getString("durasi"));
                ep.setTotal_tarif(db.rss.getDouble("total_tarif"));
                ep.setStatus(db.rss.getString("status"));
                logCari.add(ep);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logCari;
    }
    
        
    public double total_biaya(){
    	entityParkir ep=new entityParkir();
    	String perintah="update parkir set durasi='"+ep.getDurasi()+"', total_tarif='"+ep.getTotal_tarif()+"' where nopol='"+ep.getNopol()+"'";
    	double hasil=0;
    	try{
            hasil=db.stm.executeUpdate(perintah);
            
    }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Diupdate");
            System.out.println("erornya : "+e);
    }
    	return hasil;
    }
    
    
    public int tambahKendaraan(entityParkir e){
        String sql="INSERT INTO parkir_kendaraan(nopol,jenis,waktu_masuk,status) VALUES (upper('"+e.getNopol()+"'),'"+e.getJenis()+"',NOW(),'Parkir')";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(sql);
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
    
    public int keluarparkir(entityParkir e){
    	String perintah="update parkir_kendaraan set waktu_keluar=NOW(), status='Tidak Parkir' where nopol='"+e.getNopol()+"'";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(perintah);
            } catch(SQLException a){
            	JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
    
    public int keluartotal(entityParkir e){
    	String perintah="update parkir_kendaraan set durasi='"+e.getDurasi()+"', total_tarif='"+e.getTotal_tarif()+"' where nopol='"+e.getNopol()+"'";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(perintah);
            } catch(SQLException a){
            	JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
    
    public List<entityParkir> dapatkan_data(String nopol){
    	List<entityParkir> logDapatkan_data = new ArrayList<entityParkir>();
    	String perintah="SELECT  * FROM parkir_kendaraan where nopol='"+nopol+"'";
    	
    	
        try{
                db.ambilData(perintah);
                while(db.rss.next()) {
                	List <entityParkir> listParkir=new ArrayList<entityParkir>();
                	listParkir.clear();
                    listParkir=cari_data(nopol); 
                    Object[] data=new Object[8];
                    for(int x=0;x<listParkir.size();x++){
                    	
                        data[0]=listParkir.get(x).getTiket();
                        data[1]=listParkir.get(x).getNopol();
                        data[2]=listParkir.get(x).getJenis();
                        data[3]=listParkir.get(x).getWaktu_masuk();
                        data[4]=listParkir.get(x).getWaktu_keluar();
                        data[5]=listParkir.get(x).getDurasi();
                        data[6]=listParkir.get(x).getTotal_tarif();
                        data[7]=listParkir.get(x).getStatus();
                    }
                	String jenis = data[2].toString();
                	Calendar cal = Calendar.getInstance(); 
                    cal.getTime(); 
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                    
                    String hariini=sdf.format(cal.getTime());
                    data[4]=hariini;
                    
                    Date tgl1=sdf.parse((String) data[3]);
                    Date tgl2=sdf.parse((String) data[4]);
                    long diff=((tgl2.getTime()-tgl1.getTime()));
                    long diffMinutes = diff / (60 * 1000)% 60;         
                    long diffHours = diff / (60 * 60 * 1000)% 60;
                    String lama_jam=String.valueOf(diffHours);
                    String lama_menit=String.valueOf(diffMinutes);
                    durasiwaktu=lama_jam;
                    
                    
                    List <entityKendaraan> listKendaraan=new ArrayList<entityKendaraan>();
                    listKendaraan=this.tjptjb(jenis);       
                    Object[] datak=new Object[2];
                    for(int x=0;x<listKendaraan.size();x++){
                    	
                        datak[0]=listKendaraan.get(x).getTjp();
                        datak[1]=listKendaraan.get(x).getTjb();
                    }
                    
                    //akumulasi biaya
                    int vdurasi;
                    double vtjp,vtjb,vbiaya,total_biaya;
                    vdurasi=Integer.parseInt(durasiwaktu);
                    vtjp=(double) datak[0];
                    vtjb=(double) datak[1];
                    
                    if(vdurasi<=1) {
                            vbiaya=vtjp;
                    }else{
                            vbiaya=(vtjp)+((vdurasi)*vtjb);
                    }
                    total_biaya=vbiaya;
                   
                    //selesai akumulasi biaya
                    entityParkir ep=new entityParkir();
                    ep.setTiket(Integer.valueOf(data[0].toString()));
                    ep.setNopol(data[1].toString());
                    ep.setJenis(data[2].toString());
                    ep.setWaktu_masuk(data[3].toString());
                    ep.setWaktu_keluar(data[4].toString());
                    ep.setDurasi(lama_jam+" Jam "+lama_menit+" Menit");
                    ep.setTotal_tarif(total_biaya);
                    ep.setStatus(data[7].toString());
                    logDapatkan_data.add(ep);
                }

        }catch(Exception e) {
                System.out.println("gagal Mengambil dapat_data :  "+e);
                System.exit(0);
        }
        return logDapatkan_data;
        
}
    
    

    

	public int tampil_motor(){
		int jumlahmotor=0;
		try{
			String perintah="SELECT sum(case when jenis = 'Motor' then 1 else 0 end) as jmlhmtr FROM parkir_kendaraan WHERE waktu_keluar is null";
			db.ambilData(perintah);
            if(db.rss.next()) {
            	jumlahmotor = (Integer) db.rss.getInt("jmlhmtr");
            	
            }
			
		}
		catch(Exception e){
			System.out.println("gagal Mengambil dapat data tampil_motor:  "+e);
            System.exit(0);
			
		}
		return jumlahmotor;
	}
	
	public int tampil_mobil(){
		int jumlahmobil=0;
		try{
			String perintah="SELECT sum(case when jenis = 'Mobil' then 1 else 0 end) as jmlhmbl FROM parkir_kendaraan WHERE waktu_keluar is null";
            db.ambilData(perintah);
            if(db.rss.next()) {
            	jumlahmobil = db.rss.getInt("jmlhmbl");
            	            	
            }
            
		}
		catch(Exception e){
			System.out.println("gagal Mengambil dapat data tampil_mobil:  "+e);
            System.exit(0);
			
		}
		return jumlahmobil;
	}
	
	public int kapasitas_motor(){
		int kapasitasmotor=0;
		try{
			String perintah="select kapasitas as kpsmtr from kendaraan WHERE jenis='Motor'";
            db.ambilData(perintah);
            if(db.rss.next()) {
            	kapasitasmotor = db.rss.getInt("kpsmtr");
            }
            
		}
		catch(Exception e){
			System.out.println("gagal Mengambil dapat data kapasitas_motor:  "+e);
            System.exit(0);
			
		}
		return kapasitasmotor;
	}
	
	public int kapasitas_mobil(){
		int kapasitasmobil=0;
		try{
			String perintah="select kapasitas as kpsmbl from kendaraan WHERE jenis='Mobil'";
            db.ambilData(perintah);
            if(db.rss.next()) {
            	kapasitasmobil = db.rss.getInt("kpsmbl");
            }
            
		}
		catch(Exception e){
			System.out.println("gagal Mengambil dapat data kapasitas_mobil:  "+e);
            System.exit(0);
			
		}
		return kapasitasmobil;
	}


	}

	
