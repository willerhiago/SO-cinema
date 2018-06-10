package arquivo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import cinema.Pedido;

public class Arquivo {

    private FileInputStream arqEntrada;
    private DataInputStream entrada;
    private String arquivo;
    
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private int qntPedidos;
    
    private String[][] sala;
    private int qntFilas;
	private int qntCadeirasPorFila;


	//-------------------------------------M√©todos sobre arquivo
    private void abreArquivo(String nomeArquivo) throws FileNotFoundException {
        if(nomeArquivo == null || nomeArquivo == "") {
           System.out.println("Nome de arquivo inv·lido!");
        }
        else {
            this.arqEntrada = new FileInputStream(nomeArquivo);
            this.arquivo = nomeArquivo;
        }

        this.entrada = new DataInputStream(arqEntrada);
    }

    private void fechaArquivo() throws IOException {
        entrada.close();
        arqEntrada.close();
    }

    //------------------------------MÈtodos Pedidos

    public ArrayList<Pedido> lerPedidos() throws NumberFormatException, IOException {
        this.abreArquivo("pedidos.txt");
        qntPedidos = Integer.parseInt(entrada.readLine());

        while(entrada.available() != 0){
        	String[] linha = entrada.readLine().split(" ");
        	Pedido pedido = new Pedido(Integer.parseInt(linha[0]),Integer.parseInt(linha[1]),Integer.parseInt(linha[2]),Integer.parseInt(linha[3]));
        	pedidos.add(pedido);
        }

        this.fechaArquivo();
        return this.pedidos;
 }
    public void escreverPedidos() {
        if(qntPedidos == 0) System.out.println("Nao existe pedidos!");
        else {
            for(Pedido p : pedidos){
                System.out.println(p.toString());
            }
        }
    }
    
    public ArrayList<Pedido> retornarPedidos() {
        return this.pedidos;
    }

	public int getQntPedidos() {
		return qntPedidos;
	}    
   
	//---------------------------MÈtodos Sala
    public String[][] lerSala() throws IOException{

         String nome_arquivo = "sala.txt";
         RandomAccessFile arquivo = new RandomAccessFile(nome_arquivo, "r"); // Instancia arquivo

         String[] dados = arquivo.readLine().split(" ");

         int tam_filas = Integer.parseInt(dados[0]);
         int tam_poltrona = Integer.parseInt(dados[1]);
         int i = 0;

         sala = new String[tam_filas][tam_poltrona];       // Cria matriz com dimens√µes para as poltronas/pedidos
         this.qntFilas = tam_filas;
         this.qntCadeirasPorFila = tam_poltrona;
         
         while (arquivo.getFilePointer() < arquivo.length()) {       // Percorre o arquivo inteiro
             int j = 0;
             dados = arquivo.readLine().split(nome_arquivo.equals("sala.txt") ? "" : " ");       // Lendo linha do arquivo
             
             for (String dado : dados) { 
                 sala[i][j] = dado;      // Insere cada item da linha lida numa matriz representativa
                 j++;
             }
             i++;
         }
    
        return this.sala;
     }
    
    public String[][] retornaSala() {
    	return this.sala;
    }
    
    public void escreverSala() {
        if(qntFilas == 0) System.out.println("Nao existe sala!");
        else {
        	
                for(String[] assentos2 : sala){
                    for(String assento : assentos2){
                        System.out.print(assento + "");
                    }
                    System.out.println();
                }
        }
    }
    
    public int getQntFilas() {
		return qntFilas;
	}

	public int getQntCadeirasPorFila() {
		return qntCadeirasPorFila;
	}
	//-----------------------Salvar Arquivo
	
	public void salvarArquivo(String nomeArq,ArrayList<Pedido> salvar) throws IOException{
        FileWriter arq = new FileWriter(nomeArq + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for(Pedido p : salvar) {
            gravarArq.println(p.toString());
        }
        arq.close();
        gravarArq.close();
    }
}

