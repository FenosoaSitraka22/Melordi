package com.fns.melordi.view;

import com.fns.melordi.moteur.Instru;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;


public class Clavier extends Parent {

    public Clavier(Instru instru){
        Rectangle keybordBackground = new Rectangle();
        keybordBackground.setWidth(400);
        keybordBackground.setHeight(200);
        keybordBackground.setArcWidth(30);
        keybordBackground.setArcHeight(30);
        keybordBackground.setFill(
                new LinearGradient(0f, 0f, 0f, 1f, true,
                        CycleMethod.NO_CYCLE,
                        new Stop[] {
                                new Stop(0, Color.web("#666666")),
                                new Stop(1, Color.web("#000000"))
                        }
                )
        );
        Reflection reflection = new Reflection();
        reflection.setFraction(0.25);
        reflection.setBottomOpacity(0);
        reflection.setTopOpacity(0.5);
        keybordBackground.setEffect(reflection);



        this.setTranslateX(50);
        this.setTranslateY(350);
        Touche touches[] = {
                new Touche("U",50,20,60,instru),
                new Touche("I",128,20,62,instru),
                new Touche("O",206,20,64,instru),
                new Touche("P",284,20,65,instru),
                new Touche("J",50,100,67,instru),
                new Touche("K",128,100,69,instru),
                new Touche("L",206,100,71,instru),
                new Touche("M",284,100,72,instru)
        }  ;


        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
               // System.out.println(keyEvent.getText()+"+++++++++"+ touches[0].lettre.toUpperCase());
                for (Touche touche: touches){
                    if (touche.lettre.equals(keyEvent.getText().toUpperCase())){
                        touche.appuyer();
                    }
                }
            }
        });
        this.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                 for (Touche touche: touches){
                    if(touche.lettre.equals(keyEvent.getText().toUpperCase())) {
                        touche.relacher();
                    }
                }
            }
        });
        this.getChildren().add(keybordBackground);
        for (Touche touche: touches){
            this.getChildren().add(touche);
        }
    }
}
