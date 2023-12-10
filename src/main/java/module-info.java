module com.example.clicker {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.kwhat.jnativehook;


    opens com.example.clicker to javafx.fxml;
    exports com.example.clicker;
}