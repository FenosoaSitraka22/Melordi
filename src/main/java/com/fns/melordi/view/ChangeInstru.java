package com.fns.melordi.view;

import com.fns.melordi.Melordi;
import com.fns.melordi.moteur.Instru;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChangeInstru extends Parent {
    private Instru instru;
    private RadioButton radioButtonPiano;
    private  RadioButton radioButtonGuitare;
    private  RadioButton radioButtonOrgue;
    public ChangeInstru(Instru instru){
        this.instru = instru;
        GridPane gp = new GridPane();
        ImageView imageViewPiano = new ImageView();
      //  System.out.println(Melordi.class.getResource("images/piano.png")+"-----------");
        //images piano, guiare et orgue
        imageViewPiano.setImage(new Image(Melordi.class.getResource("images/piano.png").toString()));
        imageViewPiano.setFitHeight(80);
        imageViewPiano.setPreserveRatio(true);
        ImageView imageViewGuitare = new ImageView();
        imageViewGuitare.setImage(new Image(Melordi.class.getResource("images/guitare.png").toString()));
        imageViewGuitare.setFitHeight(80);
        imageViewGuitare.setPreserveRatio(true);
        ImageView imageViewOrgue = new ImageView();
        imageViewOrgue.setImage(new Image(Melordi.class.getResource( "images/orgue.png").toString()));
        imageViewOrgue.setFitHeight(80);
        imageViewOrgue.setPreserveRatio(true);
        //ajoput dans le Grid panne
        gp.add(imageViewPiano,1,0);
        gp.add(imageViewGuitare,1,1);
        gp.add(imageViewOrgue,1,2);
        //button de selection d'instrument
        radioButtonPiano = new RadioButton();
        radioButtonGuitare = new RadioButton();
        radioButtonOrgue = new RadioButton();
        //grouper les btnradion
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonPiano.setToggleGroup(toggleGroup);
        radioButtonGuitare.setToggleGroup(toggleGroup);
        radioButtonOrgue.setToggleGroup(toggleGroup);
        //tsy hay
        radioButtonPiano.setFocusTraversable(false);
        radioButtonGuitare.setFocusTraversable(false);
        radioButtonOrgue.setFocusTraversable(false);
        radioButtonPiano.setSelected(true);
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue  observableValue, Toggle toggle, Toggle t1) {
                if (t1.equals(radioButtonPiano)) instru.setInstrument(0); //set to piano
                else if (t1.equals(radioButtonGuitare)) instru.setInstrument(26); // set to guitare
                else instru.setInstrument(16); // set to orgue
            }
        });
        gp.add(radioButtonPiano,0,0);
        gp.add(radioButtonGuitare,0,1);
        gp.add(radioButtonOrgue,0,2);

        gp.setVgap(20);
        gp.setHgap(20);
        this.setTranslateX(100);
        this.setTranslateY(20);
        this.getChildren().add(gp);
    }
}
