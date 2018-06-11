package main;

import java.io.IOException;

import arquivo.*;
import cinema.*;

public class Main {

	static Cliente[] clientes;
	static int threads;
	static SistemaVenda venda;

	public static void main(String[] args) throws InterruptedException {

		try {
			venda = new SistemaVenda();
			threads = 10;
			clientes = new Cliente[threads];

			for(int i = 0;i <threads; i ++) {
				clientes[i] = new Cliente(venda,"thread "+i);
				clientes[i].start();
			}

			for(int i=0; i<threads; i++){
				clientes[i].join();
			}

			// threads acabam aqui

			Arquivo arq = new Arquivo();

			arq.salvarArquivo("Aprovados", venda.getPedidosAprovados());
			arq.salvarArquivo("Negados", venda.getPedidosNegados());

			System.out.println("\n\n----------------------------SALA---------------------------\n\n");

			venda.getSala().escreverSala();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
