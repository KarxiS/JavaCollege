package entity;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 29/03/2022 - 12:54 classa na  Strelu navadzaciu
 *
 * @author 2karo
 */
public class StrelaNavadzacia extends Strela {
    private final ArrayList<Entita> raketky;
    private double pocitadlo;

    public StrelaNavadzacia(int x, int y, ArrayList<Entita> raketky) {
        super(x, y);
        super.setObrazok(new Obrazok("pics/StrelaCervena.png"));
        this.raketky = raketky;
        this.pocitadlo = 0;
    }

    /**
     * @return najde najblizsiu raketu
     */
    public Entita najdiNajblizsiuRaketku() {
        double mojeX = super.getX();
        double mojeY = super.getY();
        if (this.raketky.isEmpty()) {
            return null;
        }
        Entita najmenejVzdialenaEntita = this.raketky.get(0);
        for (Entita entitaStacionarneAkt : this.raketky) {

            if ((Math.abs((mojeX + mojeY) - (entitaStacionarneAkt.getX() + entitaStacionarneAkt.getY()))) < (Math.abs((mojeX + mojeY) - (najmenejVzdialenaEntita.getX() + najmenejVzdialenaEntita.getY())))) {
                najmenejVzdialenaEntita = entitaStacionarneAkt;
            }


        }

        return najmenejVzdialenaEntita;
    }

    /**
     * strela sa pohybuje po vektore a prenasleduje rakety
     */
    @Override
    public void pohniSa() {

        Entita najblizsiaRaketa = this.najdiNajblizsiuRaketku();
        if (najblizsiaRaketa == null) {
            return;
        }
        double vx = najblizsiaRaketa.getXStred() - super.getX();
        double vy = najblizsiaRaketa.getYStred() - super.getY();
        this.pocitadlo += 0.00005;
        double dalsieX = super.getX() + vx * this.pocitadlo;
        double dalsieY = super.getY() + vy * this.pocitadlo;
        super.setX((int)dalsieX);
        super.setY((int)dalsieY);



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
