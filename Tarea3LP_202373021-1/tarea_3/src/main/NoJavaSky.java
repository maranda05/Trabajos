package main;

import eleccionPlaneta.MapaGalactico;
import jugador.Jugador;
import jugador.Nave;
import planetas.*;
import java.util.Scanner;
public class NoJavaSky {

    //////////////////
    // main
    //////////////////
    // PARAMETROS:
    // - String[] args: Los argumentos de la línea de comandos al iniciar el programa.
    //////////////////
    // DESCRIPCION: Punto de entrada del juego "No Java's Sky". Inicializa los elementos del juego,
    //              como el jugador, la nave, y el mapa galáctico, y controla el ciclo principal de juego.
    //              Permite al jugador viajar entre planetas, revisar su inventario, y visitar planetas.
    //              No tiene return, es un void.
    //////////////////
    public static void main(String[] args) {
        // Tamaño del margen y espacio para la salida de texto.
        int marginSize = 20;
        String margen = " ".repeat(marginSize); // Generar el margen de 10 espacios

        // Variables para controlar el ciclo del juego.
        boolean flag = true;
        boolean flag_CG = true;
        boolean flag_visita;

        // Inicialización del escáner, mapa galáctico, nave y jugador.
        Scanner scanner = new Scanner(System.in);
        MapaGalactico mapa = new MapaGalactico();
        Nave naveJugador = new Nave(100, 0);
        Jugador jugador = new Jugador(100, 0, 0, 0, 0, 0, naveJugador, mapa);
        System.out.println("-------------------------------------");
        System.out.println("-----BIENVENIDO A No Java's Sky!-----");
        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println("| No Java's Sky es un juego de aventura          |");
        System.out.println("| en el cual viajarás por 4 distintos planetas   |");
        System.out.println("| en tu nave espacial. Contarás con un ExoTraje  |");
        System.out.println("| el cual te protegerá de las adversidades del   |");
        System.out.println("| planeta en el que estés, pero cuidado, irá     |");
        System.out.println("| disminuyendo su energía entre más uso le des.  |");
        System.out.println("| Mediante distintos materiales que conseguirás  |");
        System.out.println("| en los planetas podrás conseguir mejoras a     |");
        System.out.println("| los propulsores de tu nave y a tu ExoTraje     |");
        System.out.println("| por medio de intercambio entre los habitantes  |");
        System.out.println("| de los planetas Helado u Oceanicos.            |");
        System.out.println("|                                                |");
        System.out.println("| Cuida mucho tus recursos, estos son limitados! |");
        System.out.println("| Si el combustible de tu nave o la energía de   |");
        System.out.println("| tu ExoTraje se agotan perderás todo tu         |");
        System.out.println("| inventario y volverás al planeta en el que     |");
        System.out.println("| comenzaste tu aventura.                        |");
        System.out.println("|                                                |");
        System.out.println("| Tu meta es encontrar el Centro Galáctico y     |");
        System.out.println("| poder entrar en él con la condición de que la  |");
        System.out.println("| eficiencia de tu propulsor sea mayor o igual   |");
        System.out.println("| a 50%.                                         |");
        System.out.println("|                                                |");
        System.out.println("| CONSIDERACIONES:                               |");
        System.out.println("| De los cuatro minerales que existen:           |");
        System.out.println("| Sodio, Hidrógeno, Uranio y Platino, los        |");
        System.out.println("| podrás intercambiar en los asentamientos por:  |");
        System.out.println("| -Sodio: Más energía para tu ExoTraje           |");
        System.out.println("| -Hidrógeno: Más combustible para la nave       |");
        System.out.println("| -Uranio: Más Eficiencia para los propulsores   |");
        System.out.println("|          de tu nave.                           |");
        System.out.println("| -Platino: Más Eficiencia para tu ExoTraje      |");
        System.out.println("|                                                |");
        System.out.println("| La eficiencia de los propulsores de la nave,   |");
        System.out.println("| el combustible, la eficiencia y la energía del |");
        System.out.println("| ExoTraje tienen una capacidad desde 0 hasta    |");
        System.out.println("| hasta 100 unidades.                            |");
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("~~Escribe 1 para comenzar tu aventura!~~");

        // Espera la entrada del jugador para comenzar el juego.
        while(flag) {
            int eleccion = scanner.nextInt();
            if (eleccion == 1) {
                System.out.println("Comienza tu aventura en No Java's Sky!");
                System.out.println("--------------------------------------");
                System.out.println();
                flag = false;
            } else {
                System.out.println("~~Por favor ingresa el número solicitado.~~");
            }
        }
        mapa.generadorPlaneta();

        // Ciclo principal del juego que continúa hasta que el jugador alcanza el Centro Galáctico o sale del juego.
        while(flag_CG){
            Object planetaActual = mapa.getPlaneta(mapa.getPosicion());

            // Mostrar estadísticas del jugador y la nave.
            System.out.println("--------------------------------------");
            System.out.println(margen + "Combustible: "+naveJugador.getCombustible());
            System.out.println(margen + "Eficiencia de propulsores: " + naveJugador.getEficienciaPropulsor());
            System.out.println(margen + "Energía ExoTraje: " + jugador.getEnergia());
            System.out.println(margen + "Eficiencia ExoTraje:" + jugador.getEficiencia());
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if(planetaActual instanceof Planeta planet){
                System.out.printf("Estas orbitando en el planeta %s%n", planet.darNombre());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Inventario.");
            System.out.println("2. Visitar el planeta");
            System.out.println("3. Viajar a otro planeta.");
            System.out.println("4. Rendirse.");
            System.out.println("5. Salir del juego.");
            System.out.println("---------------------------------------");
            System.out.print("Escoge la opción: ");
            int eleccion1 = scanner.nextInt();
            System.out.println();
            if(eleccion1 == 1) {
                System.out.println("--------------------------------------");
                System.out.println("-----------Tu inventario es:----------");
                System.out.println("---SODIO: " + jugador.getCantSodio());
                System.out.println("---HIDROGENO: " + jugador.getCantHidrogeno());
                System.out.println("---URANIO: " + jugador.getCantUranio());
                System.out.println("---PLATINO: " + jugador.getCantPlatino());
                System.out.println("--------------------------------------");
                System.out.println();
            } else if(eleccion1 == 2) {
                System.out.println("###OH NO! Tu ExoTraje perdió energía por la atmosfera del planeta###");
                if(planetaActual instanceof Planeta planet){
                    jugador.disminuirEnergiaViajar((int)planet.getConsumoEnergia());
                    System.out.println("###Tu energía actual es de: " + jugador.getEnergia());
                    do {
                        flag_visita = planet.visitar(jugador);
                        jugador.emergencia();
                        flag_CG = planet.getEntrarCG();

                    } while(flag_visita);
                }
            } else if (eleccion1 == 3) {
                mapa.mostrarPlanetas(jugador);
                System.out.println();
                System.out.println("----Hacia donde quieres ir?----");
                System.out.println("(-1) Volver a un planeta anterior / (1) Ir a otro planeta siguiente / (0) Salir");
                int eleccionPlaneta = scanner.nextInt();
                if (eleccionPlaneta == 1) {
                    System.out.println("~~Cuantos planetas quieres avanzar?:");
                    int eleccionSaltoDerecha = scanner.nextInt();
                    boolean emergencia_nave = naveJugador.viajarPlaneta(mapa, eleccionPlaneta, eleccionSaltoDerecha);
                    if (!emergencia_nave || naveJugador.getCombustible() <= 0) {
                        jugador.emergencia();
                    }
                } else if (eleccionPlaneta == -1) {
                    System.out.println("~~Cuantos planetas quieres retroceder?");
                    int eleccionSaltoizq = scanner.nextInt();
                    boolean emergencia_nave = naveJugador.viajarPlaneta(mapa, eleccionPlaneta, eleccionSaltoizq);
                    if (!emergencia_nave || naveJugador.getCombustible() <= 0) {
                        jugador.emergencia();
                    }
                }
            } else if(eleccion1 == 4){
                System.out.println();
                System.out.println("###Rendirse significa que volverás al planeta 0 junto a que todo tu inventario, tus");
                System.out.println("###eficiencias volverán a 0, pero tu combustible y tu energía del ExoTraje volverán a 100");
                System.out.println();
                System.out.print("~~~Estás seguro de rendirte? (1)Si  (2)No: ");
                int eleccionRendirse = scanner.nextInt();
                System.out.println();
                if (eleccionRendirse == 1){
                    jugador.setRendirse(true);
                    jugador.emergencia();
                }
            } else if(eleccion1 == 5) {
                System.out.println("-----Nos vemos!!------");
                flag_CG = false;
            } else{
                System.out.println("Pon un numero correcto:");
            }
        }
    }
}
