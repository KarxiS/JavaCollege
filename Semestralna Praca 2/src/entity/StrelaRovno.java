package entity;

import matematickeVeci.Vektor;

import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 classa na  Strelu co ide priamociaro
 *
 * @author 2karo
 */
public class StrelaRovno extends Strela {
    private int pocitadlo;
    private Vektor vektorRychlost;

    public StrelaRovno(int x, int y, Vektor vektorRychlost) {
        super(x, y);
        super.setObrazok(new Obrazok("pics/StrelaModra.png"));
        this.vektorRychlost = vektorRychlost;

        this.pocitadlo = 0;
        int delitel = 20;


        //this.vektorRychlost = vektorRychlost;
        this.vektorRychlost = vektorRychlost.podelVektor(delitel);
        if (this.vektorRychlost.getY() > -5) {
            this.vektorRychlost.setY(-5);
        }




    }


    /**
     * nastavuje dalsie suradnice po rovnej ceste
     */
    @Override
    public void pohniSa() {

        if (super.isUzVybuchnute()) {
            return;
        }
        this.pocitadlo += 1;
        if (this.pocitadlo % 2 != 0) {
            return;
        }

        super.setX(super.getX() + this.vektorRychlost.getX());
        super.setY(super.getY() + this.vektorRychlost.getY());


    }

    @Override
    public void update() {
        this.pohniSa();
    }

    @Override
    public void draw(Graphics2D g2) {


        if (super.isUzVybuchnute()) {
            g2.drawImage(super.getVybuch().getObrazok(), (int)super.getX(), (int)super.getY(), null);

        } else {
            g2.drawImage(super.getObrazok().getObrazok(), (int)super.getX(), (int)super.getY(), null);
        }
    }


}
