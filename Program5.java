package programas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//realiza la valdacion de expresiones de notacion cientifica
public class Program5 {
    FileReader archivo;
    FileReader constru = new FileReader("src/programas/constru5.txt");
    int [][] tabla;
    char [] lang;
    int entrada = 0;
    int estado = 0;
    int indice = 0;
    String cad = "";
    public Program5() throws FileNotFoundException {}
    //se toma el archivo desde el que se van a tomar las cadenas a validar.
    public void setArchivo(String cad) throws FileNotFoundException {this.archivo = new FileReader(cad);}
    private char sigCha(){
        char c = ' ';
        if(indice  < cad.length()){
            c = cad.charAt(indice);
            indice++;
        }
        return c;
    }
    //aqui se crea el automata
    private void creaAuto(){
        int fila = 0;
        BufferedReader lect;
        String[] cad = new String[0];
        try{
            if(constru.ready()){
                lect = new BufferedReader(constru);
                String renglon;
                int count = 0;
                while((renglon = lect.readLine()) != null){
                    cad = renglon.split("\\s");
                    if(count == 0)
                        //se dimensiona la tabla
                        tabla = new int[Integer.parseInt(cad[0])][Integer.parseInt(cad[1]) + 1];
                    else if (count == 1) {
                        //se establecen los lenguajes
                        lang = new char[cad.length];
                        for(int i = 0; i <= lang.length -1; i++)
                            lang[i] = cad[i].charAt(0);
                    }else{
                        //se mete la tabla de tranciciones en la tabla
                        for(int j = 0; j <= cad.length - 1; j++)
                            tabla[fila][j] = Integer.parseInt(cad[j]);
                        fila ++;
                    }
                    count ++;
                } System.out.println("Automata Listo");
                constru.close();
            }else{
                System.out.println("El archivo no está listo");
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void task(){
        creaAuto();
        ArrayList texto = new ArrayList<>();
        boolean error = false;
        int piller = 0;
        char c = ' ';
        cad = "";
        Herramientas.LectArr(archivo, texto);
        for(int i = 0; i < texto.size(); i++){
            cad = (String) texto.get(i);
            for( int j = 0; j < cad.length(); j++){
                c = sigCha();
                if (Herramientas.numero(c))
                    c = 'D';
                else if (Herramientas.signo(c))
                    c = 'S';
                if (!Herramientas.finCad(c) && indice <= cad.length()){
                    for(int l = 0; l < lang.length; l++){
                        if (c == lang[l]) {
                            error = false;
                            entrada = l;
                            break;
                        } else{
                            error = true;
                            piller = j;
                        }
                    }
                }else{
                    error = true;
                    break;
                }
                if(!error)
                    estado = tabla[estado][entrada];
                else
                    break;
            }
            if(!error){
                if (tabla[estado][lang.length] == 1) {
                    System.out.println("Token "+ i +" Valida");
                    estado = 0;
                    indice = 0;
                    error = false;
                }else{
                    System.out.println("Token "+ i +" Invalida");
                    estado = 0;
                    indice = 0;
                    error = false;
                }
            }else{
                System.out.println("Token "+ i +" contiene caracter invalido en posicion "+ piller);
                estado = 0;
                indice = 0;
                error = false;
            }
        }
    }
}