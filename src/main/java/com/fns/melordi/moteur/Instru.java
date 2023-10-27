package com.fns.melordi.moteur;



import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Instru{
    private Synthesizer synthesizer;
    private MidiChannel canal;
    public IntegerProperty volume =new SimpleIntegerProperty(100);

    public  Instru(){

        try{
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
        }catch ( MidiUnavailableException ex){
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE,null,ex);
        }
        canal = synthesizer.getChannels()[0];
        canal.programChange(0);
    }

    //jouer la note dont le n° est en paramettre
    public  void note_on(int note){
        canal.noteOn(note,volume.get());
    }
    //arreter de jouer la note dont le nom est en paramtre
    public void note_off(int note){
        canal.noteOff(note);
    }
    //changer le type d'instrument
    public  void  setInstrument(int instrument){
        canal.programChange(instrument);
    }

}