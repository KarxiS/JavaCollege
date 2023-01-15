package hlavnaTrieda;


import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

/**
 * 29/03/2022 - 12:54 classa na input z mysky
 *
 * @author 2karo
 */
public class Input implements MouseInputListener {
    private int aktualneX;
    private int aktualneY;

    public int getAktualneX() {
        return this.aktualneX;
    }

    public int getAktualneY() {
        return this.aktualneY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        //System.out.println(e.getX());
        //System.out.println(e.getY());
    }

    /**
     * @param e vystreli ked kliknem
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        OknoHry oknoHry = (OknoHry)e.getSource();
        oknoHry.hracVystrel();

    }



    @Override
    public void mouseEntered(MouseEvent e) {
       // this.aktualneX = e.getX();
       // this.aktualneY = e.getY();
        //this.mouseEntered(e);
       // System.out.println(e.getX());
       // System.out.println(e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * @param e nastavuje XY pohybom
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        this.aktualneX = e.getX();
        this.aktualneY = e.getY();

    }

    /**
     * @param e nsatavuje XY
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        this.aktualneX = e.getX();
        this.aktualneY = e.getY();

    }
}
