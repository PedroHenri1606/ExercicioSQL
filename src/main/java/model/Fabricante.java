package model;

public class Fabricante {

    private int id;
    private String nome;

    public Fabricante() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fabricante{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
