package entity;

/**
 * 29/03/2022 - 12:54 classa na AirDrop, co pridava HP
 *
 * @author 2karo
 */
public class AirDropHealth extends AirDrop {

    public AirDropHealth(int x) {
        super(x, 0, new Obrazok("pics/health.png"));
    }

    /**
     * @param delo abstraktna metoda prida zivoty
     */
    @Override
    void pouzi(Delo delo) {
        delo.pridajZivoty(25);

    }
}
