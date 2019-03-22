
import java.util.Random;


public class Matrix {
    private double[] data;
    private int rows;
    private int cols;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows * cols];
    }

    Matrix(double[][] arr) {
        this.rows = arr.length;
        this.cols = this.findMaxLength(arr);
        data = new double[rows * cols];
        this.fillMatrixbyarray(arr);
    }

    public double get(int row, int col) {
        return this.data[this.cols * row + col];

    }

    public void set(int row, int col, double value) {
        this.data[this.cols * row + col] = value;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < rows; i++) {
            buf.append("[");
            for (int j = 0; j < cols; j++) {
                buf.append(data[i * cols + j]);
                buf.append(";");
            }

            buf.append("]");
        }
        buf.append("]");
        return buf.toString();
    }

    private int findMaxLength(double[][] tab) {
        int maxLength = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].length > maxLength)
                maxLength = tab[i].length;

        }
        return maxLength;
    }

    public Matrix funkcja() {
        Matrix sum = new Matrix(1, this.cols);
        for (int i = 0; i < this.cols; i++) {
            double tmp = 0;
            for (int j = 0; j < this.rows; j++) {
                tmp += this.get(j, i);
            }
            sum.set(0, i, tmp);
        }
        return sum;
    }

    public Matrix getColumn(int i) {
        Matrix column = new Matrix(this.rows, 1);
        if (this.cols <= i)
            throw new RuntimeException(String.format("Nie wkurzaj mnie"));
        for (int j = 0; j < this.rows; j++) {
            double value = 0;
            for (int k = 0; k < this.cols; k++) {
                if (i == k) {
                    value = this.get(j, k);
                    column.set(j, 0, value);

                }
            }

        }
        return column;
    }

    public int[] shape() {
        int[] tab = new int[2];
        tab[0] = this.rows;
        tab[1] = this.cols;
        return tab;


    }

    public void reshape(int newRows, int newCols) throws Exception {
        if (rows * cols != newRows * newCols) {
            throw new Exception(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));
        } else {
            this.rows = newCols;
            this.cols = newRows;
        }
    }

    public Matrix add(Matrix m) {
        Matrix dod = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) + m.get(i, j);
                dod.set(i, j, value);

            }
        }
        return dod;
    }

    public Matrix sub(Matrix m) {
        Matrix od = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) - m.get(i, j);
                od.set(i, j, value);

            }
        }
        return od;
    }

    public Matrix mul(Matrix m) {
        Matrix mn = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) * m.get(i, j);
                mn.set(i, j, value);

            }
        }
        return mn;

    }

    public Matrix div(Matrix m) {
        Matrix div = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) / m.get(i, j);
                div.set(i, j, value);
            }
        }
        return div;
    }
    public Matrix add2(double w){
        Matrix dod = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) + w;
                dod.set(i, j, value);
            }
        }

        return dod;
    }
    public Matrix sub2(double w){
        Matrix od = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) - w;
                od.set(i, j, value);
            }
        }

        return od;
    }
    public Matrix mul2(double w){
        Matrix mn = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) * w;
                mn.set(i, j, value);
            }
        }

        return mn;
    }
    public Matrix div2(double w){
        Matrix dziel = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double value = 0;
                value = get(i, j) / w;
                dziel.set(i, j, value);
            }
        }

        return dziel;
    }






    private void fillMatrixbyarray ( double[][] tab){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < tab[i].length) {
                    data[i * cols + j] = tab[i][j];
                } else {
                    data[i * cols + j] = 0;
                }

            }
        }
    }
    public Matrix dot(Matrix m){
        if (this.cols!=m.rows ){
            throw new RuntimeException(String.format("Nie ma opcji"));
        }
        Matrix nowa = new Matrix(this.rows, m.cols);
        for (int i=0;i<this.rows;i++){
            for(int j=0;j<m.cols;j++){
                double value=0;
                for(int k=0;k<m.rows;k++){
                    value+=get(i,k)*m.get(k,j);}
                nowa.set(i,j,value);
            }
        }
        return nowa;
    }

    public double frobenius(){
        double value=0;
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.cols;j++){
                value+=Math.pow(data[(i*this.rows+j)],2);
            }

        }
        value=Math.sqrt(value);
        return value;
    }
    public static Matrix random(int rows, int cols){
        Matrix m = new Matrix(rows,cols);
        Random r = new Random();
        m.set(0,0,r.nextDouble());
        for (int i=0;i<rows;i++){
            for(int j=1;j<cols;j++){
                m.set(i,j,r.nextDouble());

            }
        }
        return m;
    }
    public static Matrix eye(int n){
        Matrix m = new Matrix(n,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) {
                    m.set(i, j, 1);
                }
                else{
                    m.set(i,j,0);
                }
            }
        }
        return m;
    }
//public Matrix inv(){ }
    //trudne -_-
}



