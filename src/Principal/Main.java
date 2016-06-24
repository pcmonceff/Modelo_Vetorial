package Principal;

import Modelo.Documento;
import Modelo.Leitura;
import Modelo.Palavra;

public class Main {
    public static void main(String args[]){
        Leitura leitura = new Leitura();
        Documento documento = new Documento();


        leitura.leArquivos();
        //leitura.imprimeIndice();
        //System.out.println(leitura.getIndice().get(0).getPalavra().toUpperCase());
        System.out.println(leitura.getIndice().size());
    }
}
