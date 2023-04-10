package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPartidos {
    
    private List<Partido> partidos;
    private String nombreArchivo;

    public ListaPartidos() {
        this.partidos = new ArrayList<>();
        this.nombreArchivo = "partidos.csv";
    }

    public ListaPartidos(List<Partido> partidos, String nombreArchivo) {
        this.partidos = partidos;
        this.nombreArchivo = nombreArchivo;
    }

    public void addPartido(Partido p) {
        this.partidos.add(p);
    }

    public Partido getPartidoById(int idPartido) {
        Partido p = null;
        for (Partido partido : this.getPartidos()) {
            if (partido.getIdPartido() == idPartido) {
                p = partido;
                break;
            }
        }
        return p;
    }

    void cargarDeArchivo(ListaEquipos equipos) {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Partido partido;
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
                int idPartido = Integer.parseInt(vector[0]);
                int idEquipo1 = Integer.parseInt(vector[1]);
                int idEquipo2 = Integer.parseInt(vector[2]);
                Equipo equipo1 = equipos.getEquipoById(idEquipo1);
                Equipo equipo2 = equipos.getEquipoById(idEquipo2);
                int golesEquipo1 = Integer.parseInt(vector[3]);
                int golesEquipo2 = Integer.parseInt(vector[4]);

                // crea el objeto en memoria
                partido = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);

                // llama al metodo add para grabar el objeto en la lista en memoria
                this.addPartido(partido);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    String listar() {
        String lista = "";
        for (Partido partido : partidos) {
            lista += "\n" + partido;
        }
        return lista;
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + ", nombreArchivo=" + nombreArchivo + '}';
    }

}