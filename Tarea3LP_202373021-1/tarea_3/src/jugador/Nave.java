package jugador;

import eleccionPlaneta.MapaGalactico;
import planetas.Planeta;
import java.util.List;

public class Nave {
    private float combustible;
    private float eficienciaPropulsor;

    //////////////////
    // Nave (constructor)
    //////////////////
    // PARAMETROS:
    // - float combustible: La cantidad inicial de combustible en la nave.
    // - float eficienciaPropulsor: La eficiencia de los propulsores de la nave.
    //////////////////
    // DESCRIPCION: Constructor que inicializa la nave con combustible y eficiencia de propulsores.
    //////////////////
    public Nave(float combustible, float eficienciaPropulsor){
        this.combustible = combustible;
        this.eficienciaPropulsor = eficienciaPropulsor;
    }


    //////////////////
    // getCombustible
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad actual de combustible de la nave.
    //              Return tipo float.
    //////////////////
    public float getCombustible(){
        return combustible;
    }

    //////////////////
    // setCombustible
    //////////////////
    // PARAMETROS:
    // - float combustible: La nueva cantidad de combustible para la nave.
    //////////////////
    // DESCRIPCION: Establece la cantidad de combustible de la nave.
    //              No tiene return, es void.
    //////////////////
    public void setCombustible(float combustible){
        this.combustible = combustible;
    }

    //////////////////
    // getEficienciaPropulsor
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la eficiencia actual de los propulsores de la nave.
    //              Return tipo float.
    //////////////////
    public float getEficienciaPropulsor(){
        return eficienciaPropulsor;
    }

    //////////////////
    // setEficienciaPropulsor
    //////////////////
    // PARAMETROS:
    // - float eficienciaPropulsor: La nueva eficiencia de los propulsores.
    //////////////////
    // DESCRIPCION: Establece la eficiencia de los propulsores de la nave.
    //              No tiene return, es void.
    //////////////////
    public void setEficienciaPropulsor(float eficienciaPropulsor){
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    //////////////////
    // disminuirCombustible
    //////////////////
    // PARAMETROS:
    // - float gasto: La cantidad de combustible a disminuir.
    //////////////////
    // DESCRIPCION: Reduce la cantidad de combustible de la nave según el gasto indicado.
    //              No tiene return, es void.
    //////////////////
    public void disminuirCombustible(float gasto){
        combustible -= gasto;
    }

    //////////////////
    // recargarPropulsores
    //////////////////
    // PARAMETROS:
    // - float hidrogeno: La cantidad de hidrógeno entregada para recargar los propulsores.
    //////////////////
    // DESCRIPCION: Recarga los propulsores de la nave utilizando hidrógeno y la eficiencia de los propulsores.
    //              No permite que el combustible exceda los 100.
    //              No tiene return, es void.
    //////////////////
    public void recargarPropulsores(float hidrogeno){
        combustible += (float)(0.6*hidrogeno*(1 + eficienciaPropulsor*0.01));
        if(combustible > 100){
            setCombustible(100);
        }
    }

    //////////////////
    // aumentarEficPropulsores
    //////////////////
    // PARAMETROS:
    // - int Uranio: La cantidad de uranio entregada para mejorar la eficiencia de los propulsores.
    //////////////////
    // DESCRIPCION: Aumenta la eficiencia de los propulsores utilizando uranio, hasta un máximo de 100.
    //              No tiene return, es void.
    //////////////////
    public void aumentarEficPropulsores(int Uranio){
        double unidadesAumentadas = 0.6*Uranio;
        if((unidadesAumentadas + getEficienciaPropulsor()) > 100){
            eficienciaPropulsor = 100;
        } else {
            eficienciaPropulsor += (float)unidadesAumentadas;
        }
    }

    //////////////////
    // viajarPlaneta
    //////////////////
    // PARAMETROS:
    // - MapaGalactico MG: El mapa galáctico en el que se encuentra la nave.
    // - int direccion: La dirección del viaje (positiva o negativa).
    // - int tamanoSalto: La distancia en unidades entre planetas para el viaje.
    //////////////////
    // DESCRIPCION: La nave viaja entre planetas según la dirección y el tamaño del salto indicados.
    //              Verifica si hay suficiente combustible y genera planetas intermedios si es necesario.
    //              Return tipo Boolean.
    //////////////////
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        List<Object> lista = MG.getListaPlanetas();
        int caminoAtomar = MG.getPosicion() + (direccion*tamanoSalto);
        double unidadesConsumidas = 0.75*(tamanoSalto*tamanoSalto)*(1 - eficienciaPropulsor*0.01);

        if(getCombustible() > 0 && getCombustible() >= unidadesConsumidas){

            if(caminoAtomar < 0){
                System.out.println("~~~No existen planetas con numeros negativos!");
            } else if(caminoAtomar >= lista.size() || caminoAtomar > 0){
                System.out.println();
                System.out.println("~~~Tienes el combustible suficiente. ¡PREPARATE PARA EL VIAJE!");
                disminuirCombustible((float)unidadesConsumidas);
                while (lista.size() <= caminoAtomar) { //Esto me permite crear planetas intermedios
                    MG.generadorPlaneta();
                }

                Object planeta = MG.getPlaneta(caminoAtomar);
                if(planeta != null){
                    if(planeta instanceof Planeta planeta1){
                        System.out.println("~~~~Viajando al planeta " + planeta1.darNombre());
                        System.out.println();
                    }
                    MG.setPosicion(caminoAtomar);
                } else {
                    System.out.println();
                    System.out.println("~~~El planeta insertado no ha sido encontrado!!");
                    System.out.println();
                }
            } else{
                Object planeta = MG.getPlaneta(caminoAtomar);
                if(planeta != null){
                    if(planeta instanceof Planeta planeta1){
                        System.out.println("~~~Viajando al planeta " + planeta1.darNombre());
                        System.out.println();
                    }
                    MG.setPosicion(caminoAtomar);
                } else{
                    System.out.println();
                    System.out.println("~~~El planeta insertado no ha sido encontrado!!");
                    System.out.println();
                }
            }
            return true;
        } else{
            System.out.println();
            System.out.println("~~~No tienes el combustible suficiente para hacer tal viaje!!");
            System.out.println();
            return false;
        }
    }
}
