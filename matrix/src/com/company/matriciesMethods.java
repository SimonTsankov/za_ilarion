package com.company;

import java.util.Arrays;

public class matriciesMethods {
    //ADDITION
    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int result[][]= new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                result[i][j]=a[i][j]+b[i][j];
            }
        }
        return result;
    }

    public static int[][] rotateLikeAVortex(int[][] mat)//ROTATE SQUARE matrix like a vortex
    {
        final int N = mat.length;
        if (N == 1) return new int[][]{new int[]{mat[0][0]}};

        int[][] ret = new int[N][N];

        for (int r = 0; r < N/2; ++r) {
            for (int i = r; i < N-r; ++i) {
                for (int j = r; j < N-r; ++j) {
                    ret[i][j] = mat[j-r][N-i-1 -r];
                }
            }

            if (r < N/2) {
                final int n = N-2*(r+1);
                final int start = r+1;
                mat = new int[n][n];
                for (int x=0; x<n; ++x)
                    for (int y=0; y<n; ++y)
                        mat[x][y] = ret[start+x][start+y];
            }
        }

        return ret;
    }

    //MATRIX MULTIPLAYER
    public static double[][] getMatrixProduct(double[][] firstMatrix, double[][] secondMatrix) {
        int r1=firstMatrix.length;
        int r2=firstMatrix[0].length;
        int c1=secondMatrix.length;
        int c2=secondMatrix[0].length;
        if(c1!=r2) return null;
        double[][] product = new double[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }

    //matrix square up, B - https://www.codewars.com/kata/5a972f30ba1bb5a2590000a0
    public static String[][] matrixSquareUp(int b) {
        //code here
        String matrix[][]=new String[b][b];
        for (int i = 0; i <b ; i++) {
            for (int j = b-1; j >=0 ; j--) {
                matrix[i][j]=Integer.toString(b-j);
            }
        }

        for (int i = 0; i <b ; i++) {
            for (int j = 0; j <b-1-i ; j++) {
                matrix[i][j]="x";
            }
        }

        return matrix;
    }

    public static int sumOfElements(int matrix[][]) {//ADDITION
        int sum=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                sum+=matrix[i][j];
            }
        }
        return sum;
        //your code here
    }

    //Check if matrix exists in another matrix
    public static int[] checkIsContained(int[][] a, int b[][]) {
        boolean flag = false;
        for (int i=0;i<a.length-b.length+1;i++)
        {
            for(int j=0;j<a[0].length-b[0].length+1;j++)
            {
                if(a[i][j]==b[0][0])
                {
                    flag = true;
                    for(int k=0;k<b.length;k++)
                    {
                        for (int l=0;l<b[0].length;l++)
                        {
                            if(a[i+k][j+l] != b[k][l])
                            {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag)
                    {
                        System.out.println("i= " + i + " j= " + j);
                        return new int[]{i,j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
    //Matrix multiplication
    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int size = a.length;
        int[][] result = new int[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                for(int k=0;k<size;k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    //STUPID CHALLANGE one semicolon code to multiply
    public static int[][] multiply(int[][] a, int[][] b) {

        return a[0].length != b.length ? null : java.util.Arrays.stream(a).map(aRow ->
                java.util.stream.IntStream.range(0, b[0].length).map(x ->
                        java.util.stream.IntStream.range(0, b.length).map(i -> aRow[i] * b[i][x]).sum()
                ).toArray()
        ).toArray(int[][]::new);
    }

    //Matrix from string
    int[][] matrix;
    public matriciesMethods(String matrixAsString) {
        int rows=matrixAsString.split("\n ?").length;
        int columns=matrixAsString.split("\n ?")[0].split(" ").length;
        this.matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrixAsString.split("\n ?")[i].split(" "))
                    .mapToInt(num -> Integer.parseInt(num)).toArray();
        }
    }
    public int[] getRow(int rowNumber){
        return matrix[rowNumber];
    }
    public int[] getColumn(int columnNumber){
        return Arrays.stream(matrix).map(arr -> arr[columnNumber])
                .mapToInt(num -> num).toArray();
    }
    public int getRowsCount(){
        return matrix.length;
    }
    public int getColumnsCount(){
        return matrix[0].length;
    }

    //annoying diagonals aranged matrix  https://www.codewars.com/kata/5ab1f8d38d28f67410000090
    public static char[][] diagonalSort(char[][] data ) {
        String string = "";
        for(int i = 0; i<data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                string += data[i][j];
            }}
        char[][] result = new char[data.length][data[0].length];
        result[data.length - 1][data[0].length - 1] = string.charAt(string.length()-1);
        int num2 = 0;
        int loop = data.length-1;
        int c = 0;
        while(loop>=0){
            int x = num2;
            int y = 0;
            while(x>=0){
                if(y<data[0].length) {
                    result[x][y] = string.charAt(c++);
                }
                x--;
                y++;
            }
            num2++;
            loop--;
        }
        int l = 1 , a = data.length - 1, b = 1,add = 1;
        while(l<data[0].length){
            while (b<data[0].length) {
                if (a < data.length && b < data[0].length && a>=0) {
                    result[a][b] = string.charAt(c++);
                }
                a--;
                b++;
            }
            a = data.length-1;
            b = 0;
            add++;
            b += add;
            l++;
        }
        return result;
    }
    //| Matrix Shift |||clickbait||| https://www.codewars.com/kata/5afd3c451839f13b95000132
    public static char[][] shift(char[][]m, int n){
        int rows = m.length, columns = m[0].length;
        n %= rows*columns;
        while(n-->0){
            char temp = m[rows-1][columns-1], temp2 = temp;
            for (int r = 0; r<rows; r++) {
                temp = temp2;
                temp2 = m[r][columns-1];
                m[r] = (temp+String.valueOf(m[r]).substring(0,columns-1)).toCharArray();
                temp = temp2;
            }
        }
        return m;
    }

}
