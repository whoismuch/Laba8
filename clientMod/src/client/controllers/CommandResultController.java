package client.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextArea;

public class CommandResultController {
    @FXML
    private TextArea text;

    public void setResult(String result) {
        text.setText(result);
    }

    public TextArea getText ( ) {
        return text;
    }
}
