package fr.maximob.color.model;

import java.util.Objects;

public class Color {

    protected int red;
    protected int green;
    protected int blue;

    public Color(int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public Color(String hexValue) throws IllegalArgumentException {
        if (hexValue == null) throw new IllegalArgumentException();
        this.setHexValue(hexValue);
    }

    public static void main(String[] args) {

    }

    public boolean isValidRGBValue(int color) {
        if (! (color >= 0 && color <= 255)) return false;
        return true;
    }

    public boolean isValidHexValue(String hexValue) {
        if (hexValue.length() != 7 || !hexValue.matches("#([0-9A-F]{6})")) return false;
        return true;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getHexValue() {
        return String.format("#%02X%02X%02X", this.red, this.green, this.blue);
    }

    public void setRed(int red) throws IllegalArgumentException {
        if (!this.isValidRGBValue(red)) throw new IllegalArgumentException();
        this.red = red;
    }

    public void setGreen(int green) throws IllegalArgumentException {
        if (!this.isValidRGBValue(green)) throw new IllegalArgumentException();
        this.green = green;
    }

    public void setBlue(int blue) throws IllegalArgumentException {
        if (!this.isValidRGBValue(blue)) throw new IllegalArgumentException();
        this.blue = blue;
    }

    public void setHexValue(String hexValue) throws IllegalArgumentException {
        if (hexValue == null || !isValidHexValue(hexValue)) throw new IllegalArgumentException();
        int red = Integer.valueOf(hexValue.substring(1, 3), 16);
        int green = Integer.valueOf(hexValue.substring(3, 5), 16);
        int blue = Integer.valueOf(hexValue.substring(5, 7), 16);
        if (this.isValidRGBValue(red)) this.red = red;
        if (this.isValidRGBValue(green)) this.green = green;
        if (this.isValidRGBValue(blue)) this.blue = blue;
    }

    public String toString() {
        return "[value=" + this.getHexValue() + ", r=" + this.red + ", g=" + this.green + ", b=" + this.blue + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return red == color.red && green == color.green && blue == color.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}
