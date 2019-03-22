import lab2.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnit {
   private String name;
   private int adminLevel;
   private double population;
   private double area;
   private double density;
   private Long parentId;
   private AdminUnit parent;
   private BoundingBox bbox;
    List<AdminUnit> children=new ArrayList<>();


    public AdminUnit(String name, int adminLevel, double population, double area, double density, Long parentId) {
        this.name=name;
        this.adminLevel=adminLevel;
        this.population=population;
        this.area=area;
        this.density=density;
        this.parentId = parentId;
    }
//    public void print_children(String filename)throws IOException {
//        CSVReader fileReader = new CSVReader(filename, ",", true);
//        Map<Long, List<AdminUnit>> parentid2child = new HashMap<>();
//        while (fileReader.next()) {
//            String name = fileReader.get("name");
//            int adminLevel = fileReader.getInt("admin_level");
//            double population = fileReader.getDouble("population");
//            double area = fileReader.getDouble("area");
//            double density = fileReader.getDouble("density");
//            Long id = fileReader.getLong("id");
//            Long parentId = fileReader.getLong("parent");
//            AdminUnit adminUnit = new AdminUnit(name, adminLevel, population, area, density, parentId);
//            if (adminUnit.adminLevel < 11) {
//                while (fileReader.next()) {
//                    String name2 = fileReader.get("name");
//                    int adminLevel2 = fileReader.getInt("admin_level");
//                    double population2 = fileReader.getDouble("population");
//                    double area2 = fileReader.getDouble("area");
//                    double density2 = fileReader.getDouble("density");
//                    Long id2 = fileReader.getLong("id");
//                    Long parentId2 = fileReader.getLong("parent");
//                    AdminUnit adminUnit2 = new AdminUnit(name, adminLevel, population, area, density, parentId);
//                    if (id == parentId2) {
//                        children.add(adminUnit);
//                    }
//                }
//                    parentid2child.put(parentId, (List<AdminUnit>) children);
//               // System.out.println(parentid2child);
//                    }
//                }
//                for(AdminUnit a:children){
//                    System.out.println(children);
//                }
//            }

    public void children(AdminUnit a, String filename)
        throws IOException {
        CSVReader fileReader = new CSVReader(filename, ",", true);
        Map<Long, List<AdminUnit>> parentid2child = new HashMap<>();
        Long tmp=fileReader.getLong("parent");
        while (fileReader.next()) {
            String name = fileReader.get("name");
            int adminLevel = fileReader.getInt("admin_level");
            double population = fileReader.getDouble("population");
            double area = fileReader.getDouble("area");
            double density = fileReader.getDouble("density");
            Long id = fileReader.getLong("id");
            Long parentId = fileReader.getLong("parent");
            AdminUnit adminUnit = new AdminUnit(name, adminLevel, population, area, density, parentId);
            if (a.getName() == adminUnit.getParent().getName()) {
                children.add(adminUnit);
                tmp=adminUnit.getParent().getParentId();
            }

        }
        parentid2child.put(tmp,children);
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

        public AdminUnit getParent() {
            return parent;
        }

    public void setParent(AdminUnit parent) {
        this.parent = parent;
    }

    public BoundingBox getBbox() {
        return bbox;
    }

    public void setBbox(BoundingBox bbox) {
        this.bbox = bbox;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(name+adminLevel+population+area+density+parent);
        return b.toString();
    }

    public String getName() {
        return name;
    }
}