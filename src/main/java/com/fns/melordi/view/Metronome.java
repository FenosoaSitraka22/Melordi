package com.fns.melordi.view;

import com.fns.melordi.Melordi;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class Metronome extends Parent {
    public Metronome(){
        ImageView imageMetronome = new ImageView();
        imageMetronome.setImage(new Image(Melordi.class.getResource("images/metronome.png").toString()));
        imageMetronome.setFitHeight(80);
        imageMetronome.setPreserveRatio(true);

        ImageView imageAiguille = new ImageView();
        imageAiguille.setImage(new Image(Melordi.class.getResource("images/aiguille.png").toString()));
        imageAiguille.setFitHeight(90);
        imageAiguille.setPreserveRatio(true);
        imageAiguille.setTranslateX(14);
        imageAiguille.setTranslateY(-10);
        //rotation de l'aiguile autour du pt A(3 ,29)
        Rotate rotate = new Rotate(45,14,64);
        imageAiguille.getTransforms().add(rotate);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,new KeyValue(rotate.angleProperty(),45)),
                new KeyFrame(new Duration(1000), new KeyValue(rotate.angleProperty(),-45))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        this.getChildren().add(imageMetronome);
        this.getChildren().add(imageAiguille);
        this.setTranslateX(400);
        this.setTranslateY(280);
    }
}
