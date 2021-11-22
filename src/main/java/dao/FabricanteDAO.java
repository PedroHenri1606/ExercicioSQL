package dao;

import factory.ConnectionFactory;
import model.Fabricante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabricanteDAO {

    Fabricante fabricante = new Fabricante();

    Connection connection = (new ConnectionFactory().getConnection());

    public FabricanteDAO(){}

    public void criaTabelaFabricante(){

        String sql = "create table if not exists fabricantes" +
                "(idFabricante int primary key auto_increment," +
                "nome VARCHAR(45) NOT NULL)";

        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastroFabricante(Fabricante fabricante){

        String sql = "insert into testedb.fabricantes(nome) value (?)";

        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, fabricante.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Fabricante> listarFabricantes(){

        String sql = "select * from testedb.fabricantes";

        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList fabricantes = new ArrayList();

            while(resultSet.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setId(resultSet.getInt("idfabricante"));
                fabricante.setNome(resultSet.getString("nome"));
                fabricantes.add(fabricante);
            }
            return fabricantes;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void remover(int id){

        try{
            String sql = "delete from testedb.fabricantes where idfabricante = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.execute();
            statement.close();
            System.out.println("REMOVIDO COM SUCESSO!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public String escolherFabricante(int escolha) {

        String sql = "select nome from testedb.fabricantes where idfabricante = " + escolha;

        String nomeFabricante = "";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nomeFabricante = resultSet.getString("nome");
            }
            statement.execute();
            statement.close();

            return nomeFabricante;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editar(int id,String conteudo) {

        String sql = "update testedb.fabricantes set nome = ? where idfabricante = ?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1,conteudo);
            statement.setInt(2,id);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
