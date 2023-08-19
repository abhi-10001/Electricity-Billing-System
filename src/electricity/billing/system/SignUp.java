package electricity.billing.system;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener{

    
    JButton create, back, showpassimg, hidepassimg;
    JPasswordField password;
    Choice accountType;
    JTextField name, username, meter;
    
    SignUp() {
        super("SignUp Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel panel = new JPanel();
        panel.setBounds(25, 24, 653, 352);
        panel.setBorder(new TitledBorder(new LineBorder(Color.black, 2 ), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.black));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Account Type");
        heading.setBounds(100, 50, 200, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont((new Font("Tahoma", Font.BOLD, 20)));
        panel.add(heading);
        
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(310, 50, 150, 25);
        panel.add(accountType);
        
        
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 200, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont((new Font("Tahoma", Font.BOLD, 20)));
        lblmeter.setVisible(false);
        panel.add(lblmeter);
                
        meter = new JTextField();
        meter.setBounds(310, 90, 200, 25);
        meter.setVisible(false);
        panel.add(meter);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 200, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont((new Font("Tahoma", Font.BOLD, 20)));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(310, 130, 200, 25);
        panel.add(username);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 200, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont((new Font("Tahoma", Font.BOLD, 20)));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(310, 170, 200, 25);
        panel.add(name);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 200, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont((new Font("Tahoma", Font.BOLD, 20)));
        panel.add(lblpassword);
        
        password = new JPasswordField();
        password.setBounds(310, 210, 200, 25);
        panel.add(password);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/showpass.png"));
        Image i2 = i1.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        showpassimg = new JButton(i3);
        showpassimg.setBackground(Color.WHITE);
        showpassimg.setBounds(520, 212, 22, 22);
        showpassimg.setBorderPainted(false); 
        showpassimg.addActionListener(this);
        panel.add(showpassimg);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/hidepass.png"));
        Image i5 = i4.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        hidepassimg = new JButton(i6);
        hidepassimg.setBackground(Color.white);
        hidepassimg.setBounds(520, 212, 22, 22);
        hidepassimg.setBorderPainted(false);
        hidepassimg.addActionListener(this);
        panel.add(hidepassimg);
        
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if(user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                    name.setText("");
                }else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                    name.setText("");

                }
            }
        });
        
        create = new JButton("Create");
        create.setBounds(140, 270, 120, 30);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Raleway", Font.BOLD, 18));
        create.addActionListener(this);
        panel.add(create);
        
        back = new JButton("Back");
        back.setBounds(300, 270, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 18));
        back.addActionListener(this);
        panel.add(back); 

        
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            @Override
            public void focusLost(FocusEvent fe) {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        setSize(700, 400);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
            
            try {
                Conn c = new Conn();
                String query = null;
                if(atype.equals("Admin")){
                    query = "insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"');";
                }else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == showpassimg){
            showpassimg.setVisible(false);
            hidepassimg.setVisible(true);
            password.setEchoChar((char)0);
        }
        else if(ae.getSource() == hidepassimg){
            hidepassimg.setVisible(false);
            showpassimg.setVisible(true);
            password.setEchoChar('*');
            
        }else {
            setVisible(false);
            
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new SignUp();
    }
    
}