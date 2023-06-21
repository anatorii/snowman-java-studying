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

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                System.exit(0);
            }
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        this.add(new SnowMan());

        this.setPreferredSize(new Dimension(800, 600));

        this.setLocation(600, 200);

        this.pack();

        this.setVisible(true);
    }
}

class SnowMan extends Canvas
{
    private static int xo = 220;
    private static int yo = 100;
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

        drawCircle(176 + xo, 380, 80);
        drawCircle(177 + xo, 273, 62);
        drawCircle(175 + xo, 185, 45);

        int a = 55, b = 10;
        gr.setColor(Color.WHITE);
        gr.fillOval(175 + xo - a, 155 - b, a*2, b*2);
        gr.setColor(Color.BLACK);
        gr.drawOval(175 + xo - a, 155 - b, a*2, b*2);

        gr.setColor(Color.WHITE);
        gr.fillRoundRect(148 + xo, 100, 58, 50, 10, 10);
        gr.setColor(Color.BLACK);
        gr.drawRoundRect(148 + xo, 100, 58, 50, 10, 10);

        this.drawPolygon(nose, true);
        this.drawPolygon(hand1, true);
        this.drawPolygon(hand2, true);
        this.drawPolygon(hatBeltLine, false);


        for (int i = 0; i < eyes.length / 2; i++) {
            drawCircle(eyes[i*2] + xo, eyes[i*2 + 1], 4);
        }
        for (int i = 0; i < roundsCentres.length / 2; i++) {
            drawCircle(roundsCentres[i*2] + xo, roundsCentres[i*2 + 1], 3);
        }

    }

    private void drawCircle(int x, int y, int r)
    {
        gr.setColor(Color.WHITE);
        gr.fillOval(x - r, y - r, r*2, r*2);
        gr.setColor(Color.BLACK);
        gr.drawOval(x - r, y - r, r*2, r*2);
    }

    private void drawPolygon(int[] poly, boolean fill)
    {
        int[] xp, yp;

        xp = new int[poly.length / 2];
        yp = new int[poly.length / 2];
        for (int i = 0; i < poly.length / 2; i++) {
            xp[i] = poly[i*2] + xo;
            yp[i] = poly[i*2 + 1];
        }

        if (fill) {
            gr.setColor(Color.WHITE);
            gr.fillPolygon(xp, yp, poly.length / 2);
        }
        gr.setColor(Color.BLACK);
        gr.drawPolygon(xp, yp, poly.length / 2);
    }
}