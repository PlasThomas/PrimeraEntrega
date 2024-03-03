package programas;

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
}
