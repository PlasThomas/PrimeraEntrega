package programas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//realiza la valdacion de expresiones de notacion cientifica
public class Program5 {
    FileReader archivo;
    int [][] tabla;
    char [] lang;
    int error = -1;
    int entrada = 0;
    int estado = 0;
    int indice = 0;
    String cad = "";
    //el constructor requiere un archivo que leeer[a para crear el automata
    //public Auto(FileReader arch){
      //  this.archivo = arch;
    //aqui se crea el automata
    public void creaAuto(){
        int fila = 0;
        BufferedReader lect;
        String[] cad = new String[0];
        try{
            if(archivo.ready()){
                lect = new BufferedReader(archivo);
                String renglon;
                int count = 0;
                while((renglon = lect.readLine()) != null){
                    cad = renglon.split("\\s");
                    if(count == 0)
                        //se dimensiona la tabla
                        tabla = new int[Integer.parseInt(cad[0])][Integer.parseInt(cad[1]) + 1];
                    else if (count == 1) {
                        //se establecen los lenguajes
                        lang = new char[cad.length + 1];
                        for(int i = 0; i <= lang.length -1; i++){
                            if(i == cad.length)
                                lang[i] = ';';
                            else
                                lang[i] = cad[i].charAt(0);
                        }
                    }else{
                        //se mete la tabla de tranciciones en la tabla
                        for(int j = 0; j <= cad.length - 1; j++)
                            tabla[fila][j] = Integer.parseInt(cad[j]);
                        fila ++;
                    }
                    count ++;
                } System.out.println("Automata Listo");
                archivo.close();
            }else{
                System.out.println("El archivo no está listo");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void task(FileReader archi){
        BufferedReader lect;
        boolean err = false;
        char c = ' ';
        cad = "";
        try{
            if(archi.ready()){
                lect = new BufferedReader(archi);
                while((cad = lect.readLine()) != null) {
                    do {
                        c = sigCha();
                        if (Herramientas.numero(c))
                            c = 'D';
                        else if (Herramientas.signo(c))
                            c = 'S';
                        if (!Herramientas.finCad(c) && indice < cad.length()){
                            for (int i = 0; i < lang.length; i++) {
                                if(c == lang[i]) {
                                    err = false;
                                    entrada = i;
                                    break;
                                } else
                                    err = true;
                            }
                            if(err){
                                error = 0;
                                break;
                            }
                        }else
                            error = 0;
                        if (error != 0)
                            estado = tabla[estado][entrada];
                    } while (indice < cad.length());
                    if (tabla[estado][lang.length-1] == 1) {
                        System.out.println("Cadena Valida");
                        estado = 0;
                        indice = 0;
                        error = -1;
                    }else{
                        System.out.println("Cadena Invalida");
                        estado = 0;
                        indice = 0;
                        error = -1;
                    }
                }
            }else{
                System.out.println("El archivo no está listo");
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private char sigCha(){
        char c = ' ';
        if(indice  < cad.length()){
            c = cad.charAt(indice);
            indice++;
        }
        return c;
    }
}
