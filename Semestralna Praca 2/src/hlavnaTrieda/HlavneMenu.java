package hlavnaTrieda;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 29/03/2022 - 12:54
 *
 * @author 2karo
 */
public class HlavneMenu extends JFrame {
    private JPanel hlavnyPanel;
    private JPanel hlavnyPanel2;
    private JButton button1;
    private JLabel hlavnyObrazok;

    public HlavneMenu() {
        this.setContentPane(this.hlavnyPanel);
        this.setTitle("Missle Command");
        this.setSize(600, 500);
        //this.setLocation(100, 100);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        this.setLocation(d.width / 2 - 300, d.height / 2 - 300);
        this.setResizable(true);


        this.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame okno = new JFrame();
                okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                okno.setTitle("Missle Command");
                okno.setSize(new Dimension(1000, 1000));
                okno.setResizable(false);
                okno.setExtendedState(JFrame.MAXIMIZED_BOTH);


                OknoHry oknoHry = new OknoHry();
                okno.add(oknoHry);
                okno.pack();
                //okno.setBackground(Color.BLACK);
                okno.setLocationRelativeTo(null); //vygeneruje sa v strede obrazovky
                okno.setVisible(true);
                oknoHry.zapniHru();
                HlavneMenu.this.dispose();
            }
        });


    }

    private void createUIComponents() {
        this.hlavnyObrazok = new JLabel(new ImageIcon("pics/hlavneMenu.png"));
    }
}
