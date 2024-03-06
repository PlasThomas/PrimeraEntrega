package programas;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        //funcionamiento de programa 1
        program1 au01 = new program1();
        au01.setArchivo("");
        au01.task();
        //funcionamiento de programa 2
        program2 afd2 = new program2();
        afd2.setArchivo("");
        afd2.task();
    }
}