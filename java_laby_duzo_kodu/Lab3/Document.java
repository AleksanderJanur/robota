import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    String title;
    Photo photo;
    List<Section>  sectionList = new ArrayList<>();

    //--------------------------//

    Document(String title){
        this.setTitle(title);
    }
    Document setTitle(String title){
        this.title=title;
        return this;
    }

    Document addPhoto(String photoUrl){
        this.photo = new Photo(photoUrl);
        return this;
    }

    Section addSection(String sectionTitle){
        Section nowaSekcja = new Section(sectionTitle);
        sectionList.add(nowaSekcja);
        return nowaSekcja;
    }

    Document addSection(Section s){
        sectionList.add(s);
        return this;
    }
    void writeHTML(PrintStream out){
        out.printf("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n");

        photo.writeHTML(out);
        for (Section section:sectionList) section.writeHTML(out);
        out.printf("</body>\n" +
                "</html>");}
}

