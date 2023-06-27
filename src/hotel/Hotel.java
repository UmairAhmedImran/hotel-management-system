package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hotel extends JFrame implements ActionListener{
    Hotel() {

        setBounds(75,75,1450,650);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hotelmain.jpg"));
        
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1450,650);
        add(image);
        
        JLabel text = new JLabel("HOTEL BOOKING SYSTEM");
        text.setBounds(20, 10, 1000, 90);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1250, 550, 150, 50);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        next.setFocusable(false);
        next.addActionListener(this);
        image.add(next);
        
        
        
        setVisible(true);
        
        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
   }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Dashboard();
    }

    public static void main(String[] args) {
        new Hotel();
    }
    
}
