package ma.showMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Ecran extends JFrame {
    JPanel MyPanel;
    ArrayList<Circle> CirclesList = new ArrayList<Circle>();
    Timer clock;

    public Ecran() {

        this.setTitle("Mac miller : Circles");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(x / 2, y / 2);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MyPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (Circle circleToDraw : CirclesList) {
                    g.setColor(circleToDraw.color);
                    g.fillOval(circleToDraw.x, circleToDraw.y, circleToDraw.diameter, circleToDraw.diameter);

                }
            }
        };
        this.setContentPane(MyPanel);

        MyPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("clicked yaaaa!");
                Random r = new Random();
                for(int i = 0 ; i<50;i++){
                    int diameter = 10 + r.nextInt(50);
                    int dx = -20 + r.nextInt(40);
                    int dy = -20 + r.nextInt(40);
                    Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
                    Circle circle = new Circle(e.getX() - diameter / 2, e.getY() - diameter / 2, diameter, dx, dy, c);
                    CirclesList.add(circle);
                }
                repaint();
            }
        });


        clock = new Timer(200,
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        for (int i = 0; i < CirclesList.size(); i++) {
                            CirclesList.get(i).x += CirclesList.get(i).dx;
                            CirclesList.get(i).y += CirclesList.get(i).dy;
                            if (CirclesList.get(i).x > MyPanel.getWidth() && CirclesList.get(i).dx > 0 ||
                                    CirclesList.get(i).x < 0 && CirclesList.get(i).dx < 0) {
                                CirclesList.get(i).dx *= -1;
                            }
                            if (CirclesList.get(i).y > MyPanel.getHeight() && CirclesList.get(i).dy > 0 ||
                                    CirclesList.get(i).y < 0 && CirclesList.get(i).dy < 0) {
                                CirclesList.get(i).dy *= -1;
                            }
                        }
                        repaint();

                    }
                });
        clock.start();
        MyPanel.setBackground(Color.black);
        this.setVisible(true);


    }
    }
