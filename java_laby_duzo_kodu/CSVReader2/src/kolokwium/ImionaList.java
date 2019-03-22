package kolokwium;

import lab2.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImionaList {
    List<Imiona> imionalist = new ArrayList<>();

    public void read(String filename) throws IOException {
        CSVReader fileReader = new CSVReader(filename, ";", true);
        while (fileReader.next()) {
            int rok = fileReader.getInt("Rok");
            String imie = fileReader.get("Imię");
            int liczba = fileReader.getInt("Liczba");
            String plec = fileReader.get("Płeć");
            Imiona imiona = new Imiona(rok, imie, liczba, plec);
            imionalist.add(imiona);

        }


    }

    public String popular_k(String filename) throws IOException {
        CSVReader fileReader = new CSVReader(filename, ";", true);
        Map<Integer,String> bestk = new HashMap<>();
         Integer tmp=100;
        while (fileReader.next()) {
            int rok = fileReader.getInt("Rok");
            String imie = fileReader.get("Imię");
            Integer liczba = fileReader.getInt("Liczba");
            String plec = fileReader.get("Płeć");
            Imiona imiona = new Imiona(rok, imie, liczba, plec);
            if (liczba > tmp) {
                tmp = liczba;

            }
            if (plec=="K") {
                bestk.put(liczba, imie);
            }
        }
        System.out.println(tmp);
            return  bestk.get(tmp);

        }


    public String popular_m(String filename) throws IOException {
        CSVReader fileReader = new CSVReader(filename, ";", true);
        Map<Integer,String> bestm = new HashMap<>();
        int tmp=0;
        while (fileReader.next()) {
            int rok = fileReader.getInt("Rok");
            String imie = fileReader.get("Imię");
            int liczba = fileReader.getInt("Liczba");
            String plec = fileReader.get("Płeć");
            Imiona imiona = new Imiona(rok, imie, liczba, plec);
            if (imiona.plec=="M") {
                bestm.put(liczba, imie);
                if (imiona.liczba > tmp) {
                    tmp = imiona.liczba;

                }
            }
        }
        return  bestm.get(tmp);

    }




    public int children(String filename) throws IOException {

        CSVReader fileReader = new CSVReader(filename, ";", true);
        int count=0;
        while (fileReader.next()) {
            int rok = fileReader.getInt("Rok");
            String imie = fileReader.get("Imię");
            int liczba = fileReader.getInt("Liczba");
            String plec = fileReader.get("Płeć");
            Imiona imiona = new Imiona(rok, imie, liczba, plec);
            count+=imiona.liczba;


        }
        return count;
    }
}
