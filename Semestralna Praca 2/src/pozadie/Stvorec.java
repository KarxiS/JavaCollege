package pozadie;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * 29/03/2022 - 12:54 stvorec
 *
 * @author 2karo
 */
public class Stvorec {
    private final int sirka;
    private int x;
    private int y;
    private boolean viditelny;


    public Stvorec(int x, int y, int sirka) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.viditelny = true;
    }

    public void draw(Graphics2D g2) {
        if (!this.isViditelny()) {
            return;
        }
        Shape stvorec = new Rectangle(this.x, this.y, this.sirka, this.sirka);
        g2.setColor(Color.ORANGE);
        g2.fill(stvorec);

        //g2.draw(stvorec);
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

