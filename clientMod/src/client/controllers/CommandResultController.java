package client.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import javafx.stage.WindowEvent;

public class CommandResultController {

    private MainWindowCollectionController mainWindowCollectionController;

    public void setMainWindowCollectionController (MainWindowCollectionController mainWindowCollectionController) {
        this.mainWindowCollectionController = mainWindowCollectionController;
    }

    @FXML
    private TextArea text;

    public void setResult(String result) {
        text.setText(result);
    }

    public TextArea getText ( ) {
        return text;
    }
}
