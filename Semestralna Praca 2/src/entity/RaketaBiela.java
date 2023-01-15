package entity;

import matematickeVeci.Vektor;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 29/03/2022 - 12:54 classa na Raketku
 *
 * @author 2karo
 */
public class RaketaBiela extends Raketa {
    private double uhol;
    private float pocitadlo;
    private int pocitadloNaVybuch;
    private EntitaStacionarne mojCiel;


    public RaketaBiela(int x, ArrayList<EntitaStacionarne> stacionarnes) {
        super();
        super.setObrazok(new Obrazok("pics/raketkaBiela.png"));
        super.setXY(x, 0);
        super.pridajEntity(stacionarnes);
        this.setVybuchni(false);
        this.najdiSvojuStacionarnu();
    }

    public void najdiSvojuStacionarnu() {

        this.mojCiel = super.najdiStacionarnuEntitu();

    }

    /**
     * najde entitu a vypocitava vektor + aktualizuje svoju poziciu k entite, zaroven odcitava od mestecka, dokym je v stanovenych suradniciach
     */
    @Override
    public void update() {

        EntitaStacionarne cielEnt = this.mojCiel;
        Vektor vektor = new Vektor();
        vektor.setX(cielEnt.getXStred());
        vektor.setY(cielEnt.getYStred());

        vektor.odcitajVektor(new Vektor(super.getX(), super.getY()));
        this.uhol = Math.atan2(vektor.getY(), vektor.getX()) + (Math.PI / 2);
        //super.setY(super.getY() + 10);

        float vx = cielEnt.getXStred() - super.getX();
        float vy = cielEnt.getYStred() - super.getY();
        this.pocitadlo += 0.00005;
        float dalsieX = super.getX() + vx * this.pocitadlo;
        float dalsieY = super.getY() + vy * this.pocitadlo;
        super.setX((int)dalsieX);
        super.setY((int)dalsieY);

        if ((this.getX() + 30 >= cielEnt.getX()) && (this.getY() > cielEnt.getY())
                && (this.getY() + 40 < cielEnt.getYStred())) {
            this.setVybuchni(true);
            if (cielEnt instanceof Mesto) {
                ((Mesto)cielEnt).zasiahnutie(1);
            } else {
                cielEnt.odcitajZivoty(1);
            }
        }


    }

    /**
     * @param g2 vykresli na platno , tu klonujem g2, aby som ho dokazal otacat a neobmedzil ine triedy co ju pouzivaju
     */
    @Override
    public void draw(Graphics2D g2) {
        Graphics2D g2Klon = (Graphics2D)g2.create();
        g2Klon.rotate(this.uhol, super.getObrazok().getXStred(), super.getObrazok().getYStred());
        g2Klon.drawImage(super.getObrazok().getObrazok(), super.getX(), super.getY(), null);
        if ((this.isVybuchni())) {
            this.vybuchni(g2Klon);

        }
    }


    //g2.drawImage(super.getObrazok().getObrazok(), super.getX(), super.getY(), null);
}

