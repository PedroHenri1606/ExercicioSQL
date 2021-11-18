package view;

import java.util.Scanner;

public class CarroView {

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
                    menuCarro();
                    break;
                case 2:
                    this.menuFabricante();
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
            System.out.println("        [1] - Selecionar Veiculo      ");
            System.out.println("        [2] - Visualizar Veiculos     ");
            System.out.println("        [0] - Voltar                  ");
            System.out.println("--------------------------------------");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    return;
            }
        } while (opcao != 0);
    }

    public void menuFabricante() {

        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--------------------------------------");
            System.out.println("      [1] - Selecionar Fabricante     ");
            System.out.println("      [2] - Visualizar Fabricantes    ");
            System.out.println("      [0] - Voltar                    ");
            System.out.println("--------------------------------------");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    return;
            }
        } while (opcao != 0);
    }

}
