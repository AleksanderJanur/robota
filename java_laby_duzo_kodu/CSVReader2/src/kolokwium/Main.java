package kolokwium;
import lab2.CSVReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        ImionaList lista=new ImionaList();
        lista.read("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium\\imiona-2000-2016.csv");
        for(Imiona imiona : lista.imionalist){
            System.out.println(imiona);
        }
        System.out.println(lista.children("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium\\imiona-2000-2016.csv"));
        System.out.println(lista.popular_k("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium\\imiona-2000-2016.csv"));
        System.out.println(lista.popular_m("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium\\imiona-2000-2016.csv"));
    }

}
