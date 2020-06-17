package client.models;

import common.generatedClasses.Route;

import java.io.IOException;
import java.util.LinkedHashSet;

public class MainWindowCollectionModel {

    private ClientProviding clientProviding;

    public MainWindowCollectionModel (ClientProviding clientProviding) {
        this.clientProviding = clientProviding;
    }

    public LinkedHashSet<Route> giveMeMyCollection () throws IOException {
        return clientProviding.getRoutes( );
    }

    public String infoCommand() throws IOException {
        clientProviding.clientWork();
        return clientProviding.sendCommand("info");
    }

    public String sumOfDistanceCommand () throws IOException {
        clientProviding.clientWork();
        return clientProviding.sendCommand("sum_of_distance");
    }

    public String historyCommand ( ) throws IOException {
        clientProviding.clientWork();
        return clientProviding.sendCommand("history");
    }

    public String clearCommand ( ) throws IOException {
        clientProviding.clientWork();
        return clientProviding.sendCommand("clear");
    }

    public void addCommand (Route route) throws IOException {
        clientProviding.clientWork();
        clientProviding.sendCommand("add");
    }

}
