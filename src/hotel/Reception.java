
package hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton checkin,checkout,logout;
    Reception() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 800, 450);
        
        checkin = new JButton("Check in Guest");
        checkin.addActionListener(this);
        checkin.setBounds(10, 70, 220, 50);
        checkin.setFocusable(false);
        checkin.setBackground(Color.BLACK);
        checkin.setForeground(Color.WHITE);
        add(checkin);
        
        checkout = new JButton("Check out Guest");
        checkout.setBounds(10, 170, 220, 50);
        checkout.setFocusable(false);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 270, 220, 50);
        logout.setFocusable(false);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/reception.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 0, 550, 470);
        add(image);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkin) {
            setVisible(false);
            new Bookcustomer();
        } else if(ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new login();
        }
    }
    
    public static void main(String[] args) {
        new Reception();
    }
}
