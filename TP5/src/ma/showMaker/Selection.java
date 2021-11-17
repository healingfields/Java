package ma.showMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Selection extends JFrame
{
    JPanel myPanel ;
    int larg=100;
    int nbrCases=8;
    int x=50,y=50;
    public Selection(){
        this.setTitle("SAGA");
        this.setSize(50*2 + nbrCases*larg + 20 ,50*2 + nbrCases*larg + 50
        );
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        myPanel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.black);
                for(int i = 0;i<=nbrCases;i++){//lignes horizontales
                    g.drawLine(50,50+ i*larg,50 + larg*nbrCases,50+i*larg);
                }
                for(int i = 0;i<=nbrCases;i++){//lignes verticales
                    g.drawLine(50+i*larg,50,50 + larg*i,50+nbrCases*larg);
                }
                g.setColor(Color.pink);
                g.fillRect(x+larg,y,larg,larg);
            }
        };
        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
              //
            }
        });




        this.setContentPane(myPanel);
        this.setVisible(true);
    }
}
