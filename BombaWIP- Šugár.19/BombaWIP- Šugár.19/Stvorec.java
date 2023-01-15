import java.awt.Rectangle;

public class Stvorec {
    private int x;
    private int y;
    private int stranaA;
    private int stranaB;
    private String farba;
    private int r;
    private int g;
    private int b;
    private boolean jeViditelny;
    private boolean somMeniaci;
    private Manazer manazer;
    
    public Stvorec(int x, int y, int r, int g, int b, int stranaA, int stranaB) {
        
        this.farba = "red";
        this.x = x;   //tieto bud budu random, alebo staticke, este uvidim. 
        this.y = y;    //Alebo bude staticke a potom dynamicke aj sandbox verzia.
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.r = r;
        this.g = g;
        this.b = b;
        this.jeViditelny = true;
    }
    
    public void nakresli() {
        if (this.somMeniaci) {
            this.nakresliMaRGB();
        } else  {
            this.nakresliMa();
        }
        this.jeViditelny = true;
    }
   
    public void nakresliMa() { //private potom, a budem puzivat len nakresli().
        Platno canvas = Platno.dajPlatno();
        this.somMeniaci = false;
        canvas.draw(this, this.farba,
                        new Rectangle(this.x, this.y, this.stranaA, this.stranaA));
    
    }
    
    public void nakresliMaRGB() { //private potom, a budem puzivat len nakresli().
        Platno canvas = Platno.dajPlatno();
        this.r = r;
        this.g = g;
        this.b = b;
        this.somMeniaci = true;
        canvas.drawRGB(this, this.r, this.g, this.b,
               new Rectangle(this.x, this.y, this.stranaA, this.stranaA));
              
    }
    
    public void skryMa() {
        
        this.zmaz();
        this.jeViditelny = false;
        
    }
    
    
    
    public void zobrazMa() {
        this.jeViditelny = true;
        this.nakresli();
    }
    
    public void zmaz() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            canvas.erase(this);
        }
    }
    
    
    public void tik() {
        this.zhorsujSa();   
    }
    
    public void zhorsujSa() {
        Platno canvas = Platno.dajPlatno(); 
        if ((this.r != 255) || (this.g != 0) || (this.b != 0)) {
            canvas.drawRGB(this, this.r, this.g, this.b ,
                new Rectangle(this.x, this.y, this.stranaA, this.stranaB));
            this.r = this.r + 10;
            this.g = this.g - 10;
            this.b = this.b - 10;
            if (this.r > 255) {
                this.r = 255;
            } 
            if (this.g < 0) {
                this.g = 0;
            }
            if (this.b < 0) {
                this.b = 0;
            }
        }

    }
  
}
