package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener{

    JButton cancel, next;
    JTextField tfcustomername, tfaddress, tfcity, tfstate, tfemail, tfphone;
    JLabel lblmeterno;
    
    NewCustomer() {
        setLayout(null);
        
        getContentPane().setBackground(new Color(164, 227, 232));
        JLabel heading = new JLabel("New Customer ");
        heading.setBounds(280, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        //customer name
        JLabel customername = new JLabel("Customer Name");
        customername.setBounds(150, 150, 200, 25);
        customername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(customername);
        
        tfcustomername = new JTextField();
        tfcustomername.setBounds(360, 150, 250, 25);
        tfcustomername.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfcustomername);
        
        JLabel meterno = new JLabel("Meter No");
        meterno.setBounds(150, 200, 200, 25);
        meterno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(meterno);
        
        lblmeterno = new JLabel("");
        lblmeterno.setBounds(360, 200, 250, 25);
        lblmeterno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblmeterno);
        
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeterno.setText("" + Math.abs(number));
        
        //Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(150, 250, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(360, 250, 250, 25);
        tfaddress.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfaddress);
        
        //City
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(150, 300, 200, 25);
        lblcity.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(360, 300, 250, 25);
        tfcity.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfcity);
        
        //State
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(150, 350, 200, 25);
        lblstate.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(360, 350, 250, 25);
        tfstate.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfstate);
        
        //Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(150, 400, 200, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(360, 400, 250, 25);
        tfemail.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfemail);
        
        //Phone Number
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(150, 450, 200, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(360, 450, 250, 25);
        tfphone.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfphone);
        
        next = new JButton("Next");
        next.setBounds(200, 550, 100, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 550, 100, 30);
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
        
        if(ae.getSource() == next) {
            String name = tfcustomername.getText();
            String meter = lblmeterno.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"');";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"','', '' );";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully!!!");
                setVisible(false );
                
                new MeterInfo(meter);
            }catch (Exception e) {
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new NewCustomer();
    }
}
