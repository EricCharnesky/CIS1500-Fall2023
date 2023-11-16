module com.example.coffeeshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coffeeshop to javafx.fxml;
    exports com.example.coffeeshop;
}