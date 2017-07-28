package com.everis.alicante.becajava;

import java.io.IOException;
import java.util.Scanner;

import mingorance.cano.socket.commondomain.MessageType;
import mingorance.enrique.client.ClientException;
import mingorance.enrique.client.SocketClientRunner;

public class MasterMindClientMain {

	public static void main(String[] args) throws IOException, ClientException {
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
