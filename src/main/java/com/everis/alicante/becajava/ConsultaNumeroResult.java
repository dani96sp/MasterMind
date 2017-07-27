package com.everis.alicante.becajava;

public class ConsultaNumeroResult {
	private int negras;
	private int blancas;
	

	@Override
	public String toString() {
		return "Numero de negras: " + negras + "\nNumero de blancas: " + blancas;
	}

	public int getNegras() {
		return negras;
	}

	public void setNegras(int negras) {
		this.negras = negras;
	}

	public int getBlancas() {
		return blancas;
	}

	public void setBlancas(int blancas) {
		this.blancas = blancas;
	}
	
	
	
	
}
