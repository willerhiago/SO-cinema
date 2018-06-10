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

        	System.out.println("\n\n---------------------PEDIDOS APROVADOS---------------------\n\n");
			for(Pedido pedido :  venda.getPedidosAprovados()) {
			System.out.println(pedido.toString());
			}
			arq.salvarArquivo("Aprovados", venda.getPedidosAprovados());
			
			System.out.println("\n\n---------------------PEDIDOS NEGADOS-----------------------\n\n");
			for(Pedido pedido :  venda.getPedidosNegados()) {
				System.out.println(pedido.toString());
			}
			arq.salvarArquivo("Negados", venda.getPedidosNegados());
			System.out.println("\n\n----------------------------SALA---------------------------\n\n");

		   venda.getSala().escreverSala();
		
		} catch (NumberFormatException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
