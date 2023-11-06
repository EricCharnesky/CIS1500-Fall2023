module com.example.lotto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lotto to javafx.fxml;
    exports com.example.lotto;
}