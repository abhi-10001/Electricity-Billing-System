package electricity.billing.system;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class BillDetails extends JFrame implements ActionListener{

    String meter;
    BillDetails(String meter){
        this.meter = meter;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JTable table = new JTable();
        
        try{
            Conn c = new Conn();
            String query = "select * from bill where meter_no = '"+meter+"' ";
            ResultSet rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 1000, 800);
        add(sp);
        
        setSize(1000, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public static void main(String[] args) {
        new BillDetails("");
    }
    
}