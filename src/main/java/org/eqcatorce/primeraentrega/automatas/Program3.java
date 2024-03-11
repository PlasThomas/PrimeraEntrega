package org.eqcatorce.primeraentrega.automatas;

//programa que realiza la validacion del la expresion regular (0|1)*110*
public class Program3 {
    private int indice = 0;
    private String cadena = "";
    private final char error = 'e';
    private final char aceptado = 'a';

    public void Automata1(String cad){
        cadena = cad;
    }

    private char sigCha(){
        char c = ' ';
        if(indice  < cadena.length()){
            c = cadena.charAt(indice);
            indice++;
        }
        return c;
    }
    public char estadoA() {
        char c = sigCha();
        switch(c){
            case '0': return estadoB();
            case '1': return estadoC();
            default: return error;
        }
    }
    public char estadoB() {
        char c = sigCha();
        switch(c){
            case '0': return estadoB();
            case '1': return estadoC();
            default: return error;
        }
    }
    public char estadoC() {
        char c = sigCha();
        switch(c){
            case '0': return estadoD();
            case '1': return estadoE();
            default: return error;
        }
    }
    public char estadoD() {
        char c = sigCha();
        switch(c){
            case '0': return error;
            case '1': return error;
            default: return error;
        }
    }
    public char estadoE() {
        char c = sigCha();
        switch(c){
            case '0': return estadoF();
            case '1': return estadoD();
            case ' ': return aceptado;
            default: return error;
        }
    }
    public char estadoF() {
        char c = sigCha();
        switch(c){
            case '0': return estadoF();
            case '1': return estadoD();
            case ' ': return aceptado;
            default: return error;
        }
    }
}
