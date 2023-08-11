package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class CalculateBill extends JFrame implements ActionListener{

    JButton cancel, submit, check;
    JTextField tfmeternumber, tfunits;
    JLabel lblname, lbladdress;
    Choice cmonth;
    Conn c;
    
    CalculateBill() {
        setLayout(null);
        
        getContentPane().setBackground(new Color(164, 227, 232));
        JLabel heading = new JLabel("Calculate Electricity Bill ");
        heading.setBounds(280, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        //customer name
        JLabel customername = new JLabel("Meter No");
        customername.setBounds(150, 150, 200, 25);
        customername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(customername);
        
        tfmeternumber = new JTextField();
        tfmeternumber.setBounds(360, 150, 250, 25);
        tfmeternumber.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfmeternumber);
        
        check = new JButton("Check");
        check.setBounds(620, 150, 100, 25);
        check.setBackground(Color.GREEN);
        check.setForeground(Color.BLACK);
        check.addActionListener(this);
        add(check);
        
        JLabel meterno = new JLabel("Name ");
        meterno.setBounds(150, 200, 200, 25);
        meterno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(meterno);
        
        lblname = new JLabel();
        lblname.setBounds(360, 200, 250, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblname);
        
        //Address
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(150, 250, 200, 25);
        labeladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labeladdress);
        
        lbladdress = new JLabel();
        lbladdress.setBounds(360, 250, 250, 25);
        lbladdress.setFont(new Font("Arial", Font.PLAIN, 20));
        add(lbladdress);
        
        //City
        JLabel lblcity = new JLabel("Units Consumed");
        lblcity.setBounds(150, 300, 200, 25);
        lblcity.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblcity);
        
        tfunits = new JTextField();
        tfunits.setBounds(360, 300, 250, 25);
        tfunits.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfunits);
        
        //State
        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(150, 350, 200, 25);
        lblstate.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblstate);
        
        cmonth = new Choice();
        cmonth.setBounds(360, 350, 250, 25);
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
        
        submit = new JButton("Submit");
        submit.setBounds(200, 550, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
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
        
        if(ae.getSource() == submit) {
            String name = lblname.getText();
            String meter = tfmeternumber.getText();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();
            
            int totalbill = 0;
            int unit_comsumed = Integer.parseInt(units);
            
            String query = "select * from tax";
            try {
                c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query);
                
                if(rs1.next()){
                    totalbill += unit_comsumed * Integer.parseInt(rs1.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs1.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs1.getString("service_charge"));
                    totalbill += Integer.parseInt(rs1.getString("service_tax"));
                    totalbill += Integer.parseInt(rs1.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs1.getString("fixed_tax")); 
                }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
            
            String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid ' );";
            
            try{
                c = new Conn();
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully!!");
                setVisible(false);
            }catch(Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == check){
            String meter = tfmeternumber.getText();
            
            String query = "select * from customer where meter_no = '"+meter+"'";
            
            try{
                c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    tfmeternumber.setText((rs.getString("meter_no")));
                    lblname.setText(rs.getString("name"));
                    lbladdress.setText(rs.getString("address"));
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Meter number not found");
                }
            }catch(Exception e) {
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new CalculateBill();
    }
}
