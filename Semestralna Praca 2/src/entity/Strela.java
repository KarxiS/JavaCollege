package entity;



import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 29/03/2022 - 12:54 classa na abstraktnu Strelu
 *
 * @author 2karo
 */
public abstract class Strela implements IVykreslovanie {

    private final Obrazok vybuch;
    private int pocitadloVybuch;
    private double x;
    private double y;
    private Obrazok obrazok;
    private boolean uzVybuchnute;

    public Strela(int x, int y) {
        this.obrazok = new Obrazok("pics/StrelaModra.png");
        this.vybuch = new Obrazok("pics/vybuch.png");
        this.x = x;
        this.y = y;
        this.pocitadloVybuch = 0;


    }

    public abstract void pohniSa();

    public Obrazok getVybuch() {
        return this.vybuch;
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


    public int getPocitadloVybuch() {
        return this.pocitadloVybuch;
    }

    public int addPocitadloVybuch() {
        this.pocitadloVybuch += 1;
        return this.pocitadloVybuch;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Obrazok getObrazok() {
        return this.obrazok;
    }

    public void setObrazok(Obrazok obrazok) {
        this.obrazok = obrazok;
    }

    public boolean isUzVybuchnute() {
        return this.uzVybuchnute;
    }

    @Override
    public abstract void update();

    @Override
    public abstract void draw(Graphics2D g2);


    /**
     * @param entity zistuje, ci arraylist entit je v nejakej suradnici entitiy
     * @return
     */
    public boolean jeVEntite(ArrayList<Entita> entity) {
        for (Entita entita : entity) {
            if ((this.x + 20 > entita.getX()) && (this.y + 30 > entita.getY()) &&
                    (this.x - 20 < entita.getX()) && (this.y - 30 < entita.getY())) {
                if (entita instanceof Raketa) {
                    ((Raketa)entita).setVybuchni(true);
                    this.uzVybuchnute = true;
                }
                entity.remove(entita);
                return true;

            }

        }
        return false;
    }

    /**
     * @param x zistuje, ci strela je v suradniciach
     * @param y
     * @return
     */
    public boolean jeVSuradniciach(int x, int y) {
        if ((this.x + 20 > x) && (this.y + 20 > y) &&
                (this.x - 20 < x) && (this.y - 20 < y)) {
            return true;

        }
        return false;
    }

    /**
     * @param entita zistuje, ci strela je v entite
     * @return
     */
    public boolean jeVSuradniciach(Entita entita) {
        if ((this.x + 20 > entita.getX()) && (this.y + 20 > entita.getY()) &&
                (this.x - 20 < entita.getX()) && (this.y - 20 < entita.getY())) {
            return true;

        }
        return false;

    }
}
