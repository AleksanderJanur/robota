package lab2;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;

    // nazwy kolumn w takiej kolejności, jak w pliku
    List<String> columnLabels = new ArrayList<>();
    // odwzorowanie: nazwa kolumny -> numer kolumny
        Map<String, Integer> columnLabelsToInt = new HashMap<>();

    public CSVReader(Reader reader,  String delimiter, boolean hasHeader) throws IOException  {
        this.reader = (BufferedReader) reader;
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if(hasHeader) parseHeader();
    }

    /**
     * @param filename  - nazwa pliku
     * @param delimiter - separator pól
     * @param hasHeader - czy plik ma wiersz nagłówkowy
     */

    public CSVReader(String filename, String delimiter, boolean hasHeader) throws IOException {
        this(new BufferedReader(new FileReader(filename)), delimiter, hasHeader);
    }

    public CSVReader(String filename,String delimiter) throws IOException {
        this(filename, delimiter, true);
    }

    public CSVReader(String filename) throws IOException {
        this(filename, ";", true);
    }
    void parseHeader() throws IOException {
        // wczytaj wiersz
        String line = reader.readLine();
        if (line == null) {
            return;
        }
        // podziel na pola
        String[] header = line.split(delimiter);
        // przetwarzaj dane w wierszu
        for (int i = 0; i < header.length; i++) {
            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i],i);
        }
        //...
    }

    List<String> getColumnLabels(){
        return columnLabels;
    }


    String[]current;

    int getRecordLength(){
        return current.length;
    }

    public boolean next() throws IOException {
        String line = reader.readLine();
        if (line == null){
            return false;
        }
        current = line.split(delimiter);
        return true;
    }

    public int getInt(String colName){
        if (isMissing(columnLabelsToInt.get(colName)))
            return -1;
        return Integer.parseInt(current [columnLabelsToInt.get(colName)]);//funkcja wygeneruje wyjatek jak by puste bylo

    }

    int getInt(int columnIndex){
        if (isMissing(columnIndex))
            return -1;
        return Integer.parseInt(current[columnIndex]);

    }
    public String get (int columnIndex){
        if (isMissing(columnIndex))
            return "-1";
        return current[columnIndex];
    }

    public String get(String colName){
        return get(columnLabelsToInt.get(colName));
    }

    public double getDouble(int columnIndex){
        if (isMissing(columnIndex))
            return -1;
        return Double.parseDouble(current [columnIndex]);
    }
    public double getDouble(String colName){
        return getDouble(columnLabelsToInt.get(colName));
    }

    public long getLong(int columnIndex){
        if (isMissing(columnIndex))
            return -1;
        return Long.parseLong(current [columnIndex]);
    }
    public long getLong(String colName){
        if (isMissing(columnLabelsToInt.get(colName)))
            return -1;
        return Long.parseLong(current [columnLabelsToInt.get(colName)]);
    }

    boolean isMissing(int columnIndex){
//        if (columnIndex>current.length || columnIndex<0)
//            return true;
//        if (current[columnIndex].isEmpty())
//            return true;
//        return false;
        return (columnIndex > current.length - 1 || columnIndex < 0) || current[columnIndex].isEmpty();
    }

    boolean isMissing(String columnLabel){
        return  isMissing(columnLabelsToInt.get(columnLabel));
    }

    LocalTime getTime(int columnIndex, String format){
        return LocalTime.parse(current[columnIndex], DateTimeFormatter.ofPattern(format));
    }

    LocalDate getDate(int columnIndex, String format){
        LocalDate date = LocalDate.parse(current[columnIndex], DateTimeFormatter.ofPattern(format));
        return date;
    }

    LocalDateTime getDateTime(int columnIndex, String format){
        LocalDateTime dt = LocalDateTime.parse(current[columnIndex], DateTimeFormatter.ofPattern(format));
        return dt;
    }


}
