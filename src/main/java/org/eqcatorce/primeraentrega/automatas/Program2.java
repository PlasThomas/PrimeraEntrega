package org.eqcatorce.primeraentrega.automatas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// programa que lee la expresion regular (0|1)*110* bajo el primer metodo de construccion
public class Program2 {
    FileReader archivo;
    //metodo que realiza la concatenacion de los automatas
    public void task(){
        ArrayList<String> a = new ArrayList<>();
        Herramientas.LectArr(archivo, a);
        AFD2(a);
    }
    //metodo para asignar el archivo
    public void setArchivo(String arch) throws FileNotFoundException {this.archivo = new FileReader(arch);}

    private void AFD2(ArrayList tx){
        int piler = 0;
        for(int i = 0; i <= tx.size()-1; i++){
            boolean error = false;
            int columna = 0;
            int estado = 0;
            String token = (String) tx.get(i);
            while(columna <= token.length()-1){
                char c = token.charAt(columna);
                switch(estado){
                    case 0:
                        if(c == '1'){
                            estado = 2;
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
                            estado = 2;
                        }else if(c == '0'){
                            estado = 1;
                        }else{
                            error = true;
                            piler = columna;
                            columna = token.length()+1;
                        }
                        break;
                    case 2:
                        if(c == '1'){
                            estado = 3;
                        }else if(c == '0'){
                            estado = 1;
                        }else{
                            error = true;
                            piler = columna;
                            columna = token.length()+1;
                        }
                        break;
                    case 3:
                        if(c == '1'){
                            estado = 3;
                        }else if(c == '0'){
                            estado = 4;
                        }else{
                            error = true;
                            piler = columna;
                            columna = token.length()+1;
                        }
                        break;
                    case 4:
                        if(c == '1'){
                            estado = 2;
                        }else if(c == '0'){
                            estado = 4;
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
                if ((estado == 3) || (estado == 4)){
                    System.out.println("token "+ i +" valido");
                }else{
                    System.out.println("token "+ i +" invalido");
                }
            }else{
                System.out.println("Caracter invalido en token "+ i +" posicion "+ piler);
            }
        }
    }
}
