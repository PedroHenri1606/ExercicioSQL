package controller;

import dao.CarroDAO;
import model.Carro;

import java.util.List;

public class CarroController {

    CarroDAO carroDAO = new CarroDAO();

    public void cadastrarCarro(Carro carro){ this.carroDAO.cadastraCarro(carro);}
    public void removerCarro(int id){ this.carroDAO.remover(id);}
    public List<Carro> listarCarros(){ return this.carroDAO.listarCarros();}
    public void editar(int id,int opcao, String conteudo){ this.carroDAO.editar(id,opcao,conteudo);}
}
