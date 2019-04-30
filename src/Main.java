import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        long startTime;
        long stopTime;
        String toFileWriting;
        String fileName = "results.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter("results.txt", true));

        System.out.println("Podaj liczbe wierzcholkow grafu: ");
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        ListGraph listGraph = new ListGraph(v);
        MatrixGraph matrixGraph = new MatrixGraph(v);
        Tarjan tj = new Tarjan(listGraph);
        Tarjan tj2 = new Tarjan(matrixGraph);

        System.out.println("Podaj gestosc grafu (liczba z przedzialu 0-1 w postaci ułamka dzisietnego np. 0,75 - im wieksza liczba tym wyzsza gestosc)");
        double p = in.nextDouble();
        RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(listGraph, matrixGraph, p);

        bw.write(Integer.toString(v) + "\t" + Double.toString(p) + "\t\t");
        startTime = System.nanoTime();
        listGraph.deleteAllEdges();
        stopTime = System.nanoTime();
        System.out.println("Lista naiwny: " + (stopTime - startTime) + "\n");
        toFileWriting = Long.toString(stopTime - startTime);
        bw.write(toFileWriting + "\t");

        startTime = System.nanoTime();
        listGraph.deleteTreeEdges();
        stopTime = System.nanoTime();
        System.out.println("Lista krawedzie drzewowe: " + (stopTime - startTime) + "\n");
        toFileWriting = Long.toString(stopTime - startTime);
        bw.write(toFileWriting + "\t");

        startTime = System.nanoTime();
        tj.startTarjan();
        stopTime = System.nanoTime();
        System.out.println("Lista Tarjan: " + (stopTime - startTime) + "\n");
        toFileWriting = Long.toString(stopTime - startTime);
        bw.write(toFileWriting + "\t");

        startTime = System.nanoTime();
        matrixGraph.deleteAllEdges();
        stopTime = System.nanoTime();
        System.out.println("Matrix naiwny: " + (stopTime - startTime) + "\n");
        toFileWriting = Long.toString(stopTime - startTime);
        bw.write(toFileWriting + "\t");

        startTime = System.nanoTime();
        matrixGraph.deleteTreeEdges();
        stopTime = System.nanoTime();
        System.out.println("Matrix krawedzie drzewowe: " + (stopTime - startTime) + "\n");
        toFileWriting = Long.toString(stopTime - startTime);
        bw.write(toFileWriting + "\t");

        startTime = System.nanoTime();
        tj2.startTarjan();
        stopTime = System.nanoTime();
        System.out.println("Matrix Tarjan: " + (stopTime - startTime) + "\n");
        toFileWriting = Long.toString(stopTime - startTime);
        bw.write(toFileWriting + "\t");

        bw.write("\n");
        br.close();
        bw.close();
    }
}

