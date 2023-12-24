import java.awt.*;
import javax.swing.*;

public class Lab1 extends JPanel {
    public static void main(String[] args) {
        Lab1 m = new Lab1();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        g.drawString("Hello", 40, 40);
        g.setColor(Color.BLUE);
        g.fillRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);
        g.setColor(Color.RED);
        g.drawLine(0, 0, 200, 30);
        g.fillOval(130, 130, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);

        
        g.setColor(Color.RED);
        plot(g, 300, 50);
        
        g.setColor(Color.BLUE);
        plot(g, 300, 100);
        
        g.setColor(Color.GREEN);
        plot(g, 300, 150);
        
        g.setColor(Color.ORANGE);
        plot(g, 300, 200);
        
        g.setColor(Color.MAGENTA);
        plot(g, 300, 250);
        
        g.setColor(Color.YELLOW);
        plot(g, 450, 50);
        
        g.setColor(Color.DARK_GRAY);
        plot(g, 450, 100);
        
        g.setColor(Color.PINK);
        plot(g, 450, 150);
        
        g.setColor(Color.CYAN);
        plot(g, 450, 200);
        
        g.setColor(Color.LIGHT_GRAY);
        plot(g, 450, 250);
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}