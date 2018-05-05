package main;

import java.io.IOException;

import arquivo.Arquivo;

public class Main {

	public static void main(String[] args) {
		
		  Arquivo arq = new Arquivo();

	        String[][] assentos;
			try {
				assentos = arq.ler("sala.txt");
				int disponivel=0, indisponivel=0;

		        if(assentos != null)
		            for(String[] assentos2 : assentos){
		                for(String assento : assentos2){
		                    if(assento == "1"){
		                        disponivel++;
		                    }else{
		                        indisponivel++;
		                    }
		                    System.out.print(assento + "");
		                }
		                System.out.println();
		            }
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	}

}
