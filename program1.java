package programas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//programa que realiza la validaion de los automatas que detectan cadenas con numeros pares de 1s o impares de 0s
public class program1 {
    public void LectArr(FileReader arch, ArrayList<String> cad){
        BufferedReader lect;
        try{
            if(arch.ready()){
                lect = new BufferedReader(arch);
                String renglon;
                while((renglon = lect.readLine()) != null){
                    cad.add(renglon);
                }
            }else{
                System.out.println("El archivo no está listo");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void Adf1(ArrayList tx){
        int piler = 0;
        int i = 0;
        for(i = 0; i <= tx.size()-1; i++){
            boolean error = false;
            int columna = 0;
            int estado = 0;
            String token = (String) tx.get(i);
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
                    System.out.println("token "+ i +" valido");
                }else{
                    System.out.println("token "+ i +" invalido");
                }
            }else{
                System.out.println("Caracter invalido en token "+ i +" posicion "+ piler);
            }
        }
    }
    public void Adf0(ArrayList tx){
        int piler = 0;
        int i = 0;
        for(i = 0; i <= tx.size()-1; i++){
            boolean error = false;
            int estado = 0;
            String token = (String) tx.get(i);
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
                    System.out.println("token "+ i +" valido");
                }else{
                    System.out.println("token "+ i +" invalido");
                }
            }else{
                System.out.println("Caracter invalido en token "+ i +" posicion " + piler);
            }
        }
    }
}
