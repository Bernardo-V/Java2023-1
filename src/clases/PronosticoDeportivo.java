package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PronosticoDeportivo {

    ListaEquipos equipos = new ListaEquipos();
    ListaPartidos partidos = new ListaPartidos();
    ListaPronosticos pronosticos = new ListaPronosticos();
    ListaParticipantes participantes = new ListaParticipantes();
    ArrayList<Participante> ordenarParticipantes = new ArrayList<>();    

    public void play() {
        // cargar y listar equipos
        equipos.cargarDeArchivo();
        System.out.println("\nLos EQUIPOS cargados son: " + equipos.listar());

        // cargar y listar partidos
        partidos.cargarDeArchivo(equipos);
        System.out.println("\nLos PARTIDOS cargados son: " + partidos.listar());

        // cargar y listar pronósticos
        pronosticos.cargarDeArchivo(partidos);
        System.out.println("\nLos PRONÓSTICOS cargados son: " + pronosticos.listar());

        // cargar y listar participantes; paso al método la lista
        // completa de pronósticos
        participantes.cargarDeArchivo(pronosticos, partidos);
        System.out.println("\nLos PARTICIPANTES cargados son: " + participantes.listar());
 
 cargarParaOrdenar();   
 
    Collections.sort(ordenarParticipantes);
 
 listarOrdenado();
        

}//cierre del main
    
////////////////OTRAS FUNCIONES/////////////////////    
    
public void cargarParaOrdenar(){//cargar para ordenar
 
    Participante parti;
    int x=0;
    int lon = participantes.getParticipantes().size();
    for (x=0;x < lon ; x++) {
        
        int id = participantes.getParticipantes().get(x).getIdParticipante() ;
        String nom= participantes.getParticipantes().get(x).getNombre();
        int pun =  participantes.getParticipantes().get(x).getPuntaje();
    parti= new Participante(id,nom,null,pun);
            
    ordenarParticipantes.add(parti);
    //                participantes.getParticipantes().get(x).getPuntaje());
        }
}//cargar para ordenar

public void listarOrdenado(){//ordenar
 
 //   Participante parti;
    int x=0;
    int lon = ordenarParticipantes.size();
      System.out.println("");
    System.out.println("-----------------------------------------------------------");
    System.out.println("    LUEGO DE PROCESAR LOS DATOS ANTERIORES OBTENEMOS UNA ");
    System.out.println("     LISTA ORDENADA POR GANADORES EN ORDEN DESCENDENTE: ");
      System.out.println("-----------------------------------------------------------");
    for (x=0;x < lon ; x++) {//for
if(x<9){        
   System.out.print("NUMERO:   "+ordenarParticipantes.get(x).getIdParticipante() +"     "+"NOMBRE:  "+ ordenarParticipantes.get(x).getNombre()+"     "+
        "\t PUNTAJE:  "+ordenarParticipantes.get(x).getPuntaje()+"\n" );
}else{
    System.out.print("NUMERO:  "+ordenarParticipantes.get(x).getIdParticipante() +"     "+"NOMBRE:  "+ ordenarParticipantes.get(x).getNombre()+"     "+
        "\t PUNTAJE:  "+ordenarParticipantes.get(x).getPuntaje()+"\n" );
      }           
        }//for    

System.out.println("");
System.out.println("                  GRACIAS POR PARTICIPAR    ");
System.out.println("");


}//ordenar
    
    
}// cierre de clase