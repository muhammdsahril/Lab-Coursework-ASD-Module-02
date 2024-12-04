/**
 * ES234319 - Algorithms and Data Structures
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 5026231220
 * Student Name     : Muhammad Sahril
 * Class            : A
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        task1();
        // task2();
        // optionalTask();
    }
     
    public static void task1(){
         
        try {
            // Section 4: 5 mennit
            //read file input
            File file = new File("C:\\Users\\USER\\Desktop\\Kuliah\\Semester 3\\Algoritma dan Struktur Data\\Lab Coursework - Module - 02\\src\\deliveryboy.txt");
            Scanner sc = new Scanner(file);
     
            // Input jumlah streets
            int N = sc.nextInt();
     
            // Section 5: 5 menit (maks. 10 menit)
            // Input matriks jarak antarjalan NxN
            int[][] T = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //code here
                    T[i][j] = sc.nextInt();
                }
            }
     
            // Input jumlah skenario
            int M = sc.nextInt();
     
            // Proses semua skenario
            for (int i = 0; i < M; i++) {
                int S = sc.nextInt(); // Restoran
                int G = sc.nextInt(); // Gas station
                int D = sc.nextInt(); // Destination
     
                // Simpan semua jarak dari jalan S
                int[] distanceS = Delivery.dijkstra(T, S);
                // hotung jarak restoran -> gas station
                int distSG = distanceS[G];
                //hitung jarak gas station -> destination
                int[] distanceG = Delivery.dijkstra(T, G);
                int distGD = distanceG[D];
                //hitung jarak original = S -> G -> D
                int jarakOriginal = distGD + distSG;
                // Hitung jarak optimal = S -> D
                int[] distanceOptimal = Delivery.dijkstra(T, S);
                int jarakOptimal = distanceOptimal[D];
                // Output hasil
                System.out.println(jarakOriginal + " " + (jarakOriginal - jarakOptimal));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void task2(){
        // Create the graph using the Graph class
 
        // Call the cheapestRoute method from TravelPlan Class
    }
    public static void optionalTask(){
        // Create the graph using WightedGraphAL class
 
        System.out.println("Weighted Graph Adjacency List:");
        // Print the graph
         
        // Call the dijkstra method from graph
    }
 
}
 