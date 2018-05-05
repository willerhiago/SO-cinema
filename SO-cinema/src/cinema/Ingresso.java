package cinema;

public class Ingresso {
	
	private int tipo;
	private int fileira;
	private int cadeira;
	private int tempo;
	
	
	
	
	public Ingresso(int tipo, int fileira, int cadeira, int tempo) {
		this.tipo = tipo;
		this.fileira = fileira;
		this.cadeira = cadeira;
		this.tempo = tempo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------Getters and Setters
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getFileira() {
		return fileira;
	}
	public void setFileira(int fileira) {
		this.fileira = fileira;
	}
	public int getCadeira() {
		return cadeira;
	}
	public void setCadeira(int cadeira) {
		this.cadeira = cadeira;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
