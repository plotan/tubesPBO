package eparking.method;

import eparking.entity.entityUser;
import eparking.konfigurasi.Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class metUser {
	
	
    Koneksi db = null;
    
    
    public metUser(){
    
    	db =  new Koneksi();	
    	
    }
	    
    public List cariLogin(String username,String password){
        List logLogin = new ArrayList();
        String sql="select username,password,hak_akses,nama from user where username='"+username+"' and password='"+password+"'";
        try{
            db.ambilData(sql);

            while(db.rss.next()){
                
            	entityUser  eu=new entityUser();
            	eu.setNama(db.rss.getString("nama"));
            	eu.setUsername(db.rss.getString("username"));
                eu.setPassword(db.rss.getString("password"));
                eu.setHakakses(db.rss.getString("hak_akses"));
                
                logLogin.add(eu);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan login, pada :\n"+a);
        }
        return logLogin;
    }



}
