/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author neong
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

import ServerController.ClientHandler;
public class Server {

    private static final int SERVER_PORT = 4000; 

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // Create a server socket on port 12345
            serverSocket= new ServerSocket(SERVER_PORT);
            System.out.println("Server waiting for connections...");

            // Wait for a client to connect
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                
                ClientHandler newClient = new ClientHandler(clientSocket);
                new Thread(newClient).start();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
