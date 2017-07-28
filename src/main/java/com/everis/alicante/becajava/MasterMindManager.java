package com.everis.alicante.becajava;

import java.util.ArrayList;
import java.util.List;

public class MasterMindManager {
	
	int intentosRestantes=10;
	List<String> numerosIntentados = new ArrayList<String>();
	String numeroInicial;
	boolean win=false;
	
	public MasterMindManager(String numeroInicial) {
		this.numeroInicial = numeroInicial;
	}
	
	public ConsultaNumeroResult ConsultarNumero(String numero) {
		ConsultaNumeroResult consulta = new ConsultaNumeroResult();
		
		// Correccion de digitos
		switch (numero.length()) {
		case 0:
			numero = "00000";
			break;
		case 1:
			numero = "0000" + numero;
			break;
		case 2:
			numero = "000" + numero;
			break;
		case 3:
			numero = "00" + numero;
			break;
		case 4:
			numero = "0" + numero;
			break;
		default:
			break;
		}

		
		// Correccion de digitos
		switch (numeroInicial.length()) {
		case 0:
			numeroInicial = "00000";
			break;
		case 1:
			numeroInicial = "0000" + numeroInicial;
			break;
		case 2:
			numeroInicial = "000" + numeroInicial;
			break;
		case 3:
			numeroInicial = "00" + numeroInicial;
			break;
		case 4:
			numeroInicial = "0" + numeroInicial;
			break;
		default:
			break;
		}
		
		
		for (int i = 0; i <5; i++) {
			if (numero.charAt(i) == numeroInicial.charAt(i)) {
				consulta.setNegras(consulta.getNegras()+1);
				System.out.println("Coincide en la posicion "+ (i+1) + " el numero: "+ numero.charAt(i));
			}

		}
		if (consulta.getNegras() == 5) {
			this.setWin();
			intentosRestantes = 0;
		} else {
			
			for (int i = 0; i <5; i++) {
				for (int j = 0; j <5; j++) {
					if (numero.charAt(j) == numeroInicial.charAt(i)) {
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
