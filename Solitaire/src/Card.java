package src;
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

    /** This is the PICTURE */
    private String face;

    /** True = RED color */
    private boolean color;

    /** 
     * This is the constructor
     */
    public Card(String value, String i) {
        setValue(value);
        setFace(i);
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
        // if (value == null || face == null) {
        //     return "null";
        // }
        
        String rtn = "";
        if (color) {
            rtn = rtn + "\u001B[31m";
        }
        rtn = rtn + value + " " + face;
        if (color) {
            rtn = rtn + "\u001B[0m";
        }

        return rtn;

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
        return getValue();
    }

}
