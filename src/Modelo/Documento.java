package Modelo;

public class Documento {
    private String nome;
    private int repeticoes;
    private Double peso;

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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
