package cinema;

public class Ingresso {
	
	private String fileira;
	private String cadeira;
	private boolean vendido;
	
	public Ingresso(String fileira, String cadeira) {
		this.fileira = fileira;
		this.cadeira = cadeira;
		this.vendido = vendido;
	}
	
	
	
	public String getPoltrona() {
		return "Poltrona" + getFileira()+" "+ " " + getCadeira(); 
	}
	
	//-------------Getters and Setters
	public String getFileira() {
		return fileira;
	}

	public void setFileira(String fileira) {
		this.fileira = fileira;
	}

	public String getCadeira() {
		return cadeira;
	}

	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	
}
