package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class MeterInfo extends JFrame implements ActionListener{

    JButton  submit;
    JLabel lblmeterno,tfcustomername,lbladdress;
    Choice meterno ,metertype, phasecode, billtype;
    String meternumber;
    
    MeterInfo(String meternumber) {
        this.meternumber = meternumber;
        setLayout(null);
        
        getContentPane().setBackground(new Color(164, 227, 232));
        JLabel heading = new JLabel("Meter Information ");
        heading.setBounds(280, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        //customer name
        JLabel customername = new JLabel("Meter Number");
        customername.setBounds(150, 150, 200, 25);
        customername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(customername);
        
        tfcustomername = new JLabel(meternumber);
        tfcustomername.setBounds(360, 150, 250, 25);
        tfcustomername.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tfcustomername);
        
        lblmeterno = new JLabel("Meter Location");
        lblmeterno.setBounds(150, 200, 200, 25);
        lblmeterno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblmeterno);
        
        meterno = new Choice();
        meterno.setBounds(360, 200, 250, 25);
        meterno.setFont(new Font("Arial", Font.PLAIN, 18));
        meterno.setBackground(Color.WHITE);
        meterno.add("Outside");
        meterno.add("Inside");
        add(meterno);
        
        lbladdress = new JLabel("Meter Type");
        lbladdress.setBounds(150, 250, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);
        
        metertype = new Choice();
        metertype.setBounds(360, 250, 250, 25);
        metertype.setFont(new Font("Arial", Font.PLAIN, 18));
        metertype.setBackground(Color.WHITE);
        metertype.add("Electri Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        add(metertype);
        
        
        lbladdress = new JLabel("Phase Code");
        lbladdress.setBounds(150, 300, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);
        
        phasecode = new Choice();
        phasecode.setBounds(360, 300, 250, 25);
        phasecode.setFont(new Font("Arial", Font.PLAIN, 18));
        phasecode.setBackground(Color.WHITE);
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        add(phasecode);
        
        lbladdress = new JLabel("Bill Type");
        lbladdress.setBounds(150, 350, 200, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);
        
        billtype = new Choice();
        billtype.setBounds(360, 350, 250, 25);
        billtype.setFont(new Font("Arial", Font.PLAIN, 18));
        billtype.setBackground(Color.WHITE);
        billtype.add("Industrial");
        billtype.add("Normal");
        add(billtype);
        
        JLabel lbldate = new JLabel("Days");
        lbldate.setBounds(150, 400, 200, 25);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbldate);
        
        JLabel labeldate = new JLabel("30 Days");
        labeldate.setBounds(360, 400, 200, 25);
        labeldate.setFont(new Font("Arial", Font.PLAIN, 20));
        add(labeldate);
        
        JLabel lblnote = new JLabel("Note: ");
        lblnote.setBounds(100, 450, 100, 25);
        lblnote.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblnote);
        
        JLabel labelnote = new JLabel("By default Bill is calculated for 30 days only");
        labelnote.setBounds(200, 450, 500, 25);
        labelnote.setFont(new Font("Arial", Font.PLAIN, 20));
        add(labelnote);
        
        
        submit = new JButton("Submit");
        submit.setBounds(200, 550, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setSize(800, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == submit) {
            String meter = meternumber;
            String location = meterno.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";
            
            String query = "insert into meter_info values('"+meter+"',  '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"');";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Meter information Added Successfully!!!");
                setVisible(false );
                
                
            }catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args) {
        new MeterInfo("");
    }
}
