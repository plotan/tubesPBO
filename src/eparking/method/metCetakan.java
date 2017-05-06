package eparking.method;

import java.io.InputStream;
import java.util.Date;
import java.sql.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.JOptionPane;

import eparking.konfigurasi.Koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class metCetakan {
	public Koneksi db=null;
	
public metCetakan(){
	db=new Koneksi();
	
	
}

public void cetakKarcis(String nopol){
	try{
	        
	        String sumber= "src/eparking/karcis/karcis.jrxml";
	        //String tujuan = "src/eparking/hasil/karcis.pdf";
	        HashMap<String, Object> parameter = new HashMap<>();
	        parameter.put("nopol", nopol);
	        JasperReport jr = JasperCompileManager.compileReport(sumber);
	        JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	        //JasperExportManager.exportReportToPdfFile(jp, tujuan);
	        JasperViewer.viewReport(jp,false);
	        } catch (JRException ex) {
	            JOptionPane.showMessageDialog(null, "Gagal tampilakn report"+ex);
	        }
	    }

public void cetakPembayaran(String cari,String durasi)
{
	try {

		 String sumber= "src/eparking/pembayaran/buktipembayaran.jrxml";
	     HashMap<String, Object> parameter = new HashMap<>();
	     parameter.put("cari",cari);
	     parameter.put("durasi", durasi);
	     JasperReport jr = JasperCompileManager.compileReport(sumber);
	     JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	     JasperViewer.viewReport(jp,false);

	     } catch (Exception ex) {
	         System.out.println(ex);
	     }
		
 }

 
 public String formatMonth(int month, Locale locale) {
	    DateFormatSymbols symbols = new DateFormatSymbols(locale);
	    String[] monthNames = symbols.getMonths();
	    return monthNames[month-1];
}
 

public void cetakLaporanBulanan(int bulan1, int tahun1){
	try{
		
        String mn=formatMonth(bulan1,Locale.GERMAN);
        String sumber= "src/eparking/laporan/laporanBulanan.jrxml";
       
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("bulan",bulan1);
        parameter.put("tahun",tahun1);
        parameter.put("blnstring", mn);
        
        JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
	} catch (Exception ex) {
		System.out.println(ex);
	}
}

public void cetakLaporanMotorBulanan(int bulan1, int tahun1){
	try{
		
        String mn=formatMonth(bulan1,Locale.GERMAN);
        String sumber= "src/eparking/laporan/laporanMotorBulanan.jrxml";
       
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("bulan",bulan1);
        parameter.put("tahun",tahun1);
        parameter.put("blnstring", mn);
        
        JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
	} catch (Exception ex) {
		System.out.println(ex);
	}
}

public void cetakLaporanMobilBulanan(int bulan1, int tahun1){
	try{
		
        String mn=formatMonth(bulan1,Locale.GERMAN);
        String sumber= "src/eparking/laporan/laporanMobilBulanan.jrxml";
       
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("bulan",bulan1);
        parameter.put("tahun",tahun1);
        parameter.put("blnstring", mn);
        
        JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
	} catch (Exception ex) {
		System.out.println(ex);
	}
}

public void cetakLaporanHarian(Date date, Date date2, Date date3){
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
	    Date tgl = date;
	    System.out.println(sdf.format(tgl));
	    int tgl1 = Integer.parseInt( sdf.format(tgl));
	    
	    SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
	    Date bln = date2;
	    System.out.println(sdf1.format(bln));
	    int bln1 = Integer.parseInt( sdf1.format(bln));
	    
	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
	    Date thn = date3;
	    
	    int thn1 = Integer.parseInt( sdf2.format(thn));
	    String mn=formatMonth(bln1,Locale.GERMAN);
        String sumber= "src/eparking/laporan/laporanHarian.jrxml";
	    
	    System.out.println(thn1);
	    System.out.println(mn);
	    HashMap<String, Object> parameter = new HashMap<>();
	    parameter.put("tanggal",tgl1);
	    parameter.put("bulan",bln1);
	    parameter.put("tahun",thn1);
	    parameter.put("blnString", mn);
	    
	    JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}

public void cetakLaporanMotorHarian(Date date, Date date2, Date date3){
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
	    Date tgl = date;
	    System.out.println(sdf.format(tgl));
	    int tgl1 = Integer.parseInt( sdf.format(tgl));
	    
	    SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
	    Date bln = date2;
	    System.out.println(sdf1.format(bln));
	    int bln1 = Integer.parseInt( sdf1.format(bln));
	    
	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
	    Date thn = date3;
	    
	    int thn1 = Integer.parseInt( sdf2.format(thn));
	    String mn=formatMonth(bln1,Locale.GERMAN);
        String sumber= "src/eparking/laporan/laporanMotorHarian.jrxml";
	    
	    System.out.println(thn1);
	    System.out.println(mn);
	    HashMap<String, Object> parameter = new HashMap<>();
	    parameter.put("tanggal",tgl1);
	    parameter.put("bulan",bln1);
	    parameter.put("tahun",thn1);
	    parameter.put("blnString", mn);
	    
	    JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}


public void cetakLaporanMobilHarian(Date date, Date date2, Date date3){
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
	    Date tgl = date;
	    System.out.println(sdf.format(tgl));
	    int tgl1 = Integer.parseInt( sdf.format(tgl));
	    
	    SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
	    Date bln = date2;
	    System.out.println(sdf1.format(bln));
	    int bln1 = Integer.parseInt( sdf1.format(bln));
	    
	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
	    Date thn = date3;
	    
	    int thn1 = Integer.parseInt( sdf2.format(thn));
	    String mn=formatMonth(bln1,Locale.GERMAN);
        String sumber= "src/eparking/laporan/laporanMobilHarian.jrxml";
	    
	    System.out.println(thn1);
	    System.out.println(mn);
	    HashMap<String, Object> parameter = new HashMap<>();
	    parameter.put("tanggal",tgl1);
	    parameter.put("bulan",bln1);
	    parameter.put("tahun",thn1);
	    parameter.put("blnString", mn);
	    
	    JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}

public static final long HOUR = 3600*1000;
public static final long MINUTES = 60*1000;
public static final long SECONDS = 1*1000;

public void cetakLaporanPeriode(Date date, Date date2){
	try{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date periode = date;
	    String periode1 = sdf.format(periode);
	    Date periode_1 = sdf.parse(periode1);
	    java.sql.Timestamp Periode_1= new java.sql.Timestamp(periode_1.getTime());
	    
	    
	    Date periodee = date2;
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    String periode_2 = sdf1.format(periodee);
	    Date Periode2 = sdf1.parse(periode_2);
	    
	    java.sql.Timestamp Periode_2= new java.sql.Timestamp(Periode2.getTime()+(23*HOUR)+(59*MINUTES)+(59*SECONDS));
	    
	    
	    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    //Date periode_1 = dateChooser_2.getDate();
	    //String periode2 = sdf1.format(periode_1);
	    
		System.out.println(Periode_1);
		System.out.println(Periode_2);
		//System.out.println(periode2);
        
		String sumber= "src/eparking/laporan/laporanPeriode.jrxml";
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("periode1",Periode_1);
        parameter.put("periode2",Periode_2);
        JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}

public void cetakLaporanMotorPeriode(Date date, Date date2){
	try{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date periode = date;
	    String periode1 = sdf.format(periode);
	    Date periode_1 = sdf.parse(periode1);
	    java.sql.Timestamp Periode_1= new java.sql.Timestamp(periode_1.getTime());
	    
	    
	    Date periodee = date2;
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    String periode_2 = sdf1.format(periodee);
	    Date Periode2 = sdf1.parse(periode_2);
	    
	    java.sql.Timestamp Periode_2= new java.sql.Timestamp(Periode2.getTime()+(23*HOUR)+(59*MINUTES)+(59*SECONDS));
	    
	    
	    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    //Date periode_1 = dateChooser_2.getDate();
	    //String periode2 = sdf1.format(periode_1);
	    
		System.out.println(Periode_1);
		System.out.println(Periode_2);
		//System.out.println(periode2);
        
		String sumber= "src/eparking/laporan/laporanMotorPeriode.jrxml";
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("periode1",Periode_1);
        parameter.put("periode2",Periode_2);
        JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}

public void cetakLaporanMobilPeriode(Date date, Date date2){
	try{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date periode = date;
	    String periode1 = sdf.format(periode);
	    Date periode_1 = sdf.parse(periode1);
	    java.sql.Timestamp Periode_1= new java.sql.Timestamp(periode_1.getTime());
	    
	    
	    Date periodee = date2;
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    String periode_2 = sdf1.format(periodee);
	    Date Periode2 = sdf1.parse(periode_2);
	    
	    java.sql.Timestamp Periode_2= new java.sql.Timestamp(Periode2.getTime()+(23*HOUR)+(59*MINUTES)+(59*SECONDS));
	    
	    
	    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    //Date periode_1 = dateChooser_2.getDate();
	    //String periode2 = sdf1.format(periode_1);
	    
		System.out.println(Periode_1);
		System.out.println(Periode_2);
		//System.out.println(periode2);
        
		String sumber= "src/eparking/laporan/laporanMobilPeriode.jrxml";
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("periode1",Periode_1);
        parameter.put("periode2",Periode_2);
        JasperReport jr = JasperCompileManager.compileReport(sumber);
	    JasperPrint jp = JasperFillManager.fillReport(jr,parameter,db.aktifkan_koneksi());
	    JasperViewer.viewReport(jp,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}
/*




private JTextField tarifJamBerikut;
private void cetakLaporanPeriode(){
	try{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date periode = dateChooser_1.getDate();
	    String periode1 = sdf.format(periode);
	    Date periode_1 = sdf.parse(periode1);
	    java.sql.Timestamp Periode_1= new java.sql.Timestamp(periode_1.getTime());
	    
	    
	    Date periodee = dateChooser_2.getDate();
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    String periode_2 = sdf1.format(periodee);
	    Date Periode2 = sdf1.parse(periode_2);
	    
	    java.sql.Timestamp Periode_2= new java.sql.Timestamp(Periode2.getTime()+(23*HOUR)+(59*MINUTES)+(59*SECONDS));
	    
	    
	    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    //Date periode_1 = dateChooser_2.getDate();
	    //String periode2 = sdf1.format(periode_1);
	    
		System.out.println(Periode_1);
		System.out.println(Periode_2);
		//System.out.println(periode2);
        
		String reportName = PathLaporanPeriode + "laporanPeriode.jasper";
        HashMap<String, Object> parameter = new HashMap<>();
        File reportFile = new File(reportName);
        parameter.put("periode1",Periode_1);
        parameter.put("periode2",Periode_2);
        JasperReport jReport = (JasperReport)JRLoader.loadObjectFromFile(reportFile.getPath());
        JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter , Koneksi.getkoneksi());
        JasperViewer.viewReport(jPrint, false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
} catch (Exception ex) {
    System.out.println(ex);
}
}

private void cetakLaporanMotorPeriode(){
	try{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date periode = dateChooser_1.getDate();
	    String periode1 = sdf.format(periode);
	    Date periode_1 = sdf.parse(periode1);
	    java.sql.Timestamp Periode_1= new java.sql.Timestamp(periode_1.getTime());
	    
	    
	    Date periodee = dateChooser_2.getDate();
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    String periode_2 = sdf1.format(periodee);
	    Date Periode2 = sdf1.parse(periode_2);
	    
	    java.sql.Timestamp Periode_2= new java.sql.Timestamp(Periode2.getTime()+(23*HOUR)+(59*MINUTES)+(59*SECONDS));
	    
	    
	    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    //Date periode_1 = dateChooser_2.getDate();
	    //String periode2 = sdf1.format(periode_1);
	    
		System.out.println(Periode_1);
		System.out.println(Periode_2);
		//System.out.println(periode2);
        
		String reportName = PathLaporanMotorPeriode + "laporanMotorPeriode.jasper";
        HashMap<String, Object> parameter = new HashMap<>();
        File reportFile = new File(reportName);
        parameter.put("periode1",Periode_1);
        parameter.put("periode2",Periode_2);
        JasperReport jReport = (JasperReport)JRLoader.loadObjectFromFile(reportFile.getPath());
        JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter , Koneksi.getkoneksi());
        JasperViewer.viewReport(jPrint, false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
 } catch (Exception ex) {
    System.out.println(ex);
}
}
private void cetakLaporanMobilPeriode(){
	try{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Date periode = dateChooser_1.getDate();
	    String periode1 = sdf.format(periode);
	    Date periode_1 = sdf.parse(periode1);
	    java.sql.Timestamp Periode_1= new java.sql.Timestamp(periode_1.getTime());
	    
	    
	    Date periodee = dateChooser_2.getDate();
	    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    String periode_2 = sdf1.format(periodee);
	    Date Periode2 = sdf1.parse(periode_2);
	    
	    java.sql.Timestamp Periode_2= new java.sql.Timestamp(Periode2.getTime()+(23*HOUR)+(59*MINUTES)+(59*SECONDS));
	    
	    
	    //SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	    //Date periode_1 = dateChooser_2.getDate();
	    //String periode2 = sdf1.format(periode_1);
	    
		System.out.println(Periode_1);
		System.out.println(Periode_2);
		//System.out.println(periode2);
        
		String reportName = PathLaporanMobilPeriode + "laporanMobilPeriode.jasper";
        HashMap<String, Object> parameter = new HashMap<>();
        File reportFile = new File(reportName);
        parameter.put("periode1",Periode_1);
        parameter.put("periode2",Periode_2);
        JasperReport jReport = (JasperReport)JRLoader.loadObjectFromFile(reportFile.getPath());
        JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter , Koneksi.getkoneksi());
        JasperViewer.viewReport(jPrint, false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);

	} catch (Exception ex) {
    System.out.println(ex);
}
}
*/
}
