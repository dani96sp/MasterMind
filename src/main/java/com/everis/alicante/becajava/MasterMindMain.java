package com.everis.alicante.becajava;

import java.io.IOException;
import java.util.Scanner;

import mingorance.cano.socket.commondomain.Message;
import mingorance.cano.socket.commondomain.MessageType;
import mingorance.enrique.client.ClientException;
import mingorance.enrique.client.SocketClientRunner;
import mingorance.enrique.commandlinemenu.Menu;
import mingorance.enrique.commandlinemenu.MenuBuilder;
import mingorance.enrique.socket.server.ServerException;
import mingorance.enrique.socket.server.SocketServerRunner;

public class MasterMindMain {

	public static void main(String[] args) throws IOException, ServerException, ClientException {
		
        Menu subMenu1 = MenuBuilder.createSubMenu("Menu Secundario 1", 1)
                .addSimpleOption(1, "Iniciar aplicacion offline")
                .addSimpleOption(2, "Conectarse a una partida Local")
                .addSimpleOption(3, "Opcion 3")
                .addSimpleOption(4, "Opcion 4")
                .addExitOption(0, "Salir")
                .build();

        Menu subMenu2 = MenuBuilder.createSubMenu("Menu Secundario 2", 2)
                .addSimpleOption(1, "Abrir partida en Local")
                .addSimpleOption(2, "Opcion 2")
                .addSimpleOption(3, "Opcion 3")
                .addSimpleOption(4, "Opcion 4")
                .addExitOption(0, "Salir")
                .build();


        Menu mainMenu = MenuBuilder.createMainMenu("Menu Principal")
                .addSubMenuOption("Jugar", subMenu1)
                .addSubMenuOption("Hostear partida", subMenu2)
                .addExitOption(0, "Salir")
                .build();

        switch(mainMenu.play()) {
    	case "1.1": 
    		iniciarAplicacionOffline();
    		break;
    	case "1.2": 
    		jugarLocal();
    		break;
    	case "1.3":
    		
    		break;
    	case "1.4": 
    		break;
    	case "2.1": 
    		iniciarServidor();
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

	private static void iniciarAplicacionOffline() {
		// Generamos un numero al azar de 5 cifras cuando se ejecuta el programa
//		String random = String.valueOf(Math.round(Math.random()*100000));
		String random = String.valueOf(12345);
		System.out.println("Bienvenido al videojuego Master Mind");
		MasterMindManager game = new MasterMindManager(random);
		
	

		System.out.println("Se ha generado un numero aleatorio de 5 cifras, prueba a adivinarlo.");
		
		do {
			System.out.println("Tienes " + game.getIntentosRestantes() +  " intentos");
			System.out.println("Inserte un numero: ");
			Scanner sc = new Scanner(System.in);
			Integer numero = sc.nextInt();
			if(numero <= 0 || numero >= 99999) {
				System.out.println("Numero invalido, inserte un numero entre el 0 y el 99999");
			} else {
				// Empieza el juego
				String numeroString = String.valueOf(numero);
				System.out.println(game.ConsultarNumero(numeroString));
			}
		}while (game.tieneIntentos());
		
		if (game.isWin()) {
			System.out.println("Has ganado!");
			System.out.println("Has intentado los siguientes numeros: " + game.numerosIntentados);
		}else {
			System.out.println("Has perdido!");
		}		
	}
	
	
	private static void iniciarServidor() throws IOException, ServerException {
//		String random = String.valueOf(Math.round(Math.random()*100000));
		String random = String.valueOf(12345);
		String nextNumber = "";
		Integer numero;
//		 <Server>
		 final SocketServerRunner socketServerRunner = SocketServerRunner.getInstance();
		 socketServerRunner.run(4200);
		 Message message;
		 message = socketServerRunner.getLastMessageFromPool();
		 System.out.println(String.format("Message received from client. Type: %s, Message: %s"
				 , message.getType()
				 , message.getMessage()));
//		 <Server/>
		 Scanner sc = new Scanner(System.in);
		 MasterMindManager game = new MasterMindManager(random);
		 
		 Message msg = null;
		 
		 do{
			 message = socketServerRunner.getLastMessageFromPool();
//			 System.out.println(random);
			 System.out.println("Tienes " + game.getIntentosRestantes() +  " intentos");
			 nextNumber = message.getMessage();
			 numero = Integer.parseInt(nextNumber);
				if(numero <= 0 || numero >= 99999) {
					 message = socketServerRunner.getLastMessageFromPool();
					System.out.println("Numero invalido, inserte un numero entre el 0 y el 99999");
				} else {
			 	 game.ConsultarNumero(nextNumber);
				 msg = Message.fromString(nextNumber);
				 socketServerRunner.sendToClient(msg);
			 }
		 }while (game.tieneIntentos());
		
			if (game.isWin()) {
				 message = socketServerRunner.getLastMessageFromPool();
				System.out.println("Has ganado!");
				 message = socketServerRunner.getLastMessageFromPool();
				System.out.println("Has intentado los siguientes numeros: " + game.numerosIntentados);
			}else {
				 message = socketServerRunner.getLastMessageFromPool();
				System.out.println("Has perdido!");
			}	
	}
	
	
	
	private static void jugarLocal() throws IOException, ClientException {
		final SocketClientRunner socketClientRunner = SocketClientRunner.getInstance();
        socketClientRunner.run("localhost", 4200);

        String message;
        String resultado = "";
        do {   	
            System.out.println("Insert a value to send to the server");
            Scanner in = new Scanner(System.in);
            message = in.nextLine();
            socketClientRunner.sendToServer(MessageType.MESSAGE, message);
            System.out.println(socketClientRunner.waitServer().getMessage());
        } while (!"exit".equalsIgnoreCase(message));
		
	}
	
	
}
