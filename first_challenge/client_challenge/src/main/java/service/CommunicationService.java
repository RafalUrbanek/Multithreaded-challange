package service;

import java.io.IOException;
import java.net.Socket;

public interface CommunicationService {

//    void sendMessage(Integer mode);

//    void receiveMessage();

    Boolean acceptNewConnection(Socket socket) throws IOException;
}
