package kolokwium2;
import lab2.CSVReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StockItemList Silist = new StockItemList();
        Silist.read("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium2\\super-toys.csv");
            for (StockItem stockt : Silist.StockItemList) {
                System.out.println(stockt);
            }
            System.out.println(Silist.najciezsze("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium2\\super-toys.csv"));
        System.out.println(Silist.swn("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium2\\super-toys.csv"));

        StockItemList selectByName = Silist.selectByName("mercedes", true);
        for (StockItem s : selectByName.StockItemList) {
            System.out.println(s.name);
    }
    }
}



