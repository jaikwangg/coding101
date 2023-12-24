import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class lab2 extends JFrame {

    private List<Point> naiveLine(int x1, int y1, int x2, int y2) {
        List<Point> points = new ArrayList<>();
        float dx = x2 - x1;
        float dy = y2 - y1;
        float b = y1 - (dy / dx) * x1;

        for (int x = x1; x <= x2; x++) {
            int y = Math.round((dy / dx) * x + b);
            points.add(new Point(x, y));
        }

        return points;
    }
    private List<Point> ddaLine(int x1, int y1, int x2, int y2) {
        List<Point> points = new ArrayList<>();
        float dx = x2 - x1;
        float dy = y2 - y1;
        float m = dy / dx;

        if (m >= 0 && m <= 1) {
            for (int x = x1; x <= x2; x++) {
                x1 += m;
                points.add(new Point(x, Math.round(x1)));
            }
        } else if (m <= -1) {
            for (int x = x2; x >= x1; x--) {
                x2 += m;
                points.add(new Point(x, Math.round(x2)));
            }
        } else if (m > 1) {
            for (int y = y1; y <= y2; y++) {
                y1 += 1 / m;
                points.add(new Point(Math.round(y1), y));
            }
        } else {
            for (int y = y2; y <= y1; y++) {
                y2 += 1 / m;
                points.add(new Point(Math.round(y2), y));
            }
        }

        return points;
    }

    public lab2() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        drawLine(g2d, naiveLine(100, 100, 400, 200));
        drawLine(g2d, naiveLine(400, 300, 100, 200));
        drawLine(g2d, naiveLine(100, 100, 200, 400));

        drawLine(g2d, ddaLine(100, 100, 400, 200));
        drawLine(g2d, ddaLine(400, 300, 100, 200));
        drawLine(g2d, ddaLine(100, 100, 200, 400));
    }

    private void drawLine(Graphics2D g2d, List<Point> points) {
        for (Point point : points) {
            g2d.drawLine(point.x, point.y, point.x, point.y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new lab2());
    }
}
