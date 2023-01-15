package entity;

/**
 * 29/03/2022 - 12:54 airdrop, co pridava NormalneStrely
 *
 * @author 2karo
 */
public class AirDropNormalStrela extends AirDrop {
    public AirDropNormalStrela(int x) {
        super(x, 0, new Obrazok("pics/AmmoAir.png"));
    }

    /**
     * @param delo abstraktna metoda prida do inventaru strelu normalnu
     */
    @Override
    void pouzi(Delo delo) {
        delo.pridajNormalnuStrelu(15);
    }
}
