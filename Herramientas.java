package programas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Herramientas {
    public static boolean numero(char c){
        boolean numero = false;
        if(c >= 48 && c <= 57)
            numero = true;
        return numero;
    }
    public static boolean signo(char c){
        boolean s = false;
        if(c == 43 || c == 45)
            s = true;
        return s;
    }
    public static boolean finCad(char c){
        boolean fc = false;
        if(c == 32)
            fc = true;
        return fc;
    }
    public static void LectArr(FileReader arch, ArrayList<String> cad){
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
}
