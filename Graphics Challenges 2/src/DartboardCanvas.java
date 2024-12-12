import java.awt.*;
import javax.swing.*;

public class DartboardCanvas extends Canvas {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        DartboardCanvas canvas = new DartboardCanvas();
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas).setBackground(Color.gray);
        frame.setLocationRelativeTo(null); // Sets JFrame to center of screen
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Center of dartboard
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Dartboard dimensions
        int dartboardRadius = Math.min(getWidth(), getHeight()) / 2 - 20;

        // Colors for the dartboard
        Color black = Color.black;
        Color white = Color.white;
        Color red = Color.red;
        Color green = new Color(0, 128, 0);

        // Draw the 20 sections (base black and white segments first)
        int numberOfSections = 20;
        double angleStep = 360.0 / numberOfSections;
        double offsetAngle = angleStep / 2; // Adjust to align sections

        for (int i = 0; i < numberOfSections; i++) {
            double startAngle = i * angleStep + offsetAngle;

            Color sectionColor = (i % 2 == 0) ? black : white;
            g2d.setColor(sectionColor);

            g2d.fillArc(
                centerX - dartboardRadius, centerY - dartboardRadius,
                dartboardRadius * 2, dartboardRadius * 2,
                (int) -startAngle, (int) -angleStep
            );
        }

        // Draw concentric rings (bullseye and scoring zones)
        int[] ringRadii = {dartboardRadius, dartboardRadius - 40, dartboardRadius - 60, dartboardRadius - 80, dartboardRadius - 100, 15, 30};
        Color[] ringColors = {black, white, black, white, black, green, red};

        for (int i = 0; i < ringRadii.length; i++) {
            g2d.setColor(ringColors[i]);
            int diameter = ringRadii[i] * 2;
            g2d.fillOval(centerX - ringRadii[i], centerY - ringRadii[i], diameter, diameter);
        }

        // Draw double and triple scoring areas (green and red zones)
        int tripleOuterRadius = dartboardRadius - 80;
        int tripleInnerRadius = dartboardRadius - 100;
        int doubleOuterRadius = dartboardRadius - 40;
        int doubleInnerRadius = dartboardRadius - 60;

        for (int i = 0; i < numberOfSections; i++) {
            double startAngle = i * angleStep + offsetAngle;

            Color tripleColor = (i % 2 == 0) ? green : red;
            g2d.setColor(tripleColor);

            // Triple ring
            g2d.fillArc(
                centerX - tripleOuterRadius, centerY - tripleOuterRadius,
                tripleOuterRadius * 2, tripleOuterRadius * 2,
                (int) -startAngle, (int) -angleStep
            );
            g2d.setColor(black);
            g2d.fillArc(
                centerX - tripleInnerRadius, centerY - tripleInnerRadius,
                tripleInnerRadius * 2, tripleInnerRadius * 2,
                (int) -startAngle, (int) -angleStep
            );

            Color doubleColor = (i % 2 == 0) ? green : red;
            g2d.setColor(doubleColor);

            // Double ring
            g2d.fillArc(
                centerX - doubleOuterRadius, centerY - doubleOuterRadius,
                doubleOuterRadius * 2, doubleOuterRadius * 2,
                (int) -startAngle, (int) -angleStep
            );
            g2d.setColor(black);
            g2d.fillArc(
                centerX - doubleInnerRadius, centerY - doubleInnerRadius,
                doubleInnerRadius * 2, doubleInnerRadius * 2,
                (int) -startAngle, (int) -angleStep
            );
        }

        // Draw numbers
        g2d.setColor(white);
        Font font = new Font("Arial", Font.BOLD, 18);
        g2d.setFont(font);

        // Adjust the number order for right-shifting, moving "20" to the last segment
        int[] numberOrder = {1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5, 20};

        // Loop to draw the numbers in the new order
        for (int i = 0; i < numberOfSections; i++) {
            double angle = Math.toRadians(i * angleStep - 90 + offsetAngle + 10); // Adjust angle for correct placement
            int textRadius = dartboardRadius + 20;
            int x = (int) (centerX + textRadius * Math.cos(angle));
            int y = (int) (centerY + textRadius * Math.sin(angle));

            String number = String.valueOf(numberOrder[i]);
            int textWidth = g2d.getFontMetrics().stringWidth(number);
            int textHeight = g2d.getFontMetrics().getHeight();

            g2d.drawString(number, x - textWidth / 2, y + textHeight / 4);
        }
    }
}
