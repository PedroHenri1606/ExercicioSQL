package controller;

import dao.FabricanteDAO;
import model.Fabricante;

import java.util.List;

public class FabricanteController {

    FabricanteDAO fabricanteDAO = new FabricanteDAO();

    public void cadastro(Fabricante fabricante){ this.fabricanteDAO.cadastroFabricante(fabricante);}
    public List<Fabricante> listarFabricantes(){ return this.fabricanteDAO.listarFabricantes();}
    public void remover(int id){ this.fabricanteDAO.remover(id);}
}