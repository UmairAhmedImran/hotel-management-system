package hotel;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagmentsystem", "root", "853MySQL$$#u");
            s = c.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
