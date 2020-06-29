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
import java.util.ResourceBundle;

public class EnterDistanceController {

    private MainWindowCollectionController mainWindowCollectionController;
    private UniversalLocalizationModel universalLocalizationModel;

    @FXML
    private TextField distanceED;

    @FXML
    private Button doneED;

    @FXML
    private Label resultED;

    private Float dist;

    private ResourceBundle bundle;

    private String result;


    public Float getDist ( ) {
        return dist;
    }

    public Button getDone ( ) {
        return doneED;
    }

    public void onActionDone (ActionEvent actionEvent) throws IOException {
        try {
            dist = Float.parseFloat(distanceED.getText( ));
            if (dist <= 1) {
                result = "Расстояние должно быть > 1";
                resultED.setText(bundle.getString(result));
            }
            else {
                result = "Все супер";
                resultED.setText(bundle.getString(result));
                mainWindowCollectionController.doFilterLess(dist.toString( ));

                new Thread(( ) -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace( );
                    }
                    Platform.runLater(( ) -> {
                        Stage stage = (Stage) doneED.getScene( ).getWindow( );
                        stage.close( );
                    });
                }).start( );

            }
        } catch (NumberFormatException ex) {
            result = "Расстояние должно быть вещественной чиселкой";
            resultED.setText(bundle.getString(result));
        }
    }

    public void setEverything (MainWindowCollectionController mainWindowCollectionController, UniversalLocalizationModel universalLocalizationModel, ResourceBundle bundle) {
        this.mainWindowCollectionController = mainWindowCollectionController;
        this.universalLocalizationModel = universalLocalizationModel;
        this.bundle = bundle;

        Platform.runLater(() -> translate(bundle));

    }

    public void translate(ResourceBundle bundle) {
        this.bundle = bundle;
        universalLocalizationModel.changeLanguage(doneED.getParent(), bundle);
        universalLocalizationModel.updateLabels(resultED, result, bundle);
    }
}
