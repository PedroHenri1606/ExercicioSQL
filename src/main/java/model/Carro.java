package model;

public class Carro {
    private int id;
    private String nomeCarro;
    private String marcaCarro;

    public Carro() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    @Override
    public String toString() {
        return "Carro: " + "id= " + id + " nomeCarro= " + nomeCarro + " marcaCarro= " + marcaCarro ;
    }
}
