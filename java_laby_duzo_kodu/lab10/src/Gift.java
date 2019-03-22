import java.awt.*;

public class Gift implements XmasShape {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color giftColor;
    double scale;



    public Gift(int x,int y,int width,int height, Color giftcolor,double scale){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.giftColor=giftcolor;
        this.scale=scale;

    }
    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(giftColor);
        g2d.fillRect(x, y, width, height);

    }
}
