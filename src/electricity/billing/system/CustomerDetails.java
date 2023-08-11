package electricity.billing.system;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener{

    JTable table;
    JButton print;
    
    CustomerDetails() {
        super("Customer Details");
      
        
       
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bill");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        print = new JButton("Print");
        print.setBackground(Color.black);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print, "South");
      
        setSize(1200, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
            try{
                table.print();
            }catch(Exception e) {
                e.printStackTrace();
            }
        
    }

    public static void main(String[] args) {
        new CustomerDetails();
    }
    
}
