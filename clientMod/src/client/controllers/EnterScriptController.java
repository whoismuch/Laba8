package client.controllers;

import client.models.ClientProviding;
import common.exceptions.NoPermissionsException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EnterScriptController {
    private MainWindowCollectionController mainWindowCollectionController;
    private ClientProviding clientProviding;

    public void setMainWindowCollectionController (MainWindowCollectionController mainWindowCollectionController) {
        this.mainWindowCollectionController = mainWindowCollectionController;
    }

    @FXML
    private TextArea nameScript;

    @FXML
    private Button done;

    @FXML
    private Label result;

    @FXML
    private TextArea commandResult;


    public Button getDone ( ) {
        return done;
    }

    public void onActionDone (ActionEvent actionEvent) throws IOException {
        try {
            String arg = clientProviding.getUserManager( ).contentOfFile(nameScript.getText( ));
            clientProviding.getUserManager( ).setFinalScript(arg);
            if (arg == null) result.setText("Ммм, скрипт пустой");
            else {
                int commandNumber = clientProviding.getUserManager( ).checkContentOfFile(arg, 0);
                if (commandNumber == 0) {
                    result.setText("Бе, скрипт с ошибочками, такой скрипт мы обработать не сможем");
                } else {
                    arg = clientProviding.getUserManager( ).getFinalScript( );
                    result.setText("Все супер");
                    commandResult.setText(mainWindowCollectionController.doExecScript(arg));


//                    new Thread(( ) -> {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace( );
//                        }
//                        Platform.runLater(( ) -> {
//                            Stage stage = (Stage) done.getScene( ).getWindow( );
//                            stage.close( );
//                        });
//                    }).start( );

                }
            }

        } catch (NoPermissionsException e) {
            result.setText("Недостаточно прав для чтения скрипта");
        } catch (FileNotFoundException e) {
            result.setText("Файла со скриптом по указанному пути не существует");
        } catch (NullPointerException e) {
            result.setText("Файл пуст!");
        }
    }

    public void setEverything (ClientProviding clientProviding, MainWindowCollectionController mainWindowCollectionController) {
        this.clientProviding = clientProviding;
        this.mainWindowCollectionController = mainWindowCollectionController;
    }
}
