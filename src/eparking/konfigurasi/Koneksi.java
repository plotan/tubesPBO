package eparking.konfigurasi;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Koneksi{
    
	String url, username, password;
    public Connection cnn;
    public Statement stm;
    public ResultSet rss;
	DefaultTableModel isi;
    public static Connection koneksi;
	
    //Constructor
    public static Connection aktifkan_koneksi(){
        if(koneksi==null){
            try{
                String server="jdbc:mysql://localhost:3306/eParking_ITERA";
                String user="root";
                String password="1234567890";
                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection(server,user,password);               
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Koneksi GATOT, Pesan error \n"+e);
            }                        
        }
        return koneksi;
    }
    
    public void koneksi(){
            try{
                String server="jdbc:mysql://localhost:3306/eParking_ITERA";
                String user="root";
                String password="1234567890";
                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection(server,user,password);  
                stm=koneksi.createStatement();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Koneksi gagal\n"+e);
            }
            
    }
    
    public void tutupKoneksi(ResultSet rss){
        try{
            if(rss!=null){
                rss.close();
            }
            stm.close();
            koneksi.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Tutup Koneksi Gagal\n"+e);
        }
    }
     
    public ResultSet ambilData(String sql){
        
        try{
            koneksi();
            rss=stm.executeQuery(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ambil Data Gagal, Pesan error : \n"+e);
        }
        return rss;
    }
    
    public Statement simpanData(String sql){
        try{            
            koneksi();
            stm.executeUpdate(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Simpan Data Gagal, Pesan error : \n"+e);
        }        
    return stm;
    }
    
    
 

    
    
    

}
