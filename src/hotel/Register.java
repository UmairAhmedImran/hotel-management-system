package hotel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Register extends JFrame implements ActionListener{
    JTextField username, password, address, phone_number, email, credit_card;
    JButton register;
    JRadioButton user_radio, business_radio;
    Register(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        setBounds(500, 200, 600, 300);
        
        user_radio = new JRadioButton("User");
        user_radio.setBounds(80, 10, 50,30);
        user_radio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        user_radio.setBackground(Color.WHITE);
        user_radio.setFocusable(false);
        add(user_radio);
        
        business_radio = new JRadioButton("Business");
        business_radio.setBounds(180, 10, 70,30);
        business_radio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        business_radio.setBackground(Color.WHITE);
        business_radio.setFocusable(false);
        add(business_radio);

        ButtonGroup bg = new ButtonGroup();
        bg.add(user_radio);
        bg.add(business_radio);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 40, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 40, 150, 30);
        add(username);
        
        JLabel user_address = new JLabel("Address");
        user_address.setBounds(320, 40, 100, 30);
        add(user_address);
        
        address = new JTextField();
        address.setBounds(400, 40, 150, 30);
        add(address);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 100, 100, 30);
        add(pass);
        
        password = new JTextField();
        password.setBounds(150, 100, 150, 30);
        add(password);
        
        JLabel number = new JLabel("Phone");
        number.setBounds(320, 100, 100, 30);
        add(number);
        
        phone_number = new JTextField();
        phone_number.setBounds(400, 100, 150, 30);
        add(phone_number);
        
        JLabel mail = new JLabel("Email");
        mail.setBounds(320, 160, 100, 30);
        add(mail);
        
        email = new JTextField();
        email.setBounds(400, 160, 150, 30);
        add(email);
        
        JLabel credit = new JLabel("Credit card");
        credit.setBounds(40, 160, 100, 30);
        add(credit);
        
        credit_card = new JTextField();
        credit_card.setBounds(150, 160, 150, 30);
        add(credit_card);

        register = new JButton("Register");
        register.setBounds(230, 220, 120, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.setFocusable(false);
        register.addActionListener(this);
        
        add(register);
        setVisible(true);
    }
  
    public void actionPerformed(ActionEvent ac) {
        String user = username.getText();
        String pass = password.getText();
        String user_address= address.getText();
        String user_number = phone_number.getText();
        String user_credit = credit_card.getText();
        String user_email = email.getText();
        String type = null;
        
        if (user.equals("")) {
            JOptionPane.showMessageDialog(null, "username should not be empty");
            return;
        }
        if (pass.equals("")) {
            JOptionPane.showMessageDialog(null, "password should not be empty");
            return;
        }
        if (user_address.equals("")) {
            JOptionPane.showMessageDialog(null, "address should not be empty");
            return;
        }
        if (user_number.equals("")) {
            JOptionPane.showMessageDialog(null, "number should not be empty");
            return;
        }
        if (user_credit.equals("")) {
            JOptionPane.showMessageDialog(null, "credit card should not be empty");
            return;
        }
        if (user_email.equals("")) {
            JOptionPane.showMessageDialog(null, "email should not be empty");
            return;
        }
        
            if (user_radio.isSelected()) {
                type = "User";
            } else if (business_radio.isSelected()){
                type = "Business";
            }
        try {
            Conn c = new Conn();
            String sql = "INSERT INTO register values('" + user + "', '" + user_address + "', '"+ pass + "', '" + user_number + "', '"+ user_credit + "', '"+ user_email + "', '" + type + "');";
            String sql2 = "INSERT INTO login VALUES ('" + user + "', '"+ pass + "', '" + type + "');";
            
            c.s.executeUpdate(sql);
            c.s.executeUpdate(sql2);
            
            JOptionPane.showMessageDialog(null, "Registered successfully");
            setVisible(false);
            new login();
        } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
  public static void main(String[] args){
        new Register();
    }
}

