package cinema;

public class Ingresso {
	
	private int fileira;
	private int cadeira;
	private boolean vendido = false;
	
	public Ingresso(int fileira, int cadeira) {
		this.fileira = fileira;
		this.cadeira = cadeira;
	}
	
	
	
	public String getPoltrona() {
		return "Poltrona: " + getFileira()+" "+ " " + getCadeira(); 
	}
	
	public void vendido() {
		this.vendido = true;
	}
	
	//-------------Getters and Setters
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

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	
}
