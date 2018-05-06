package main;

import java.io.IOException;

import arquivo.*;

public class Main {

	public static void main(String[] args) {
		
		  Arquivo arq = new Arquivo();
		  Arquivo arq2 = new Arquivo();
	        String[][] assentos;
			try {
				//arq.lerPedidos();
				//arq.escreverPedidos();
				arq.lerSala();
				arq.escreverSala();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	}

}
