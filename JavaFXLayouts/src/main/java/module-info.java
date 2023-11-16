module com.example.javafxlayouts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxlayouts to javafx.fxml;
    exports com.example.javafxlayouts;
}