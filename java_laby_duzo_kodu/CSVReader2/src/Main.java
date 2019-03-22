import lab2.CSVReader;

import java.io.IOException;
import java.util.Locale;

public class Main {
   public static void main(String[] args) throws IOException {
//        //        lab2.CSVReader reader_tmp = new lab2.CSVReader(new BufferedReader(new FileReader("")))
//        CSVReader reader = new CSVReader("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\out\\production\\CSVReader2\\admin-units.csv", ",", true);
//        System.out.printf(Locale.US,"LINESTRING(%f %f, %f %f, %f %f, %f %f)",
//                reader.getDouble("x1"),
//                reader.getDouble("y1"),
//                reader.getDouble("x2"),
//                reader.getDouble("y2"),
//                reader.getDouble("x3"),
//                reader.getDouble("y3"),
//                reader.getDouble("x4"),
//                reader.getDouble("y4")
//              //  reader.getDouble("x5"),
//            //    reader.getDouble("y5")
//        );
//        String text = "a,b,c\n123.4,567.8,91011.12";
        //     lab2.CSVReader reader;
        //      reader = new lab2.CSVReader("C:\\Users\\Olek\\Downloads\\accelerator.csv",",",true);
        //     System.out.println(reader);


//        lab2.CSVReader reader_tmp = new lab2.CSVReader(new BufferedReader(new FileReader("")))
//        CSVReader reader = new CSVReader("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\out\\production\\CSVReader2\\admin-units.csv", ",", true);
//        while (reader.next()) {
//            int id = reader.getInt("id");
//            String parent = reader.get("parent");
//            String name = reader.get("name");
//            System.out.printf(Locale.US, "%d %s %s \n", id, parent, name);
//
//        }


        AdminUnitList adminUnitList = new AdminUnitList();
       AdminUnit adminUnit2 = new AdminUnit("Bębło",8,-1,5.74514,-1, (long) 10464);

        adminUnitList.read("C:\\Users\\Olek\\IdeaProjects\\po2018-aleksander-janur\\CSVReader2\\out\\production\\CSVReader2\\admin-units.csv");
        AdminUnitList test = adminUnitList.getNeighbors(adminUnit2,15);
       double t1 = System.nanoTime()/1e6;
        for (AdminUnit a : test.units){
            System.out.println(a);
        }
       double t2 = System.nanoTime()/1e6;
       System.out.printf(Locale.US,"t2-t1=%f\n",t2-t1);
        AdminUnitList selectByName = adminUnitList.selectByName("Grażyna", false);
        for (AdminUnit adminUnit: selectByName.units) {
            System.out.println(adminUnit.getName());
            if (adminUnit.getParent() != null) {
                System.out.println(adminUnit.getParent().getName());
                adminUnitList.fixMissingValues(adminUnit);
            }
        }
       AdminUnitQuery query = new AdminUnitQuery()
               .selectFrom(new AdminUnitList())
               .where(a->a.getArea()>1000)
               .or(a->a.getName().startsWith("Sz"))
               .sort((a,b)->Double.compare(a.getArea(),b.getArea()))
               .limit(100);
       //query.execute().(out);
}
}

