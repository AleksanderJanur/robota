import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
        DrawPanel(){
            setBackground(new Color(160, 208, 255));
    //       setOpaque(true);
        }
        List<XmasShape> shapes = new ArrayList<>();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (XmasShape s : shapes) {
                s.draw((Graphics2D) g);
            }
            g.setColor(new Color(230, 0, 0));
            g.setFont(new Font("courier", Font.BOLD, 60));
            g.drawString("Wesołych świąt!", 450, 125);
        }
        public void addShape(XmasShape shape) {
            if (shape == null) return;
            this.shapes.add(shape);
        }

    }


