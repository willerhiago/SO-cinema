package cinema;

import java.io.IOException;

import arquivo.Arquivo;

public class Sala {
	
	int qntFilas;
	int cadeirasPorFila;
	String[][] poltronas;
	
	
	public Sala() throws IOException {
		Arquivo arq = new Arquivo();
		this.poltronas = arq.ler("sala.txt");
		this.qntFilas = arq.getQntFilas();
		this.cadeirasPorFila = arq.getQntCadeirasPorFila();
	}
	
	
	public boolean consultaAssento(int fileira, int cadeira) {
		boolean result = false;
		if(this.poltronas[fileira][cadeira] == "1") result = true;
		return result;
		
	}
	
	/*
 
	for(int i=0; i < qntFilas; i++){
		for(int j=0; j < cadeirasPorFila; j++){
			if(this.poltronas[i][j] == "1")result = true;
		}
	}
	*/
}
