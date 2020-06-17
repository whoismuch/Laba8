package server.armory;

import server.receiver.collection.Navigator;
import server.receiver.collection.RouteBook;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class GetFromClient implements Runnable {

    private Socket incoming;
    private DataBase db;
    private Navigator navigator;
    private RouteBook routeBook;
    private Object obj;
    private ExecutorService executorService;
    private SendToClient sendToClient;
    private Driver driver;
    private List<Socket> clients;
    private Socket listener;


    public GetFromClient (Socket incoming, Socket listener, List<Socket> clients, DataBase db, Navigator navigator, RouteBook routeBook, Driver driver, ExecutorService executorService, SendToClient sendToClient) {
        this.incoming = incoming;
        this.db = db;
        this.navigator = navigator;
        this.routeBook = routeBook;
        this.executorService = executorService;
        this.sendToClient = sendToClient;
        this.driver = driver;
        this.clients = clients;
        this.listener = listener;

    }

    public void run ( ) {
        try {
            ObjectInputStream get = new ObjectInputStream(incoming.getInputStream( ));
            obj = get.readObject( );

            Thread childTread = new Thread(new ServerConnection(obj, incoming, listener, clients, db, routeBook, navigator, driver, executorService, sendToClient));
            childTread.start( );
        } catch (EOFException e) {
            System.out.println("Клиент решил внезапно покинуть нас");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }
    }

}