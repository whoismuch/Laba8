package client;

import client.controllers.AuthenticationController;
import client.controllers.ConnectionController;
import client.controllers.EnterRouteController;
import client.controllers.MainWindowCollectionController;
import client.models.ClientProviding;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class ClientApp extends Application {

    private Stage primaryStage;
    private static ClientProviding clientProviding;
    private MainWindowCollectionController mainWindowCollectionController;
    private String address;
    private String port;

    /**
     * @param args массив по умолчанию в основном методе. Не используется здесь.
     */
    public static void main (String[] args) {
        clientProviding = new ClientProviding( );
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {


        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RouteApp");

        InputStream stream = getClass( ).getResourceAsStream("fxmls/Connection.fxml");
        FXMLLoader loader = new FXMLLoader( );
        VBox vBox = loader.load(stream);
        // Отображаем сцену, содержащую корневой макет.

        ConnectionController connectionController = loader.getController( );
        ConnectionController cc = connectionController;
        cc.setEverything(clientProviding, this);
        loader.setController(cc);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show( );

        primaryStage.show( );
    }

    public void showAthorization (String address, String port) throws IOException {

        this.address = address;
        this.port = port;
        InputStream stream = getClass( ).getResourceAsStream("fxmls/Authentication.fxml");
        FXMLLoader loader = new FXMLLoader( );
        VBox vBox = loader.load(stream);
        // Отображаем сцену, содержащую корневой макет.

        AuthenticationController authenticationController = loader.getController( );
        AuthenticationController ac = authenticationController;
        ac.setEverything(clientProviding, this);
        loader.setController(ac);

        Stage stage = new Stage( );
        stage.setTitle("RouteApp");
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show( );
    }

    public void showMainWindow ( ) throws IOException {
        InputStream stream = getClass( ).getResourceAsStream("fxmls/MainWindowCollection.fxml");
        FXMLLoader loader = new FXMLLoader( );
        TabPane tabPane = loader.load(stream);
        // Отображаем сцену, содержащую корневой макет.


        MainWindowCollectionController mainWindowCollectionController = loader.getController( );
        MainWindowCollectionController mwcc = mainWindowCollectionController;

        mwcc.setEverything(clientProviding, this, address, port);
        loader.setController(mwcc);
        this.mainWindowCollectionController = mwcc;
        clientProviding.setMainController(mwcc);

        Stage stage = new Stage( );
        stage.setTitle("RouteApp");
        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.show( );
    }

    public FXMLLoader showCommandResult ( ) throws IOException {
        InputStream stream = getClass( ).getResourceAsStream("fxmls/CommandResult.fxml");
        FXMLLoader loader = new FXMLLoader( );
        BorderPane borderPane = loader.load(stream);

        Stage stage = new Stage( );
        stage.setTitle("CommandResult");
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show( );

        return loader;
    }

    public FXMLLoader showEnterRoute ( ) throws IOException {
        InputStream stream = getClass( ).getResourceAsStream("fxmls/EnterRoute.fxml");
        FXMLLoader loader = new FXMLLoader( );
        VBox vBox = loader.load(stream);

        EnterRouteController enterRouteController = loader.getController( );
        EnterRouteController erc = enterRouteController;

        erc.setMainWindowCollectionController(mainWindowCollectionController);

        erc.setEverything(clientProviding, this);
        loader.setController(erc);

        Stage stage = new Stage( );
        stage.setTitle("EnterRoute");
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show( );

        return loader;

    }
}

