/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NurRochman
 */

public class InputReader  {
    //String coor1, coor2;
    //Scanner read = new Scanner(new File("E:\\NRD\\ITS\\Semester 9\\FP\\datasets\\small1.csv")); 
    ArrayList <Integer> kota = new ArrayList <Integer>();
    ArrayList <Integer> coor1 = new ArrayList <Integer>();    
    ArrayList <Integer> coor2 = new ArrayList <Integer>();
    String str;
    BufferedReader br;
    
    public void baca (String namaFile) {
            try {
                br = new BufferedReader(new FileReader(namaFile));
                br.readLine();
                
                while((str = br.readLine()) != null){
                    String[] coor = str.split(",");
                    coor1.add(Integer.parseInt(coor[0]));
                    coor2.add(Integer.parseInt(coor[1]));
                }
            } 
            catch (FileNotFoundException ex) {
                Logger.getLogger(InputReader.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) {
                Logger.getLogger(InputReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public void cetak (){
        for (int i = 0; i < coor1.size(); i++)
        {
            System.out.print("Koordinat kota " + (i+1) + " : " + coor1.get(i));
            System.out.println(" dan " + coor2.get(i));
        }
    }
}