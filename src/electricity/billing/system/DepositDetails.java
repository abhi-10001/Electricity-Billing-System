package electricity.billing.system;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{

    Choice cmonth, meternumber;
    JTable table;
    JButton search, print, cancel;
    
    DepositDetails() {
        super("Deposit Details");
        setLayout(null);
        
        JLabel lblmeternumber = new JLabel("Search by meter number");
        lblmeternumber.setBounds(20, 40, 230, 30);
        lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblmeternumber);
        
        meternumber = new Choice();
        meternumber.setBounds(250, 40, 150, 30);
        meternumber.setFont(new Font("Arial", Font.PLAIN, 18));
        meternumber.setBackground(Color.white);
        add(meternumber);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                meternumber.add(rs.getString("meter_no"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblmonth = new JLabel("Search by month");
        lblmonth.setBounds(440, 40, 180, 30);
        lblmonth.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblmonth);
        
        cmonth = new Choice();
        cmonth.setBounds(620, 40, 150, 30);
        cmonth.setFont(new Font("Arial", Font.PLAIN, 18));
        cmonth.setBackground(Color.WHITE);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bill");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 150, 800, 800);
        add(sp);
        
        print = new JButton("Print");
        print.setBounds(50, 100, 100, 30);
        print.setBackground(Color.black);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);
        
        search = new JButton("Search");
        search.setBounds(200, 100, 100, 30);
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(350, 100, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(800, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == search){
            String query = "select * from bill where meter_no = '"+meternumber.getSelectedItem()+"' and month = '"+cmonth.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DepositDetails();
    }
    
}
