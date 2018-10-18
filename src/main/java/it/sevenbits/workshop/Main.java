package it.sevenbits.workshop;

import it.sevenbits.workshop.matrix.Matrix;
import it.sevenbits.workshop.matrix.MatrixException;

public class Main {

    public static void main(String[] args) throws MatrixException {
        
        Matrix matrix = new Matrix(5, 5);
        System.out.println(matrix.toString());
    }
}
