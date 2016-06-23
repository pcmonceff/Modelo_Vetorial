package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by pcmonceff on 23/06/16.
 */
public class Leitura {
    private ArrayList<Palavra> indice;
    private ArrayList<String> arquivos;

    public Leitura() {
        this.indice = new ArrayList<Palavra>();
        this.arquivos = new ArrayList<String>();
    }

    public ArrayList<Palavra> getIndice() {
        return indice;
    }

    public boolean existePalavra(String token){
        for (int i = 0; i < this.indice.size(); i++) {
            if (this.indice.get(i).getPalavra().toString().equals(token)){
                return true;
            }
        }
        return false;
    }

    public void inserePalavra(Palavra palavra){
        this.indice.add(palavra);
    }

    public int indicePalavra(String token){
        for (int i = 0; i < this.indice.size(); i++) {
            if (this.indice.get(i).getPalavra().toString().equals(token)){
                return i;
            }
        }
        return -1;
    }

    public void imprimeIndice() {
        for (int i = 0; i < this.indice.size(); i++) {
            System.out.println("Palavra: " + this.indice.get(i).getPalavra());
            Palavra palavra = indice.get(i);
            ArrayList<Documento> documentos = palavra.getRepeticoes();

            for (int j = 0; j < documentos.size(); j++) {
                System.out.print(documentos.get(j).getNome() + "->");
                System.out.print(documentos.get(j).getRepeticoes() + " ");
            }
            System.out.println();

        }
    }

    public void leArquivos() {
        Leitura indiceInvertido = new Leitura();

        File file = new File("Arquivos");
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];

            if (arquivos.getName().contains("file")) {
                this.arquivos.add(arquivos.getName());
                List<String> palavras = new ArrayList<>();
                List<String> listaFinal = new ArrayList<>();
                List<Integer> quantidade = new ArrayList<>();
                String token = " ";
                try {
                    FileReader arq = new FileReader(arquivos);
                    BufferedReader lerArq = new BufferedReader(arq);
                    String linha = lerArq.readLine();
                    while (linha != null) {
                        linha = linha.replace(".", " ");
                        linha = linha.replace(",", " ");
                        linha = linha.replace("-", " ");
                        linha = linha.replace(".", " ");
                        linha = linha.replace("\"", " ");
                        linha = linha.toUpperCase();
                        StringTokenizer frase = new StringTokenizer(linha);
                        while (frase.hasMoreTokens()) {
                            token = frase.nextToken();
                            if (token.length() > 1) {
                                palavras.add(token);
                            }
                        }
                        linha = lerArq.readLine();
                    }
                    arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                }
                for (int k = 0; k <= palavras.size() - 1; k++) {
                    if (!(listaFinal.contains(palavras.get(k)))) {
                        listaFinal.add(palavras.get(k));
                        quantidade.add(Collections.frequency(palavras, palavras.get(k)));
                    }
                }
                for (int k = 0; k <= listaFinal.size() - 1; k++) {
                    Palavra palavra = new Palavra(listaFinal.get(k));
                    if (!(indiceInvertido.existePalavra(listaFinal.get(k)))) {
                        palavra.insereDocumento(new Documento(arquivos.getName(), quantidade.get(k)));
                        indiceInvertido.inserePalavra(palavra);
                    } else {
                        indiceInvertido.getIndice().get(indiceInvertido.indicePalavra(listaFinal.get(k)))
                                .insereDocumento(new Documento(arquivos.getName(), quantidade.get(k)));
                    }
                }
            }

        }
        //Leitura.imprimeIndice();
        indice = indiceInvertido.getIndice();
    }
}
