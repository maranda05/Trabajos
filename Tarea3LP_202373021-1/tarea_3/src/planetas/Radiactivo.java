package planetas;

import jugador.Jugador;

import java.util.Random;
import java.util.Scanner;

public class Radiactivo extends Planeta{
    private int radiacion;

    //////////////////
    // Radiactivo (constructor)
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Constructor de la clase Radiactivo que inicializa los atributos del planeta, calculando radiación, consumo de energía y cantidad de uranio.
    //              No tiene return, es el constructor.
    //////////////////
    public Radiactivo(){
        super(); //Llama al constructor de la clase base (Planeta)
        calculoRadiacion();
        calculoConsumoEnergia();
        calculoUranio();
    }

    //////////////////
    // calculoRadio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entradas.
    //////////////////
    // DESCRIPCION: Metodo que calcula el radio del planeta Radiactivo. El radio se genera aleatoriamente entre 10000 y 100000.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoRadio() {
        Random rand = new Random();
        this.radio = rand.nextInt(90001) + 10000; // Radio entre 10000 y 100000
    }


    //////////////////
    // calculoFloresSodio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo que calcula la cantidad de flores de sodio, mediante la formula entregada en la guía,
    //              en el planeta Radiactivo basado en su radio.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoFloresSodio(){
        double formula = 0.2*(4*Math.PI*radio*radio);
        this.CantFloresSodio = (int)formula;
    }

    //////////////////
    // calculoCristalesHidrogeno
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo que calcula la cantidad de cristales de hidrógeno, mediante la formula entregada en la guía,
    //              en el planeta Radiactivo basado en su radio.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoCristalesHidrogeno(){
        double formula = 0.2*(4*Math.PI*radio*radio);
        this.CantCristalesHidrogeno = (int)formula;
    }

    //////////////////
    // calculoUranio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo que calcula la cantidad de uranio, mediante la formula entregada en la guía,
    //              en el planeta Radiactivo basado en su radio.
    //              No tiene return, es void.
    //////////////////
    public void calculoUranio(){
        double formula = 0.25*(4*Math.PI*radio*radio);
        this.CantUranio = (int)formula;
    }

    //////////////////
    // calculoRadiacion
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo que calcula la radiación del planeta Radiactivo. La radiación se genera aleatoriamente entre 10 y 50.
    //              No tiene return, es void.
    //////////////////
    public void calculoRadiacion(){
        Random rand = new Random();
        this.radiacion = rand.nextInt(41) + 10; //Radiación entre 10 y 50 Rad.
    }


    //////////////////
    // getRadiacion
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo que retorna la cantidad de radiación del planeta Radiactivo.
    //              Retorna un int.
    //////////////////
    public int getRadiacion(){
        return radiacion;
    }

    //////////////////
    // calculoConsumoEnergia
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo que calcula el consumo de energía, mediante la formula entrega en la guía,
    //              del planeta Radiactivo basado en su radiación.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoConsumoEnergia(){
        double formula = 0.3*(radiacion);
        this.ConsumoEnergia = (int)formula;
    }

    //////////////////
    // visitar
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: el jugador que visita el planeta.
    //////////////////
    // DESCRIPCION: Metodo que maneja la visita del jugador al planeta Radiactivo.
    //              Permite al jugador extraer materiales y maneja el consumo de energía.
    //              Retorna un booleano.
    //////////////////
    @Override
    public boolean visitar(Jugador jugador){
        if(jugador.getEnergia() <= 0){
            jugador.emergencia();
            return false;
        }
        System.out.println();
        System.out.println("~~~~~~~~Entrando al planeta escogido~~~~~~~~");
        System.out.println();
        System.out.println("-----Información del planeta Radiactivo-----");
        System.out.println("---Radio: " + getRadio());
        System.out.println("---Radiación: " + getRadiacion());
        System.out.println("---Cantidad de Hidrógeno: " + getCristales());
        System.out.println("---Cantidad de Sodio: " + getFloresSodio());
        System.out.println("---Cantidad de Uranio: " + getUranio());
        System.out.println("---Energía consumida: " + getConsumoEnergia());
        System.out.println();
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
                System.out.println("~~~~~~~~~Buscando minerales...~~~~~~~~~");
                System.out.println("---------------------------------------");
                System.out.println("---Que minerales quieres extraer?");
                System.out.println("---1. Flores de Sodio: " + getFloresSodio());
                System.out.println("---2. Cristales de Hidrógeno: " + getCristales());
                System.out.println("---3. Uranio: " + getUranio());
                System.out.println("---4. Platino: (No existe en este planeta)");
                System.out.println("---------------------------------------");
                System.out.println("---5. No quiero extraer minerales.");
                int eleccion1 = scanner.nextInt();
                if(eleccion1 == 1){
                    System.out.println("---Cuanta cantidad quieres extraer?");
                    System.out.println("###WARNING: Dependiendo de la cantidad de material que extraigas");
                    System.out.println("###la energía de tu ExoTraje irá disminuyendo. CUIDADO!");
                    int cantTotal = extraerRecursos(eleccion1);
                    System.out.println("---------------------------------------");
                    int cantExtraida = scanner.nextInt();
                    setFloresSodio(cantTotal-cantExtraida);
                    jugador.aumentarSodio(cantExtraida);
                    System.out.println("---Listo! Has extraido " + cantExtraida + " Flores de sodio.");
                    System.out.println("---------------------------------------");
                    System.out.println("###OH NO! Tu ExoTraje perdió energía por extraer tanto material###");
                    jugador.disminuirEnergiaProteccion(cantExtraida, getConsumoEnergia());
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
                    setCristales(cantTotal - cantExtraida);
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
                } else if(eleccion1 == 3){
                    System.out.println("---Cuanta cantidad quieres extraer?");
                    System.out.println("###WARNING: Dependiendo de la cantidad de material que extraigas");
                    System.out.println("###la energía de tu ExoTraje irá disminuyendo. CUIDADO!");
                    int cantTotal = extraerRecursos(eleccion1);
                    System.out.println("---------------------------------------");
                    int cantExtraida = scanner.nextInt();
                    setUranio(cantTotal - cantExtraida);
                    jugador.aumentarUranio(cantExtraida);
                    System.out.println("----Listo! Has extraido " + cantExtraida + " Uranios.");
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
                    System.out.println("---No existe este mineral en este planeta---");
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
    // DESCRIPCION: Metodo que retorna el nombre del planeta Radiactivo.
    //              Retorna un String.
    //////////////////
    public String darNombre(){
        return "Radiactivo";
    }

}
