import java.io.PrintStream;

public class Paragraph {
    String content;

    Paragraph(){}
    Paragraph(String text){
        this.content= text;
    }
    Paragraph setContent(String dupka2){
        this.content = dupka2;
        return this;
    }

    void writeHTML(PrintStream out){
        out.printf("<p> %s </p>\n",content);
    }
}
