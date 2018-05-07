package cinema;

import java.io.IOException;
import java.util.ArrayList;

public class SistemaVenda {
	
	private LotePedidos pedidos;
	private Sala sala;
	private ArrayList<Pedido> pedidosAprovados;
	private ArrayList<Pedido> pedidosNegados;
	
	public SistemaVenda() throws NumberFormatException, IOException{
		pedidos = new LotePedidos();
		sala = new Sala();
		pedidosAprovados = new ArrayList<Pedido>();
		pedidosNegados = new ArrayList<Pedido>();
	}
		
	private void vendeIngresso(Pedido pedido){
		
		int fileira = pedido.getIngresso().getFileira();
		int cadeira = pedido.getIngresso().getCadeira();
		
		boolean result = false;
		boolean aprovado = false;
		
		switch(pedido.getTipo()) {
		
			case 1: //----------------------------------------Somente consulta
				sala.consultaAssento(fileira,cadeira); 
				break;
				
			case 2: //---------------------------------  Consulta, Reserva e não compra
				
				while(pedido.executaTempo() <  pedido.getTempo()) { // loop no tempo do pedido tentando reservar até conseguir
					result = sala.reservaAssento(fileira, cadeira);
					if(result) {
						aprovado = true;
					}
				}
					pedido.pedidoNegado(fileira, cadeira); 
					pedidosNegados.add(pedido);
					sala.retiraReserva(fileira, cadeira); 
				
				
				break;
				
			case 3: //-------------------------------------- Consulta, Reserva e compra
				
				while(pedido.executaTempo() <  pedido.getTempo()) { // loop no tempo do pedido tentando reservar até conseguir
					result = sala.reservaAssento(fileira, cadeira);
					if(result) {
						aprovado = true;
					}
				}
				if(aprovado) {
					pedido.pedidoAprovado(fileira, cadeira); 
					pedidosAprovados.add(pedido);
				}else{
					pedido.pedidoNegado(fileira, cadeira); 
					pedidosNegados.add(pedido);
				}
				break;
		}
		
	}
	
	public void novoPedido() {
		if(!pedidos.loteVazio()) vendeIngresso(pedidos.novoPedido());
		else System.out.println("Não há mais pedidos!");
	}
	
	//------------------------------------Getters
	public LotePedidos getPedidos() {
		return pedidos;
	}

	public Sala getSala() {
		return sala;
	}

	public ArrayList<Pedido> getPedidosAprovados() {
		return pedidosAprovados;
	}

	public ArrayList<Pedido> getPedidosNegados() {
		return pedidosNegados;
	}
	
	
}
