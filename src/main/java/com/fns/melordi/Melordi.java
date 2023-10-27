package com.fns.melordi;

import com.fns.melordi.moteur.Instru;
import com.fns.melordi.view.ChangeInstru;
import com.fns.melordi.view.Clavier;
import com.fns.melordi.view.Metronome;
import com.fns.melordi.view.Son;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Melordi extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 600);
        Instru instru = new Instru();
        Metronome metronome = new Metronome();
        root.getChildren().add(metronome);
        //  FXMLLoader fxmlLoader = new FXMLLoader(Melordi.class.getResource("hello-view.fxml"));
        Clavier clavier = new Clavier(instru);
        root.getChildren().add(clavier);

        instru.note_on(65);
        Son son = new Son(clavier);
        instru.volume.bind(son.slider.valueProperty());
        root.getChildren().add(son);



        stage.setTitle("Hello!");
        stage.setScene(scene);
        ChangeInstru changeInstru = new ChangeInstru(instru);
        root.getChildren().add(changeInstru);
        clavier.requestFocus();
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}