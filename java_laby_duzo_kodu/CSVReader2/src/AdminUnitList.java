import lab2.CSVReader;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Predicate;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();


    /**
     * Czyta rekordy pliku i dodaje do listy
     *
     * @param filename nazwa pliku
     */

    public void read(String filename) throws IOException {
        CSVReader fileReader = new CSVReader(filename, ",", true);

        Map<Long, AdminUnit> idPerAdminUnit = new HashMap<>();
        while (fileReader.next()) {
            String name = fileReader.get("name");
            int adminLevel = fileReader.getInt("admin_level");
            double population = fileReader.getDouble("population");
            double area = fileReader.getDouble("area");
            double density = fileReader.getDouble("density");
            Long id = fileReader.getLong("id");
            Long parentId = fileReader.getLong("parent");
            AdminUnit adminUnit = new AdminUnit(name, adminLevel, population, area, density, parentId);
            idPerAdminUnit.put(id, adminUnit);
            units.add(adminUnit);
        }

        for (AdminUnit adminUnit : units) {
            AdminUnit parentAdminUnit = idPerAdminUnit.get(adminUnit.getParentId());
            adminUnit.setParent(parentAdminUnit);
        }
    }


    /**
     * Wypisuje zawartość korzystając z Adminit.toString()
     *
     * @param out
     */
    void list(PrintStream out) {
        for (AdminUnit adminUnit : units) {
            out.print(adminUnit);
        }
    }

    /**
     * Wypisuje co najwyżej limit elementów począwszy od elementu o indeksie offset
     *
     * @param out    - strumień wyjsciowy
     * @param offset - od którego elementu rozpocząć wypisywanie
     * @param limit  - ile (maksymalnie) elementów wypisać
     */
    void list(PrintStream out, int offset, int limit) throws Exception {
        if (offset < 0) {
            throw new Exception("offest is below 0");
        }

        if (limit > units.size()) {
            throw new Exception("Limit is above");
        }
        for (int i = offset; i < limit; i++) {
            out.println(units.get(i));
        }
    }

    /**
     * Zwraca nową listę zawierającą te obiekty AdminUnit, których nazwa pasuje do wzorca
     *
     * @param pattern - wzorzec dla nazwy
     * @param regex   - jeśli regex=true, użyj finkcji String matches(); jeśli false użyj funkcji contains()
     * @return podzbiór elementów, których nazwy spełniają kryterium wyboru
     */
    AdminUnitList selectByName(String pattern, boolean regex) {
        AdminUnitList ret = new AdminUnitList();

        for (AdminUnit adminUnit : units) {
            if ((regex && adminUnit.getName().matches(pattern)) || adminUnit.getName().contains(pattern)) {
                ret.units.add(adminUnit);
            }
        }
//
//
//
//        if (regex) {
//            for (AdminUnit unit : units) {
//                if (unit.getName().matches(pattern)) {
//                    ret.units.add(unit);
//                }
//            }
//        } else {
//            for (AdminUnit unit : units) {
//                if (unit.getName().contains(pattern)) {
//                    ret.units.add(unit);
//                }
//            }
//        }

        return ret;
    }

    public AdminUnit getUnit(int index) {
        return units.get(index);
    }

    public void fixMissingValues(AdminUnit a) {
        if ((a.getPopulation() == -1) && (a.getDensity() == -1)) {
            a.setDensity(a.getParent().getDensity());
            System.out.println(a.getDensity());
            a.setPopulation(a.getArea() * a.getDensity());
            System.out.println(a.getPopulation());


        }
    }

    /**
     * Zwraca listę jednostek sąsiadujących z jendostką unit na tym samym poziomie hierarchii admin_level.
     * Czyli sąsiadami wojweództw są województwa, powiatów - powiaty, gmin - gminy, miejscowości - inne miejscowości
     *
     * @param unit        - jednostka, której sąsiedzi mają być wyznaczeni
     * @param maxdistance - parametr stosowany wyłącznie dla miejscowości, maksymalny promień odległości od środka unit,
     *                    w którym mają sie znaleźć punkty środkowe BoundingBox sąsiadów
     * @return lista wypełniona sąsiadami
     */
    AdminUnitList getNeighbors(AdminUnit unit, double maxdistance) {
        AdminUnitList neighbours = new AdminUnitList();
        for (int i = 0; i < units.size(); i++) {
            if (unit.getAdminLevel() == units.get(i).getAdminLevel()) {
                if (unit.getAdminLevel() == 11) {
                    if (unit.getBbox().distanceTo(units.get(i).getBbox()) > maxdistance) {
                        neighbours.units.add(units.get(i));
                    }
                } else {
                    neighbours.units.add(units.get(i));
                }

            }
        }
        return neighbours;
    }

    /**
     * Sortuje daną listę jednostek (in place = w miejscu)
     *
     * @return this
     */
    AdminUnitList sortInplaceByName() {
        class AdminUnitComparator implements Comparator<AdminUnit> {
            @Override
            public int compare(AdminUnit o1, AdminUnit o2) {
                return o1.getName().compareTo(o2.getName());

            }
        }
        units.sort(new AdminUnitComparator());
        return this;
    }

    /**
     * Sortuje daną listę jednostek (in place = w miejscu)
     *
     * @return this
     */
    AdminUnitList sortInplaceByArea() {
        units.sort(new Comparator<AdminUnit>() {
            @Override
            public int compare(AdminUnit o1, AdminUnit o2) {
                return Double.compare(o1.getArea(),o2.getArea());//compareTo nie dziala, ale nie wiem czemu|o1.getArea() - (o2.getArea())
            }
        });
        return this;
    }

    /**
     * Sortuje daną listę jednostek (in place = w miejscu)
     *
     * @return this
     */
    AdminUnitList sortInplaceByPopulation() {
        units.sort((o1, o2) -> (int) (o1.getPopulation() - (o2.getPopulation())));//compare to nie dziala, ale nie wiem czemu
        return this;
    }

    AdminUnitList sortInplace(Comparator<AdminUnit> cmp) {
        units.sort(cmp);
        return this;
    }

    AdminUnitList sort(Comparator<AdminUnit> cmp) {
        AdminUnitList adminUnitList = new AdminUnitList();
        adminUnitList.units = new ArrayList<>(this.units);//czy this.units.size()????
        adminUnitList.units.sort(cmp);
        return adminUnitList;
    }

    /**
     * @param pred referencja do interfejsu Predicate
     * @return nową listę, na której pozostawiono tylko te jednostki,
     * dla których metoda test() zwraca true
     */
    AdminUnitList filter(Predicate<AdminUnit> pred) {
        AdminUnitList adminUnitList = new AdminUnitList();
        for (AdminUnit unit : units) {
            if (pred.test(unit)) {
                adminUnitList.units.add(unit);
            }
        }
        return adminUnitList;
    }

    /**
     * Zwraca co najwyżej limit elementów spełniających pred
     *
     * @param pred  - predykat
     * @param limit - maksymalna liczba elementów
     * @return nową listę
     */
    AdminUnitList filter(Predicate<AdminUnit> pred, int limit) {
        AdminUnitList adminUnitList = new AdminUnitList();
        for (int i = 0; i < limit; i++) {
            if (pred.test(units.get(i))) {
                adminUnitList.units.add(units.get(i));

            }
        }
        return adminUnitList;

    }
    /**
     * Zwraca co najwyżej limit elementów spełniających pred począwszy od offset
     * Offest jest obliczany po przefiltrowaniu
     * @param pred - predykat
     * @param - od którego elementu
     * @param limit - maksymalna liczba elementów
     * @return nową listę
     */
    AdminUnitList filter(Predicate<AdminUnit> pred, int offset, int limit){
        AdminUnitList adminUnitList=new AdminUnitList();
        for(int i=offset;i<limit;i++){
            if (pred.test(units.get(i))) {
                adminUnitList.units.add(units.get(i));

            }
        }
        return adminUnitList;

    }
        }





