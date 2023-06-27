package hotel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, register;
    JRadioButton user_radio, business_radio, reception_radio;
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500, 200, 600, 300);

        JLabel type = new JLabel("Type");
        type.setBounds(40,20,120,30);
        add(type);

        user_radio = new JRadioButton("User");
        user_radio.setBounds(140, 20, 50,30);
        user_radio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        user_radio.setBackground(Color.WHITE);
        user_radio.setFocusable(false);
        add(user_radio);
        
        business_radio = new JRadioButton("Business");
        business_radio.setBounds(190, 20, 70,30);
        business_radio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        business_radio.setBackground(Color.WHITE);
        business_radio.setFocusable(false);
        add(business_radio);
        
        reception_radio = new JRadioButton("Reception");
        reception_radio.setBounds(270, 20, 75,30);
        reception_radio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        reception_radio.setBackground(Color.WHITE);
        reception_radio.setFocusable(false);
        add(reception_radio);
        ButtonGroup bg = new ButtonGroup();
        bg.add(user_radio);
        bg.add(business_radio);
        bg.add(reception_radio);
        JLabel user = new JLabel("Username");
        user.setBounds(40, 60, 100, 30);
        add(user);
        username = new JTextField();
        username.setBounds(150, 60, 150, 30);
        add(username);
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 120, 100, 30);
        add(pass);
        password = new JPasswordField();
        password.setBounds(150, 120, 150, 30);
        add(password);
        login = new JButton("Login");
        login.setBounds(40, 180, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFocusable(false);
        login.addActionListener(this);
        add(login);
        register = new JButton("Register");
        register.setBounds(180, 180, 120, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.setFocusable(false);
        register.addActionListener(this);
        add(register);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(350, 10,220,230);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            String type = null;
            if (user_radio.isSelected()) {
                type = "User";
            } else if (business_radio.isSelected()){
                type = "Business";
            } else {
                type = "Reception";
            }
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "' and type = '" + type + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
//                    new Dashboard();
                      
                      if (type == "User") {
                          new User();
                      } else if (type == "Business") {
                          new Business();
                      } else if (type == "Reception"){
                          new Reception();
                      }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ac.getSource() == register) {
            setVisible(false);
            new Register();
        }
    }
    
    public static void main(String[] args){
        new login();
    }
}
