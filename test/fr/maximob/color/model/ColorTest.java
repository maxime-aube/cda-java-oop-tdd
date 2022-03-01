package fr.maximob.color.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    protected int red = 213;
    protected int green = 141;
    protected int blue = 53;
    protected String hexValue = this.getHexValue(this.red, this.green, this.blue);

    protected Color color;

    private String getHexValue(int r, int g, int b) {
        return ("#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b)).toUpperCase();
    }

    @BeforeEach
    public void setUp() {
        this.color = new Color(this.red, this.green, this.blue);
    }


    /*
        Constructors
     */

    @Test
    @Tags({
        @Tag("construct"),
        @Tag("equals")
    })
    public void testColorConstructRGBEquals() {
        Color newColor = new Color(this.red, this.green, this.blue);
        assertNotSame(this.color, newColor);
        assertEquals(this.color, newColor);
    }

    @Test
    @Tags({
        @Tag("construct"),
        @Tag("equals")
    })
    public void testColorConstructHexEquals() {
        Color newColor = new Color(this.hexValue);
        assertNotSame(this.color, newColor);
        assertEquals(this.color, newColor);
    }

    @Test
    @Tags({
        @Tag("construct"),
        @Tag("exception")
    })
    public void testColorConstructRGBException() {
        assertThrows(IllegalArgumentException.class, ()->new Color(-3, 26, 511), "expected IllegalArgumentException but none was thrown");
    }

    @Test
    @Tags({
        @Tag("construct"),
        @Tag("exception")
    })
    public void testColorConstructHexException() {

//        System.out.println(! "#D58DG8".matches("#([0-9A-F]{6})"));
//        System.out.println(! "#mauvais".matches("#([0-9A-F]{6})"));
//        System.out.println(! "correct".matches("#([0-9A-F]{6})"));

        // todo => passe même quand in devrait échouer

//        assertThrows(IllegalArgumentException.class, ()->new Color("#D58DG8"), "expected IllegalArgumentException but none was thrown");

        assertAll("Exception not thrown",
            ()->assertThrows(IllegalArgumentException.class, ()->new Color("#D58DG8"), "expected IllegalArgumentException but none was thrown"),
            ()->assertThrows(IllegalArgumentException.class, ()->new Color("#mauvais"), "expected IllegalArgumentException but none was thrown"),
            ()->assertThrows(IllegalArgumentException.class, ()->new Color("correct"), "expected IllegalArgumentException but none was thrown")
        );

    }

    /*
        Getters
     */

    @Test
    @Tags({
        @Tag("getter"),
        @Tag("equals")
    })
    public void testGetRedEquals() {
        assertEquals(this.red, this.color.getRed());
    }

    @Test
    @Tags({
        @Tag("getter"),
        @Tag("equals")
    })
    public void testGetGreenEquals() {
        assertEquals(this.green, this.color.getGreen());
    }

    @Test
    @Tags({
        @Tag("getter"),
        @Tag("equals")
    })
    public void testGetBlueEquals() {
        assertEquals(this.blue, this.color.getBlue());
    }

    @Test
    @Tags({
        @Tag("getter"),
        @Tag("equals")
    })
    public void testGetHexValueEquals() {
        assertEquals(this.hexValue, this.color.getHexValue());
    }

    /*
        Setters
     */

    @Test
    @Tags({
        @Tag("setter"),
        @Tag("equals")
    })
    public void testSetRedEquals() {
        int color = 26;
        this.color.setRed(color);
        assertEquals(color, this.color.getRed());
        assertAll("Color object non conformes",
            ()->assertEquals(color, this.color.getRed(), "getRed() est incorrect"),
            ()->assertEquals(this.green, this.color.getGreen(), "getGreen() est incorrect"),
            ()->assertEquals(this.blue, this.color.getBlue(), "getBlue() est incorrect"),
            ()->assertEquals(this.getHexValue(color, this.green, this.blue), this.color.getHexValue(), "getHexValue() est incorrect")
        );
    }

    @Test
    @Tags({
        @Tag("setter"),
        @Tag("equals")
    })
    public void testSetGreenEquals() {
        int color = 26;
        this.color.setGreen(color);
        assertAll("Color object non conformes",
                ()->assertEquals(this.red, this.color.getRed(), "getRed() est incorrect"),
                ()->assertEquals(color, this.color.getGreen(), "getGreen() est incorrect"),
                ()->assertEquals(this.blue, this.color.getBlue(), "getBlue() est incorrect"),
                ()->assertEquals(this.getHexValue(this.red, color, this.blue), this.color.getHexValue(), "getHexValue() est incorrect")
        );

    }

    @Test
    @Tags({
        @Tag("setter"),
        @Tag("equals")
    })
    public void testSetBlueEquals() {
        int color = 26;
        this.color.setBlue(color);
        assertAll("Color object non conformes",
                ()->assertEquals(this.red, this.color.getRed(), "getRed() est incorrect"),
                ()->assertEquals(this.green, this.color.getGreen(), "getGreen() est incorrect"),
                ()->assertEquals(color, this.color.getBlue(), "getBlue() est incorrect"),
                ()->assertEquals(this.getHexValue(this.red, this.green, color), this.color.getHexValue(), "getHexValue() est incorrect")
        );
    }

    @Test
    @Tags({
        @Tag("setter"),
        @Tag("equals")
    })
    public void testSetHexValueEquals() {
        String hex = "#33CCFF";
        this.color.setHexValue(hex);
        assertAll("Color object non conformes",
                ()->assertEquals(Integer.valueOf(hex.substring(1, 3), 16), this.color.getRed(), "getRed() est incorrect"),
                ()->assertEquals(Integer.valueOf(hex.substring(3, 5), 16), this.color.getGreen(), "getGreen() est incorrect"),
                ()->assertEquals(Integer.valueOf(hex.substring(5, 7), 16), this.color.getBlue(), "getBlue() est incorrect"),
                ()->assertEquals(hex, this.color.getHexValue(), "getHexValue() est incorrect")
        );
    }

    // todo => setter exceptions

    /*
        toString
     */

    @Test
    @Tags({
        @Tag("toString"),
        @Tag("equals")
    })
    public void testToStringEquals() {
        String expected = "[value=" + this.hexValue + ", r=" + this.red + ", g=" + this.green + ", b=" + this.blue + "]";
        assertEquals(expected, this.color.toString());
    }


    @AfterEach
    public void tearDown() {
        this.color = null;
    }
}
