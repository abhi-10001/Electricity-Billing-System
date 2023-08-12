package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class PayBill extends JFrame implements ActionListener {

    Choice cmonth;
    JButton pay, cancel;
    String meter;
    JLabel labelstatus;

    PayBill(String meter) {
        this.meter = meter;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setBounds(200, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 100, 240, 30);
        lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(280, 100, 150, 30);
        meternumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(meternumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 150, 240, 30);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(280, 150, 150, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(name);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(100, 200, 150, 30);
        lblmonth.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(280, 200, 150, 30);
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

        JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(100, 250, 240, 30);
        lblunits.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblunits);

        JLabel labelunits = new JLabel("");
        labelunits.setBounds(280, 250, 150, 30);
        labelunits.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelunits);

        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(100, 300, 240, 30);
        lbltotalbill.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbltotalbill);

        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setBounds(280, 300, 150, 30);
        labeltotalbill.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labeltotalbill);

        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(100, 350, 240, 30);
        lblstatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblstatus);

        labelstatus = new JLabel("");
        labelstatus.setBounds(280, 350, 150, 30);
        labelstatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelstatus);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter + "'");
            while (rs.next()) {
                meternumber.setText(meter);
                name.setText(rs.getString("name"));
            }

            rs = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' and month = 'January'");
            if (rs.next()) {
                labelunits.setText(rs.getString("units"));
                labeltotalbill.setText(rs.getString("totalbill"));
                labelstatus.setText(rs.getString("status"));

                if (labelstatus.getText().equals("Paid")) {
                    labelstatus.setForeground(Color.green);
                } else {
                    labelstatus.setForeground(Color.red);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cmonth.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("select * from bill where meter_no = '" + meter + "' and month = '" + cmonth.getSelectedItem() + "'");
                    if (rs1.next()) {
                        labelunits.setText(rs1.getString("units"));
                        labeltotalbill.setText(rs1.getString("totalbill"));
                        labelstatus.setText(rs1.getString("status"));

                        if (labelstatus.getText().equals("Paid")) {
                            labelstatus.setForeground(Color.green);
                        } else {
                            labelstatus.setForeground(Color.red);
                        }
                    } else {
                        labelunits.setText("");
                        labeltotalbill.setText("");
                        labelstatus.setText("");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBounds(130, 450, 100, 30);
        pay.setBackground(Color.black);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 450, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(600, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '" + meter + "' and month = '" + cmonth.getSelectedItem() + "'");

            } catch (Exception e) {
                e.printStackTrace();
            }

            setVisible(false);
            new PayTm(meter);
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PayBill("");

    }

}
