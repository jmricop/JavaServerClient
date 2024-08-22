package ServerController;

import java.net.Socket;

public class ClientHandler implements Runnable {
    
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }


    public void run() {

    }
}
