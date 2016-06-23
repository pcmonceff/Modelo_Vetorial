package Modelo;

public class Documento {
    private String nome;
    private int repeticoes;

    public Documento(String nome, int repeticoes) {
        this.nome = nome;
        this.repeticoes = repeticoes;
    }

    public Documento(String nome) {
        this.nome = nome;
    }

    public Documento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
}
