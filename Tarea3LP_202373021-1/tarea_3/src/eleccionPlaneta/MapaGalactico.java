package eleccionPlaneta;
import planetas.*;
import jugador.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class MapaGalactico {
    private final List<Object> planetas;
    private int posicion;
    private boolean aparicionCG;

    //////////////////
    // MapaGalactico
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Este es el constructor de la clase MapaGalactico.
    //              Inicializa la lista de planetas, establece la posición inicial en 0
    //              e inicializa la variable aparicionCG que indica si apareció o no el Centro Galáctico.
    //////////////////
    public MapaGalactico() {
        this.planetas = new ArrayList<>();
        this.posicion = 0;
        this.aparicionCG = true;
    }

    /* Metodos */

    //////////////////
    // setAparicionCG
    //////////////////
    // PARAMETROS:
    // - boolean flag: Recibe true si apareció el Centro Galáctico en la lista, en caso contrario un false.
    //////////////////
    // DESCRIPCION: Establece si el Centro Galáctico ya apareció o no (true si sí, false si no).
    //              No tiene return, es un void.
    //////////////////
    public void setAparicionCG(boolean flag) {
        this.aparicionCG = flag;
    }

    //////////////////
    // getAparicionCG
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada debido a que es un getter.
    //////////////////
    // DESCRIPCION: Retorna el valor actual que indica si el Centro Galáctico apareció o no.
    //              Return tipo boolean.
    //////////////////
    public boolean getAparicionCG() {
        return aparicionCG;
    }

    //////////////////
    // setPosicion
    //////////////////
    // PARAMETROS:
    // - int indice: La posición actual del jugador en la lista de planetas.
    //////////////////
    // DESCRIPCION: Establece la posición actual del jugador en la lista de planetas.
    //              No tiene return, es un void.
    //////////////////
    public void setPosicion(int indice) {
        this.posicion = indice;
    }

    //////////////////
    // getPosicion
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada debido a que es un getter.
    //////////////////
    // DESCRIPCION: Retorna la posición actual del jugador en la lista de planetas.
    //              Return tipo int.
    //////////////////
    public int getPosicion() {
        return posicion;
    }

    //////////////////
    // generadorPlaneta
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Genera un planeta aleatorio basado en probabilidades
    //              y lo añade a la lista de planetas. Si aún no ha aparecido el Centro Galáctico, lo puede generar.
    //              Una vez generado el Centro Galáctico se modifica las probabilidades para que ya no aparezca más.
    //              No tiene return, es un void.
    //////////////////
    public void generadorPlaneta(){
        Random random = new Random();
        int prob = random.nextInt(100) + 1;
        if(getAparicionCG()){
            if(prob <= 30){
                planetas.add(new Helado());
            } else if (prob <= 60) {
                planetas.add(new Oceanico());
            } else if (prob <= 80) {
                planetas.add(new Radiactivo());
            } else if (prob <= 99) {
                planetas.add(new Volcanico());
            } else{
                planetas.add(new CentroGalactico());
                setAparicionCG(false);
            }
        } else{
            if(prob <= 30){
                planetas.add(new Helado());
            } else if (prob <= 60) {
                planetas.add(new Oceanico());
            } else if (prob <= 80) {
                planetas.add(new Radiactivo());
            } else { //Cuando ya está el centro galactico en la lista solo agrego un 1% mas de probabilidad al planeta volcano.
                planetas.add(new Volcanico());
            }
        }
    }

    //////////////////
    // getListaPlanetas
    //////////////////
    // PARAMETROS:
    // - No recibe parametros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la lista de planetas generados hasta el momento.
    //              Return tipo List<Object>.
    //////////////////
    public List<Object> getListaPlanetas(){
        return planetas;
    }

    //////////////////
    // getPlaneta
    //////////////////
    // PARAMETROS:
    // - int indice: La posición del planeta que se desea obtener en la lista de planetas.
    //////////////////
    // DESCRIPCION: Devuelve el planeta en la posición especificada de la lista,
    //              o un mensaje de error si la posición es incorrecta.
    //              Return tipo Object. (retorna el planeta solicitado)
    //////////////////
    public Object getPlaneta(int indice){
        if(indice >= 0 && indice < planetas.size()){
            return planetas.get(indice);
        } else{
            System.out.println("Por favor ingresa un numero correcto");
        }
        return null;
    }

    //////////////////
    // mostrarPlanetas
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: El objeto del jugador actual.
    //////////////////
    // DESCRIPCION: Muestra en consola la lista de planetas disponibles,
    //              indicando en cuál planeta está el jugador actualmente.
    //              Si la energía o el combustible del jugador es cero,
    //              se llama a la función de emergencia y se establece la posición en el Centro Galáctico.
    //              No tiene return, es un void.
    //////////////////
    public void mostrarPlanetas(Jugador jugador){
        System.out.println("------LISTA DE PLANETAS DISPONIBLES------");
        for(int i = 0; i < planetas.size(); i++){
            Object planeta = getPlaneta(i);
            if (planeta instanceof Planeta planeta1){
                if(i == getPosicion()){
                    if(planeta1.darNombre().equals("Centro Galactico")){
                        System.out.printf("%d. Centro Galactico.  (ESTAS AQUI)" + "\n", i);
                    } else{
                        System.out.printf("%d. Planeta %s.  (ESTAS AQUI)" + "\n", i, planeta1.darNombre());
                    }
                } else{
                    if(planeta1.darNombre().equals("Centro Galactico")){
                        System.out.printf("%d. Centro Galactico." + "\n", i);
                    } else{
                        System.out.printf("%d. Planeta %s." + "\n", i, planeta1.darNombre());
                    }
                }
                if(jugador.getEnergia() <= 0 || jugador.getNave().getCombustible() <= 0){
                    jugador.emergencia();
                    setPosicion(0);
                }
            }
        }
        System.out.println("-----------------------------------------");
    }
}
