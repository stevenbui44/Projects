package game;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 * Okay steven so this is the file for a Card object
 * 
 * Compile:     javac Card.java
 * Run:         java Card
 * 
 */
public class Card {

    // okay steven so each card has a VALUE (number) and a FACE (picture) maybe a COLOR

    /** This is the NUMBER */
    private String value;

    /** This is the PICTURE, either H D C S */
    private String face;

    /** True = RED color */
    private boolean color;

    /** 
     * This is the constructor
     */
    public Card(String value, String face) {
        setValue(value);
        setFace(face);
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    public String getFace() {
        return face;
    }

    private void setFace(String face) {
        this.face = face;
        if (face.equals("H") || face.equals("D")) {
            setColor(true);
        }
    }

    public boolean getColor() {
        return color;
    }

    private void setColor(boolean color) {
        this.color = color;
    }

    public String toString() {
    	
    	
    	// CHUNK ONE: Manual escape sequences
        String rtn = "";
        if (color) {
            rtn = rtn + "\u001B[31m";
        }
        rtn = rtn + value + " " + face;
        if (color) {
            rtn = rtn + "\u001B[0m";
        }

        return rtn;
    	
    	
        // CHUNK TWO: ANSI
//    	AnsiConsole.systemInstall();
//
//        String rtn = "";
//        if (color) {
//            rtn = rtn + Ansi.ansi().fgRed().a(value + " " + face).reset();
//        } else {
//            rtn = rtn + value + " " + face;
//        }
//
//        AnsiConsole.systemUninstall();
//        return rtn;
    	
    	
    	// CHUNK THREE: No color
//    	String rtn = "";
//        rtn = rtn + value + " " + face;
//        return rtn;
        
        
    	

    }

    public String updateValue() {
        if (getValue().equals("K")) {
            return "13";
        }
        else if (getValue().equals("Q")) {
            return "12";
        }
        else if (getValue().equals("J")) {
            return "11";
        }
        else if (getValue().equals("A")) {
        	return "1";
        }
        return getValue();
    }
    
    public String fileName() {
    	return getFace().toLowerCase() + updateValue();
    }

}
