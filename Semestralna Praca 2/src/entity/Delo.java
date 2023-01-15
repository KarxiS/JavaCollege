package entity;

import hlavnaTrieda.Input;
import matematickeVeci.Vektor;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 29/03/2022 - 12:54 hrac, ovlada dela
 *
 * @author 2karo
 */
public class Delo extends EntitaStacionarne {
    private final Input mouseListener;
    private ArrayList<Strela> aktualneVystrelene;
    //private final OknoHry oknoHry;
    private final Obrazok obrazokPodstavec;
    private double uhol;
    private ArrayList<Entita> raketky;
    private ArrayList<AirDrop> airDropy;
    private int pocetNavadzacichStriel;
    private int pocetNormalnychStriel;

    public Delo(int x, int y, Input mouseListener) {
        super(400);
        super.setObrazok(new Obrazok("pics/delo.png"));
        super.setXY(x, y);
        //super.odcitajZivoty(100);
        this.aktualneVystrelene = new ArrayList<>();
        //this.oknoHry = oknoHry;
        this.mouseListener = mouseListener;
        this.airDropy = new ArrayList<>();
        this.pocetNavadzacichStriel = 0;
        this.pocetNormalnychStriel = 20;

        //super.setXY(x, y);


        this.obrazokPodstavec = new Obrazok("pics/podstavec2.png");


    }


    /**
     * update ma za ulohu aktualizovat uhol, kam sa diva podla mysky. Ak su nejake vystrelene strely, aktualizuje aj tie . Ak su v nejakej rakete, posle arraylist entit a spyta sa , ci tam je.
     */
    @Override
    public void update() {
        Vektor vektor = new Vektor();
        vektor.setX(this.mouseListener.getAktualneX());
        vektor.setY(this.mouseListener.getAktualneY());
        vektor.odcitajVektor(new Vektor(super.getXStred(), super.getYStred()));
        this.uhol = Math.atan2(vektor.getY(), vektor.getX()) + (Math.PI / 2);
        if ((this.uhol > Math.PI + Math.PI / 5) || (this.uhol < -Math.PI / 3)) {
            this.uhol = -Math.PI / 3;
        } else if (this.uhol > Math.PI / 2 - Math.PI / 5) {
            this.uhol = (Math.PI / 2) - Math.PI / 5;

        }

        if (!this.aktualneVystrelene.isEmpty()) {
            for (Strela strela : new ArrayList<>(this.aktualneVystrelene)) {
                strela.update();
                if (strela.jeVEntite(this.raketky) || strela.isUzVybuchnute()) {
                    if (strela.addPocitadloVybuch() == 160) {
                        this.aktualneVystrelene.remove(strela);
                    }

                }
            }
            for (Strela strela : new ArrayList<>(this.aktualneVystrelene)) {
                for (AirDrop airDrop : new ArrayList<>(this.airDropy)) {
                    if (strela.jeVSuradniciach(airDrop.getX(), airDrop.getY())) {

                        this.aktualneVystrelene.remove(airDrop);
                        airDrop.pouzi(this);
                        this.airDropy.remove(airDrop);

                    }
                }

            }


        }

        //aktualneVystrelene.remove(strela);

    }


    //uhol = Math.tan(Math.abs(vektor.getY() / vektor.getX()));

    //uhol = new Random().nextDouble(360);
    //uhol = -20;
    //aff.rotate(uhol, obrazok.getXStred(), obrazok.getYStred());


    /**
     * tu berie z inventara dostupnych striel a striela
     */
    public void vystrel() {
        Vektor vektor = new Vektor();
        vektor.setX(this.mouseListener.getAktualneX());
        vektor.setY(this.mouseListener.getAktualneY());
        vektor.odcitajVektor(new Vektor(super.getXStred(), super.getYStred()));
        if (this.pocetNavadzacichStriel != 0) {
            this.pocetNavadzacichStriel--;
            StrelaNavadzacia strela = new StrelaNavadzacia(super.getXStred(), super.getYStred(), this.raketky);
            this.aktualneVystrelene.add(strela);
        } else if ((this.pocetNormalnychStriel != 0)) {
            this.pocetNormalnychStriel--;
            StrelaRovno strela = new StrelaRovno(super.getXStred(), super.getYStred(), vektor);
            this.aktualneVystrelene.add(strela);
        }
        //StrelaRovno strela = new StrelaRovno(super.getXStred(), super.getYStred(), vektor);

    }


    /**
     * @param g2 vykresluje vystrelene strely+samotne delo
     */
    @Override
    public void draw(Graphics2D g2) {
        if (!this.aktualneVystrelene.isEmpty()) {
            for (Strela strela : this.aktualneVystrelene) {
                strela.draw(g2);
            }
        }

        Graphics2D g2Klon = (Graphics2D)g2.create();
        g2Klon.rotate(this.uhol, super.getObrazok().getXStred(), super.getObrazok().getYStred());  //toto je fix, ked som mal scaling vo windowse na 150 percent ,

        g2Klon.drawImage(super.getObrazok().getObrazok(), super.getX(), super.getY(), null); // naprv toto kreslin na klona Graphics2D
        g2.drawImage(this.obrazokPodstavec.getObrazok(), super.getX() - 80, super.getY() + 60, null); // potom toto kreslim na povodny Graphics2D , nech sa prekryju
        super.vykresliZivoty(g2);


    }

    public int getPocetNavadzacichStriel() {
        return this.pocetNavadzacichStriel;
    }

    public int getPocetNormalnychStriel() {
        return this.pocetNormalnychStriel;
    }

    public void pridajRaketky(ArrayList<Entita> raketky) {
        this.raketky = raketky;
    }

    public void pridajAirDropy(ArrayList<AirDrop> airDrops) {
        this.airDropy = airDrops;
    }

    public void pridajNavadzaciuStrelu(int i) {
        this.pocetNavadzacichStriel += i;
    }

    public void pridajNormalnuStrelu(int i) {
        this.pocetNormalnychStriel += i;
    }
}
