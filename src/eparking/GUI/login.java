package eparking.GUI;

import eparking.entity.entityUser;
import eparking.method.metUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import eparking.konfigurasi.tengah;
import eparking.method.metUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class login extends JFrame{
	
	List<entityUser> listLogin=new ArrayList<entityUser>();
	metUser mu=new metUser();
	entityUser eu=new entityUser();
	JTextField usernameField;
	JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public String username;
	private JLabel warning;
	
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the application.
	 * @param b   
	 * @param jFrame 
	 */
	public login() {
		setBackground(new Color(102, 204, 204));
		initialize();
		tengah tengah = new tengah(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("eParking");
		getContentPane().setBackground(new Color(102, 204, 204));
		setBounds(100, 100, 589, 405);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.BLACK);
		
		JLabel lblLoginEparking = new JLabel("Login eParking");
		lblLoginEparking.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLoginEparking.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginEparking.setBackground(Color.WHITE);
		
		JLabel lblCopyright = new JLabel("Copyright ©2017");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCopyright, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblLoginEparking, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)))
					.addGap(1))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblLoginEparking)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCopyright)
					.addContainerGap())
		);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		
		JLabel lblSelamatDatangDi = new JLabel("Selamat Datang di eParking");
		lblSelamatDatangDi.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/eparking/img/itera.png")));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}

			
		});
		
		warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setFont(new Font("Dialog", Font.BOLD, 10));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(55)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(warning, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLogin))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblSelamatDatangDi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(8))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblPassword)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(passwordField, 133, 133, 133))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
					.addGap(56))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addComponent(lblSelamatDatangDi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(36)
									.addComponent(label))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(warning, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLogin))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}


	

/*
	private void btnLoginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		utama u=new utama();
		pengaturan p = new pengaturan();
		if(usernameField.getText().equals("") || passwordField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Inputkan username dan password","Pesan",JOptionPane.INFORMATION_MESSAGE);
        } else {
           try{
           listLogin = mu.cariLogin(usernameField.getText(), passwordField.getText());
           
           if(listLogin.size()>=1) {
               if(listLogin.get(0).getHakakses().equalsIgnoreCase("Petugas")){
            	   
                    //mnu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            	   username = listLogin.get(0).getNama();
            	   u.utama();
            	   u.lblPtgs.setText("Petugas: "+username);
            	   u.tampilUser(username);
                   
                   dispose();
               } else {
            	   username = listLogin.get(0).getNama();
                    p.pengaturan();
                    p.admin = username;
                    p.tampilUser(username);
                   
                    //mnu.tampilUser(txtUsername.getText());
                    //mnu.hakAksesKasir();
                    dispose();
               }

           } else {
               JOptionPane.showMessageDialog(null, "Username atau Password tidak ditemukan \nHarap ulangi","Ami Market",
               JOptionPane.WARNING_MESSAGE);
               usernameField.requestFocus();
           }
            } catch(Exception a){
                JOptionPane.showMessageDialog(null, "Terjadi kesalahaan\n"+a);
            }
        }

	}
*/
	private void btnLoginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		utama u=new utama();
		pengaturan p = new pengaturan();
		if(usernameField.getText().equals("") || passwordField.getText().equals("")){
            warning.setText("Inputkan username dan password");
        } else {
           try{
           listLogin = mu.cariLogin(usernameField.getText(), passwordField.getText());
           
           if(listLogin.size()>=1) {
        	   username = listLogin.get(0).getNama();
               if(listLogin.get(0).getHakakses().equalsIgnoreCase("Petugas")){
            	   
                    //mnu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            	   
            	   u.utama();
            	   dispose();
            	   JOptionPane.showMessageDialog(null, "Selamat datang "+username);
               } else {
            	   
            	    p.pengaturan();
                    
                    //mnu.tampilUser(txtUsername.getText());
                    //mnu.hakAksesKasir();
                    dispose();
                    JOptionPane.showMessageDialog(null, "Selamat datang "+username);
               }

           } else {
               warning.setText("Username atau Password salah");
               usernameField.requestFocus();
           }
            } catch(Exception a){
                JOptionPane.showMessageDialog(null, "Terjadi kesalahaan\n"+a);
            }
        }
		
	}
	




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new login().setVisible(true);
            }
		});
	}
}
