package cinema;

public enum TipoPedido {
	CONSULTA(1),
	CONSULTA_RESERVA_E_NAO_COMPRA(2),
	CONSULTA_RESERVA_E_COMPRA(3);
	
	private int tipo;
	
	TipoPedido(int tipo) {
	  this.tipo = tipo;
	}
	
	public int getTipo() {
        return tipo;
    }
}
