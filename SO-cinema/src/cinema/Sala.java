package cinema;

import java.io.IOException;

import arquivo.Arquivo;

public class Sala {

	String[][] poltronas;
	
	
	public Sala() throws IOException {
		Arquivo arq = new Arquivo();
		this.poltronas = arq.ler("sala.txt");
	}
}
