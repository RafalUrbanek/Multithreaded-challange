package service;

import java.io.IOException;
import java.net.Socket;

public interface CinemaService {

    void generateNewUserConnection(Socket socket) throws IOException;

    Boolean saveMovieToSchedule(Socket connection) throws IOException;

    void activeThreads();
}
