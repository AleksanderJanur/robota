import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    String title;
    List<Paragraph> paragraps = new ArrayList<>();

    Section(String text){
        this.setTitle(text);
    }
    Section setTitle(String title){
        this.title= title;
        return this;
    }

    Section addParagraph(String paragraphText){
        this.paragraps.add(new Paragraph(paragraphText));

        return this;
    }

    Section addParagraph(Paragraph p){
        this.paragraps.add(p);

        return this;
    }

    void writeHTML(PrintStream out){
        out.printf("<div>\n");
        out.printf("<h1> %s </h1>",title);
        for (Paragraph paragraph:paragraps) paragraph.writeHTML(out);
        out.printf("</div>\n");
    }




}
