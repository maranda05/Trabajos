package planetas;

import java.util.Random;
import java.util.Scanner;

import jugador.Jugador;

public class Volcanico extends Planeta{
    private int temperatura;

    //////////////////
    // Volcanico (constructor)
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Constructor de la clase Volcanico que inicializa
    //              el planeta y llama a métodos para calcular la temperatura,
    //              consumo de energía y cantidad de platino.
    //              No tiene return, es el constructor.
    //////////////////
    public Volcanico(){
        super(); //Llama al constructor de la clase base (Planeta)
        calculoTemperatura();
        calculoConsumoEnergia();
        calculoPlatino();
    }

    //////////////////
    // calculoRadio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada
    //////////////////
    // DESCRIPCION: Este mwtodo calcula el radio del planeta utilizando un valor aleatorio
    //              en el rango de 1000 a 100000.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoRadio() {
        Random rand = new Random();
        this.radio = rand.nextInt(99001) + 1000; // Radio entre 10000 y 100000
    }

    //////////////////
    // calculoCristalesHidrogeno
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Este metodo calcula la cantidad de cristales de hidrógeno
    //              en función del radio del planeta, utilizando la formula entregada en la guía.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoCristalesHidrogeno(){
        double formula = 0.3*(4*Math.PI*radio*radio);
        this.CantCristalesHidrogeno = (int)formula;
    }

    //////////////////
    // calculoPlatino
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada
    //////////////////
    // DESCRIPCION: Este metodo calcula la cantidad de platino en el planeta
    //              utilizando la formula entregada en la guía.
    //              No tiene return, es void.
    //////////////////
    public void calculoPlatino(){
        double formula = 0.25*(4*Math.PI*radio*radio);
        this.CantPlatino = (int)formula;
    }

    //////////////////
    // calculoTemperatura
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Este metodo calcula una temperatura aleatoria para el planeta
    //              en el rango de 120 a 256.
    //              No tiene return, es void.
    //////////////////
    public void calculoTemperatura(){
        Random rand = new Random();
        this.temperatura = rand.nextInt(137) + 120;
    }

    //////////////////
    // getTemperatura
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Este metodo devuelve la temperatura del planeta.
    //              Retorna un int.
    //////////////////
    public int getTemperatura(){
        return temperatura;
    }

    //////////////////
    // calculoConsumoEnergia
    //////////////////
    // PARAMETROS:
    // -
    // -
    //////////////////
    // DESCRIPCION: Este metodo calcula el consumo de energía en función de la
    //              temperatura del planeta utilizando la formula entregada en la guía.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoConsumoEnergia(){
        double formula = 0.08*(temperatura);
        this.ConsumoEnergia = (int)formula;
    }

    //////////////////
    // visitar
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: el objeto jugador que interactúa con el planeta.
    //////////////////
    // DESCRIPCION: Este metodo permite al jugador visitar el planeta, mostrando información
    //              sobre el mismo y permitiendo la extracción de recursos. Retorna un booleano false que indica
    //              si el jugador ha salido del planeta.
    //////////////////
    @Override
    public boolean visitar(Jugador jugador) {
        if(jugador.getEnergia() <= 0){
            jugador.emergencia();
            return false;
        }
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("-----Información del planeta Volcanico-----");
        System.out.println("---Radio: " + getRadio());
        System.out.println("---Temperatura: " + getTemperatura());
        System.out.println("---Cantidad de Hidrogeno: " + getCristales());
        System.out.println("---Cantidad de Sodio: " + getFloresSodio());
        System.out.println("---Cantidad de Platino: " + getPlatino());
        System.out.println("---Energía consumida: " + getConsumoEnergia());
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Qué es lo que quieres hacer?");
        System.out.println("1. Extraer materiales");
        System.out.println("2. Salir");
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        if (eleccion == 1) {
            boolean flag_intercambio = true;
            while(flag_intercambio){
                System.out.println();
                System.out.println("~~~~~~~~Buscando minerales...~~~~~~~~~~");
                System.out.println("---------------------------------------");
                System.out.println("---Que mineral quieres extraer?");
                System.out.println("---1. Flores de Sodio: (No existe en este planeta)");
                System.out.println("---2. Cristales de Hidrógeno: " + getCristales());
                System.out.println("---3. Uranio: (No existe en este planeta)");
                System.out.println("---4. Platino: " + getPlatino());
                System.out.println("---------------------------------------");
                System.out.println("---5. No quiero extraer.");
                int eleccion1 = scanner.nextInt();
                if(eleccion1 == 4){
                    System.out.println("---Cuanta cantidad quieres extraer?");
                    System.out.println("###WARNING: Dependiendo de la cantidad de material que extraigas");
                    System.out.println("###la energía de tu ExoTraje irá disminuyendo.");
                    int cantTotal = extraerRecursos(eleccion1);
                    System.out.println("---------------------------------------");
                    int cantExtraida = scanner.nextInt();
                    setPlatino(cantTotal-cantExtraida);
                    jugador.aumentarPlatino(cantExtraida);
                    System.out.println("---Listo! Has extraido " + cantExtraida + " Platino.");
                    System.out.println("---------------------------------------");
                    jugador.disminuirEnergiaProteccion(cantExtraida, getConsumoEnergia());
                    System.out.println("###OH NO! Tu ExoTraje perdió energía por extraer tanto material###");
                    if(jugador.getEnergia() <= 0){
                        jugador.emergencia();
                        return false;
                    }

                    System.out.println("Tu energía actual es de: " + (jugador.getEnergia()));
                    System.out.println();
                } else if (eleccion1 == 2) {
                    System.out.println("---Cuanta cantidad quieres extraer?");
                    System.out.println("###WARNING: Dependiendo de la cantidad de material que extraigas");
                    System.out.println("###la energía de tu ExoTraje irá disminuyendo.");
                    int cantTotal = extraerRecursos(eleccion1);
                    System.out.println("---------------------------------------");
                    int cantExtraida = scanner.nextInt();
                    setCristales(cantTotal-cantExtraida);
                    jugador.aumentarHidrogeno(cantExtraida);
                    System.out.println("----Listo! Has extraido " + cantExtraida + " Cristales de hidrógeno.");
                    System.out.println("---------------------------------------");
                    System.out.println("###OH NO! Tu ExoTraje perdió energía por extraer tanto material###");
                    jugador.disminuirEnergiaProteccion(cantExtraida, getConsumoEnergia());
                    if(jugador.getEnergia() <= 0){
                        jugador.emergencia();
                        return false;
                    }
                    System.out.println("Tu energía actual es de: " + (jugador.getEnergia()));
                    System.out.println();
                } else if (eleccion1 == 5) {
                    System.out.println("~~~~~Regresando a la superficie del planeta~~~~~");
                    flag_intercambio = false;
                } else{
                    System.out.println("---No existe ese mineral en este planeta---");
                }
            }


        } else if (eleccion == 2) {
            return salir();
        }
        return true;
    }

    //////////////////
    // darNombre
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Este metodo devuelve el nombre del planeta, que es "Volcánico".
    //              Retorna un String.
    //////////////////
    public String darNombre(){
        return "Volcánico";
    }

}
