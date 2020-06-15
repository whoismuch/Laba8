package client.models;

import common.generatedClasses.Route;

import java.io.IOException;
import java.util.ArrayList;
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
        clientProviding.getMap();
        clientProviding.sendCommand("info");
        return clientProviding.getResult();
    }

    public String sumOfDistanceCommand () throws IOException {
        clientProviding.clientWork();
        clientProviding.getMap();
        clientProviding.sendCommand("sum_of_distance");
        return clientProviding.getResult();
    }

    public String historyCommand ( ) throws IOException {
        clientProviding.clientWork();
        clientProviding.getMap();
        clientProviding.sendCommand("history");
        return clientProviding.getResult();
    }

    public String clearCommand ( ) throws IOException {
        clientProviding.clientWork();
        clientProviding.getMap();
        clientProviding.sendCommand("clear");
        return clientProviding.getResult();
    }

    public void addCommand (Route route) throws IOException {
        clientProviding.clientWork();
        clientProviding.getMap();
        clientProviding.sendCommand("add");
        clientProviding.getResult();
    }

}
