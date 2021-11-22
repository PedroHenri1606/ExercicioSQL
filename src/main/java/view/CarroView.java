package view;

import controller.CarroController;
import controller.FabricanteController;
import model.Carro;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CarroView {

    CarroController carroController = new CarroController();
    FabricanteView fabricanteView = new FabricanteView();
    FabricanteController fabricanteController = new FabricanteController();

    public void telaMenu() {

        System.out.println("--------------------------------------");
        System.out.println("         [1] - Menu Carros            ");
        System.out.println("         [2] - Menu Fabricantes       ");
        System.out.println("         [0] - Sair                   ");
        System.out.println("--------------------------------------");
    }

    public void menu() {

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            this.telaMenu();
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    this.menuCarro();
                    break;
                case 2:
                    fabricanteView.menuFabricante();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("--------------------------------------");
                    System.out.println("        OPÇÃO INVALIDA!");
                    break;
            }
        } while (true);
    }


    public void menuCarro() {

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--------------------------------------");
            System.out.println("        [1] - Cadastrar Carro         ");
            System.out.println("        [2] - Listar Carro            ");
            System.out.println("        [3] - Remover Carro           ");
            System.out.println("        [4] - Editar Carro            ");
            System.out.println("        [0] - Voltar                  ");
            System.out.println("--------------------------------------");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrarCarro();
                    break;
                case 2:
                    this.listarCarros();
                    break;
                case 3:
                    this.removerCarro();
                    break;
                case 4:
                    this.editarCarro();
                case 0:
                    return;
                default:
                    break;
            }
        } while (true);
    }

    public void cadastrarCarro(){

        FabricanteView fabricanteView = new FabricanteView();
        Carro carro = new Carro();
        Scanner scan = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.print  (" Nome: "); carro.setNomeCarro(scan.nextLine());

        fabricanteView.listar();

        System.out.println("--------------------------------------");
        System.out.println(" Selecione opção para Fabricante ");
        System.out.println("--------------------------------------");
        System.out.println(" [1] - Cadastrar Fabricante ");
        System.out.println(" [2] - Escolher Fabricante ");
        System.out.println("--------------------------------------");
        int opcao = scan.nextInt();


        switch (opcao){
            case 1:
                fabricanteView.cadastrar();

            case 2:
                carro.setMarcaCarro(this.escolhendoFabricante());
                break;

            default:
                System.out.println("--------------------------------------");
                System.out.println("        OPÇÃO INVALIDA!");
                return;
        }
        this.carroController.cadastrarCarro(carro);
    }

    public String escolhendoFabricante(){

        Scanner scan = new Scanner(System.in);

            fabricanteView.listar();
            System.out.println("--------------------------------------");
            System.out.print  ("Selecione por id: ");
            int fabricante1 =Integer.parseInt(scan.nextLine());
            String fabricante = fabricanteController.escolherFabricante(fabricante1);
            return fabricante;
        }


    public void listarCarros(){

        List<Carro> carros = this.carroController.listarCarros();
        Iterator var = carros.iterator();

        System.out.println("--------------------------------------");
        while(var.hasNext()){
            Carro carro = (Carro)var.next();
            PrintStream tmp1 = System.out;
            int tmp2 = carro.getId();
            tmp1.println("| Id: " + tmp2 + " | Veiculo: " + carro.getNomeCarro() + " | Fabricante: " + carro.getMarcaCarro());
        }
    }

    public void removerCarro(){

        Scanner scan = new Scanner(System.in);

        this.listarCarros();
        System.out.println("--------------------------------------");
        System.out.print  (" Selecione o Id para remover: ");
        int id = Integer.parseInt(scan.nextLine());
        this.carroController.removerCarro(id);
    }

    public void editarCarro(){

        Scanner scan = new Scanner(System.in);
        this.listarCarros();
        String conteudo;
        System.out.println("--------------------------------------");
        System.out.print  ("Selecione o ID a ser editado: "); int id = Integer.parseInt(scan.nextLine());
        System.out.println("--------------------------------------");
        System.out.println("        [1] - Editar Nome ");
        System.out.println("        [2] - Editar Fabricante");
        System.out.println("--------------------------------------");
        int opcao = Integer.parseInt(scan.nextLine());
        System.out.println("--------------------------------------");

        switch (opcao){
            case 1:
                System.out.print("Informe o novo nome do Veiculo: "); conteudo = scan.nextLine();
                break;
            case 2:
                conteudo = this.escolhendoFabricante();
                break;
            default:
                System.out.println("OPCAO INFORMADA INVALIDA");
                return;
        }
        this.carroController.editar(id,opcao,conteudo);
    }

}