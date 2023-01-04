package service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CommunicationServiceImpl implements CommunicationService {

    public CommunicationServiceImpl() throws IOException {

        System.out.println("Server started");
            ServerSocket serverSocket = new ServerSocket(1234);
            try {
                while(true) {
                    Socket socket = serverSocket.accept();
                    Thread thread = new Thread(()-> {
                        Boolean flag = true;
                        System.out.println(socket);
                            while(flag){
                                try {
                                    System.out.println("in inner while");
                                    flag = acceptNewConnection(socket);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }
                    });
                    thread.start();
                    // nowy thread z metoda acceptNewConnection(socket) z outputStream
                    //, calosc opleciona whilem tak dlugo jak istnieje polaczenie
                }
            } finally {
                serverSocket.close();
        }
    }
    //initialize your socket
    //provide run cinemaMenu() method

    public Boolean acceptNewConnection(Socket socket) throws IOException {
        DataInputStream input = new DataInputStream(socket.getInputStream());
        System.out.println("input: " + input);
        String answer = input.readUTF();
        System.out.println("answer: " + answer);
        return !answer.equals("new connection set");
    }

        //in this method you need to send message to server with information for example: I would like to buy a ticket
        //dont worry in this step about row and column your ticket
        //only simple information

        //mode argument from cinemaMenu: 1 - buy ticket
}