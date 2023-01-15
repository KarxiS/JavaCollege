package pozadie;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 hp bar, okazuje aktualne hp
 *
 * @author 2karo
 */
public class HPBar {
    private Obdlznik stvorecZeleny;
    private Obdlznik stvorecCerveny;
    private Obdlznik stvorecPozadie;
    private int zivoty;
    private int zivotyZaciatocne;
    private int sirkaHUD = 80;
    private int sirkaZeleny = 80;

    public HPBar(int x, int y, int zivoty) {

        this.zivoty = zivoty;
        this.zivotyZaciatocne = zivoty;
        this.stvorecZeleny = new Obdlznik(x, y, sirkaHUD, 20, Color.GREEN);
        this.stvorecCerveny = new Obdlznik(x, y, sirkaHUD, 20, Color.RED);
        this.stvorecPozadie = new Obdlznik(x - 3, y - 3, sirkaHUD + 6, 26, Color.BLACK);

    }

    /**
     * @param x nastavi XY kazdeho stvorca
     * @param y
     */
    public void setXY(int x, int y) {
        this.stvorecZeleny.setX(x);
        this.stvorecZeleny.setY(y);
        this.stvorecCerveny.setX(x);
        this.stvorecCerveny.setY(y);
        this.stvorecPozadie.setX(x - 3);
        this.stvorecPozadie.setY(y - 3);

    }

    public void update() {
        this.sirkaZeleny = (100 * zivoty) / zivotyZaciatocne;
        this.stvorecZeleny.setSirka((int) (sirkaZeleny * 0.8));


    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
        this.update();

    }

    public void draw(Graphics2D g2) {
        this.stvorecPozadie.draw(g2);
        this.stvorecCerveny.draw(g2);
        this.stvorecZeleny.draw(g2);


    }
}
