package eparking.GUI;

import eparking.entity.entityKendaraan;
import eparking.entity.entityParkir;
import eparking.entity.entityUser;
import eparking.konfigurasi.*;
import eparking.method.metCetakan;
import eparking.method.metUser;
import eparking.method.metUtama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import java.awt.SystemColor;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.UIManager;

//import org.joda.time.DateTime;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.ImageIcon;

public class utama extends JFrame{
	
	
	DefaultTableModel model;
	metUtama mu=new metUtama();
	metUser metu= new metUser();
	metCetakan mc=new metCetakan();
    entityParkir ep=new entityParkir();
    entityUser eu = new entityUser();
    entityKendaraan ek=new entityKendaraan();
    Object[] datak=new Object[5];
    String petugas;
    List <entityParkir> listParkir=new ArrayList<entityParkir>();
    List<entityUser> listLogin=new ArrayList<entityUser>();
    List <entityKendaraan> listKendaraan=new ArrayList<entityKendaraan>();
    String[] namaBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
            "Augustus", "September", "Oktober", "November", "Desember" };
    
    
    
		
	/**
	 * Launch the application.
	 */
	public utama() {
		initialize();
		tengah tengah= new tengah(frmEparking);
		buatTabel();
		showTabel();
		showKendaraan();
		waktu();
	}
	
	private void buatTabel(){
        model=new DefaultTableModel();
        model.addColumn("Tiket");
        model.addColumn("Nopol");
        model.addColumn("Jenis");
        model.addColumn("Waktu Masuk");
        model.addColumn("Waktu Keluar");
        model.addColumn("Durasi");
        model.addColumn("Total Tarif Rp.");
        model.addColumn("Status");
        
        table.setModel(model);
    }

	
    private void showTabel(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();    
        listParkir.clear();        
        listParkir=mu.tampil_parkir();
        for(int x=0; x < listParkir.size(); x++){
            Object[] data=new Object[8];
            data[0]=listParkir.get(x).getTiket();
            data[1]=listParkir.get(x).getNopol();
            data[2]=listParkir.get(x).getJenis();
            data[3]=listParkir.get(x).getWaktu_masuk();
            data[4]=listParkir.get(x).getWaktu_keluar();
            data[5]=listParkir.get(x).getDurasi();
            data[6]=listParkir.get(x).getTotal_tarif();
            data[7]=listParkir.get(x).getStatus();
            model.addRow(data);            
        }        
    }
    
    private void showKendaraan(){
    	listKendaraan.clear();        
        listKendaraan=mu.tampil_kendaraan();        
        for(int x=0; x < listKendaraan.size(); x++){
            
            datak[0]=listKendaraan.get(x).getId();
            datak[1]=listKendaraan.get(x).getJenis();
            datak[2]=listKendaraan.get(x).getTjp();
            datak[3]=listKendaraan.get(x).getTjb();
            datak[4]=listKendaraan.get(x).getKapasitas();
            
    }
    }
    
    
    
    

    private void bersih(){
        nopol.setText("");
        cari.setText("");
        jenis.setText("");
        waktu_masuk.setText("");
        status.setText("");
        waktu_keluar.setText("");
        durasi.setText("");
        total_tarif.setText("");
        tjp.setText("");
        tjb.setText("");
        
    }
    
    private void waktu(){
		Thread waktu=new Thread()
        {
                public void run()
                {

                        try {

                                for(;; ) {
                                        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
                                        Date sekarang = new Date();
                                        Calendar cal=new GregorianCalendar();
                                        int hari=cal.get(Calendar.DAY_OF_MONTH);
                                        String bulan= namaBulan[cal.get(Calendar.MONTH)];
                                        int tahun=cal.get(Calendar.YEAR);
                                        String jam = sdfTime.format(sekarang);
                                        lblWaktu.setText("Waktu: "+hari+" "+bulan+" "+tahun+" -  "+jam);
                                        lblWaktu_1.setText("Waktu: "+hari+" "+bulan+" "+tahun+" -  "+jam);
                                        sleep(1000);
                                }
                        }
                        catch(InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        };
        waktu.start();
    }
    
    
    
	/**
	 * Create the application.
	 */
    
    
	
    

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEparking = new JFrame();
		frmEparking.setTitle("eParking");
		frmEparking.getContentPane().setBackground(new Color(102, 204, 204));
		frmEparking.setBounds(100, 100, 708, 481);
		
		frmEparking.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	int p = JOptionPane.showConfirmDialog (null, "Apakah anda ingin logout?","Warning",JOptionPane.YES_NO_OPTION);
				
				if(p==0){
					System.exit(0);
				}
				if(p==1){
					JOptionPane.showMessageDialog(null,"Logout dibatalkan");
				}
		    	
		        }
		    
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("TabbedPane.highlight"));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.addTab("Parkir Masuk", null, panel_1, null);
		
		JLabel lblNomorPolisi = new JLabel("Nomor Polisi:");
		lblNomorPolisi.setHorizontalAlignment(SwingConstants.RIGHT);
		
		nopol = new JTextField();
		nopol.setColumns(10);
		
		JLabel lblJenisKendaraan = new JLabel("Jenis Kendaraan:");
		lblJenisKendaraan.setHorizontalAlignment(SwingConstants.RIGHT);
		
		rdbtnMotor = new JRadioButton("Motor");
		buttonGroup.add(rdbtnMotor);
		rdbtnMotor.setBackground(SystemColor.text);
		
		rdbtnMobil = new JRadioButton("Mobil");
		buttonGroup.add(rdbtnMobil);
		rdbtnMobil.setBackground(SystemColor.text);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSimpanActionPerformed(e);
			}

			
		});
		
		lblWaktu = new JLabel("Waktu");
		

		
		JLabel lblJumlahKendaraan = new JLabel("Jumlah Kendaraan:");
		
		lblMotor = new JLabel("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
		
		lblMobil = new JLabel("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
		
		
		JLabel lblSistemParkirKendaraan = new JLabel("Sistem Parkir Kendaraan Masuk");
		lblSistemParkirKendaraan.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(rdbtnMotor, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMobil)
									.addGap(59))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSimpan)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNomorPolisi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nopol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(129))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblJenisKendaraan, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(227)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblWaktu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(365))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblMotor)
									.addContainerGap()))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMobil)
								.addContainerGap()))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblJumlahKendaraan)
							.addContainerGap())))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(204)
					.addComponent(lblSistemParkirKendaraan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(400))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemParkirKendaraan)
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWaktu)
						.addComponent(lblNomorPolisi)
						.addComponent(nopol, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblJenisKendaraan)
							.addGap(13))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblJumlahKendaraan)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMotor)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnMotor)
							.addComponent(rdbtnMobil)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMobil)
						.addComponent(btnSimpan))
					.addGap(29))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.addTab("Parkir Keluar", null, panel, null);
		
		JLabel lblCariNopol = new JLabel("Cari Nopol: ");
		lblCariNopol.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cari = new JTextField();
		cari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			cariKeyReleased(e);
			}

			
		});
		cari.setColumns(10);
		
		JLabel lblJenis = new JLabel("Jenis: ");
		lblJenis.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jenis = new JTextField();
		jenis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			jenisKeyReleased(e);
			}

			
		});
		jenis.setEditable(false);
		jenis.setColumns(10);
		
		JLabel lblWaktuMasuk = new JLabel("Waktu Masuk:");
		lblWaktuMasuk.setHorizontalAlignment(SwingConstants.RIGHT);
		
		waktu_masuk = new JTextField();
		waktu_masuk.setEditable(false);
		waktu_masuk.setColumns(10);
		
		JLabel lblWaktuKeluar = new JLabel("Waktu Keluar:");
		lblWaktuKeluar.setHorizontalAlignment(SwingConstants.RIGHT);
		
		waktu_keluar = new JTextField();
		waktu_keluar.setEditable(false);
		waktu_keluar.setColumns(10);
		
		JLabel lblDurasi = new JLabel("Durasi:");
		
		durasi = new JTextField();
		durasi.setEditable(false);
		durasi.setColumns(10);
		
		JLabel lblJamPertama = new JLabel("T/JP: Rp.");
		
		JLabel lblJamBerikut = new JLabel("T/JB: Rp.");
		
		tjp = new JTextField();
		tjp.setEditable(false);
		tjp.setColumns(10);
		
		tjb = new JTextField();
		tjb.setEditable(false);
		tjb.setColumns(10);
		
		JLabel lblBiayaRp = new JLabel("Biaya: Rp.");
		
		total_tarif = new JTextField();
		total_tarif.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				total_tarifKeyReleased(e);
			}

			
		});
		total_tarif.setBackground(SystemColor.info);
		total_tarif.setEditable(false);
		total_tarif.setColumns(10);
		
		lblWaktu_1 = new JLabel("Waktu: ");
		
		lblStatus = new JLabel("Status: ");
		
		JLabel lblJumlahKendaraan_1 = new JLabel("Jumlah Kendaraan:");
		
		lblMotor_1 = new JLabel("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
		
		lblMobil_1 = new JLabel("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
		
		status = new JLabel("");
		status.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnKeluar = new JButton("Keluar Parkir");
		btnKeluar.setHorizontalAlignment(SwingConstants.LEADING);
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnKeluarActionPerformed(e);
			}

			
		});
		
		lblSistemParkirKendaraan_1 = new JLabel("Sistem Parkir Kendaraan Keluar");
		lblSistemParkirKendaraan_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblWaktuKeluar, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(0)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(12)
									.addComponent(lblWaktuMasuk, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(70)
									.addComponent(lblJenis, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(19)
									.addComponent(lblCariNopol, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(120, Short.MAX_VALUE)
							.addComponent(lblDurasi)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(waktu_masuk, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(jenis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJamBerikut))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(cari, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJamPertama)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tjp, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(status, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tjb, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnKeluar))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(durasi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblBiayaRp)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(total_tarif, 127, 127, 127))
								.addComponent(waktu_keluar, 336, 336, Short.MAX_VALUE)
								.addComponent(lblWaktu_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblJumlahKendaraan_1)
								.addComponent(lblMobil_1)
								.addComponent(lblMotor_1))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(240)
					.addComponent(lblSistemParkirKendaraan_1, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(223))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemParkirKendaraan_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCariNopol)
						.addComponent(cari, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus)
						.addComponent(lblJamPertama)
						.addComponent(tjp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(status))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblJenis)
								.addComponent(jenis, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblJamBerikut)
								.addComponent(tjb, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWaktuMasuk)
								.addComponent(waktu_masuk, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnKeluar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(waktu_keluar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblJumlahKendaraan_1))
						.addComponent(lblWaktuKeluar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(durasi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBiayaRp)
						.addComponent(total_tarif, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDurasi)
						.addComponent(lblMotor_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWaktu_1)
						.addComponent(lblMobil_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(102, 204, 204));
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setIcon(new ImageIcon(utama.class.getResource("/eparking/img/logout.png")));
		btnLogout.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogoutActionPerformed(e);
			}

			
		});
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}

			
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCopyright = new JLabel("Copyright ©2017");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmEparking.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(576, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 704, Short.MAX_VALUE)
						.addComponent(lblCopyright, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
					.addGap(2))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 268, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCopyright)
					.addContainerGap())
		);
		frmEparking.getContentPane().setLayout(groupLayout);
	}
	
	private void btnSimpanActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( !"".equals(nopol.getText())) {
			if(mu.tampil_motor()<mu.kapasitas_motor() && rdbtnMotor.isSelected()){
				ep.setNopol(this.nopol.getText());
				ep.setJenis(this.rdbtnMotor.getText());
				if(mu.tambahKendaraan(ep)==1){
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                } else{
                    JOptionPane.showMessageDialog(null, "Data gagal disimpan");
                }
				showTabel();
				mc.cetakKarcis(this.nopol.getText());
				lblMotor.setText("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
				lblMotor_1.setText("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
				bersih();
				if(mu.tampil_motor()==mu.kapasitas_motor()) {
                	JOptionPane.showMessageDialog(null, "Parkiran motor sudah penuh!");
                }
			}
			if(mu.tampil_mobil()<mu.kapasitas_mobil() && rdbtnMobil.isSelected()){
				ep.setNopol(this.nopol.getText());
				ep.setJenis(this.rdbtnMobil.getText());
				if(mu.tambahKendaraan(ep)==1){
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                } else{
                    JOptionPane.showMessageDialog(null, "Data gagal disimpan");
                }
				showTabel();
				mc.cetakKarcis(this.nopol.getText());
				lblMobil.setText("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
				lblMobil_1.setText("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
				bersih();
				if(mu.tampil_mobil()==mu.kapasitas_mobil()) {
                	JOptionPane.showMessageDialog(null, "Parkiran motor sudah penuh!");
                
				}
				
			}
			if(mu.tampil_motor()==mu.kapasitas_motor()){
				JOptionPane.showMessageDialog(null, "Parkiran penuh");
				bersih();
				lblMotor.setText("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
				
			}
			if(mu.tampil_mobil()==mu.kapasitas_mobil()){
				JOptionPane.showMessageDialog(null, "Parkiran penuh");
				bersih();
				lblMobil.setText("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
		
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Masukkan Nomor Polisi");
		}
	}
	
	private void btnLogoutActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int p = JOptionPane.showConfirmDialog (null, "Apakah anda ingin logout?","Warning",JOptionPane.YES_NO_OPTION);
		
		if(p==0){
			System.exit(0);
		}
		if(p==1){
			JOptionPane.showMessageDialog(null,"Logout dibatalkan");
		}
	}
/*	
	private void btnRefreshActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showTabel();
		lblMotor.setText("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
		lblMobil.setText("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
		lblMotor_1 = new JLabel("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
		lblMobil_1 = new JLabel("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
	}
	*/
	private void cariKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if("".equals(cari.getText())){
			bersih();
			buatTabel();
			showTabel();
		}
		else{
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        listParkir.clear();
        listParkir=mu.cari_data(cari.getText());       
        for(int x=0;x<listParkir.size();x++){
        	Object[] data=new Object[8];
            data[0]=listParkir.get(x).getTiket();
            data[1]=listParkir.get(x).getNopol();
            data[2]=listParkir.get(x).getJenis();
            data[3]=listParkir.get(x).getWaktu_masuk();
            data[4]=listParkir.get(x).getWaktu_keluar();
            data[5]=listParkir.get(x).getDurasi();
            data[6]=listParkir.get(x).getTotal_tarif();
            data[7]=listParkir.get(x).getStatus();
            model.addRow(data);
        }
        table.setModel(model);
        
	}
	}
	
	private void jenisKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		listParkir.clear();
		listParkir=mu.dapatkan_data(cari.getText());
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
	}
	
	private void total_tarifKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		//total_tarif.valueOf(mu.akumulasi_biaya());
	}
	
	private void tableMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int baris = table.getSelectedRow();
		
	    cari.setText(table.getModel().getValueAt(baris, 1).toString());
        jenis.setText(table.getModel().getValueAt(baris, 2).toString());
        waktu_masuk.setText(table.getModel().getValueAt(baris, 3).toString());
        status.setText(table.getModel().getValueAt(baris, 7).toString());
        
        showKendaraan();
        listKendaraan=mu.tjptjb(jenis.getText());      
        Object[] data=new Object[2];
        for(int x=0;x<listKendaraan.size();x++){
        	
            data[0]=listKendaraan.get(x).getTjp();
            data[1]=listKendaraan.get(x).getTjb();
        }
        
		tjp.setText(data[0].toString());
        tjb.setText(data[1].toString());
        if("Parkir".equals(status.getText())){
        	status.setForeground(Color.green);
        }
        if("Tidak Parkir".equals(status.getText())){
        	status.setForeground(Color.red);
        }
	}
	private void btnKeluarActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( !"".equals(cari.getText()) && "Parkir".equals(status.getText())) {
		ep.setNopol(this.cari.getText());
		
		mu.keluarparkir(ep);
		mu.dapatkan_data(this.cari.getText());
		listParkir.clear();
		listParkir=mu.dapatkan_data(cari.getText());
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
		jenis.setText(data[2].toString());
		waktu_keluar.setText(data[4].toString());
		durasi.setText(data[5].toString());
		total_tarif.setText(data[6].toString());
		status.setText(data[7].toString());
		
		
		
		
		lblMotor.setText("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
		lblMobil.setText("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
		lblMotor_1.setText("Motor: "+mu.tampil_motor()+" / "+mu.kapasitas_motor());
		lblMobil_1.setText("Mobil: "+mu.tampil_mobil()+" / "+mu.kapasitas_mobil());
		ep.setDurasi(this.durasi.getText());
		ep.setTotal_tarif(Double.parseDouble(total_tarif.getText()));
		mu.keluartotal(ep);
		mc.cetakPembayaran(cari.getText(),durasi.getText());
		buatTabel();
		showTabel();
	}
		else{
            JOptionPane.showMessageDialog(null, "Kendaraan tidak ada");
            }
	}
	public static void utama() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					utama window = new utama();
					window.frmEparking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
		});
	}
	private JFrame frmEparking;
	private JTable table;
	private JTextField nopol;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMotor;
	private JRadioButton rdbtnMobil;
	private JLabel lblMotor;
	private JLabel lblMobil;
	private JLabel lblMotor_1;
	private JLabel lblMobil_1;
	private JTextField cari;
	private JTextField jenis;
	private JTextField waktu_masuk;
	private JTextField waktu_keluar;
	private JTextField durasi;
	private JTextField tjp;
	private JTextField tjb;
	private JTextField total_tarif;
	private JLabel lblWaktu;
	private JLabel lblWaktu_1;
	private JLabel lblStatus;
	private JLabel status;
	private JLabel lblSistemParkirKendaraan_1;
}
