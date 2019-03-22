public class BoundingBox {
    double xmin;
    double ymin;
    double xmax;//=Double.MAX_VALUE;
    double ymax;//=Double.MAX_VALUE;
    boolean flag = true;

    public BoundingBox(double xmin, double ymin, double xmax, double ymax) {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
        this.flag = false;
    }

    /**
     * Powiększa BB tak, aby zawierał punkt (x,y)
     *
     * @param x - współrzędna x
     * @param y - współrzędna y
     */
    void addPoint(double x, double y) {
        if (isEmpty()) {
            this.xmin = x;
            this.ymin = y;
            this.xmax = x;
            this.ymax = y;
            flag = false;
        } else {
            if (x > this.xmax) {
                this.xmax = x;
            } else if (y > this.ymax) {
                this.ymax = y;
            } else if (x < this.xmin) {
                this.xmin = x;
            } else if (y < this.ymin) {
                this.ymin = y;
            }
        }

    }

    /**
     * Sprawdza, czy BB zawiera punkt (x,y)
     *
     * @param x
     * @param y
     * @return
     */
    boolean contains(double x, double y) {
        if (isEmpty()) {
            return false;
        } else {
            return x <= this.xmax && x >= xmin && y <= this.ymax && y >= this.ymin;
        }
        //if (x <= this.xmax && x >= xmin && y <= this.ymax && y >= this.ymin) {
        //  return true;
        //} else {
        //  return false;
        // }
    }

    /**
     * Sprawdza czy dany BB zawiera bb
     *
     * @param bb
     * @return
     */
    boolean contains(BoundingBox bb) {
        if (isEmpty()) {
            return false;
        } else {
            return bb.xmin >= this.xmax && bb.ymin >= this.ymax && bb.ymax <= this.ymin && bb.xmax <= this.xmin;//?
        }
    }

    /**
     * Sprawdza, czy dany BB przecina się z bb
     *
     * @param bb
     * @return
     */
    boolean intersects(BoundingBox bb) {
        if (isEmpty()) {
            return false;
        } else {
            return !(bb.ymin > this.ymax && bb.xmin < this.xmax && bb.ymax < this.ymin && bb.xmin > this.xmax);
        }
    }

    /**
     * Powiększa rozmiary tak, aby zawierał bb oraz poprzednią wersję this
     *
     * @param bb
     * @return
     */
    BoundingBox add(BoundingBox bb) {
        xmin = xmin < bb.xmin ? xmin : bb.xmin;
        ymin = ymin < bb.ymin ? ymin : bb.ymin;
        xmax = xmax > bb.xmax ? xmax : bb.xmax;
        ymax = ymax > bb.ymax ? ymax : bb.ymax;
        return this;
        //nie do konca rozumiem
    }

    /**
     * Sprawdza czy BB jest pusty
     *
     * @return
     */
    boolean isEmpty() {
        return flag;
    }

    /**
     * Oblicza i zwraca współrzędną x środka
     *
     * @return if !isEmpty() współrzędna x środka else wyrzuca wyjątek
     * (sam dobierz typ)
     */
    double getCenterX() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        } else {
            return (xmin + xmax) / 2;

        }
    }

    /**
     * Oblicza i zwraca współrzędną y środka
     *
     * @return if !isEmpty() współrzędna y środka else wyrzuca wyjątek
     * (sam dobierz typ)
     */
    double getCenterY() {
        if (isEmpty()) {
            throw new RuntimeException("Not implemented");
        } else {
            return (ymax + ymin) / 2;
        }
    }

    /**
     * Oblicza odległość pomiędzy środkami this bounding box oraz bbx
     *
     * @param bbx prostokąt, do którego liczona jest odległość
     * @return if !isEmpty odległość, else wyrzuca wyjątek lub zwraca maksymalną możliwą wartość double
     * Ze względu na to, że są to współrzędne geograficzne, zamiast odległosci euklidesowej możesz użyć wzoru haversine
     * (ang. haversine formula)
     */
    double distanceTo(BoundingBox bbx) {
        final double R = 6372.8; // In kilometers
        double lat1;
        double lon1;
        double lat2;
        double lon2;
        try {
            lat1 = bbx.getCenterX();
            lon1 = bbx.getCenterY();
            lat2 = this.getCenterX();
            lon2 = this.getCenterY();
        } catch (Exception e) {
            return Double.MAX_VALUE;
        }
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2   ), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        return 2 * R * Math.asin(Math.sqrt(a));
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "xmin=" + xmin +
                ", ymin=" + ymin +
                ", xmax=" + xmax +
                ", ymax=" + ymax +
                '}';
    }
}