package entity;

import java.awt.Graphics2D;

/**
 * 29/03/2022 - 12:54 classa na abstraktny Airdrop
 *
 * @author 2karo
 */
public abstract class AirDrop extends Entita {
    public AirDrop(int x, int y, Obrazok obrazok) {
        super.setObrazok(obrazok);
        super.setX(x);
        super.setY(y);

    }

    /**
     * @param delo abstraktna metoda
     */
    abstract void pouzi(Delo delo);

    @Override
    public void update() {
        super.setY(super.getY() + 1);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(super.getObrazok().getObrazok(), super.getX(), super.getY(), null);

    }
}
