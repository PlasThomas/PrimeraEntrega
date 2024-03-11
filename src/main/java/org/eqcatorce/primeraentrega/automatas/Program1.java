package org.eqcatorce.primeraentrega.automatas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//programa que realiza la validaion de los automatas que detectan cadenas con numeros pares de 1s o impares de 0s
public class Program1 {
    FileReader archivo;
    //metodo que realiza la concatenacion de los automatas
    public void task(){
        String cad;
        ArrayList<String> a = new ArrayList<>();
        Herramientas.LectArr(archivo, a);
        for(int i = 0; i < a.size(); i++){
            cad = a.get(i);
            System.out.println("Token "+ i);
            Adf1(cad);
            Adf0(cad);
        }
    }
    //metodo para asignar el archivo
    public void setArchivo(String arch) throws FileNotFoundException{this.archivo = new FileReader(arch);}
    //metodo que ejecuta el automata de numero pares de unos
    private void Adf1(String token){
        int piler = 0;
        boolean error = false;
        int columna = 0;
        int estado = 0;
        while(columna <= token.length()-1){
            char c = token.charAt(columna);
            switch(estado){
                case 0:
                    if(c == '1'){
                        estado = 1;
                    }else if(c == '0'){
                        estado = 0;
                    }else{
                        error = true;
                        piler = columna;
                        columna = token.length()+1;
                    }
                    break;
                case 1:
                    if(c == '1'){
                        estado = 0;
                    }else if(c == '0'){
                        estado = 1;
                    }else{
                        error = true;
                        piler = columna;
                        columna = token.length()+1;
                    }
                    break;
            }
            columna++;
        }
        if (!error){
            if (estado == 0){
                System.out.println("valido para pares de 1");
            }else{
                System.out.println("invalido para pares de 1");
            }
        }else{
            System.out.println("Caracter invalido en posicion "+ piler);
        }

    }
    //metodo que ejecuta el automata de numero impares de 0
    private void Adf0(String token){
        int piler = 0;
        boolean error = false;
        int estado = 0;
        int columna = 0;
        while(columna <= token.length()-1){
            char c = token.charAt(columna);
            switch(estado){
                case 0:
                    if(c == '1'){
                        estado = 0;
                    }else if(c == '0'){
                        estado = 1;
                    }else{
                        error = true;
                        piler = columna;
                        columna = token.length()+1;
                    }
                    break;
                case 1:
                    if(c == '1'){
                        estado = 1;
                    }else if(c == '0'){
                        estado = 0;
                    }else{
                        error = true;
                        piler = columna;
                        columna = token.length()+1;
                    }
                    break;
            }
            columna++;
        }
        if (!error){
            if (estado == 1){
                System.out.println("valido para impares de 0");
            }else{
                System.out.println("invalido para impares de 0");
            }
        }else{
            System.out.println("Caracter invalido en posicion " + piler);
        }
    }
}