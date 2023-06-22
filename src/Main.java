import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main
{
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JFrameWindow();
    }
}

class JFrameWindow extends JFrame
{
    private static final long serialVersionUID = 1L;

    public JFrameWindow()
    {
        super("snow man picture");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        this.add(new SnowMan());

        this.setPreferredSize(new Dimension(800, 600));

        this.setLocation(600, 200);

        this.pack();

        this.setVisible(true);
    }
}

class SnowMan extends Canvas
{
    private static final int xo = 220;
    private static final int yo = 100;
    private Graphics gr;

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        this.gr = g;

        this.setBackground(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        int[] hand1 = new int[]{234, 249, 306, 225, 317, 204, 323, 208, 313, 225, 336, 221, 338, 228, 315, 232, 328, 245, 323, 248, 307, 234, 238, 258};
        int[] hand2 = new int[]{129, 249, 58, 225, 47, 205, 42, 209, 51, 225, 30, 221, 28, 228, 49, 232, 36, 243, 41, 248, 58, 235, 126, 257};
        int[] nose = new int[]{183, 189, 234, 188, 185, 199};
        int[] hatBeltLine = new int[]{149, 137, 206, 137};
        int[] roundsCentres = new int[]{187, 252, 187, 270, 187, 287, 168, 206, 179, 210, 191, 210, 201, 205};
        int[] eyes = new int[]{175, 179, 197, 178};

        drawCircle(176 + xo, 380, 80, Color.WHITE, true);
        drawCircle(176 + xo, 380, 80, Color.BLACK, false);
        drawCircle(177 + xo, 273, 62, Color.WHITE, true);
        drawCircle(177 + xo, 273, 62, Color.BLACK, false);
        drawCircle(175 + xo, 185, 45, Color.WHITE, true);
        drawCircle(175 + xo, 185, 45, Color.BLACK, false);

        int a = 55, b = 10;
        gr.setColor(Color.WHITE);
        gr.fillOval(175 + xo - a, 155 - b, a*2, b*2);
        gr.setColor(Color.BLACK);
        gr.drawOval(175 + xo - a, 155 - b, a*2, b*2);

        gr.setColor(Color.WHITE);
        gr.fillRoundRect(148 + xo, 100, 58, 50, 10, 10);
        gr.setColor(Color.BLACK);
        gr.drawRoundRect(148 + xo, 100, 58, 50, 10, 10);

        this.drawPolygon(nose, Color.WHITE,true);
        this.drawPolygon(nose, Color.BLACK,false);
        this.drawPolygon(hand1, Color.WHITE, true);
        this.drawPolygon(hand1, Color.BLACK, false);
        this.drawPolygon(hand2, Color.WHITE, true);
        this.drawPolygon(hand2, Color.BLACK, false);
        this.drawPolygon(hatBeltLine, Color.BLACK, false);


        for (int i = 0; i < eyes.length / 2; i++) {
            drawCircle(eyes[i*2] + xo, eyes[i*2 + 1], 4, Color.BLACK, false);
        }
        for (int i = 0; i < roundsCentres.length / 2; i++) {
            drawCircle(roundsCentres[i*2] + xo, roundsCentres[i*2 + 1], 3, Color.BLACK, false);
        }

    }

    private void drawCircle(int x, int y, int r, Color color, boolean fill)
    {
        gr.setColor(color);

        if (fill) {
            gr.fillOval(x - r, y - r, r * 2, r * 2);
        } else {
            gr.drawOval(x - r, y - r, r * 2, r * 2);
        }
    }

    private void drawPolygon(int[] poly, Color color, boolean fill)
    {
        int[] xp, yp;

        xp = new int[poly.length / 2];
        yp = new int[poly.length / 2];
        for (int i = 0; i < poly.length / 2; i++) {
            xp[i] = poly[i*2] + xo;
            yp[i] = poly[i*2 + 1];
        }

        gr.setColor(color);
        if (fill) {
            gr.fillPolygon(xp, yp, poly.length / 2);
        } else {
            gr.drawPolygon(xp, yp, poly.length / 2);
        }
    }
}