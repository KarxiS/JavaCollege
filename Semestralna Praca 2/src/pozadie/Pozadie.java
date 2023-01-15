package pozadie;

import hlavnaTrieda.OknoHry;

import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 pozadie, generuje stvorceky zeme
 *
 * @author 2karo
 */
public class Pozadie {
    private Stvorec[][] zem;
    private final int sirka = 80;

    public Pozadie() {
        int velkostOkna = OknoHry.getVelkostOkna();
        this.zem = new Stvorec[(velkostOkna / this.sirka) + 1][3];

        for (int i = 0; i < this.zem.length; i++) {
            for (int j = 0; j < this.zem[i].length; j++) {
                this.zem[i][j] = new Stvorec(i * this.sirka, velkostOkna - (this.sirka * j), this.sirka);
            }

        }

    }

    public void draw(Graphics2D g2) {

        for (Stvorec[] stvorecs : this.zem) {
            for (Stvorec stvorec : stvorecs) {
                stvorec.draw(g2);
            }
        }

    }
}


