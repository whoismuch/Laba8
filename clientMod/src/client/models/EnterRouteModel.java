package client.models;

import java.util.Locale;

public class EnterRouteModel {

    private ClientProviding clientProviding;

    public EnterRouteModel (ClientProviding clientProviding) {
        this.clientProviding = clientProviding;
    }

    public String checkRoute (Locale locale, String name, String coordX, String coordY, String fromName, String fromX, String fromY, String toName, String toX, String toY, String distance) {
        String result = clientProviding.getUserManager().checkRoute(locale, 0, name, coordX, coordY, fromName, fromX, fromY, toName, toX, toY, distance);
        return result;
    }

}
