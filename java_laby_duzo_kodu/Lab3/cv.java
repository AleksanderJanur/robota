import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class cv {
    public static void main(String[] args) {
        Document cv = new Document("Jana Kowalski - CV");
        cv.addPhoto("C:\\Users\\Ula\\Documents\\kluska.jpg");
        cv.addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("...");
        cv.addSection("Umiejętności")
                .addParagraph(
                        new ParagraphWithList().setContent("Umiejętności")
                                .addListItem("C")
                                .addListItem("C++")
                                .addListItem("Java")
                );
        try{
            cv.writeHTML(new PrintStream("cv.html","ISO-8859-2"));
        } catch (FileNotFoundException | UnsupportedEncodingException e){};
    }
}
