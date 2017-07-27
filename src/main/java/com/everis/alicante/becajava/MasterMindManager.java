package com.everis.alicante.becajava;

import java.util.ArrayList;
import java.util.List;

public class MasterMindManager {
	
	int intentosRestantes=10;
	List<Integer> numerosIntentados = new ArrayList<Integer>();
	Integer numeroInicial;
	boolean win=false;
	
	public MasterMindManager(Integer numeroInicial) {
		this.numeroInicial = numeroInicial;
	}
	
	public ConsultaNumeroResult ConsultarNumero(Integer numero) {
		ConsultaNumeroResult consulta = new ConsultaNumeroResult();
		String numeroString = numero.toString();
		// Correccion de digitos
		switch (numeroString.length()) {
		case 0:
			numeroString = "00000";
			break;
		case 1:
			numeroString = "0000" + numeroString;
			break;
		case 2:
			numeroString = "000" + numeroString;
			break;
		case 3:
			numeroString = "00" + numeroString;
			break;
		case 4:
			numeroString = "0" + numeroString;
			break;
		default:
			break;
		}

		String numeroInicialString = numeroInicial.toString();
		// Correccion de digitos
		switch (numeroInicialString.length()) {
		case 0:
			numeroInicialString = "00000";
			break;
		case 1:
			numeroInicialString = "0000" + numeroInicialString;
			break;
		case 2:
			numeroInicialString = "000" + numeroInicialString;
			break;
		case 3:
			numeroInicialString = "00" + numeroInicialString;
			break;
		case 4:
			numeroInicialString = "0" + numeroInicialString;
			break;
		default:
			break;
		}
		
		
		for (int i = 0; i <5; i++) {
			if (numeroString.charAt(i) == numeroInicialString.charAt(i)) {
				consulta.setNegras(consulta.getNegras()+1);
				System.out.println("Coincide en la posicion "+ (i+1) + " el numero: "+ numeroString.charAt(i));
			}

		}
		if (consulta.getNegras() == 5) {
			this.setWin();
			intentosRestantes = 0;
		} else {
			
			for (int i = 0; i <5; i++) {
				for (int j = 0; j <5; j++) {
					if (numeroString.charAt(j) == numeroInicialString.charAt(i)) {
						consulta.setBlancas(consulta.getBlancas()+1);
						j=5;
					}	
				}
			}	
			consulta.setBlancas(consulta.getBlancas()-consulta.getNegras());
			numerosIntentados.add(numero);
			intentosRestantes = intentosRestantes -1;
		}
		return consulta;

	}
	
	
	public int getIntentosRestantes() {
		return intentosRestantes;
	}
	
	public boolean tieneIntentos() {
		if(intentosRestantes >= 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isWin() {
		return win;
	}

	public void setWin() {
		win = true;
	}	
	
}
