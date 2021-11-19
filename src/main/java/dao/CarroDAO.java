        package dao;

import factory.ConnectionFactory;
import model.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    Connection connection = (new ConnectionFactory()).getConnection();
    FabricanteDAO fabricanteDAO = new FabricanteDAO();

    public CarroDAO() {
    }

    public void criaTabelaCarros() {
        String sql = "create table if not exists carros" +
                "(idCarro int primary key auto_increment," +
                "nome VARCHAR(45) NOT NULL," +
                "fabricante VARCHAR(45) NOT NULL)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastraCarro(Carro carro) {
        String sql = "insert into testedb.carros(nome, fabricante) value (?, ?)";

        try {
            PreparedStatement stml = this.connection.prepareStatement(sql);
            stml.setString(1, carro.getNomeCarro());
            stml.setString(2, carro.getMarcaCarro());
            stml.execute();
            stml.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Carro> listarCarros() {
        String sql = "select * from testedb.carros";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList carros = new ArrayList();

            while (resultSet.next()) {
                Carro carro = new Carro();
                carro.setId(resultSet.getInt("idCarro"));
                carro.setNomeCarro(resultSet.getString("nome"));
                carro.setMarcaCarro(resultSet.getString("fabricante"));
                carros.add(carro);
            }
            return carros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(int id){
        try{
            String sql = "delete from testedb.carros where idCarro = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            System.out.println("REMOVIDO COM SUCESSO!");
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public void editar(int id,int opcao,String conteudo){
        String sql = null;
        switch (opcao) {
            case 1:
                sql = "update testedb.carros set nome = ? where idCarro = ?";
                break;
            case 2:
                sql = "update testedb.carros set fabricante = ? where idCarro = ?";
                break;
        }
        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1,conteudo);
            statement.setInt(2,id);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
}