package pozadie;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * 29/03/2022 - 12:54 obdlznik
 *
 * @author 2karo
 */
public class Obdlznik {
    private int sirka;
    private int vyska;
    private Color farba;
    private int x;
    private int y;
    private boolean viditelny ;


    public Obdlznik(Color farba) {
        this.farba = farba;
        this.x = 0;
        this.y = 0;
        this.sirka = 20;
        this.vyska = 20;

        this.viditelny = true;
    }

    public Obdlznik(int x, int y, int sirka, int vyska, Color farba) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
        this.farba = farba;
        this.viditelny = true;
    }

    public void draw(Graphics2D g2) {
        if (!this.isViditelny()) {
            return;
        }
        Shape stvorec = new Rectangle(this.x, this.y, this.sirka, this.vyska);

        g2.setColor(this.farba);
        g2.fill(stvorec);

        //g2.draw(stvorec);
    }

    public void setSirka(int sirka) {
        this.sirka = sirka;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isViditelny() {
        return this.viditelny;
    }

    public void setViditelny(boolean viditelny) {
        this.viditelny = viditelny;
    }
}
