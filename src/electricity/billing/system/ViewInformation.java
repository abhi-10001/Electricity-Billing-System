package electricity.billing.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class ViewInformation extends JFrame implements ActionListener{
    
    JButton cancel;
    String meter;
    ViewInformation(String meter) {
        this.meter = meter;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(200, 30, 500, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 50, 100, 200);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setBounds(250, 50, 200, 200);
        name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(name);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70, 100, 150, 200);
        lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblmeternumber);
        
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(250, 100, 200, 200);
        meternumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(meternumber);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70, 150, 150, 200);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lbladdress);
        
        JLabel address = new JLabel("");
        address.setBounds(250, 150, 200, 200);
        address.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(address);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70, 200, 150, 200);
        lblcity.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblcity);
        
        JLabel city = new JLabel("");
        city.setBounds(250, 200, 200, 200);
        city.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(city);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(450, 150, 150, 200);
        lblstate.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblstate);
        
        JLabel state = new JLabel("");
        state.setBounds(450, 150, 200, 200);
        state.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(state);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(450, 50, 150, 200);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblemail);
        
        JLabel email = new JLabel("");
        email.setBounds(450, 50, 200, 200);
        email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(email);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(450, 100, 150, 200);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblphone);
        
        JLabel phone = new JLabel("");
        phone.setBounds(450, 100, 200, 200);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phone);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                meternumber.setText(rs.getString("meter_no"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBounds(550, 350, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFocusable(false);//to get rid of outline around text from default focus on only button 
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 350, 600, 300);
        add(image);
        
        setSize(850, 650);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewInformation("");
    }
}
