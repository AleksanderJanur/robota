import java.io.PrintStream;

public class ParagraphWithList extends Paragraph{
    UnorderedList list = new UnorderedList();

    ParagraphWithList(){
        super();
    }
    ParagraphWithList setContent(String dupka2){
        this.content = dupka2;
        return this;
    }


    ParagraphWithList addListItem(String item){
        this.list.addItem(item);
        return this;
    }
@Override
    void writeHTML(PrintStream out){
        out.printf("<p>\n");
        super.writeHTML(out);
        list.writeHTML(out);
        out.printf("</p>\n");
    }
}
