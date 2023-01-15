package hlavnaTrieda;

import entity.*;
import pozadie.Pozadie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * 29/03/2022 - 12:54 samotna hra
 *
 * @author 2karo
 */
public class OknoHry extends JPanel implements Runnable {

    private int aktualneSkore;
    private final String menoHraca;
    private final Delo hrac;
    private final Pozadie pozadie;
    private ArrayList<AirDrop> airDrops;
    private ArrayList<Mesto> mestoArrayList;
    private ArrayList<EntitaStacionarne> pozemneEntity;
    private ArrayList<Entita> raketky;
    //private final Podstavec podstavec;
    private Thread hraThread;
    private Input mouseListener;
    private static final int VELKOSTOKNA = 1000;
    private static final int FPS = 90;
    private boolean koniecHry;

    public OknoHry() {
        this.setPreferredSize(new Dimension(VELKOSTOKNA, VELKOSTOKNA));
        this.menoHraca = "karol";
        this.aktualneSkore = 0;
        this.koniecHry = false;

        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //rychlejsie vykreslovanie
        this.setFocusable(true);
        this.mouseListener = new Input();
        this.addMouseMotionListener(this.mouseListener);
        this.addMouseListener(this.mouseListener);
        this.hrac = new Delo(470, 720, this.mouseListener);
        this.mestoArrayList = new ArrayList<>();
        this.raketky = new ArrayList<Entita>();
        this.airDrops = new ArrayList<>();
        this.airDrops.add(new AirDropHealth(50));
        this.hrac.pridajAirDropy(this.airDrops);

        this.pozemneEntity = new ArrayList<>();


        this.mestoArrayList.add(new Mesto(250, 760, 200));
        this.mestoArrayList.add(new Mesto(50, 760, 200));
        this.mestoArrayList.add(new Mesto(850, 760, 200));
        this.mestoArrayList.add(new Mesto(650, 760, 200));
        this.pozadie = new Pozadie();
        this.pozemneEntity.addAll(this.mestoArrayList);
        this.pozemneEntity.add(this.hrac);
        this.raketky.add(new RaketaBiela(100, this.pozemneEntity));
        this.raketky.add(new RaketaBiela(70, this.pozemneEntity));
        this.raketky.add(new RaketaBiela(200, this.pozemneEntity));
        this.hrac.pridajRaketky(this.raketky);


        //this.podstavec = new Podstavec(500,500);
    }

    public static int getVelkostOkna() {

        return VELKOSTOKNA;
    }

    public void zapniHru() {

        this.hraThread = new Thread(this);
        this.hraThread.start();


    }

    public void hracVystrel() {
        this.hrac.vystrel();
    }

    /**
     * urcenie 60fps refresh rate
     */
    @Override
    public void run() {
        while (this.hraThread != null) {

            long jednoFPSCasVMilisekundach = 1000 / FPS;
            long dalsiaSnimka = System.currentTimeMillis() + jednoFPSCasVMilisekundach;


            //najprv treba zmenit informacie
            this.update();
            //System.out.println("bezi");

            //if(this.mouseListener)


            //potom vykreslit zmenene informacie
            this.repaint();


            try {
                double ostavajuciCas = dalsiaSnimka - System.currentTimeMillis();
                if (ostavajuciCas < 0) {
                    ostavajuciCas = 0;
                }
                Thread.sleep((long) ostavajuciCas);
                dalsiaSnimka = dalsiaSnimka + jednoFPSCasVMilisekundach;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /** porovnavac, ci je medzi urcenymi hranicami
     * @param x
     * @param dolnaHranica
     * @param hornaHranica
     * @return
     */
    public static boolean jeMedzi(int x, int dolnaHranica, int hornaHranica) {
        return dolnaHranica <= x && x <= hornaHranica;
    }

    /**
     * Pomocou random, generuje rakety, aktualizuje entity, airdropy
     */
    public void update() {
        if (this.koniecHry) {
            return;
        }
        //podstavec.update();
        this.hrac.update();

        Random random = new Random();
        int randomInt = random.nextInt(1000);
        if (jeMedzi(randomInt, 1, 2)) {
            this.raketky.add(new RaketaBiela(random.nextInt(1000), this.pozemneEntity));
        }

        if (jeMedzi(randomInt, 6, 6)) {
            this.airDrops.add(new AirDropHealth(random.nextInt(1000)));
        }

        if (jeMedzi(randomInt, 7, 7)) {
            this.airDrops.add(new AirDropNormalStrela(random.nextInt(1000)));
        }

        if (jeMedzi(randomInt, 8, 8)) {
            this.airDrops.add(new AirDropNavStrela(random.nextInt(1000)));
        }

        if (jeMedzi(randomInt, 100, 110)) {
            this.raketky.add(new RaketaBiela(random.nextInt(1000), this.pozemneEntity));
        }


        for (EntitaStacionarne entitaStacionarne : this.pozemneEntity) {
            entitaStacionarne.update();
        }
        for (Entita raketa : new ArrayList<>(this.raketky)) {
            raketa.update();
            if (raketa instanceof Raketa raketa1) {
                if ((raketa1.isVybuchni()) && (raketa1.addPocitadloVybuch() == 60)) {
                    this.raketky.remove(raketa1);
                    continue;
                }
            }
        }
        for (AirDrop airDrop : this.airDrops) {
            airDrop.update();
        }
        //this.mestoArrayList.get(1).zasiahnutie(1);

    }


    /**
     * @param g2 vykresluje aktualneSkore cez g2 s aktualnym inventarom hraca + dokaze vykreslit koniec hry
     */
    public void vykresliAktualneSkore(Graphics2D g2) {
        if (!this.koniecHry) {
            this.aktualneSkore += 1;
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Serif", Font.PLAIN, 40);
        g2.setFont(font);
        g2.setColor(Color.RED);
        double celeZivoty = 0;
        double celeZivotyMax = 0;

        for (EntitaStacionarne entitaStacionarne : this.pozemneEntity) {
            celeZivoty += entitaStacionarne.getZivoty();
            celeZivotyMax += entitaStacionarne.getZivotyMax();

        }
        double prepocitaneZivortPercenta = celeZivoty * 100 / celeZivotyMax;

        g2.drawString("(" + this.menoHraca + ")  Aktualne skore je " + (int) (this.aktualneSkore * (prepocitaneZivortPercenta / 100)), 0, 1000);
        g2.drawString("Celkove hp  " + (int) prepocitaneZivortPercenta + "%", 700, 1000);
        if (prepocitaneZivortPercenta == 0) {
            this.koniecHry = true;

        }

        Font font2 = new Font("Serif", Font.PLAIN, 20);
        g2.setFont(font2);
        g2.drawString("Normalne strely:  " + this.hrac.getPocetNormalnychStriel(), 800, 30);
        g2.drawString("Navadzacie strely:  " + this.hrac.getPocetNavadzacichStriel(), 800, 60);
        if (this.koniecHry) {
            Font font3 = new Font("Serif", Font.PLAIN, 69);
            g2.setFont(font3);
            g2.drawString("koniec hry, prezil si " + this.aktualneSkore / 60 + " sekund", 100, 200);

        }
    }


    /**
     * @param g vykresluje vsetky objekty
     */
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;  //zmena Graphics do Graphics2
        g2.setColor(Color.white);
        this.pozadie.draw(g2);
        this.hrac.draw(g2);
        for (EntitaStacionarne entitaStacionarne : this.pozemneEntity) {
            entitaStacionarne.draw(g2);
        }
        for (Entita raketa : new ArrayList<>(this.raketky)) {

            raketa.draw(g2);
        }
        for (AirDrop airDrop : this.airDrops) {
            airDrop.draw(g2);
        }

        this.vykresliAktualneSkore(g2);


        g2.dispose();
    }
}
