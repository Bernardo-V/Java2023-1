package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPronosticos {
    private List<Pronostico> pronosticos;
    private String nombreArchivo;

    public ListaPronosticos() {
        pronosticos = new ArrayList<>();
        nombreArchivo = "pronosticos.csv";
    }

    public ListaPronosticos(List<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.nombreArchivo = nombreArchivo;
    }

    void cargarDeArchivo(ListaPartidos partidos) {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Pronostico pronostico;
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
                int idPronostico = Integer.parseInt(vector[0]);
                int idPartido = Integer.parseInt(vector[2]);
                int equipoNro = Integer.parseInt(vector[3]);
                String resultado = vector[4];
                Partido partido = partidos.getPartidoById(idPartido);
                Equipo equipo = null;
                if (equipoNro == 1) {
                    equipo = partido.getEquipo1();
                } else {
                    equipo = partido.getEquipo2();
                }
                pronostico = new Pronostico(idPronostico, equipo, partido, resultado.charAt(1));
                this.addPronostico(pronostico);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    String listar() {
        String lista = "";
        for (Pronostico pronostico : this.getPronosticos()) {
            lista += "\n" + pronostico;
        }
        return lista;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public Pronostico getPronosticoById(int idPronostico) {
        Pronostico pronostico = null;
        for (Pronostico p : this.getPronosticos()) {
            if (p.getIdPronostico() == idPronostico) {
                pronostico = p;
                break;
            }
        }

        return pronostico;
    }

    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
