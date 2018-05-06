package cinema;

public class LotePedidos {
	
	private int qntPedidos;
	private Pedido[] pedidos;
	
	public LotePedidos(int qntPedidos){
		this.qntPedidos = qntPedidos;
	}
	
	public void escreverPedidos() {
        if(qntPedidos == 0) System.out.println("Nao existe pedidos!");
        else {
            for(Pedido p : pedidos){
                System.out.println(p.toString());
            }
        }
    }

	//-------------------Getters
	
	public int getQntPedidos() {
		return qntPedidos;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}
	
}
