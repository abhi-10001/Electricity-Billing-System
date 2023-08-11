package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{

    JButton login, signup, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    Choice logginin;
    
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 300, 300);
        add(image);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 30, 150, 30);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(460, 30, 200, 30);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300, 80, 150, 30);
        lblpassword.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(460, 80, 200, 30);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfpassword);
        
        JLabel lblloginas = new JLabel("Login as ");
        lblloginas.setBounds(300, 130, 150, 30);
        lblloginas.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblloginas);
        
        logginin = new Choice();
        logginin.setBounds(460, 130, 200, 30);
        logginin.add("Admin");
        logginin.add("Customer");
        add(logginin);
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image img2 = img1.getImage().getScaledInstance(16 , 16 , Image.SCALE_SMOOTH);
        login = new JButton("Login", new ImageIcon(img2));
        login.setBounds(350, 190, 100, 30);
        login.addActionListener(this);
        add(login);
        
        ImageIcon cancelimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image cancelimg2 = cancelimg1.getImage().getScaledInstance(16 , 16 , Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(cancelimg2));
        cancel.setBounds(520, 190, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon signupimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image signupimg2 = signupimg1.getImage().getScaledInstance(16 , 16 , Image.SCALE_DEFAULT);
        signup = new JButton("SignUp", new ImageIcon(signupimg2));
        signup.setBounds(430, 240, 100, 30);
        signup.addActionListener(this);
        add(signup);
        
        
        setSize(700, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String susername = tfusername.getText();
            String spassword = tfpassword.getText();
            String user = logginin.getSelectedItem();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password =  '"+spassword+"' and user = '"+user+"' ";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    tfpassword.setText("");
                    tfusername.setText("");
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel) {
            System.exit(0);
        }else {
            setVisible(false);
            new SignUp();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}