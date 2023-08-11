package electricity.billing.system;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateInformation extends JFrame implements ActionListener{
    
    JButton cancel, update;
    JTextField tfmeternumber,tfaddress, tfcity, tfstate, tfemail, tfphone, tfname;
    String meter;
    
    UpdateInformation(String meter) {
        this.meter = meter;
        setLayout(null);
        getContentPane().setBackground(new Color(164, 227, 232));
        
        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(100, 30, 550, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 150, 100, 30);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(250, 150, 250, 30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfname.setEditable(false);
        add(tfname);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70, 200, 150, 30);
        lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblmeternumber);
        
        tfmeternumber = new JTextField();
        tfmeternumber.setBounds(250, 200, 250, 30);
        tfmeternumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfmeternumber.setEditable(false);
        add(tfmeternumber);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70, 250, 150, 30);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(250, 250, 250, 30);
        tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfaddress);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70, 300, 150, 30);
        lblcity.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(250, 300, 250, 30);
        tfcity.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfcity);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(70, 350, 150, 30);
        lblstate.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(250, 350, 250, 30);
        tfstate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfstate);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(70, 400, 150, 30);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250, 400, 250, 30);
        tfemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfemail);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(70, 450, 150, 30);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(250, 450, 250, 30);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfphone);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfmeternumber.setText(rs.getString("meter_no"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFocusable(false);//to get rid of outline around text from default focus on only button 
        add(cancel);
        
        update = new JButton("Update");
        update.setBounds(250, 550, 100, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFocusable(false);//to get rid of outline around text from default focus on only button 
        add(update);
        
        setSize(650, 650);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update){
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address = '"+address+"', city = '"+city+"', state = '"+state+"', email = '"+email+"', phone = '"+phone+"' where meter_no = '"+meter+"'");
                
                JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
                setVisible(false);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateInformation("");
    }
}