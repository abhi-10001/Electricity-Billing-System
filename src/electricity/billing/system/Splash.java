package electricity.billing.system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t ;  
    
    Splash() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JLabel heading = new JLabel("Electricity Billing System");
        heading.setBounds(190, 20, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
        t = new Thread(this);
        t.start();
        
        setUndecorated(true);
        setSize(730, 550);
        setLocation(600, 150);
        setVisible(true);
    }
    
    public void run() {
        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
