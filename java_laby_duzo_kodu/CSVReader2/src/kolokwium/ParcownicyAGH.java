package kolokwium;
import lab2.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ParcownicyAGH {
    public static void main(String[] args) {


        BufferedReader br = null;
        FileReader fr = null;


        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium\\w-pustyni"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
            fr = new FileReader("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\src\\kolokwium\\w-pustyni");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
            br = new BufferedReader(fr);

            String sCurrentLine;
            List<String> words = new ArrayList<String>();

            String pattern = "[\\s|\\r|\\,|\\.|\\-|\\!|\\—|\\?]+";
            while ((sCurrentLine = br.readLine()) != null) {
                words.addAll(Arrays.asList(sCurrentLine.split(pattern)));
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (String word : words) {
                int wordLength = word.length();
                if (map.containsKey(wordLength))
                    map.put(wordLength, map.get(wordLength) + 1);
                else
                    map.put(wordLength, 1);
            }
            List<Integer> maxSizes = new ArrayList<>();
            int maxLength = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (value > maxLength) {
                    maxLength = value;
                    maxSizes.clear();
                    maxSizes.add(key);
                } else if (value == maxLength) {
                    maxSizes.add(key);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

