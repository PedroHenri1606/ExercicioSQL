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
            }
        } while (opcao != 0);
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
        } while (opcao != 0);
    }

    public void cadastrarCarro(){
        Carro carro = new Carro();
        Scanner scan = new Scanner(System.in);
        System.out.print(" Nome: "); carro.setNomeCarro(scan.nextLine());
        carro.setMarcaCarro(this.escolhendoFabricante());
        this.carroController.cadastrarCarro(carro);
    }

    public String escolhendoFabricante(){
        Scanner scan = new Scanner(System.in);


            System.out.println("--------------------------------------");
            fabricanteView.listar();
            System.out.println("--------------------------------------");
            System.out.print  ("Selecione por id: ");
            int fabricante1 =Integer.parseInt(scan.nextLine());
            String fabricante = fabricanteController.escolherFabricante(fabricante1);
            System.out.println("--------------------------------------");
            return fabricante;
        }


    public void listarCarros(){
        List<Carro> carros = this.carroController.listarCarros();
        Iterator var = carros.iterator();

        while(var.hasNext()){
            Carro carro = (Carro)var.next();
            PrintStream var10000 = System.out;
            int var10001 = carro.getId();
            var10000.println("Id: " + var10001 + " |Veiculo: " + carro.getNomeCarro() + " |Fabricante: " + carro.getMarcaCarro());
        }
    }

    public void removerCarro(){
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------");
        this.listarCarros();
        System.out.println("--------------------------------------");
        System.out.println(" Selecione o Id para remover: ");
        int id = Integer.parseInt(scan.nextLine());
        this.carroController.removerCarro(id);
    }

    public void editarCarro(){
        Scanner scan = new Scanner(System.in);
        this.listarCarros();
        String conteudo = null;
        System.out.print(" Selecione o ID a ser editado: "); int id = Integer.parseInt(scan.nextLine());
        System.out.println("--------------------------------------");
        System.out.println("        [1] - Editar Nome ");
        System.out.println("        [2] - Editar Fabricante");
        System.out.println("--------------------------------------");
        int opcao = Integer.parseInt(scan.nextLine());
        switch (opcao){
            case 1:
                System.out.print("Informe o novo nome do Veiculo: "); conteudo = scan.nextLine();
                break;
            case 2:
                System.out.print("Informe o novo fabricante do Veiculo: "); conteudo = scan.nextLine();
                break;
            default:
                System.out.println("OPCAO INFORMADA INVALIDA");
                return;
        }
        this.carroController.editar(id,opcao,conteudo);
    }

}