import dao.CarroDAO;
import view.CarroView;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        CarroDAO carroDAO = new CarroDAO();
        carroDAO.criaTabelaCarros();

        CarroView carroView = new CarroView();
        carroView.menu();
    }
}
