package cinema;

public class Pedido {
	
	private int tipo;
	private Ingresso ingresso;
	private int tempo;
	
	Pedido(int tipo, String fileira, String cadeira, int tempo){
		this.tipo = tipo;
		this.tempo = tempo;
		this.ingresso = new Ingresso(fileira,cadeira);
	}
	
	public boolean atende(){
		boolean result = false;
		
		switch(tipo) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
		}
		
		return result;
	}
	
	
}
