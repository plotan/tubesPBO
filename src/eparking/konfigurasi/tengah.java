package eparking.konfigurasi;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class tengah {
     public tengah(java.awt.Frame form) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - form.getSize().width)/2;
        int y = (dim.height - form.getSize().height)/2;
        form.setLocation(x,y);
    }
}

//SELECT sum(case when jenis = 'Motor' then 1 else 0 end) males FROM parkir WHERE jam_keluar is null 