package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaParticipantes {
    
    private List<Participante> participantes;
    private String nombreArchivo;

    public ListaParticipantes() {
        participantes = new ArrayList<>();
        nombreArchivo = "participantes.csv";
    }

    public ListaParticipantes(List<Participante> participantes, String nombreArchivo) {
        this.participantes = participantes;
        this.nombreArchivo = nombreArchivo;
    }

    void cargarDeArchivo(ListaPronosticos todos, ListaPartidos partidos) {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.getNombreArchivo()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                line = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosEquipo);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vector = line.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int idParticipante = Integer.parseInt(vector[0]);
                String nombre = vector[1];

                // crea el objeto en memoria
                participante = new Participante(idParticipante, nombre);

                // cargo todos los pronósticos como parámetro
                participante.cargarPronosticos(todos, partidos);

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addParticipante(participante);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    void addParticipante(Participante p) {
        this.participantes.add(p);
    }

    void calcularPuntajes() {

    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    String listar() {
        String lista = "";
        for (Participante participante : this.getParticipantes()) {
            lista += "\n" + participante;
        }
        return lista;
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
