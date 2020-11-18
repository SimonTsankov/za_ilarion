package com.company;
public class Matrix {
    final int rows;
    final int cols;
    final double[][] data;

    public Matrix(double[][] elements) {
        if (elements == null)
            throw new IllegalArgumentException();
        if (elements.length == 0 || elements[0] == null)
            throw new IllegalArgumentException();
        if (elements[0].length == 0)
            throw new IllegalArgumentException();
        rows = elements.length;
        cols = elements[0].length;
        data = new double[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (elements[i] == null || j>=elements[i].length) {
                    throw new IllegalArgumentException();
                }
                data[i][j] = elements[i][j];
            }
        }
    }

    public Matrix(int rows, int cols, double... elements) {
        if (elements == null) {
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
        int i=0, j=0;
        if (elements != null) {
            for (double e : elements) {
                data[i][j] = e;
                j++;
                if (j>=cols) {
                    i++;
                    j=0;
                }
            }
        }
    }

    public double[][] toArray() {
        double[][] result = new double[this.rows][this.cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                result[i][j] = this.data[i][j];
            }
        }
        return result;
    }

    public Matrix transpose() {
        double[] elements = new double[rows * cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                elements[i + (j*rows)] = data[i][j];
            }
        }
        Matrix result = new Matrix(cols, rows, elements);
        return result;
    }

    public Matrix add(Matrix m) {
        if (m == null || m.rows != this.rows || m.cols != this.cols)
            throw new IllegalArgumentException();
        Matrix result = new Matrix(data);
        for (int i=0; i<result.rows; i++) {
            for (int j=0; j<result.cols; j++) {
                result.data[i][j] += m.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(double d) {
        Matrix result = new Matrix(data);
        for (int i=0; i<result.rows; i++) {
            for (int j=0; j<result.cols; j++) {
                result.data[i][j] *= d;
            }
        }
        return result;
    }
    public Matrix multiply(Matrix m) {
        if (m == null || this.cols != m.rows) {
            throw new IllegalArgumentException();
        }
        Matrix result = new Matrix(this.rows, m.cols);
        for (int i=0; i<result.rows; i++) {
            for (int j=0; j<result.cols; j++) {
                double scalarProduct = 0;
                for (int a=0; a<this.cols; a++) {
                    scalarProduct += (this.data[i][a] * m.data[a][j]);
                }
                result.data[i][j] = scalarProduct;
            }
        }
        return result;
    }
}