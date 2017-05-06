package eparking.method;

import eparking.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import eparking.entity.*;
import eparking.konfigurasi.*;
public class metPengaturan {
	public Koneksi db=null;
	public metPengaturan(){
		db=new Koneksi();
	}
	
	public List<entityUser> tampil_user(){
        List<entityUser> logUser = new ArrayList<entityUser>();       
        String perintah="select * from user";
        try{
            db.ambilData(perintah);

            while(db.rss.next()){
            	entityUser eu = new entityUser();
                 eu.setId(db.rss.getInt("id"));
                 eu.setNama(db.rss.getString("nama"));
                 eu.setUsername(db.rss.getString("username"));
                 eu.setPassword(db.rss.getString("password"));
                 eu.setHakakses(db.rss.getString("hak_akses"));
                 
                 logUser.add(eu);
            }
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data "+e);
            System.exit(0);
         }
        
        return logUser;
    }
	
	public List<entityKendaraan> tampil_tarif(){
        List<entityKendaraan> logTarif = new ArrayList<entityKendaraan>();       
        String perintah="select id,jenis,tarif_jam_pertama,tarif_jam_berikut from kendaraan";
        try{
            db.ambilData(perintah);

            while(db.rss.next()){
            	entityKendaraan ek = new entityKendaraan();
                 ek.setId(db.rss.getInt("id"));
                 ek.setJenis(db.rss.getString("jenis"));
                 ek.setTjp(db.rss.getDouble("tarif_jam_pertama"));
                 ek.setTjb(db.rss.getDouble("tarif_jam_berikut"));
                 
                 logTarif.add(ek);
            }
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data "+e);
            System.exit(0);
         }
        
        return logTarif;
    }
	
	public List<entityKendaraan> tampil_kapasitas(){
        List<entityKendaraan> logKapasitas = new ArrayList<entityKendaraan>();       
        String perintah="select * from kendaraan";
        try{
            db.ambilData(perintah);

            while(db.rss.next()){
            	entityKendaraan ek = new entityKendaraan();
                 ek.setId(db.rss.getInt("id"));
                 ek.setJenis(db.rss.getString("jenis"));
                 ek.setKapasitas(db.rss.getInt("kapasitas"));
                 
                 logKapasitas.add(ek);
            }
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengambil data "+e);
            System.exit(0);
         }
        
        return logKapasitas;
    }
	
	public int ubahtarif(entityKendaraan e){
    	String perintah="update kendaraan set tarif_jam_pertama='"+e.getTjp()+"', tarif_jam_berikut='"+e.getTjb()+"' where jenis= '"+e.getJenis()+"'";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(perintah);
            } catch(SQLException a){
            	JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
	
	public int ubahkapasitas(entityKendaraan e){
    	String perintah="update kendaraan set kapasitas='"+e.getKapasitas()+"' where jenis= '"+e.getJenis()+"'";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(perintah);
            } catch(SQLException a){
            	JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
	
	public int tambahUser(entityUser e){
        String sql="INSERT INTO user(nama,username,password,hak_akses) VALUES ('"+e.getNama()+"','"+e.getUsername()+"','"+e.getPassword()+"','"+e.getHakakses()+"')";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(sql);
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
	
	public int hapusUser(entityUser e){
        String sql="DELETE FROM `user` WHERE `user`.`id` ='"+e.getId()+"'";
        int hasil=0;
        try{
            hasil=db.stm.executeUpdate(sql);
        } catch(SQLException a){
        	JOptionPane.showMessageDialog(null,"Gagal simpan"+a);
        }
        return hasil;
    }
}
