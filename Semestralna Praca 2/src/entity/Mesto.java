package entity;

import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 classa na Mestecko
 *
 * @author 2karo
 */
public class Mesto extends EntitaStacionarne {
    private int znicenost = 0;
    private final int polkaHP;

    public Mesto(int x, int y, int zivoty) {
        super(zivoty);

        this.polkaHP = zivoty / 2;
        super.setObrazok(new Obrazok("pics/0mesto100px.png"));
        super.setXY(x, y);
    }

    public void zasiahnutie(int damage) {
        this.odcitajZivoty(damage);
    }

    /**
     * @param kolko odcita zivoty a k tomu zmeni obrazok , resp. znicitelnost
     * @return
     */
    @Override
    public int odcitajZivoty(int kolko) {
        int aktHP = super.odcitajZivoty(kolko);
        if (aktHP == 0) {
            this.znicenost = 3;

        } else if (aktHP < this.polkaHP) {
            this.znicenost = 2;
        } else if (aktHP < this.polkaHP * 2) {
            this.znicenost = 1;
        } else if (aktHP == this.polkaHP * 2) {
            this.znicenost = 0;
        }
        return aktHP;
    }

    /**
     * podla znicitelnosti nastavi obrazok
     */
    @Override
    public void update() {
        switch (this.znicenost) {
            case 0: {
                super.setObrazok(new Obrazok("pics/0mesto100px.png"));
                break;
            }
            case 1: {
                super.setObrazok(new Obrazok("pics/1mesto100px.png"));
                break;
            }
            case 2: {
                super.setObrazok(new Obrazok("pics/2mesto100px.png"));
                break;
            }
            case 3: {
                super.setObrazok(new Obrazok("pics/4mesto100px.png"));
                break;
            }
        }


    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(super.getObrazok().getObrazok(), super.getX(), super.getY(), null);
        super.vykresliZivoty(g2);
    }
}
