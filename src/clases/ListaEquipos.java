package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaEquipos {
    
    private List<Equipo> equipos;
    private String nombreArchivo;

    public ListaEquipos() {
        this.equipos = new ArrayList<>();
        this.nombreArchivo = "equipos.csv";
    }

    public ListaEquipos(List<Equipo> equipos, String nombreArchivo) {
        this.equipos = equipos;
        this.nombreArchivo = nombreArchivo;
    }

    void cargarDeArchivo() {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Equipo equipo;
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
                int idEquipo = Integer.parseInt(vector[0]);
                String nombre = vector[1];
                String descripcion = vector[2];
                // crea el objeto en memoria
                equipo = new Equipo(idEquipo, nombre, descripcion);

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addEquipo(equipo);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    // add, remove and get elements
    public void addEquipo(Equipo e) {
        this.equipos.add(e);
    }

    public void removeEquipo(Equipo e) {
        this.equipos.remove(e);
    }

    public Equipo getEquipoById(int idEquipo) {

        Equipo encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Equipo eq : this.getEquipos()) {
            if (eq.getIdEquipo() == idEquipo) {
                encontrado = eq;
                break;
            }
        }
        return encontrado;
    }

    String listar() {
        String lista = "";
        for (Equipo equipo : equipos) {
            lista += "\n" + equipo;
        }
        return lista;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getNombreArchivo() {
        return this.nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
