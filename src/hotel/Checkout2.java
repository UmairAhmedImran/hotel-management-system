
package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout2 extends JFrame implements ActionListener{
    Choice customer;
    JLabel roomnumber,checkin,checkout;
    JButton checkout_button, back;
    Checkout2() {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        
        JLabel text = new JLabel("CHECKOUT");
        text.setBounds(100,20,120,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tohma", Font.PLAIN, 20));
        add(text);
        
        JLabel id = new JLabel("Customer id");
        id.setBounds(30,80,100,15);
        add(id);
        
        customer = new Choice();
        customer.setBounds(150, 80, 150, 25);
        add(customer);
        
        roomnumber = new JLabel();
        roomnumber.setBounds(150,130,100,15);
        add(roomnumber);
        
        checkin = new JLabel();
        checkin.setBounds(150,180,180,15);
        add(checkin);
        
        try {
            Conn conn = new Conn();
            String query = "Select * from customer";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                customer.add(rs.getString("id"));
                roomnumber.setText(rs.getString("room"));
                checkin.setText(rs.getString("checkintime"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel room = new JLabel("Room number");
        room.setBounds(30,130,100,15);
        add(room);
        
        
        
        JLabel checkintime = new JLabel("Check in time");
        checkintime.setBounds(30,180,100,15);
        add(checkintime);
        
        
        
        JLabel checkouttime = new JLabel("Check out time");
        checkouttime.setBounds(30,230,100,15);
        add(checkouttime);
        
        Date date = new Date();
        checkout = new JLabel("" + date);
        checkout.setBounds(150,230,180,15);
        add(checkout);
        
        checkout_button = new JButton("Checkout");
        checkout_button.setBackground(Color.BLACK);
        checkout_button.setForeground(Color.WHITE);
        checkout_button.setFocusable(false);
        checkout_button.setBounds(30,280,120,30);
        checkout_button.addActionListener(this);
        add(checkout_button);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        
        setBounds(500,250,500,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout_button) {
            String query1 = "delete from customer where id = '"+ customer.getSelectedItem() + "'";
            String query2 = "update room set availability = 'Available' where roomnumber = '" + roomnumber.getText() +"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout done");
                setVisible(false);
                new Reception();
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new User();
        }
    
}
    public static void main(String[] args) {
        new Checkout2();
    
    }
}
