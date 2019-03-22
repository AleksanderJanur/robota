package kolokwium2;
import lab2.CSVReader;
public class StockItem {
    String product_code;
    int active;
    String name;
    double prize;
    int vat;
    String unit;
    String category;
    String producer;
    double weight;
    int stock;
    String ean;
    String delivery;

    StockItem(String product_code, int active, String name, double prize, int vat, String unit, String category, String producer, double weight, int stock, String ean, String delivery) {
        this.product_code = product_code;
        this.active = active;
        this.name = name;
        this.prize = prize;
        this.vat = vat;
        this.unit = unit;
        this.category = category;
        this.producer = producer;
        this.weight = weight;
        this.stock = stock;
        this.ean = ean;
        this.delivery = delivery;
    }
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(product_code + active + name + prize+ vat + unit + category + producer + weight + stock + ean + delivery);
        return b.toString();
    }
}
