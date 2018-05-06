package cinema;

public class Pedido {
	
	private int tipo;
	private Ingresso ingresso;
	private int tempo;
	private int count;
	
	
	public Pedido(){}
	
	public Pedido(int tipo, int fileira, int cadeira, int tempo){
		this.tipo = tipo;
		this.tempo = tempo;
		this.ingresso = new Ingresso(fileira,cadeira);
	}
	
	
	public int executaTempo() {
		count++;
		return count;
	}

	public String toString(){
		return "Tipo: " + this.tipo + " " + ingresso.getPoltrona() +" Tempo: "+this.tempo;
		
	}
	
	public void pedidoAprovado(int fileira, int cadeira) {
		this.ingresso.setFileira(fileira);
		this.ingresso.setCadeira(cadeira);
		this.ingresso.setVendido(true);
	}
	
	public void pedidoNegado(int fileira, int cadeira) {
		this.ingresso.setFileira(fileira);
		this.ingresso.setCadeira(cadeira);
		this.ingresso.setVendido(false);
	}
	//------------------Getters
	
	public int getTipo() {
		return tipo;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public int getTempo() {
		return tempo;
	}
	
}
