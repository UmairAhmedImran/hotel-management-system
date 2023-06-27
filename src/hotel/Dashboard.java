package hotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboardpic.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        JLabel text = new JLabel("WELCOME TO LUTON HOTEL");
        text.setBounds(450,50,1000,50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);
        JButton login = new JButton("Login");
        login.setBounds(1300, 50, 180, 60);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFocusable(false);
        login.addActionListener(this);
        image.add(login);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
        new login();
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
