package com.example.coffeeshop;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private RadioButton espressoRadioButton;
    @FXML
    private ToggleGroup beverageToggleGroup;
    @FXML
    private RadioButton latteRadioButton;
    @FXML
    private RadioButton coffeeRadioButton;
    @FXML
    private Label receiptLabel;
    @FXML
    private CheckBox halfAndHalfCheckBox;
    @FXML
    private CheckBox milkCheckBox;
    @FXML
    private CheckBox soyMilkCheckBox;
    @FXML
    private Slider milkSlider;

    Beverage beverage;
    ArrayList<Beverage> order;
    @FXML
    private TextField customerNameTextField;
    @FXML
    private TextArea orderTextArea;

    // can't use a constructor here, because the FX stuff isn't loaded
    public HelloController() {
        //showReceipt();
    }

    // kind of like a constructor - this runs AFTER the javafx stuff is added
    public void initialize() {
        showReceipt();
    }

    @FXML
    public void beverageRadioButtonClicked(ActionEvent actionEvent) {
//        if ( actionEvent.getSource() == espressoRadioButton ){
//            receiptLabel.setText("Espresso $1.50");
//        } else if ( actionEvent.getSource() == coffeeRadioButton ){
//            receiptLabel.setText("Coffee $1.00");
//        } else if ( actionEvent.getSource() == latteRadioButton ){
//            receiptLabel.setText("Latte $2.00");
//        }
        showReceipt();
    }

    private void showReceipt() {

        double totalCost = 0;
        if (espressoRadioButton.isSelected()) {
            beverage = new Beverage("Espresso");
        } else if (coffeeRadioButton.isSelected()) {
            beverage = new Beverage("Coffee");
        } else if (latteRadioButton.isSelected()) {
            beverage = new Beverage("Latte");
        }
        int numberOfMilksToAdd = (int) milkSlider.getValue();
        if (milkCheckBox.isSelected()) {
            beverage.addAddin("milk", numberOfMilksToAdd);
        }
        if (halfAndHalfCheckBox.isSelected()) {
            beverage.addAddin("half and half", numberOfMilksToAdd);
        }
        if (soyMilkCheckBox.isSelected()) {
            beverage.addAddin("soy milk", numberOfMilksToAdd);
        }

        receiptLabel.setText(beverage.getReceipt());
    }

    @FXML
    public void addinCheckBoxChecked(ActionEvent actionEvent) {
        showReceipt();
    }

    @FXML
    public void milkSliderScroll(Event event) {
        showReceipt();
    }

    @FXML
    public void addToOrderButtonClicked(ActionEvent actionEvent) {
        beverage.setCustomerName(customerNameTextField.getText());
        orderTextArea.appendText(beverage.getReceipt() + "\n");
        customerNameTextField.setText("");
    }
}