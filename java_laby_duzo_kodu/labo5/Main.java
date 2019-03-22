import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {
    static void buildAndPrint(){
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        System.out.println(exp.toString());
    }
    static void buildAndEvaluate() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(new Power(x, 3))
                .add(-2, new Power(x, 2))
                .add(-1, x)
                .add(2);
        System.out.println(exp);
        for (double v = -5; v < 5; v += 0.1) {
            x.setValue(v);
            System.out.printf(Locale.US, "f(%f)=%f\n", v, exp.evaluate());
        }
    }


    static void defineCircle() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Node circle = new Sum()
                .add(new Power(x, 2))
                .add(new Power(y, 2))
                .add(8, x)
                .add(4, y)
                .add(16);
        System.out.println(circle.toString());

        Set<Point> differentResults = new HashSet();
        while (differentResults.size() < 100) {
            Point p = Point.getRandomPoint(0.5, 100);
            x.setValue(p.x);
            y.setValue(p.y);
            double fv = circle.evaluate();
            if (fv < 0) {
                differentResults.add(p);
            }
        }

        int i = 0;
        for (Point p: differentResults) {
            System.out.println(p);
            x.setValue(p.x);
            y.setValue(p.y);
            double fv = circle.evaluate();
            i++;
            System.out.println(String.format("%d, Punkt (%f,%f) leży %s koła %s", i, p.x, p.y, (fv < 0 ? "wewnątrz" : "na zewnątrz"), circle.toString()));
        }


            double xv = 100 * (Math.random() - .5);
           double yv = 100 * (Math.random() - .5);
            x.setValue(xv);
            y.setValue(yv);
            double fv = circle.evaluate();
            System.out.println(String.format("Punkt (%f,%f) leży %s koła %s", xv, yv, (fv < 0 ? "wewnątrz" : "na zewnątrz"), circle.toString()));
        }



        public static void main (String[]args){
            buildAndPrint();
            buildAndEvaluate();
            defineCircle();
        }
    }

// 2.1*x^3 + x^2 + (-2)*x + 7