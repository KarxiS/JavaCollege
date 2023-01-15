package entity;

import pozadie.HPBar;

import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 classa pre stacionarne entity
 *
 * @author 2karo
 */
public abstract class EntitaStacionarne extends Entita {
    private final int zivotyMax;
    private int zivoty;
    private final HPBar hpBar;
    //protected int zivoty;


    public EntitaStacionarne(int zivoty) {
        this.zivoty = zivoty;
        this.zivotyMax = zivoty;
        this.hpBar = new HPBar(0, 0, zivoty);
    }


    public int getZivotyMax() {
        return this.zivotyMax;
    }

    protected void setXY(int x, int y) {
        super.setX(x);
        super.setY(y);

        this.hpBar.setXY(super.getX(), super.getY() + (((super.getYStred() - super.getY()) * 3)));
    }

    public int getZivoty() {
        return this.zivoty;
    }

    public void pridajZivoty(int kolko) {
        this.zivoty += kolko;
        this.setZivoty(this.zivoty);

    }

    /**
     * @param g2 vykresli pekny hpBar
     */
    public void vykresliZivoty(Graphics2D g2) {
        this.hpBar.draw(g2);

    }

    public int odcitajZivoty(int kolko) {
        if (this.getZivoty() == 0) {
            return 0;
        }

        this.zivoty -= kolko;
        this.hpBar.setZivoty(this.zivoty);
        return this.zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
