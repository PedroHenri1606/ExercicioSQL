package view;

import controller.FabricanteController;
import model.Fabricante;

import java.awt.print.Printable;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
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
                    this.listar();
                    break;
                case 3:
                    this.remover();
                    break;
                case 4:
                    this.editar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("--------------------------------------");
                    System.out.println("        OPÇÃO INVALIDA!");
                    break;
            }
        } while (opcao != 0);
    }

    public void cadastrar() {

        Fabricante fabricante = new Fabricante();
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.print("Nome: ");
        fabricante.setNome(scan.nextLine());
        this.fabricanteController.cadastro(fabricante);
    }

    public void listar() {

        List<Fabricante> fabricantes = this.fabricanteController.listarFabricantes();
        Iterator var = fabricantes.iterator();

        System.out.println("--------------------------------------");
        while (var.hasNext()) {
            Fabricante fabricante = (Fabricante) var.next();
            PrintStream var10000 = System.out;
            int var10001 = fabricante.getId();
            var10000.println("| Id: " + var10001 + " | Marca: " + fabricante.getNome());
        }

    }

    public void remover() {

        Scanner scan = new Scanner(System.in);

        this.listar();
        System.out.println("--------------------------------------");
        System.out.print("Selecione por Id para remover: ");
        int id = scan.nextInt();
        this.fabricanteController.remover(id);
    }

    public void editar() {

        Scanner scan = new Scanner(System.in);

        this.listar();
        String conteudo = null;

        System.out.println("--------------------------------------");
        System.out.print("Selecione o ID a ser editado: ");
        int id = scan.nextInt();

        System.out.println("--------------------------------------");
        System.out.println("        [1] - Editar Nome ");
        System.out.println("        [0] - Voltar ");
        System.out.println("--------------------------------------");
        int opcao = scan.nextInt();
        System.out.println("--------------------------------------");

        switch (opcao) {
            case 1:
                conteudo = scan.nextLine();
                System.out.print("Informe o novo Nome: ");
                conteudo = scan.nextLine();
                break;
            case 0:
                break;
            default:
                System.out.println("--------------------------------------");
                System.out.println("        OPÇÃO INVALIDA!");
                return;
        }
        this.fabricanteController.editar(id,conteudo);
    }
}


