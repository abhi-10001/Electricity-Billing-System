package electricity.billing.system;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {

    String atype, meter;
    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1900, 1000);
        add(image);

        JMenuBar mb = new JMenuBar();
        mb.setBackground(new Color(0, 208, 255));
        setJMenuBar(mb);

        //Master
        JMenu master = new JMenu("   Master   |");
        master.setFont(new Font("Monospaced", Font.BOLD, 20));

        JMenuItem newcustomer = new JMenuItem("New Customer    ");
        newcustomer.setFont(new Font("Monospaced", Font.PLAIN, 20));
        newcustomer.setBackground(Color.white);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('d');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        newcustomer.addActionListener(this);
        master.add(newcustomer);

        JMenuItem customerdetails = new JMenuItem("Customer Details    ");
        customerdetails.setFont(new Font("Monospaced", Font.PLAIN, 20));
        customerdetails.setBackground(Color.white);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('m');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        customerdetails.addActionListener(this);
        master.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposite Details    ");
        depositdetails.setFont(new Font("Monospaced", Font.PLAIN, 20));
        depositdetails.setBackground(Color.white);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.setMnemonic('n');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        depositdetails.addActionListener(this);
        master.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill    ");
        calculatebill.setFont(new Font("Monospaced", Font.PLAIN, 20));
        calculatebill.setBackground(Color.white);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('b');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        calculatebill.addActionListener(this);
        master.add(calculatebill);

        //Information
        JMenu info = new JMenu("   Information   |");
        info.setFont(new Font("Monospaced", Font.BOLD, 20));

        JMenuItem updateinformation = new JMenuItem("Update Information    ");
        updateinformation.setFont(new Font("Monospaced", Font.PLAIN, 20));
        updateinformation.setBackground(Color.white);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5));
        updateinformation.setMnemonic('p');
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        updateinformation.addActionListener(this);
        info.add(updateinformation);

        JMenuItem viewinformation = new JMenuItem("View Information    ");
        viewinformation.setFont(new Font("Monospaced", Font.PLAIN, 20));
        viewinformation.setBackground(Color.white);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(image6));
        viewinformation.setMnemonic('o');
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        viewinformation.addActionListener(this);
        info.add(viewinformation);

        //User
        JMenu user = new JMenu("|   User   |");
        user.setFont(new Font("Monospaced", Font.BOLD, 20));

        JMenuItem paybill = new JMenuItem("Pay Bill    ");
        paybill.setFont(new Font("Monospaced", Font.PLAIN, 20));
        paybill.setBackground(Color.white);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('r');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details    ");
        billdetails.setFont(new Font("Monospaced", Font.PLAIN, 20));
        billdetails.setBackground(Color.white);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('b');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        billdetails.addActionListener(this);
        user.add(billdetails);

        //Report
        JMenu report = new JMenu("|   Report   |");
        report.setFont(new Font("Monospaced", Font.BOLD, 20));

        JMenuItem generatebill = new JMenuItem("Generate Bill    ");
        generatebill.setFont(new Font("Monospaced", Font.PLAIN, 20));
        generatebill.setBackground(Color.white);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('g');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        generatebill.addActionListener(this);
        report.add(generatebill);

        //Utility
        JMenu utility = new JMenu("|   Utility   |");
        utility.setFont(new Font("Monospaced", Font.BOLD, 20));

        JMenuItem notepad = new JMenuItem("Notepad    ");
        notepad.setFont(new Font("Monospaced", Font.PLAIN, 20));
        notepad.setBackground(Color.white);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('k');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator    ");
        calculator.setFont(new Font("Monospaced", Font.PLAIN, 20));
        calculator.setBackground(Color.white);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('a');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        calculator.addActionListener(this);
        utility.add(calculator);

        //Exit
        JMenu mexit = new JMenu("|   Exit    ");
        mexit.setFont(new Font("Monospaced", Font.BOLD, 20));

        JMenuItem exit = new JMenuItem("Exit    ");
        exit.setFont(new Font("Monospaced", Font.PLAIN, 20));
        exit.setBackground(Color.white);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('x');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        mexit.add(exit);

        if(atype.equals("Admin")){
        mb.add(master);
        }else {
        mb.add(info);
        mb.add(user);
        mb.add(report);
        }
        
        mb.add(utility);
        mb.add(mexit);

        setSize(1900, 1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("New Customer    ")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details    ")) {
            new CustomerDetails();
        } else if (msg.equals("Deposite Details    ")) {
            new DepositDetails();
        } else if (msg.equals("Calculate Bill    ")) {
            new CalculateBill();
        } else if (msg.equals("Update Information    ")) {
            new UpdateInformation(meter);
        } else if (msg.equals("View Information    ")) {
            new ViewInformation(meter);
        } else if (msg.equals("Pay Bill    ")) {

        } else if (msg.equals("Bill Details    ")) {

        } else if (msg.equals("Generate Bill    ")) {

        } else if (msg.equals("Notepad    ")) {

        } else if (msg.equals("Calculator    ")) {

        } else if (msg.equals("Exit    ")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Project("", "");
    }

}
