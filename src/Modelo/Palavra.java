package Modelo;

import java.util.ArrayList;

public class Palavra {
    private String nome;
    private ArrayList<Documento> documentos;


    public Palavra(String palavra, ArrayList<Documento> documentos) {
        super();
        this.nome = palavra;
        this.documentos = documentos;
    }

    public Palavra(String palavra) {
        this.nome = palavra;
        this.documentos = new ArrayList<Documento>();
    }

    public void insereDocumento(Documento documento){
        this.documentos.add(documento);
    }

    public String getPalavra() {
        return nome;
    }

    public void setPalavra(String palavra) {
        this.nome = palavra;
    }


    public ArrayList<Documento> getRepeticoes() {
        return documentos;
    }


    public void setRepeticoes(ArrayList<Documento> repeticoes) {
        this.documentos = repeticoes;
    }

    public void listaDocumentos(Palavra palavra){

    }

}
