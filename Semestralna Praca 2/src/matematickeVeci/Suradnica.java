package matematickeVeci;

/**
 * 29/03/2022 - 12:54
 *
 * @author 2karo
 */
public class Suradnica {
    private int x;
    private int y;

    public Suradnica(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Suradnica odcitajodSuradnice(Suradnica odcitanec) {
        this.x -= odcitanec.getX();
        this.y -= odcitanec.getY();
        return this;
    }

    public Suradnica pricitajodSuradnice(Suradnica odcitanec) {
        this.x += odcitanec.getX();
        this.y += odcitanec.getY();
        return this;
    }

    public Suradnica zistiPomer(int movement) {
//        int absX = Math.abs(this.x);
//        int absY = Math.abs(this.y);
//        int pomerX = absX / absY;
//        int pomerY = 1;
//        int posunX= (20/pomerX + pomerY)*pomerX;
//        int posunY= (20/pomerX + pomerY)*pomerY;
//        if (this.x < 0) {
//            this.posun = -this.posun;
//        }
        return this;
    }


}
