
package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Bookcustomer2 extends JFrame implements ActionListener{
    JButton booking,bookout,logout;
    JTextField user_id, user_name;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    Bookcustomer2() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 750, 500);
        
        JLabel text = new JLabel("CUSTOMER BOOKING FORM");
        text.setBounds(220, 30, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);
        
        JLabel id = new JLabel("ID");
        id.setBounds(50, 100, 70, 20);
        
        add(id);
        
        user_id = new JTextField();
        user_id.setBounds(150, 100, 150, 25);
        add(user_id);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50, 170, 70, 20);
        add(name);
        
        user_name = new JTextField();
        user_name.setBounds(150, 170, 150, 25);
        add(user_name);
        
//        JLabel room_type = new JLabel("Room Type");
//        room_type.setBounds(50, 240, 85, 20);
//        add(room_type);
        
//        single = new JRadioButton("Single");
//        single.setBounds(150, 240, 80,30);
//        single.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        single.setBackground(Color.WHITE);
//        single.setFocusable(false);
//        add(single);
//        
//        double_bed = new JRadioButton("Double bed");
//        double_bed.setBounds(230, 240, 90,30);
//        double_bed.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        double_bed.setBackground(Color.WHITE);
//        double_bed.setFocusable(false);
//        add(double_bed);
//        
//        twin = new JRadioButton("Twin");
//        twin.setBounds(330, 240, 80,30);
//        twin.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        twin.setBackground(Color.WHITE);
//        twin.setFocusable(false);
//        add(twin);
//        
//        
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(single);
//        bg.add(double_bed);
//        bg.add(twin);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(50, 240, 85, 20);
        add(room);
        
        croom = new Choice();
        croom.setBounds(150, 240, 150, 25);
        add(croom);
        
        
        try {
            Conn conn = new Conn();
            String query = "Select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkintime = new JLabel("Check in time");
        checkintime.setBounds(50, 310, 170, 25);
        add(checkintime);
        
        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setBounds(150, 310, 170, 25);
        add(checkintime);
        
        add = new JButton("Add");
        add.setFocusable(false);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 380, 120, 25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setFocusable(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/image.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 70,300,400);
        add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = user_id.getText();
            String name = user_name.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            
            try {
                String query = "insert into customer values('"+ id + "', '" + name + "', '" + room + "', '"+ time+ "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber ='"+ room + "'";
                
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Check in successfully" );
                
                setVisible(false);
                new Reception();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new User();
        }
        
    }
    
     public static void main(String[] args) {
     new Bookcustomer2();
     }
}
