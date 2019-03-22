import java.io.PrintStream;

public class ListItem {
    String content;

    void writeHTML (PrintStream out){
        out.printf("<li>%s</li>\n",content);
    }

    public ListItem(String dupka){
        this.content = dupka;
    }

}
