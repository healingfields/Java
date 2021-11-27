package ma.showMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Ecran extends JFrame {
    JPanel MyPanel;
    ArrayList<Circle> CirclesList = new ArrayList<Circle>();
    Timer clock;
    public void initializeCircles(){
        String chaine;
        String fragements[];
        try {
            FileReader fr = new FileReader("/home/idriss/DevSection/Java/FormationTPs/TP5/src/savedCircles.txt");
            BufferedReader br = new BufferedReader(fr);
            do {
                chaine = br.readLine();
                if(chaine!=null) {
                    fragements = chaine.split(" ");
                    Circle c = new Circle(Integer.parseInt(fragements[0]), Integer.parseInt(fragements[1]), Integer.parseInt(fragements[4]), Integer.parseInt(fragements[2]), Integer.parseInt(fragements[3]), new Color(Integer.parseInt(fragements[5])));
                    CirclesList.add(c);
                }
            } while (chaine!=null);
        }catch(Exception ex){
            System.out.println("failed");
        }
    }

    public Ecran() {

        this.setTitle("Mac miller : Circles");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(x / 2, y / 2);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeCircles();
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
                for(int i = 0 ; i<5;i++){
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

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    FileWriter fw = new FileWriter("/home/idriss/DevSection/Java/FormationTPs/TP5/src/savedCircles.txt");
                    PrintWriter pw = new PrintWriter(fw);
                    for (Circle c : CirclesList) {
                        pw.println(c.x + " " + c.y + " " + c.dx + " " + c.dy + " " + c.diameter + " " + c.color.getRGB());
                    }
                    pw.close();
                    fw.close();
                } catch (Exception ex) {
                    System.out.println("cant save the file");
                }
            }
        });

        this.setVisible(true);
    }

    }
