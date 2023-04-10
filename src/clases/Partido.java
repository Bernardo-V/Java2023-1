package clases;

import clases.Equipo;


public class Partido {
    private int idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    //métodos
    //constructores
    public Partido() {
        this.idPartido = 0;
        this.equipo1 = null;
        this.equipo2 = null;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
    }

    public Partido(int idPartido, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public char resultado(Equipo e){
        return 'X';
    }
    
    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + '}';
    }
    
}
