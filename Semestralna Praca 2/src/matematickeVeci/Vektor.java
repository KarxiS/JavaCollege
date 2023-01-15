package matematickeVeci;

import static java.lang.Math.abs;

/**
 * 29/03/2022 - 12:54 obsahuje x a y, odpocitavam a rozne mat operacie
 *
 * @author 2karo
 */
public class Vektor {
    private double x;
    private double y;

    public Vektor(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vektor() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vektor zmenVektorOkolko(double x, double y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Vektor odcitajVektor(Vektor vektor) {
        this.x -= vektor.getX();
        this.y -= vektor.getY();
        return this;
    }

    /**
     * @param vektor pricita x a y
     * @return
     */
    public Vektor pricitajVektor(Vektor vektor) {
        this.x += vektor.getX();
        this.y += vektor.getY();
        return this;
    }

    public Vektor podelVektor(double kolko) {
        this.x = this.x / kolko;
        this.y = this.y / kolko;
        return this;

    }

    /**
     * @param movementSpeed podeli ich rovnakym dielom
     * @return
     */
    public Vektor podelVPomere(double movementSpeed) {
        double pomerX;
        pomerX = this.x / this.y;
        double pomerY = 1;
        double dokopyPomer = pomerX + pomerY;
        this.x = (movementSpeed / dokopyPomer) * pomerX;
        this.y = -(movementSpeed / dokopyPomer) * pomerY;
        return this;

    }


    public Vektor podelDokymBude(int menejAko) {
        while (this.x + this.y > menejAko) {
            this.x = this.x / menejAko;
            this.y = this.y / menejAko;
        }

        while (-this.x + -this.y > menejAko) {
            this.x = this.x / menejAko;
            this.y = this.y / menejAko;
        }
        return this;
    }


    public Vektor absodcitajVektor(Vektor vektor) {
        this.x -= vektor.getX();
        this.y -= vektor.getY();
        this.x = abs(this.x);
        this.y = abs(this.y);
        return this;
    }
}


