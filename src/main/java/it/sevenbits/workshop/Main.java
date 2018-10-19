package it.sevenbits.workshop;

import it.sevenbits.workshop.matrix.Matrix;
import it.sevenbits.workshop.matrix.MatrixException;
import it.sevenbits.workshop.queue.DoubleEndedQueue;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MatrixException, IOException {



        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rows and columns");

        Matrix matrix = new Matrix(scanner.nextInt(), scanner.nextInt());

        Matrix matrix1 = new Matrix(5, 5);
        Matrix matrix2 = new Matrix(2, 3);
        Matrix matrix3 = new Matrix(4, 1);
        Matrix matrix4 = new Matrix(8, 2);
        Matrix matrix5 = new Matrix(1, 9);

        DoubleEndedQueue<Matrix> doubleEndedQueue = new DoubleEndedQueue<>();
        doubleEndedQueue.addStart(matrix1);
        doubleEndedQueue.addStart(matrix2);
        doubleEndedQueue.addStart(matrix3);
        doubleEndedQueue.addStart(matrix4);
        doubleEndedQueue.addStart(matrix5);
        doubleEndedQueue.addEnd(matrix);

        System.out.println("<----------------SIMPLE OUTPUT------------------->");
        System.out.println(doubleEndedQueue);

        System.out.println("<----------------FOREACH OUT--------------------->");
        doubleEndedQueue.forEach(System.out::println);
    }
}
