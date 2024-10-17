module com.example.ejerciciob {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejerciciob to javafx.fxml;
    exports com.example.ejerciciob;
}