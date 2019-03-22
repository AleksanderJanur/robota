import java.awt.*;
public class Star implements XmasShape {
    private int x, y;
    private double scale;
    private Color starColor;

    public Star(int x, int y, double scale, Color starColor) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.starColor = starColor;
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x, y);
        g2d.scale(scale, scale);

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(starColor);
        int tabX[] = {60, 80, 120, 93, 100, 60, 23, 30, 0, 40};
        int tabY[] = {0, 37, 43, 73, 113, 97, 113, 73, 43, 37};
        g2d.fillPolygon(tabX, tabY, tabX.length);

        }


    }
