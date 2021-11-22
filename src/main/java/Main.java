import dao.CarroDAO;
import dao.FabricanteDAO;
import view.CarroView;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        CarroView carroView = new CarroView();
        CarroDAO carroDAO = new CarroDAO();

        FabricanteDAO fabricanteDAO = new FabricanteDAO();

        fabricanteDAO.criaTabelaFabricante();
        carroDAO.criaTabelaCarros();

        carroView.menu();
    }
}
