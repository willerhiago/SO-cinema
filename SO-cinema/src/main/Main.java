package main;

import java.io.IOException;

import arquivo.*;
import cinema.Pedido;
import cinema.SistemaVenda;

public class Main {

	public static void main(String[] args) {
		
		try {
			SistemaVenda venda = new SistemaVenda();
			while(!venda.getPedidos().loteVazio()){
				venda.novoPedido();
			}
			System.out.println("\n\n---------------------Pedidos aprovados-------------------\n\n");
			for(Pedido pedido :  venda.getPedidosAprovados()) {
				System.out.println(pedido.toString());
			}
			System.out.println("\n\n---------------------Pedidos negados-------------------\n\n");
			for(Pedido pedido :  venda.getPedidosNegados()) {
				System.out.println(pedido.toString());
			}
			
		} catch (NumberFormatException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
