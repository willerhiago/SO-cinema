package cinema;

import java.io.IOException;
import java.util.ArrayList;

import arquivo.Arquivo;

public class LotePedidos {
	
	private int qntPedidos;
	private ArrayList<Pedido> pedidos;
	
	public LotePedidos() throws NumberFormatException, IOException{
		Arquivo arq = new Arquivo();
		this.pedidos = arq.lerPedidos();
		this.qntPedidos = arq.getQntPedidos();
	}
	
	public void escreverPedidos() {
        if(qntPedidos == 0) System.out.println("Nao existe pedidos!");
        else {
            for(Pedido p : pedidos){
                System.out.println(p.toString());
            }
        }
    }
	
	public Pedido novoPedido() {
		Pedido pedido = new Pedido();
		pedido = pedidos.remove(0);
		return pedido;
	}
	
	public boolean loteVazio(){
		return pedidos.isEmpty();
	}

	//-------------------Getters
	
	public int getQntPedidos() {
		return qntPedidos;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
}
