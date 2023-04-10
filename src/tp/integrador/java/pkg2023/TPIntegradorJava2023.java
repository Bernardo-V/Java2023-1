package tp.integrador.java.pkg2023;

import clases.PronosticoDeportivo;


public class TPIntegradorJava2023 {

public static PronosticoDeportivo PRODE;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Sistema de simulacion de pronosticos deportivos");

        PRODE = new PronosticoDeportivo();

        PRODE.play();
    }
    
}
