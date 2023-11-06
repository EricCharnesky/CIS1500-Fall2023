package com.example.lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField maxNumberTextField;
    @FXML
    private TextField numberOfValuesTextField;
    @FXML
    private Label resultsLabel;
    @FXML
    private TextArea ticketTextArea;


    @FXML
    public void findWinnerButtonClick(ActionEvent actionEvent) {
        int numberOfValues = Integer.parseInt(numberOfValuesTextField.getText());
        int maxValue = Integer.parseInt(maxNumberTextField.getText());

        LottoTicket winningTicket = new LottoTicket(numberOfValues, maxValue);
        ticketTextArea.appendText("Winning Ticket: ");
        addTicketToTextArea(winningTicket);

        int numberOfTicketsUntilAWinner = 1;

        LottoTicket anotherTicket  = new LottoTicket(numberOfValues, maxValue);
        addTicketToTextArea(anotherTicket);

        while ( !anotherTicket.isWinner(winningTicket)){
            anotherTicket  = new LottoTicket(numberOfValues, maxValue);
            addTicketToTextArea(anotherTicket);
            numberOfTicketsUntilAWinner++;
        }

        resultsLabel.setText("It took " + numberOfTicketsUntilAWinner + " tickets to get a winner!");

    }

    private void addTicketToTextArea(LottoTicket ticket){
        String numbers = "";
        for ( int number : ticket.getNumbers()){
            numbers += number + " ";
        }

        ticketTextArea.appendText(numbers);
        ticketTextArea.appendText("\n");
    }
}