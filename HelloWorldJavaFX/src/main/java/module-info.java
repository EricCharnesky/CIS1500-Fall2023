module com.example.helloworldjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.helloworldjavafx to javafx.fxml;
    exports com.example.helloworldjavafx;
}