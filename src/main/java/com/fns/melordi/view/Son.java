package com.fns.melordi.view;

import com.fns.melordi.Melordi;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;

public class Son extends Parent {
    public Slider slider;
    private Clavier clavier;
    public Son( Clavier cla){
        slider = new Slider(0,127,60);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setTranslateY(40);
        slider.setTranslateX(7);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
             cla.requestFocus();
            }
        });
        ProgressIndicator indicator = new ProgressIndicator();
        indicator.progressProperty().bind(slider.valueProperty().divide(127.0));
        indicator.setTranslateY(2.5);
        this.getChildren().add(slider);
        this.getChildren().add(indicator);
        this.setTranslateY(350);
        this.setTranslateX(60);
    }
}
