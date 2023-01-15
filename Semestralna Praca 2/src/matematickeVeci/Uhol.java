package matematickeVeci;

/**
 * 29/03/2022 - 12:54
 *
 * @author 2karo
 */
public class Uhol {
    private int uhol;
    private int kotvaX;
    private int kotvaY;
    public Uhol(int uhol, int kotvaX, int kotvaY) {
        this.uhol = uhol;
        this.kotvaX = kotvaX;
        this.kotvaY = kotvaY;
    }

    public int getUhol() {
        return this.uhol;
    }

    public int getKotvaX() {
        return this.kotvaX;
    }

    public int getKotvaY() {
        return this.kotvaY;
    }

    public void setUhol(int uhol) {
        this.uhol = uhol;
    }

    public void setKotvaX(int kotvaX) {
        this.kotvaX = kotvaX;
    }

    public void setKotvaY(int kotvaY) {
        this.kotvaY = kotvaY;
    }
}
