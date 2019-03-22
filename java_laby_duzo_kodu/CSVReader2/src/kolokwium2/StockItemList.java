package kolokwium2;
import lab2.CSVReader;

import kolokwium.Imiona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockItemList {
    List<StockItem> StockItemList = new ArrayList<>();

    public void read(String filename) throws IOException {
        CSVReader fileReader = new CSVReader(filename, ";", true);
        while (fileReader.next()) {
            String product_code = fileReader.get("product_code");
            int active = fileReader.getInt("active");
            String name = fileReader.get("name");
            double prize = fileReader.getDouble("price");
            int vat = fileReader.getInt("vat");
            String unit = fileReader.get("unit");
            String category = fileReader.get("category");
            String producer = fileReader.get("producer");
            double weight = fileReader.getDouble("weight");
            int stock = fileReader.getInt("stock");
            String ean = fileReader.get("ean");
            String delivery = fileReader.get("delivery");
            StockItem stockitem = new StockItem(product_code, active, name, prize, vat, unit, category, producer, weight, stock, ean, delivery);
            StockItemList.add(stockitem);

        }
    }
    public double najciezsze(String filename) throws IOException {
        double tmp=0;
        CSVReader fileReader = new CSVReader(filename, ";", true);
        while (fileReader.next()) {
            String product_code = fileReader.get("product_code");
            int active = fileReader.getInt("active");
            String name = fileReader.get("name");
            double prize = fileReader.getDouble("price");
            int vat = fileReader.getInt("vat");
            String unit = fileReader.get("unit");
            String category = fileReader.get("category");
            String producer = fileReader.get("producer");
            double weight = fileReader.getDouble("weight");
            int stock = fileReader.getInt("stock");
            String ean = fileReader.get("ean");
            String delivery = fileReader.get("delivery");
            StockItem stockitem = new StockItem(product_code, active, name, prize, vat, unit, category, producer, weight, stock, ean, delivery);
            if(stockitem.category.equals("Wózki dla lalek")){
                if(stockitem.weight>tmp){
                    tmp=stockitem.weight;
                }
            }
        }
        return tmp;
    }

    StockItemList selectByName(String pattern, boolean regex) {
        StockItemList ret = new StockItemList();

        for (StockItem s : StockItemList) {
            if ((regex && s.name.matches(pattern)) || s.name.contains(pattern)) {
                ret.StockItemList.add(s);
            }
        }
        return ret;
    }

    public double srednia(String filename) throws IOException {
        double srednia=0;
        int i=0;
        CSVReader fileReader = new CSVReader(filename, ";", true);
        StockItemList tmp=new StockItemList();
        StockItemList selectByName = tmp.selectByName("mercedes", true);
        while (fileReader.next()) {
            String product_code = fileReader.get("product_code");
            int active = fileReader.getInt("active");
            String name = fileReader.get("name");
            double prize = fileReader.getDouble("price");
            int vat = fileReader.getInt("vat");
            String unit = fileReader.get("unit");
            String category = fileReader.get("category");
            String producer = fileReader.get("producer");
            double weight = fileReader.getDouble("weight");
            int stock = fileReader.getInt("stock");
            String ean = fileReader.get("ean");
            String delivery = fileReader.get("delivery");
            StockItem stockitem = new StockItem(product_code, active, name, prize, vat, unit, category, producer, weight, stock, ean, delivery);
            for (StockItem s : selectByName.StockItemList) {
                if (s.name.equals("Samochody na akumulator")){
                    srednia+=stockitem.prize;
                    i++;

                }
            }

        }
        return srednia/i;
    }
    public double swn(String filename) throws IOException {
        double sum=0;
        CSVReader fileReader = new CSVReader(filename, ";", true);
        while (fileReader.next()) {
            String product_code = fileReader.get("product_code");
            int active = fileReader.getInt("active");
            String name = fileReader.get("name");
            double prize = fileReader.getDouble("price");
            int vat = fileReader.getInt("vat");
            String unit = fileReader.get("unit");
            String category = fileReader.get("category");
            String producer = fileReader.get("producer");
            double weight = fileReader.getDouble("weight");
            int stock = fileReader.getInt("stock");
            String ean = fileReader.get("ean");
            String delivery = fileReader.get("delivery");
            StockItem stockitem = new StockItem(product_code, active, name, prize, vat, unit, category, producer, weight, stock, ean, delivery);
            sum += prize * stock;
        }
        return sum;


    }
}