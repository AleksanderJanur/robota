import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<ListItem> Lista = new ArrayList<ListItem>();

    UnorderedList addItem(String item){
        this.Lista.add(new ListItem(item)) ;
        return this;
    }

    void writeHTML(PrintStream out){
        out.printf("<ul>\n");
        for (ListItem listItem:Lista) listItem.writeHTML(out);
        out.printf("</ul>\n");

    }
}
