package client.controllers;

import client.models.UniversalLocalizationModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EnterDistanceController {

    private MainWindowCollectionController mainWindowCollectionController;
    private UniversalLocalizationModel universalLocalizationModel;

    @FXML
    private TextArea distance;

    @FXML
    private Button done;

    @FXML
    private Label result;

    private Float dist;


    public Float getDist ( ) {
        return dist;
    }

    public Button getDone ( ) {
        return done;
    }

    public void onActionDone (ActionEvent actionEvent) throws IOException {
        try {
            dist = Float.parseFloat(distance.getText( ));
            if (dist <= 1) result.setText("Расстояние должно быть > 1");
            else {
                result.setText("Все супер");
                mainWindowCollectionController.doFilterLess(dist.toString( ));

                new Thread(( ) -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace( );
                    }
                    Platform.runLater(( ) -> {
                        Stage stage = (Stage) done.getScene( ).getWindow( );
                        stage.close( );
                    });
                }).start( );

            }
        } catch (NumberFormatException ex) {
            result.setText("Расстояние должно быть вещественной чиселкой");
        }
    }

    public void setEverything (MainWindowCollectionController mainWindowCollectionController, UniversalLocalizationModel universalLocalizationModel) {
        this.mainWindowCollectionController = mainWindowCollectionController;
        this.universalLocalizationModel = universalLocalizationModel;
    }
}
