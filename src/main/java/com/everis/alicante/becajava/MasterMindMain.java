package com.everis.alicante.becajava;

import java.util.Scanner;

import mingorance.enrique.commandlinemenu.Menu;
import mingorance.enrique.commandlinemenu.MenuBuilder;

public class MasterMindMain {

	public static void main(String[] args) {
//		// Generamos un numero al azar de 5 cifras cuando se ejecuta el programa
//		int random = (int)Math.round(Math.random()*100000);
//		
//		System.out.println("Bienvenido al videojuego Master Mind");
//		MasterMindManager game = new MasterMindManager(random);
//		
//	
//
//		System.out.println("Se ha generado un numero aleatorio de 5 cifras, prueba a adivinarlo.");
//		
//		do {
//			System.out.println("Tienes " + game.getIntentosRestantes() +  " intentos");
//			System.out.println("Inserte un numero: ");
//			Scanner sc = new Scanner(System.in);
//			Integer numero = sc.nextInt();
//			if(numero <= 0 || numero >= 99999) {
//				System.out.println("Numero invalido, inserte un numero entre el 0 y el 99999");
//			} else {
//				// Empieza el juego
//				System.out.println(game.ConsultarNumero(numero));
//			}
//		}while (game.tieneIntentos());
//		
//		if (game.isWin()) {
//			System.out.println("Has ganado!");
//			System.out.println("Has intentado los siguientes numeros: " + game.numerosIntentados);
//		}else {
//			System.out.println("Has perdido!");
//		}
		
        Menu subMenu1 = MenuBuilder.createSubMenu("Menu Secundario 1", 1)
                .addSimpleOption(1, "Opcion 1")
                .addSimpleOption(2, "Opcion2 ")
                .addSimpleOption(3, "Opcion 3")
                .addSimpleOption(4, "Opcion 4")
                .addExitOption(0, "Salir")
                .build();

        Menu subMenu2 = MenuBuilder.createSubMenu("Menu Secundario 2", 2)
                .addSimpleOption(1, "Opcion 1")
                .addSimpleOption(2, "Opcion 2")
                .addSimpleOption(3, "Opcion 3")
                .addSimpleOption(4, "Opcion 4")
                .addExitOption(0, "Salir")
                .build();


        Menu mainMenu = MenuBuilder.createMainMenu("Menu Principal")
                .addSubMenuOption("Jugar YA!", subMenu1)
                .addSubMenuOption("Jugar Online", subMenu2)
                .addExitOption(0, "Salir")
                .build();

        switch(mainMenu.play()) {
    	case "1.1": 
    		
    		break;
    	case "1.2": 
    		break;
    	case "1.3": 
    		break;
    	case "1.4": 
    		break;
    	case "2.1": 
        		break;
       	case "2.2": 
        		break;
       	case "2.3": 
        		break;
       	case "2.4": 
        		break;
    	default:
    		break;
        
        }

		
		
		
		
		
	}
}
