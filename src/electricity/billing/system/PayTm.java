package electricity.billing.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.DefaultEditorKit;




public class PayTm extends JFrame implements ActionListener{

    String meter;
    JButton back;
    
    PayTm(String meter){
        this.meter = meter;
        
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        
        try{
            j.setPage("https://paytm.com/online-payments");
        }catch(Exception e){
            j.setContentType("text/html");
            j.setText("<html> Could not load</html>");
        }
        
        JScrollPane pane = new JScrollPane(j);
        add(pane);
        
        back = new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        j.add(back);
        
        setSize(800, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new PayBill(meter);
    }

    public static void main(String[] args) {
        new PayTm("");
    }
    
}
