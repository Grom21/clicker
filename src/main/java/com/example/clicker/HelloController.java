package com.example.clicker;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
//    private boolean button = false;

    @FXML
    protected void onHelloButtonClick() {
        //переделать кнопку под выход, а текст (инструкцию) выводить постоянно!
        welcomeText.setText("By-by");
        System.exit(0);


    }
}