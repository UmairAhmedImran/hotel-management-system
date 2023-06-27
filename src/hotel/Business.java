
package hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Business extends JFrame implements ActionListener{
    JButton booking,bookout,logout;
    Business(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 800, 450);
 
        booking = new JButton("Book in");
        booking.addActionListener(this);
        booking.setBounds(10, 70, 220, 50);
        booking.setFocusable(false);
        booking.setBackground(Color.BLACK);
        booking.setForeground(Color.WHITE);
        add(booking);
        
        bookout = new JButton("Book out");
        bookout.setBounds(10, 170, 220, 50);
        bookout.setFocusable(false);
        bookout.setBackground(Color.BLACK);
        bookout.setForeground(Color.WHITE);
        bookout.addActionListener(this);
        add(bookout);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 270, 220, 50);
        logout.setFocusable(false);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/buss2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 0, 550, 470);
        add(image);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == booking) {
            setVisible(false);
            new Bookcustomer3();
        } else if(ae.getSource() == bookout) {
            setVisible(false);
            new Checkout3();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new login();
        }
    }
    public static void main(String[] args) {
        new Business();
    }
    
}
