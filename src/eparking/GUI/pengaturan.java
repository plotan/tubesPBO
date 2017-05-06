package eparking.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import eparking.entity.entityKendaraan;
import eparking.entity.entityUser;
import eparking.konfigurasi.tengah;
import eparking.method.metCetakan;
import eparking.method.metPengaturan;

import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class pengaturan extends JFrame{
	
	metPengaturan mp = new metPengaturan();
	metCetakan mc = new metCetakan();
	entityUser eu=new entityUser();
	
	List <entityUser> listUser=new ArrayList<entityUser>();
	entityKendaraan ek=new entityKendaraan();
	List <entityKendaraan> listTarif=new ArrayList<entityKendaraan>();
	List <entityKendaraan> listKapasitas=new ArrayList<entityKendaraan>();
	String admin="";
	
	
	/**
	 * Launch the application.
	 */
	public pengaturan() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(102, 204, 204));
		setTitle("Pengaturan eParking");
		initialize();
		tengah tengah = new tengah(this);
		buatTabelUser();
		buatTabelTarif();
		buatTabelKapasitas();
		showTabelUser();
		showTabelTarif();
		showTabelKapasitas();
		
	}
	
	
	
	private void buatTabelUser(){
        modelUser = new DefaultTableModel();
        modelUser.addColumn("id");
        modelUser.addColumn("Nama");
        modelUser.addColumn("Username");
        modelUser.addColumn("Password");
        modelUser.addColumn("Hak Akses");
        tableUser.setModel(modelUser);
    }
	
	
	
	private void showTabelUser(){
        modelUser.getDataVector().removeAllElements();
        modelUser.fireTableDataChanged();    
        listUser.clear();        
        listUser=mp.tampil_user();
        Object[] datauser=new Object[5];
        for(int x=0; x < listUser.size(); x++){
            
            datauser[0]=listUser.get(x).getId();
            datauser[1]=listUser.get(x).getNama();
            datauser[2]=listUser.get(x).getUsername();
            datauser[3]=listUser.get(x).getPassword();
            datauser[4]=listUser.get(x).getHakakses();
            modelUser.addRow(datauser);            
        }        
    }
	
	private void buatTabelTarif(){
        modelTarif = new DefaultTableModel();
        modelTarif.addColumn("id");
        modelTarif.addColumn("Jenis");
        modelTarif.addColumn("Tarif Jam Pertama Rp.");
        modelTarif.addColumn("Tarif Jam Berikut Rp.");
        
        tableTarif.setModel(modelTarif);
        	
    }
	
	private void showTabelTarif(){
        modelTarif.getDataVector().removeAllElements();
        modelTarif.fireTableDataChanged();    
        listTarif.clear();        
        listTarif=mp.tampil_tarif();
        Object[] data=new Object[4];
        for(int x=0; x < listTarif.size(); x++){
            
            data[0]=listTarif.get(x).getId();
            data[1]=listTarif.get(x).getJenis();
            data[2]=listTarif.get(x).getTjp();
            data[3]=listTarif.get(x).getTjb();
       
            modelTarif.addRow(data);            
        }        
    }
	
	private void buatTabelKapasitas(){
        modelKapasitas = new DefaultTableModel();
        modelKapasitas.addColumn("id");
        modelKapasitas.addColumn("Jenis");
        modelKapasitas.addColumn("Kapasitas Parkir");
        
        tableKapasitas.setModel(modelKapasitas);
        	
    }
	
	private void showTabelKapasitas(){
        modelKapasitas.getDataVector().removeAllElements();
        modelKapasitas.fireTableDataChanged();    
        listKapasitas.clear();        
        listKapasitas=mp.tampil_kapasitas();
        Object[] data=new Object[3];
        for(int x=0; x < listKapasitas.size(); x++){
            
            data[0]=listKapasitas.get(x).getId();
            data[1]=listKapasitas.get(x).getJenis();
            data[2]=listKapasitas.get(x).getKapasitas();     
            modelKapasitas.addRow(data);            
        }        
    }
	
	private void bersih(){
		nama.setText("");
		username.setText("");
		password.setText("");
		buttonGroup.clearSelection();
		buttonGroup_1.clearSelection();
		buttonGroup_2.clearSelection();
		tjp.setText("");
		tjb.setText("");
		kapasitas.setText("");
		hapusUser.setText("");
	}
	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 673, 563);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(102, 204, 204));
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(new Color(153, 204, 204));
		tabbedPane.addTab("User eParking", null, panelUser, null);
		
		JLabel lblTambahPetugas = new JLabel("Tambah User:");
		lblTambahPetugas.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		
		username = new JTextField();
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		password = new JPasswordField();
		
		JButton btnSimpanUser = new JButton("Simpan");
		btnSimpanUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSimpanUserActionPerformed(e);
			}

			
		});
		
		JLabel lblHapusPetugas = new JLabel("Hapus User:");
		
		JLabel lblIdPetugas = new JLabel("ID User:");
		lblIdPetugas.setHorizontalAlignment(SwingConstants.LEFT);
		
		hapusUser = new JTextField();
		hapusUser.setBackground(Color.PINK);
		hapusUser.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNama = new JLabel("Nama:");
		lblNama.setHorizontalAlignment(SwingConstants.RIGHT);
		
		nama = new JTextField();
		nama.setColumns(10);
		
		JLabel lblHakAkses = new JLabel("Hak Akses:");
		lblHakAkses.setHorizontalAlignment(SwingConstants.RIGHT);
		
		rdbtnPetugas = new JRadioButton("Petugas");
		rdbtnPetugas.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnPetugas.setBackground(new Color(153, 204, 204));
		buttonGroup.add(rdbtnPetugas);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBackground(new Color(153, 204, 204));
		buttonGroup.add(rdbtnAdmin);
		
		JButton btnHapusUser = new JButton("Hapus");
		btnHapusUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHapusUserActionPerformed(e);
			}

			
		});
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(pengaturan.class.getResource("/eparking/img/logouser.png")));
		GroupLayout gl_panelUser = new GroupLayout(panelUser);
		gl_panelUser.setHorizontalGroup(
			gl_panelUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUser.createSequentialGroup()
							.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSimpanUser)
								.addGroup(gl_panelUser.createSequentialGroup()
									.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelUser.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
												.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
										.addComponent(lblNama, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
										.addComponent(password, 125, 125, 125)
										.addComponent(username, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(nama, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelUser.createSequentialGroup()
									.addComponent(rdbtnPetugas, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(rdbtnAdmin, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGap(44))
								.addGroup(gl_panelUser.createSequentialGroup()
									.addComponent(lblTambahPetugas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(124)))
							.addGap(18))
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(lblHakAkses, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(162)))
					.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(label_2)
							.addGap(17)
							.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUser.createSequentialGroup()
									.addGap(18)
									.addComponent(lblHapusPetugas)
									.addContainerGap())
								.addGroup(gl_panelUser.createSequentialGroup()
									.addGap(15)
									.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelUser.createSequentialGroup()
											.addComponent(lblIdPetugas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(156))
										.addGroup(gl_panelUser.createSequentialGroup()
											.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnHapusUser)
												.addComponent(hapusUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addContainerGap())))))
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panelUser.setVerticalGroup(
			gl_panelUser.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelUser.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(lblTambahPetugas, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblHakAkses)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelUser.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnPetugas)
								.addComponent(rdbtnAdmin))
							.addGap(20)
							.addGroup(gl_panelUser.createParallelGroup(Alignment.TRAILING)
								.addComponent(nama, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNama))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelUser.createParallelGroup(Alignment.BASELINE)
								.addComponent(username, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelUser.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSimpanUser)
							.addGap(8))
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_panelUser.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_panelUser.createSequentialGroup()
							.addComponent(lblHapusPetugas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblIdPetugas, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hapusUser, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHapusUser)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableUser = new JTable();
		tableUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		tableUser.getColumnModel().getColumn(0).setPreferredWidth(33);
		scrollPane_2.setViewportView(tableUser);
		panelUser.setLayout(gl_panelUser);
		
		JPanel panelTarif = new JPanel();
		panelTarif.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(153, 204, 204), new Color(102, 204, 204)));
		panelTarif.setBackground(new Color(153, 204, 204));
		tabbedPane.addTab("Tarif Parkir", null, panelTarif, null);
		tabbedPane.setBackgroundAt(1, new Color(102, 204, 204));
		
		JLabel lblJenisKendaraan = new JLabel("Jenis Kendaraan:");
		lblJenisKendaraan.setHorizontalAlignment(SwingConstants.RIGHT);
		
		rdbtnMotorTarif = new JRadioButton("Motor");
		rdbtnMotorTarif.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnMotorTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		buttonGroup_1.add(rdbtnMotorTarif);
		rdbtnMotorTarif.setBackground(new Color(153, 204, 204));
		
		rdbtnMobilTarif = new JRadioButton("Mobil");
		rdbtnMobilTarif.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnMobilTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(rdbtnMobilTarif);
		rdbtnMobilTarif.setBackground(new Color(153, 204, 204));
		
		JLabel lblTarifJamPertama = new JLabel("Tarif jam pertama: Rp.");
		lblTarifJamPertama.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tjp = new JTextField();
		tjp.setColumns(10);
		
		JLabel lblTarifJamBerikut = new JLabel("Tarif jam berikut: Rp.");
		lblTarifJamBerikut.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tjb = new JTextField();
		tjb.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(pengaturan.class.getResource("/eparking/img/flatmoney.png")));
		
		JButton btnSimpanTarif = new JButton("Simpan");
		btnSimpanTarif.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSimpanTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSimpanTarifActionPerformed(e);
			}

			
		});
		GroupLayout gl_panelTarif = new GroupLayout(panelTarif);
		gl_panelTarif.setHorizontalGroup(
			gl_panelTarif.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTarif.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelTarif.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelTarif.createSequentialGroup()
							.addComponent(lblJenisKendaraan, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(209))
						.addGroup(gl_panelTarif.createSequentialGroup()
							.addComponent(rdbtnMotorTarif, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnMobilTarif, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(208))
						.addGroup(gl_panelTarif.createSequentialGroup()
							.addGroup(gl_panelTarif.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTarifJamBerikut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
								.addComponent(lblTarifJamPertama, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelTarif.createParallelGroup(Alignment.LEADING)
								.addComponent(tjp, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(tjb, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSimpanTarif, Alignment.TRAILING))
							.addGap(95)))
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(gl_panelTarif.createSequentialGroup()
					.addGap(122)
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
					.addGap(109))
		);
		gl_panelTarif.setVerticalGroup(
			gl_panelTarif.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTarif.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelTarif.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelTarif.createSequentialGroup()
							.addComponent(lblJenisKendaraan)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelTarif.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnMotorTarif)
								.addComponent(rdbtnMobilTarif))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelTarif.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTarifJamPertama)
								.addComponent(tjp, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelTarif.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTarifJamBerikut)
								.addComponent(tjb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnSimpanTarif))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		tableTarif = new JTable();
		tableTarif.setBackground(UIManager.getColor("TabbedPane.highlight"));
		scrollPane.setViewportView(tableTarif);
		panelTarif.setLayout(gl_panelTarif);
		
		JPanel panelKapasitas = new JPanel();
		panelKapasitas.setBackground(new Color(153, 204, 204));
		tabbedPane.addTab("Kapasitas Parkir", null, panelKapasitas, null);
		
		JLabel lblJenisKendaraan_1 = new JLabel("Jenis Kendaraan:");
		lblJenisKendaraan_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		rdbtnMotorKps = new JRadioButton("Motor");
		rdbtnMotorKps.setHorizontalAlignment(SwingConstants.RIGHT);
		buttonGroup_2.add(rdbtnMotorKps);
		rdbtnMotorKps.setBackground(new Color(153, 204, 204));
		
		rdbtnMobilKps = new JRadioButton("Mobil");
		buttonGroup_2.add(rdbtnMobilKps);
		rdbtnMobilKps.setBackground(new Color(153, 204, 204));
		
		JLabel lblJumlahKapasitas = new JLabel("Jumlah Kapasitas:");
		lblJumlahKapasitas.setHorizontalAlignment(SwingConstants.RIGHT);
		
		kapasitas = new JTextField();
		kapasitas.setColumns(10);
		
		JButton btnSimpanKps = new JButton("Simpan");
		btnSimpanKps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSimpanKpsActionPerfomed(e);
			}

			
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(pengaturan.class.getResource("/eparking/img/parkir.png")));
		GroupLayout gl_panelKapasitas = new GroupLayout(panelKapasitas);
		gl_panelKapasitas.setHorizontalGroup(
			gl_panelKapasitas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelKapasitas.createSequentialGroup()
					.addGap(264)
					.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(252))
				.addGroup(Alignment.LEADING, gl_panelKapasitas.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panelKapasitas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelKapasitas.createSequentialGroup()
							.addComponent(lblJenisKendaraan_1)
							.addContainerGap())
						.addGroup(gl_panelKapasitas.createSequentialGroup()
							.addGroup(gl_panelKapasitas.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelKapasitas.createSequentialGroup()
									.addComponent(rdbtnMotorKps, GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMobilKps)
									.addGap(82))
								.addGroup(gl_panelKapasitas.createSequentialGroup()
									.addGroup(gl_panelKapasitas.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSimpanKps)
										.addGroup(gl_panelKapasitas.createSequentialGroup()
											.addComponent(lblJumlahKapasitas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(kapasitas, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(43)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
							.addGap(23))))
		);
		gl_panelKapasitas.setVerticalGroup(
			gl_panelKapasitas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelKapasitas.createSequentialGroup()
					.addGap(48)
					.addComponent(lblJenisKendaraan_1)
					.addGap(18)
					.addGroup(gl_panelKapasitas.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelKapasitas.createSequentialGroup()
							.addGroup(gl_panelKapasitas.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnMotorKps)
								.addComponent(rdbtnMobilKps))
							.addGap(18)
							.addGroup(gl_panelKapasitas.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblJumlahKapasitas)
								.addComponent(kapasitas, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSimpanKps)
							.addGap(43))
						.addGroup(gl_panelKapasitas.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(53)))
					.addComponent(label_3)
					.addGap(53))
		);
		
		tableKapasitas = new JTable();
		tableKapasitas.setBackground(UIManager.getColor("TabbedPane.highlight"));
		scrollPane_1.setViewportView(tableKapasitas);
		panelKapasitas.setLayout(gl_panelKapasitas);
		
		JPanel panelLaporan = new JPanel();
		panelLaporan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLaporan.setBackground(new Color(153, 204, 204));
		tabbedPane.addTab("Laporan Parkir", null, panelLaporan, null);
		
		JLabel lblJenisKendaraan_2 = new JLabel("Jenis Kendaraan:");
		lblJenisKendaraan_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTanggal = new JLabel("Tanggal:");
		
		Tanggal = new JDateChooser();
		
		bulan = new JMonthChooser();
		bulan.getComboBox().setBackground(SystemColor.text);
		
		tahun = new JYearChooser();
		
		JLabel lblBulan = new JLabel("Bulan:");
		
		JLabel lblTahun = new JLabel("Tahun:");
		
		JLabel lblPeriodeAwal = new JLabel("Periode awal:");
		
		periodeAwal = new JDateChooser();
		
		JLabel lblPeriodeAkhir = new JLabel("Periode akhir:");
		
		periodeAkhir = new JDateChooser();
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(pengaturan.class.getResource("/eparking/img/report logo.png")));
		
		JButton btnCetak = new JButton("Cetak");
		btnCetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCetakActionPerformed(e);
						
				
			}

			

			
		});
		
		chckbxMotor = new JCheckBox("Motor");
		chckbxMotor.setBackground(new Color(153, 204, 204));
		
		chckbxMobil = new JCheckBox("Mobil");
		chckbxMobil.setBackground(new Color(153, 204, 204));
		
		laporanHarian = new JRadioButton("Laporan Harian");
		buttonGroup_3.add(laporanHarian);
		laporanHarian.setBackground(new Color(153, 204, 204));
		
		laporanBulanan = new JRadioButton("Laporan Bulanan");
		buttonGroup_3.add(laporanBulanan);
		laporanBulanan.setBackground(new Color(153, 204, 204));
		
		laporanPeriode = new JRadioButton("Laporan Periode");
		buttonGroup_3.add(laporanPeriode);
		laporanPeriode.setBackground(new Color(153, 204, 204));
		GroupLayout gl_panelLaporan = new GroupLayout(panelLaporan);
		gl_panelLaporan.setHorizontalGroup(
			gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLaporan.createSequentialGroup()
					.addGroup(gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelLaporan.createSequentialGroup()
							.addGap(57)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(63))
						.addGroup(gl_panelLaporan.createSequentialGroup()
							.addContainerGap(121, Short.MAX_VALUE)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLaporan.createSequentialGroup()
									.addComponent(chckbxMotor)
									.addGap(18)
									.addComponent(chckbxMobil))
								.addComponent(lblJenisKendaraan_2))
							.addGap(31)))
					.addGap(0)
					.addGroup(gl_panelLaporan.createParallelGroup(Alignment.LEADING)
						.addComponent(laporanBulanan)
						.addGroup(gl_panelLaporan.createSequentialGroup()
							.addGap(0)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLaporan.createSequentialGroup()
									.addComponent(lblPeriodeAkhir)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelLaporan.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCetak, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(periodeAkhir, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelLaporan.createSequentialGroup()
									.addComponent(lblPeriodeAwal)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(periodeAwal, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addComponent(laporanPeriode)))
						.addGroup(gl_panelLaporan.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLaporan.createSequentialGroup()
									.addComponent(lblTahun)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tahun, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelLaporan.createSequentialGroup()
									.addComponent(lblBulan)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bulan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelLaporan.createSequentialGroup()
							.addComponent(lblTanggal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Tanggal, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addComponent(laporanHarian))
					.addGap(252))
		);
		gl_panelLaporan.setVerticalGroup(
			gl_panelLaporan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLaporan.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addGroup(gl_panelLaporan.createSequentialGroup()
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblJenisKendaraan_2)
								.addComponent(laporanHarian))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Tanggal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panelLaporan.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTanggal)
									.addComponent(chckbxMotor)
									.addComponent(chckbxMobil)))
							.addGap(24)
							.addComponent(laporanBulanan)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBulan)
								.addComponent(bulan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTahun)
								.addComponent(tahun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addComponent(laporanPeriode)
							.addGap(18)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPeriodeAwal)
								.addComponent(periodeAwal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelLaporan.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPeriodeAkhir)
								.addComponent(periodeAkhir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(btnCetak, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panelLaporan.setLayout(gl_panelLaporan);
		
		JButton btnLiatParkir = new JButton("Tampil Parkir");
		btnLiatParkir.setBackground(Color.WHITE);
		btnLiatParkir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			bgnLiatParkirActionPerformed(e);
			}

			
		});
		
		JLabel lblCopyright = new JLabel("Copyright 2017");
		
		JLabel lblPetugas = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPetugas)
					.addPreferredGap(ComponentPlacement.RELATED, 470, Short.MAX_VALUE)
					.addComponent(btnLiatParkir)
					.addContainerGap())
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 671, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(276)
					.addComponent(lblCopyright, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(290))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLiatParkir)
						.addComponent(lblPetugas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 447, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCopyright)
					.addGap(5))
		);
		getContentPane().setLayout(groupLayout);
	}

	
	
	private void btnSimpanUserActionPerformed(ActionEvent e) {
		if(rdbtnPetugas.isSelected() || rdbtnAdmin.isSelected()){
		// TODO Auto-generated method stub
			if(rdbtnPetugas.isSelected()){
				if(nama.getText().isEmpty() && username.getText().isEmpty() && password.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Masukkan semua data Petugas");
				}
				else{
					eu.setNama(this.nama.getText());
					eu.setUsername(this.username.getText());
					eu.setPassword(this.password.getText());
					eu.setHakakses(this.rdbtnPetugas.getText());
					if(mp.tambahUser(eu)==1){
						JOptionPane.showMessageDialog(null, "Petugas baru berhasil disimpan");
					} 
					else{
						JOptionPane.showMessageDialog(null, "Data gagal disimpan");
					}
					showTabelUser();
					bersih();
				}
			}
			
		if(rdbtnAdmin.isSelected()){
			if(nama.getText().isEmpty() && username.getText().isEmpty() && password.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Masukkan semua data Admin");
			}
			else{
				eu.setNama(this.nama.getText());
				eu.setUsername(this.username.getText());
				eu.setPassword(this.password.getText());
				eu.setHakakses(this.rdbtnAdmin.getText());
				if(mp.tambahUser(eu)==1){
					JOptionPane.showMessageDialog(null, "Admin baru berhasil disimpan");
				} else{
					JOptionPane.showMessageDialog(null, "Data gagal disimpan");
				}
				showTabelUser();
				bersih();
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Pilih Hak Akses user");
		}
	}
	
	private void btnHapusUserActionPerformed(ActionEvent e) {
		
		if(hapusUser.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Masukkan ID User\nID User tidak ditemukan");
		}
		else{
			eu.setId(Integer.parseInt(hapusUser.getText()));
			int pesan=JOptionPane.showConfirmDialog(null, "Yakin user akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION
					,JOptionPane.QUESTION_MESSAGE);
			if(pesan==JOptionPane.YES_OPTION)
				if(mp.hapusUser(eu)==1){
					JOptionPane.showMessageDialog(null, "User berhasil dihapus");
				} 
				else{             
					JOptionPane.showMessageDialog(null, "ID User Data gagal disimpan");
				} 		
			showTabelUser();
			bersih();
		}
	}
	
	private void btnSimpanTarifActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(rdbtnMotorTarif.isSelected()){
			ek.setJenis(this.rdbtnMotorTarif.getText());
			ek.setTjp(Double.parseDouble(this.tjp.getText()));
			ek.setTjb(Double.parseDouble(this.tjb.getText()));
			if(mp.ubahtarif(ek)==1){
				JOptionPane.showMessageDialog(null, "Tarif motor berhasil di update");
			} else{
				JOptionPane.showMessageDialog(null, "Tarif motor gagal di update");
			}
			buatTabelTarif();
			showTabelTarif();
			
			bersih();
		}
		if(rdbtnMobilTarif.isSelected()){
			ek.setJenis(this.rdbtnMobilTarif.getText());
			ek.setTjp(Double.parseDouble(this.tjp.getText()));
			ek.setTjb(Double.parseDouble(this.tjb.getText()));
			if(mp.ubahtarif(ek)==1){
				JOptionPane.showMessageDialog(null, "Tarif mobil berhasil di update");
			} else{
				JOptionPane.showMessageDialog(null, "Tarif mobil gagal di update");
			}
			buatTabelTarif();
			showTabelTarif();
			bersih();
		}
		
	}
	
	private void btnSimpanKpsActionPerfomed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(rdbtnMotorKps.isSelected()){
			ek.setJenis(this.rdbtnMotorKps.getText());
			ek.setKapasitas(Integer.parseInt(this.kapasitas.getText()));
			if(mp.ubahkapasitas(ek)==1){
				JOptionPane.showMessageDialog(null, "Kapasitas motor berhasil di update");
			} else{
				JOptionPane.showMessageDialog(null, "Kapasitas motor gagal di update");
			}
			buatTabelKapasitas();
			showTabelKapasitas();
			
			bersih();
		}
		if(rdbtnMobilKps.isSelected()){
			ek.setJenis(this.rdbtnMobilKps.getText());
			ek.setKapasitas(Integer.parseInt(this.kapasitas.getText()));
			if(mp.ubahkapasitas(ek)==1){
				JOptionPane.showMessageDialog(null, "Kapasitas mobil berhasil di update");
			} else{
				JOptionPane.showMessageDialog(null, "Kapasitas mobil gagal di update");
			}
			buatTabelKapasitas();
			showTabelKapasitas();
			bersih();
		}
	
	}
	
	private void btnCetakActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stu
	
		//Laporan Bulanan
		
		
		if(chckbxMotor.isSelected()&&chckbxMobil.isSelected() && laporanBulanan.isSelected()){
			
		mc.cetakLaporanBulanan(this.bulan.getMonth()+1, this.tahun.getYear());
		}
		else if(chckbxMotor.isSelected() && laporanBulanan.isSelected()){
			mc.cetakLaporanMotorBulanan(this.bulan.getMonth()+1, this.tahun.getYear());
			}
		else if(chckbxMobil.isSelected() && laporanBulanan.isSelected()){
			mc.cetakLaporanMobilBulanan(this.bulan.getMonth()+1, this.tahun.getYear());
			}
		
		//Laporan Harian
		else if(chckbxMotor.isSelected()&&chckbxMobil.isSelected() && laporanHarian.isSelected()){
			if(Tanggal.getDate() == null){
				JOptionPane.showMessageDialog(null, "Masukkan Tanggal");
			}
			else{
				
				mc.cetakLaporanHarian(this.Tanggal.getDate(), this.Tanggal.getDate(),this.Tanggal.getDate());
			}
		}
		else if(chckbxMotor.isSelected() && laporanHarian.isSelected()){
			if(Tanggal.getDate() == null){
				JOptionPane.showMessageDialog(null, "Masukkan Tanggal");
			}
			else{
			mc.cetakLaporanMotorHarian(this.Tanggal.getDate(), this.Tanggal.getDate(),this.Tanggal.getDate());
			}
			}
		
		
		else if(chckbxMobil.isSelected() && laporanHarian.isSelected()){
			if(Tanggal.getDate() == null){
				JOptionPane.showMessageDialog(null, "Masukkan Tanggal");
			}else{
			mc.cetakLaporanMobilHarian(this.Tanggal.getDate(), this.Tanggal.getDate(),this.Tanggal.getDate());
			}
			}
		
		//Laporan Periode
		
		else if(chckbxMotor.isSelected()&&chckbxMobil.isSelected() && laporanPeriode.isSelected()){
			if(periodeAwal.getDate() == null &&  periodeAkhir.getDate() == null){
				JOptionPane.showMessageDialog(null, "Masukkan Tanggal Periode");
			}
			else{
			mc.cetakLaporanPeriode(this.periodeAwal.getDate(), this.periodeAkhir.getDate());
			}
		}
		else if(chckbxMotor.isSelected() && laporanPeriode.isSelected()){
			if(periodeAwal.getDate() == null &&  periodeAkhir.getDate() == null){
				JOptionPane.showMessageDialog(null, "Masukkan Tanggal Periode");
			}
			else{
			mc.cetakLaporanMotorPeriode(this.periodeAwal.getDate(), this.periodeAkhir.getDate());
			}
		}
		else if(chckbxMobil.isSelected() && laporanPeriode.isSelected()){
			if(periodeAwal.getDate() == null &&  periodeAkhir.getDate() == null){
				JOptionPane.showMessageDialog(null, "Masukkan Tanggal Periode");
			}
			else{
			mc.cetakLaporanMobilPeriode(this.periodeAwal.getDate(), this.periodeAkhir.getDate());
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Masukkan Jenis Kendaraan Dan Jenis Laporan");
		}	
		
		
	}

	private void bgnLiatParkirActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		utama u = new utama();
		u.utama();
	}
	public static void pengaturan() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new pengaturan().setVisible(true);
			}
		});
	}
	private JTextField tjp;
	private JTextField tjb;
	private JTable tableTarif;
	private JTextField kapasitas;
	private JTextField username;
	private JPasswordField password;
	private JTextField hapusUser;
	private DefaultTableModel modelUser;
	private DefaultTableModel modelTarif;
	private DefaultTableModel modelKapasitas;
	private JTextField nama;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPetugas;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnMotorTarif;
	private JRadioButton rdbtnMobilTarif;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable tableUser;
	private JTable tableKapasitas;
	private JRadioButton rdbtnMotorKps;
	private JRadioButton rdbtnMobilKps;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JRadioButton rdbtnLaporanBulanan;
	private JYearChooser tahun;
	private JMonthChooser bulan;
	private JCheckBox chckbxMobil;
	private JCheckBox chckbxMotor;
	private JRadioButton laporanBulanan;
	private JDateChooser Tanggal;
	private JRadioButton laporanHarian;
	private JRadioButton laporanPeriode;
	private JDateChooser periodeAwal;
	private JDateChooser periodeAkhir;
	private JLabel lblPetugas;
}
