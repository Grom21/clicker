package com.example.clicker;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;
import java.security.Provider;

public class HelloApplication extends Application {
    public static volatile boolean click = false;
    @Override
    public void start(Stage stage) throws Exception {
        startThreads();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void startThreads() {
        ThreadKeyListener threadKeyListener = new ThreadKeyListener();
        threadKeyListener.start();
        ThreadMouseClicker threadMouseClicker = new ThreadMouseClicker();
        threadMouseClicker.start();
    }

    public static void main(String[] args) {
        launch();
    }
}