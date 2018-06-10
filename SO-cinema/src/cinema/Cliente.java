package cinema;

public class Cliente extends Thread{
	
	SistemaVenda venda;
	
	public Cliente(SistemaVenda venda,String nome) {
		super(nome);
		this.venda = venda;
	}
	
	@Override
	public void run() {
		while(!venda.getPedidos().loteVazio()){
			try {
				venda.novoPedido();
				venda.getPedidos();
				System.out.println(this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
