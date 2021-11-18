import view.CarroView;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        CarroView carroView = new CarroView();
        carroView.menu();
        /*try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcteste","root","");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from carros");

        while (resultSet.next()){
            System.out.print(resultSet.getInt("idCarros"));              System.out.print(" | ");
            System.out.print(resultSet.getString("nomeCarro"));          System.out.print(" | ");
            System.out.println(resultSet.getString("nomeFabricante"));
        }
    }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        }*/
    }
}