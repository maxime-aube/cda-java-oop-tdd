package fr.maximob.color.model;

import java.util.Objects;

public class Color {

    protected int red;
    protected int green;
    protected int blue;

    /**
     *
     * @param red
     * @param green
     * @param blue
     * @throws IllegalArgumentException Si les valeurs des args ne sont pas des RGB valides
     */
    public Color(int red, int green, int blue) throws IllegalArgumentException {
        // check if args make are in a valid rgb range
        if (red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        } else throw new IllegalArgumentException();
    }

    public Color(String hexValue) throws IllegalArgumentException {
        if (!hexValue.matches("#([0-9A-F]{6})")) {
            throw new IllegalArgumentException();
        }
        this.setHexValue(hexValue);
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
        this.red = red;
    }

    public void setGreen(int green) throws IllegalArgumentException {
        this.green = green;
    }

    public void setBlue(int blue) throws IllegalArgumentException {
        this.blue = blue;
    }

    public void setHexValue(String hexValue) throws IllegalArgumentException {
        this.red = Integer.valueOf(hexValue.substring(1, 3), 16);
        this.green = Integer.valueOf(hexValue.substring(3, 5), 16);
        this.blue = Integer.valueOf(hexValue.substring(5, 7), 16);
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
