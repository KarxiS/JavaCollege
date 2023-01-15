package entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * 29/03/2022 - 12:54 classa na Raketku abstraktna
 *
 * @author 2karo
 */
public abstract class Raketa extends Entita {
    private boolean vybuchni;
    private final Obrazok vybuch;
    private int pocitadloVybuch;
    private final ArrayList<EntitaStacionarne> entitaStacionarnes;

    public Raketa() {
        this.entitaStacionarnes = new ArrayList<>();
        this.vybuch = new Obrazok("pics/vybuch.png");
        this.pocitadloVybuch = 0;

    }

    public boolean isVybuchni() {
        return this.vybuchni;
    }

    public void setVybuchni(boolean vybuchni) {
        this.vybuchni = vybuchni;
    }

    protected void setXY(int x, int y) {
        super.setX(x);
        super.setY(y);


    }

    /**
     * @param entitaStacionarness prida entity to existujuceho arraylistu
     */
    public void pridajEntity(ArrayList<EntitaStacionarne> entitaStacionarness) {
        this.entitaStacionarnes.addAll(entitaStacionarness);
    }

    /**
     * @return najde stacionarnuEntitu, ktora nema 0HP
     */
    public EntitaStacionarne najdiStacionarnuEntitu() {
//        int mojeX = super.getX();
//        int mojeY = super.getY();
//        EntitaStacionarne najmenejVzdialenaEntita = entitaStacionarnes.get(0);
//        for (EntitaStacionarne entitaStacionarneAkt : entitaStacionarnes) {
//            int entitaX = entitaStacionarneAkt.getX();
//
//            int entitaY = entitaStacionarneAkt.getY();
//
//            if ((Math.abs((mojeX + mojeY) - (entitaStacionarneAkt.getX() + entitaStacionarneAkt.getY()))) < (Math.abs((mojeX + mojeY) - (najmenejVzdialenaEntita.getX() + najmenejVzdialenaEntita.getY())))) {
//                najmenejVzdialenaEntita = entitaStacionarneAkt;
//            }
//
//
//        }
        Random random = new Random();
        EntitaStacionarne vybranaEntita;
        do {

            vybranaEntita = this.entitaStacionarnes.get(random.nextInt(this.entitaStacionarnes.size()));
        } while (vybranaEntita.getZivoty() == 0);
        return vybranaEntita;

    }


    /**
     * @param g2 vybuchne a vykresli sa
     */
    protected void vybuchni(Graphics2D g2) {

        this.setVybuchni(false);
        g2.drawImage(this.vybuch.getObrazok(), this.getX() - 50, this.getY() - 70, null);

    }

    public int getPocitadloVybuch() {
        return this.pocitadloVybuch;
    }

    public int addPocitadloVybuch() {
        return this.pocitadloVybuch++;
    }
}