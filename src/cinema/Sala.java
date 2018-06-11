package cinema;

import java.io.IOException;

import arquivo.Arquivo;

public class Sala {

	int qntFilas;
	int cadeirasPorFila;
	String[][] poltronas;


	public Sala() throws IOException {
		Arquivo arq = new Arquivo();
		this.poltronas = arq.lerSala();;
		this.qntFilas = arq.getQntFilas();
		this.cadeirasPorFila = arq.getQntCadeirasPorFila();
	}


	public boolean consultaAssento(int fileira, int cadeira) {
		return true;

	}

	public synchronized boolean reservaAssento(int fileira, int cadeira){
		boolean result = false;
		if(this.poltronas[fileira][cadeira].equals("1")) {
			this.poltronas[fileira][cadeira] = "X";
			result=true;
		}
		return result;
	}

	public synchronized boolean compraAssento(int fileira, int cadeira){
		boolean result = false;
		if(reservaAssento(fileira, cadeira)){
			result = true;
		}

		return result;
	}

	public synchronized boolean retiraReserva(int fileira, int cadeira) {
		boolean result = false;
		if(this.poltronas[fileira][cadeira].equals("X")) {
			this.poltronas[fileira][cadeira] = "1";
			result = true;
		}
		return result;
	}


	public void escreverSala() {
		if(qntFilas == 0) System.out.println("Nao existe sala!");
		else {

			for(String[] assentos2 : poltronas){
				for(String assento : assentos2){
					System.out.print(assento + "");
				}
				System.out.println();
			}
		}
	}

	//------------------------Getters 
	public int getQntFilas() {
		return qntFilas;
	}


	public int getCadeirasPorFila() {
		return cadeirasPorFila;
	}


	public String[][] getPoltronas() {
		return poltronas;
	}

}
