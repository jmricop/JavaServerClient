/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author neong
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    

    public static void main(String[] args){
        String user;
        try {
            // Connect to the server on port 12345
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to the server");

            // Set up output to the server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Set up input from the keyboard
            Scanner scanner = new Scanner(System.in);

            // Send messages to the server
            System.out.println("Write your name");
            user = scanner.nextLine();
            
            while (true) {
                System.out.print("Type a message for the server: ");
                String message = scanner.nextLine();
                writer.println(user + ": "+message);

                if ("bye".equalsIgnoreCase(message)) {
                    // If the client types "bye", exit the loop
                    break;
                }
            }

            // Close sockets
            writer.close();
            scanner.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}