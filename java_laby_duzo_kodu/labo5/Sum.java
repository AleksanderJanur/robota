import java.util.ArrayList;
import java.util.List;

public class Sum extends Node {

    List<Node> args = new ArrayList<>();

    Sum() {
    }

    Sum(Node n1, Node n2) {
        args.add(n1);
        args.add(n2);
    }

    Sum add(Node n) {
        args.add(n);
        return this;
    }

    Sum add(double c) {
        args.add(new Constant(c));
        return this;
    }

    Sum add(double c, Node n) {
        Node mul = new Prod(c, n);
        args.add(mul);
        return this;
    }

    @Override
    double evaluate() {
        double result = 0;
//        oblicz sumę wartości nych przez wywołanie evaluate skłądników sumy
        for (Node n : args) {
            result += n.evaluate();
        }
        return sign * result;
    }

    int getArgumentsCount() {
        return args.size();
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        if (sign < 0) b.append("-(");
        for (int i = 0; i < args.size(); i++) {
            Node n = args.get(i);
            b.append(n.toString());
            if (i < args.size() - 1) {
                if (n.getSign() < 0) {
                    b.append("-");
                } else {
                    b.append("+");
                }
            }
        }

        if (sign < 0) b.append(")");
        return b.toString();
    }
 //   Node diffVanilla(Variable var) {
     //   Sum r = new Sum();
    //    for(Node n:args){
     //       r.add(n.diff(var));
        }
     //   return r;
  //  }


