package it.sevenbits.workshop.matrix;

import java.util.Random;

public class Matrix {

    private static final int CELL_MAX_VALUE = 100;

    private Cell[][] matrix;

    private Matrix(){}

    public Matrix(int rows, int columns) throws MatrixException {
        if(rows <= 0 || columns <= 0)
            throw new MatrixException("rows or columns can not be less than zero");

        matrix = new Cell[rows][columns];
        fillMatrixByRandomValues();
    }

    private void fillMatrixByRandomValues(){
        Random random = new Random();

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                matrix[x][y] = new Cell(x, y, random.nextInt(CELL_MAX_VALUE));
            }
        }
    }

    public void inverseMatrix(){
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                matrix[x][y].inverse();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                stringBuilder.append(matrix[x][y].getValue()).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
