package entity;

/**
 * 29/03/2022 - 12:54 airdrop, co pridava NavigujuceStrely
 *
 * @author 2karo
 */
public class AirDropNavStrela extends AirDrop {

    public AirDropNavStrela(int x) {
        super(x, 0, new Obrazok("pics/AmmoAirNavadzacia.png"));
    }

    /**
     * @param delo abstraktna metoda prida do inventaru dela strely
     */
    @Override
    void pouzi(Delo delo) {
        delo.pridajNavadzaciuStrelu(2);

    }
}
