package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Participante implements Comparable<Participante> {
    private int idParticipante;
    private String nombre;
    private List<Pronostico> pronosticos;
    private int puntaje;

    public Participante() {
        this.idParticipante = 0;
        this.nombre = null;
        this.pronosticos = new ArrayList<>();
        this.puntaje = 0;
    }

    public Participante(int Id, String nombre) {
        this.idParticipante = Id;
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
        this.puntaje = 0;
    }

    public Participante(int idParticipante, String nombre, List<Pronostico> pronosticos, int puntaje) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
        this.puntaje = puntaje;
    }

    void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    void cargarPronosticos(ListaPronosticos todos, ListaPartidos partidos) {
        //cargo nuevamente archivo pronosticos.csv y extraigo solo idPronostico 
        //y idParticipante

        String line;
        String vector[];
        int fila = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(new File("pronosticos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                line = sc.next();
                fila++;
                if (fila == 1) {
                    continue;
                }
                vector = line.split(",");
                int idPronostico = Integer.parseInt(vector[0]);
                int idParticipante = Integer.parseInt(vector[1]);
                
                if (idParticipante == this.getIdParticipante()) {

                    //este pronostico pertenece a éste participante
                    Pronostico pronostico = todos.getPronosticoById(idPronostico);
                    this.addPronostico(pronostico);

                    //verifico si el pronóstico es acertado
                    //tomo partido, equipo y resultado pronosticados 
                    Partido partido = pronostico.getPartido();
                    Equipo equipo_pronosticado = pronostico.getEquipo();
                    char resultado_pronosticado = pronostico.getResultado();

                    //comparamos resultados
                    char resultado_real = 'X';

                    if (partido.getGolesEquipo1() == partido.getGolesEquipo2()) {
                        
                        //empate
                        resultado_real = 'E';
                    } else {
                        
                        //algún equipo ganó
                        if (equipo_pronosticado.equals(partido.getEquipo1())) {
                            
                            //se apostó por el equipo uno
                            if(partido.getGolesEquipo1() > partido.getGolesEquipo2()){
                                resultado_real = 'G'; //gana equipo uno
                            }else{
                                resultado_real = 'P'; //pierde equipo uno
                            }
                        } else {
                            
                            //se apostó por el equipo dos
                            if(partido.getGolesEquipo2() > partido.getGolesEquipo1()){
                                resultado_real = 'G'; //gana equipo uno
                            }else{
                                resultado_real = 'P'; //pierde equipo uno
                            }
                        }
                    }
                    
                    //Incrementar puntaje si acertó el pronóstico
                    if(resultado_real == resultado_pronosticado){
                        this.setPuntaje(this.getPuntaje() + 1);
                    }
                }
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", pronosticos=" + pronosticos + ", puntaje=" + puntaje + '}';
    }

    @Override
    public int compareTo(Participante t) {
        /*throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        */
        
        return t.puntaje - this.puntaje;
        
}

}
