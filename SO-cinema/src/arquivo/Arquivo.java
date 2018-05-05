package arquivo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Arquivo {

    public String[][] ler(String nome_arquivo)
           throws IOException{

        String[][] assentos;

        if(nome_arquivo.equals("sala.txt") || nome_arquivo.equals("pedidos.txt")){

            RandomAccessFile arquivo = new RandomAccessFile(nome_arquivo, "r"); // Instancia arquivo

            String[] dados = arquivo.readLine().split(" ");

            int tam_filas = Integer.parseInt(dados[0]), // Recuperando numero de filas/pedidos registrado no arquivo
            /*
             * Recuperando numero de colunas registrado no arquivo.
             * Se nome_arquivo == 'sala.txt', recebe 2º numero passado na primeira linha do arquivo
             * Se nome_arquivo == 'pedidos.txt', recebe 4 (número de dados em cada linha após a primeira)
             */ tam_poltrona = (nome_arquivo.equals("sala.txt")) ? Integer.parseInt(dados[1]) : 4,
                i = 0;

            assentos = new String[tam_filas][tam_poltrona];       // Cria matriz com dimensões para as poltronas/pedidos

            while (arquivo.getFilePointer() < arquivo.length()) {       // Percorre o arquivo inteiro
                int j = 0;

                /*
                * Lendo linha do arquivo
                * Se nome_arquivo == 'sala.txt', quebra a string por [""]
                * Se nome_arquivo == 'pedidos.txt', quebra a string por [" "]
                */
                dados = arquivo.readLine().split(nome_arquivo.equals("sala.txt") ? "" : " ");       // Lendo linha do arquivo

                for (String dado : dados) {                       // Percorre cada item da linha lida
                    assentos[i][j] = dado;      // Insere cada item da linha lida numa matriz representativa
                    j++;
                }

                i++;
            }
        }else{
            System.out.println("Só trabalhamos com os arquivos de nome \'sala.txt\' ou \'pedidos.txt\'");
            assentos = null;
        }

        return assentos;
    }

    public synchronized void registrar(String nome_arquivo, String tipo_dado, int num_pedido, int fila, int poltrona)throws IOException{
        boolean vendido=false, negado=false;

        /* ${tipo_dado} == VENDIDO || NEGADO */
        if(vendido = (tipo_dado.equalsIgnoreCase("VENDIDO") && nome_arquivo.equals("vendidos.txt")) || // SE ${tipo_dado} == 'VENDIDO' && ${nome_arquivo} == 'vendidos.txt' OU
            (negado = (tipo_dado.equalsIgnoreCase("NEGADO") && nome_arquivo.equals("negados.txt")))) {  // SE ${tipo_dado} == 'NEGADOS' && ${nome_arquivo} == 'negados.txt'

            RandomAccessFile arquivo = new RandomAccessFile(nome_arquivo, "rw"); // Instancia do arquivo

            arquivo.seek(arquivo.length()); // Apontar para final do arquivo

        /*
         * Definir formato numerico (caso tenha apenas 1 digito, este passara a ter 2, sendo o primeiro um 'ZERO')
         * Ex.: '4'   = '04'
         * Porém não afeta no caso de mais de UM digito
         * Ex.: '120' = '120'
         */ NumberFormat dc = new DecimalFormat("00");

            // Criando STRING para ser inserida
            arquivo.writeUTF(tipo_dado.toUpperCase() + ", PEDIDO " + num_pedido + ", POLTRONA " + dc.format(fila) + " " + dc.format(poltrona) + System.lineSeparator());

        }else{
            System.out.println("Só trabalhamos com o parametro ${tipo_dado} de nome \'VENDIDO\' e ${nome_arquivo} de nome \'vendidos.txt\' ou ${tipo_dado} de nome \'NEGADO\' e ${nome_arquivo} de nome \'negados.txt\'");
        }
    }

}
