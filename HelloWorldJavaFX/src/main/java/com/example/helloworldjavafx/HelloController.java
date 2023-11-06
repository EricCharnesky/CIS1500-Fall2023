package com.example.helloworldjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Hello World!");
    }

    @FXML
    public void onOtherButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Oh no, you clicked the button!");
    }
}