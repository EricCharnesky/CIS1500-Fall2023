package com.example.javafxlayouts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private TextArea textArea;
    @FXML
    private Button leftButton;
    @FXML
    private Button upButton;
    @FXML
    private Button downButton;
    @FXML
    private Button rightButton;

    private Coffee coffee;

    public void initialize(){
        textArea.setEditable(false);
        coffee = null;
    }

    @FXML
    public void buttonClicked(ActionEvent actionEvent) {
        if ( actionEvent.getSource() == upButton ){
            textArea.appendText("Up button Clicked!\n");
        } else if ( actionEvent.getSource() == rightButton ){
            textArea.appendText("Right button Clicked!\n");
        }else if ( actionEvent.getSource() == downButton ){
            textArea.appendText("Down button Clicked!\n");
        }else if ( actionEvent.getSource() == leftButton ){
            textArea.appendText("Left button Clicked!\n");
        }

        upButton.setDisable(false);
        rightButton.setDisable(false);
        downButton.setDisable(false);
        leftButton.setDisable(false);

        switch ((int)(Math.random() * 4)){
            case 0:
                upButton.setDisable(true);
                coffee = new Coffee(null);
                break;
            case 1:
                rightButton.setDisable(true);
                coffee = new Coffee("small");
                break;
            case 2:
                downButton.setDisable(true);
                coffee = new Coffee("medium");
                break;
            case 3:
                leftButton.setDisable(true);
                coffee = new Coffee("large");
                break;
        }

        // checking if there is a value or not
        if ( coffee.getSize() != null ){
            textArea.appendText("You found a " + coffee.getSize() + " coffee!\n");
        }

    }
}