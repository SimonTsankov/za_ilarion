package com.company;
import java.util.*;
public class Matrix<T> {
    private final int rows; private int columns;
    private final Object[][] matrix;
    public Matrix(int nrows, int ncolumns)
    {
       rows=nrows;
       columns =ncolumns;
       matrix =new Object[nrows][ncolumns];
    }
    public T get(int i, int j){
    return (T) matrix[i-1][j-1];
    }


    public void set(int i, int j, T value){
            matrix[i-1][j-1]=value;
    }

    public void setRow(int i,T... values){
    matrix[i-1]=Arrays.copyOf(values, values.length);
    }

    public void swap(int i1,int j1,int i2,int j2){
        Object temp= matrix[i1-1][j1-1];
        matrix[i1-1][j1-1]= matrix[i2-1][j2-1];
        matrix[i2-1][j2-1]=temp;
    }

    public String[][] toArray(){
        String[][] str=new String[rows][columns];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns; j++) {
                str[i][j]=String.valueOf(matrix[i][j]);
            }
        }
        return str;


    }

}
