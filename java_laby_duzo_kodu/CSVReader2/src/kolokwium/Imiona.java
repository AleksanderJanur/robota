package kolokwium;

import lab2.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Imiona {
    int rok;
    String imie;
    int liczba;
    String plec;

    Imiona(int rok, String imie, int liczba, String plec) {
        this.rok = rok;
        this.imie = imie;
        this.liczba = liczba;
        this.plec = plec;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(rok + imie + liczba + plec);
        return b.toString();
    }
}
