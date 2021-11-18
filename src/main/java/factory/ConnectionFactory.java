package factory;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ConnectionFactory {

    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcteste","root","PEDROHENRIQUE123");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
