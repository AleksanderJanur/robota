import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // write your code here
        JFrame frame = new JFrame("Choinka");
        //  Bubble b= new Bubble(150,50,1,Color.red,Color.yellow);
        DrawPanel d = new DrawPanel();
        // addBubbles(d);
        frame.setContentPane(d);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        //d.addShape(b);
        //addBubbles(d);
        Trunk trunk = new Trunk(280, 440, 1);
        d.addShape(trunk);
        Branch br = new Branch(300, 200, 50, Color.green);
        d.addShape(br);
     //   Light l = new Light(500, 200, 2, Color.yellow);
       // d.addShape(l);
        Star s = new Star(240, 55, 1, Color.yellow);
        d.addShape(s);
        Gift g = new Gift(50, 230, 100, 100, Color.blue, 1);
        d.addShape(g);
        addGifts(d);
        addBackground(d);
        Branch br2 = new Branch(300, 100, 100, Color.green);
        d.addShape(br2);
        Branch br3 = new Branch(300, 0, 150, Color.green);
        d.addShape(br3);
        addBubbles(d);
        addlights(d);


    }

    private static void addBackground(DrawPanel panel) {
        Random rand = new Random();
        for (int i = 0; i < 175; ++i) {
            panel.addShape(new Snow(rand.nextInt(1000), rand.nextInt(700), 0.2, Color.white));
        }
    }


    private static void addBubbles(DrawPanel d) {
        d.addShape(new Bubble(300, 200, 0.2,
                new Color(189, 5, 5),
                new Color(120, 201, 255)));

        d.addShape(new Bubble(200, 400, 0.2,
                new Color(0xBD27AC),
                new Color(0xB42FBD)));

        d.addShape(new Bubble(370, 370, 0.2,
                new Color(0xBD482A),
                new Color(0xBD3311)));

        d.addShape(new Bubble(300, 360, 0.2,
                new Color(0x261DBD),
                new Color(0x0022FF)));

        d.addShape(new Bubble(340, 280, 0.2,
                new Color(0xFF252D),
                new Color(0xFF252D)));

        d.addShape(new Bubble(280, 400, 0.2,
                new Color(0x100530),
                new Color(0x100530)));

        d.addShape(new Bubble(300, 300, 0.2,
                new Color(0xBD007D),
                new Color(0xBD007D)));
        d.addShape(new Bubble(250, 300, 0.2,
                new Color(0xBDB813),
                new Color(0xBDB813)));
        d.addShape(new Bubble(270, 250, 0.2,
                new Color(0x2BBDAC),
                new Color(0x2BBDAC)));
        d.addShape(new Bubble(240, 370, 0.2,
                new Color(0x6B054A),
                new Color(0x6B054A)));
        d.addShape(new Bubble(340, 420, 0.2,
                new Color(0xCB4214),
                new Color(0xCB4214)));
        d.addShape(new Bubble(300, 240, 0.2,
                new Color(0xF6F4FF),
                new Color(0xF7FFE6)));
    }

    private static void addGifts(DrawPanel d) {
        d.addShape(new Gift(100, 240, 75, 75, Color.pink, 1));
        d.addShape(new Gift(160, 231, 75, 75, Color.red, 1));
        d.addShape(new Gift(180, 250, 75, 75, Color.orange, 1));
        d.addShape(new Gift(120, 270, 75, 75, new Color(48, 5, 48), 1));
        d.addShape(new Gift(200, 235, 75, 75, new Color(189, 136, 52), 1));
    }

    private static void addlights(DrawPanel d) {
        d.addShape(new Light(240, 325, 2, new Color(255, 215, 8)));
        d.addShape(new Light(360, 395, 2, new Color(255, 215, 8)));
        d.addShape(new Light(275, 205, 2, new Color(255, 215, 8)));
        d.addShape(new Light(330, 330, 2, new Color(255, 215, 8)));
        d.addShape(new Light(240, 410, 2, new Color(255, 215, 8)));

    }
}



