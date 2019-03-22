import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix matrix;

    @org.junit.Before
    public void setUp() throws Exception {
        matrix = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    @org.junit.Test
    public void get() {
        Double row1_2 = matrix.get(1, 2);
        assertTrue(row1_2 == 6);
    }

    @org.junit.Test
    public void createMatrix() {
        Matrix matrix = new Matrix(2, 3);
        assertEquals(matrix.getRows(), 2);
        assertEquals(matrix.getCols(), 3);
    }

    @org.junit.Test
    public void getExceptionShape() {
        try {
            matrix.reshape(5, 32);
        } catch (Exception e) {
            System.out.println(e);
            assertTrue(true);
            return;
        }
        assertTrue(false);
    }

    @org.junit.Test
    public void createMatrix2() {
        Matrix m = new Matrix(new double[1][3]);
        assertEquals(m.getRows(), 1);
        assertEquals(m.getCols(), 3);
    }

    @org.junit.Test
    public void testStringtostring() {
        String s = "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        s = s.replaceAll("(\\[|\\]|\\s)+", "");
        String[] t = s.split("(,)+");
        for (String x : t) {
            System.out.println(String.format("\'%s\'", x));
        }

        double[] d = new double[t.length];
        for (int i = 0; i < t.length; i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][] = new double[1][];
        arr[0] = d;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
    @org.junit.Test
    public void testmul(){
        Matrix m1;

    }
}
