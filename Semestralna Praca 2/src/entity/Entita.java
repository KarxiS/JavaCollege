package entity;

import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 entita, zakladna jednotka pre vsetky objekty
 *
 * @author 2karo
 */
public abstract class Entita {
    //protected int zivoty;
    private int x;
    private int y;
    private Obrazok obrazok;

    public Entita() {

        //this.obrazok = new Obrazok("pics/delo2.png");
    }

    /**
     * aktualizuje stav entity
     */
    public abstract void update();

    /**
     * @param g2 vykresli na platno
     *
     */
    public abstract void draw(Graphics2D g2);

    public void setX(int x) {
        this.obrazok.setX(x);
        this.x = x;

    }


    protected void setY(int y) {
        this.obrazok.setY(y);
        this.y = y;
    }


    protected int getXStred() {
        return this.obrazok.getObrazok().getWidth() / 2 + this.x;
    }

    protected int getYStred() {
        return this.obrazok.getObrazok().getHeight() / 2 + this.y;
    }

    protected int getX() {
        // return obrazok.getLavyHornyX();
        return this.x;
    }

    protected int getY() {
        //return this.obrazok.getLavyHornyY();
        return this.y;
    }

    protected Obrazok getObrazok() {
        return this.obrazok;
    }

    protected void setObrazok(Obrazok obrazok) {

        this.obrazok = obrazok;
    }

}
