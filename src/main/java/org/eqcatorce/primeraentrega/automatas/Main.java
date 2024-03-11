package org.eqcatorce.primeraentrega.automatas;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try{
            //funcionamiento de programa 1
            Program1 au01 = new Program1();
            au01.setArchivo("Pruebas.txt");
            au01.task();
            //funcionamiento de programa 2
            Program2 afd2 = new Program2();
            afd2.setArchivo("Pruebas.txt");
            afd2.task();
            //funcionamiento de programa 3

            //funcionamiento de programa 4

            //funcionamiento de programa 5
            Program5 autoCenti = new Program5();
            autoCenti.setArchivo("Pruebas.txt");
            autoCenti.task();
            //funcionamiento de programa 7
            Program7 autoConfig = new Program7();
            autoConfig.setConstru("Pruebas.txt");
            autoConfig.setArchivo("Pruebas.txt");
            autoConfig.task();
        } catch(Exception e){

        }
    }
}