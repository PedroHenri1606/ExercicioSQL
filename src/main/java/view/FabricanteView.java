package view;

import controller.FabricanteController;
import model.Fabricante;

import java.util.Scanner;

public class FabricanteView {

    FabricanteController fabricanteController = new FabricanteController();

    public void menuFabricante() {

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--------------------------------------");
            System.out.println("      [1] - Cadastrar  Fabricante     ");
            System.out.println("      [2] - Visualizar Fabricantes    ");
            System.out.println("      [3] - Remover Fabricantes       ");
            System.out.println("      [4] - Editar Fabricantes        ");
            System.out.println("      [0] - Voltar                    ");
            System.out.println("--------------------------------------");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    return;
            }
        } while (opcao != 0);
    }

    public void cadastrar(){
        Fabricante fabricante = new Fabricante();
        Scanner scan = new Scanner(System.in);

        System.out.print("Nome: "); fabricante.setNome(scan.nextLine());
        this.fabricanteController.cadastro(fabricante);
    }
}
