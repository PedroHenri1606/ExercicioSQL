package controller;

import dao.FabricanteDAO;
import model.Fabricante;

import java.util.List;

public class FabricanteController {

    FabricanteDAO fabricanteDAO = new FabricanteDAO();

    public void cadastro(Fabricante fabricante){ this.fabricanteDAO.cadastroFabricante(fabricante);}
    public List<Fabricante> listarFabricantes(){ return this.fabricanteDAO.listarFabricantes();}
    public void remover(int id){ this.fabricanteDAO.remover(id);}
    public String escolherFabricante(int escolha){ return fabricanteDAO.escolherFabricante(escolha);}
    public void editar(int id,String conteudo){ fabricanteDAO.editar(id,conteudo);}
}
