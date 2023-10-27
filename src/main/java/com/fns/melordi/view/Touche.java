package com.fns.melordi.view;

import com.fns.melordi.moteur.Instru;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Touche extends Parent {
    public String lettre = new String("X");
    private int posX =0;
    private int posY = 0;
    private  int note =0;
    private Instru instru;
    Rectangle fondTouche = new Rectangle();
    Text lettreTouche = new Text();

    public Touche(String lettre, int x, int y, int n,Instru instru){
        this.lettre = lettre;
        this.posX = x;
        this.posY = y;
        this.note = n;
        this.instru = instru;
        fondTouche = new Rectangle(75,75, Color.WHITE);
        fondTouche.setArcHeight(10);
        fondTouche.setArcWidth(10);
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-5.0);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        fondTouche.setEffect(lighting);
        this.getChildren().add(fondTouche);

        lettreTouche = new Text(lettre);
        lettreTouche.setFont(new Font(25));
        lettreTouche.setFill(Color.GREY);
        lettreTouche.setX(28);
        lettreTouche.setY(45);
        this.getChildren().add(lettreTouche);
        //position de la touche
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fondTouche.setFill(Color.gray(0.5));
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fondTouche.setFill(Color.WHITE);
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                appuyer();
            }
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                relacher();
            }
        });

    }

    public void appuyer(){
        fondTouche.setFill(Color.DARKGRAY);
        this.setTranslateY(posY+2);
        instru.note_on(note);
    }
    public void relacher(){
        System.out.println("-----------");
        fondTouche.setFill(Color.WHITE);
        this.setTranslateY(posY);
        instru.note_off(note);
    }
}
