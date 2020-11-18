package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Matrix<Integer> m = new Matrix<>(3, 3);
        m.setRow(1, new Integer[] { 2, 9, 5 });
        m.setRow(2, new Integer[] { 3, 0, 8 });
        m.setRow(3, new Integer[] { 6, 1, 7 });



        m.set(2, 3, -4);
        m.set(1, 1, m.get(1, 2) * m.get(2, 1));
        //m.set(3, 2, m.get(3, 2) + m.get(3, 3) / 3);

}

}
