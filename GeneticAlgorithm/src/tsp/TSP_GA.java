/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import java.io.*;
import java.util.*;

/**
 *
 * @author NurRochman
 */

/*
* TSP_GA.java
* Create a tour and evolve a solution
*/

public class TSP_GA {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.currentTimeMillis();
        // int index adalah index pada array
        int index = 0;
        
        // variasi file yang diimport
        String dataset = "E:\\SEMESTER 7\\OKH\\FP\\datasets\\small1.csv";
        //String small2 = "E:\\NRD\\ITS\\Semester 9\\FP\\datasets\\small2.csv"; 
        //String medium1 = "E:\\NRD\\ITS\\Semester 9\\FP\\datasets\\medium1.csv";
        //String medium2 = "E:\\NRD\\ITS\\Semester 9\\FP\\datasets\\medium2.csv";
        //String big1 = "E:\\NRD\\ITS\\Semester 9\\FP\\datasets\\big1.csv";
        //String big2 = "E:\\NRD\\ITS\\Semester 9\\FP\\datasets\\big2.csv";
        
        // menginisiasi objek reader
        InputReader reader = new InputReader();
        reader.baca(dataset);
        reader.cetak();
        System.out.println("Banyak kota = " + reader.coor1.size());
        
        // membuat objek city dan menambahkan ke TourManager
        while (index < reader.coor1.size()) {
            City city = new City(index, reader.coor1.get(index), reader.coor2.get(index));
            TourManager.addCity(city);
            index++;
        }

        // menginisialisasi populasi
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // mengevolusi populasi untuk 100 generasi
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 250; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // mencetak hasil akhir
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
        
        final long duration = System.currentTimeMillis()- startTime;
        System.out.println("With running time = " + duration + "ms");
        
        PrintWriter ga = new PrintWriter(new File("HasilGA.csv"));
        StringBuilder text = new StringBuilder();
        text.append("Final distance : " + pop.getFittest().getDistance());
        text.append('\n');
        text.append("Solution : " +pop.getFittest());
        text.append('\n');
        text.append("Running Time : " +duration+" ms");
        
        ga.write(text.toString());
        ga.close();        
    }
}
