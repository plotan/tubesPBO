package eparking;

import javax.swing.UIManager;
import eparking.GUI.login;

public class Main {
	public static void main(String[] args) {
        // TODO code application logic here
                try {
            // Select the Look and Feel
            //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");

            login a=new login();
            a.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
      
    }

}
