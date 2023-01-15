package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Trieda entity.Obrazok, reprezentuje bitmapovy obrazok, ktory moze byt vykresleny na platno.
 *
 * @author Miroslav Kvassay
 * @version 1.1
 * @author Michal Varga
 */
public class Obrazok {

    private int lavyHornyX;
    private int lavyHornyY;

    private BufferedImage obrazok;

    /**
     * Parametricky konstruktor vytvori entity.Obrazok na pozicii paX, paY s natocenim paUhol
     *
     * @param suborSObrazkom cesta k suboru s obrazkom, ktory sa ma vykreslovat
     */
    public Obrazok(String suborSObrazkom) {
        this.obrazok = this.nacitajObrazokZoSuboru(suborSObrazkom);

        this.lavyHornyX = 100;
        this.lavyHornyY = 300;
    }


    public void setX(int x) {
        this.lavyHornyX = x;

    }

    public void setY(int y) {
        this.lavyHornyY = y;

    }

    public int getXStred() {
        return this.lavyHornyX + (this.obrazok.getWidth() / 2);


    }

    public int getYStred() {
        return this.lavyHornyY + this.obrazok.getHeight() / 2;

    }


    /**
     * (Obrázok) Zmení obrázok.
     * Súbor s obrázkom musí existovať.
     *
     * @param suborSObrazkom cesta k súboru s obrázkom, ktorý sa má načítať
     */
    public void zmenObrazok(String suborSObrazkom) {


        this.obrazok = this.nacitajObrazokZoSuboru(suborSObrazkom);

    }

    public BufferedImage getObrazok() {
        return this.obrazok;
    }

    /*
     * Načíta obrázok zo súboru.
     */
    private BufferedImage nacitajObrazokZoSuboru(String subor) {
        BufferedImage nacitanyOBrazok = null;

        try {
            nacitanyOBrazok = ImageIO.read(new File(subor));
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Subor " + subor + " sa nenasiel.");
        }

        return nacitanyOBrazok;
    }


}
