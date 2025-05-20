package planetas;

import eleccionPlaneta.tieneAsentamientos;
import jugador.Jugador;

import java.util.Random;
import java.util.Scanner;

public class Oceanico extends Planeta implements tieneAsentamientos {
    private int profundidad;

    //////////////////
    // Oceanico (constructor)
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Constructor por defecto de la clase Oceanico.
    //              Inicializa la profundidad y el consumo de energía del planeta.
    //              No tiene return, es un constructor.
    //////////////////
    public Oceanico(){
        super(); //Llama al constructor de la clase base (Planeta)
        calculoProfundidad();
        calculoConsumoEnergia();
    }


    //////////////////
    // calculoRadio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula y asigna un valor aleatorio al radio del planeta entre 10000 y 1000000 unidades.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoRadio() {
        Random rand = new Random();
        this.radio = rand.nextInt(990001) + 10000; // Radio entre 10000 y 1000000
    }

    //////////////////
    // calculoFloresSodio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula la cantidad de Flores de Sodio según la fórmula entregada en la guía basada en el radio del planeta.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoFloresSodio(){
        double formula = 0.65*(4*Math.PI*radio*radio);
        this.CantFloresSodio = (int)formula;
    }

    //////////////////
    // calculoCristalesHidrogeno
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula la cantidad de Cristales de Hidrógeno según la fórmula entregada en la guía
    //              en función del radio del planeta.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoCristalesHidrogeno(){
        double formula = 0.2*(4*Math.PI*radio*radio);
        this.CantCristalesHidrogeno = (int)formula;
    }

    //////////////////
    // calculoProfundidad
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula un valor aleatorio para la profundidad del océano del planeta entre 30 y 100 unidades.
    //              No tiene return, es void.
    //////////////////
    public void calculoProfundidad(){
        Random rand = new Random();
        this.profundidad = rand.nextInt(71) + 30;
    }

    //////////////////
    // getProfundidad
    //////////////////
    // PARAMETROS:
    // - Ninguno.
    //////////////////
    // DESCRIPCION: Retorna el valor (tipo int) de la profundidad del océano del planeta.
    //////////////////
    public int getProfundidad(){
        return profundidad;
    }

    //////////////////
    // calculoConsumoEnergia
    //////////////////
    // PARAMETROS:
    // - Ninguno.
    //////////////////
    // DESCRIPCION: Calcula el consumo de energía del exotraje al visitar el planeta, basado en la profundidad.
    //              No tiene return, es void.
    //////////////////
    @Override
    protected void calculoConsumoEnergia(){
        double formula = 0.002*(this.profundidad)*(this.profundidad);
        this.ConsumoEnergia = (int)formula;
    }

    //////////////////
    // visitarAsentamientos
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: El jugador que ingresa a los asentamientos.
    //////////////////
    // DESCRIPCION: Este metodo permite al jugador intercambiar recursos con los habitantes
    //              del planeta Oceanico. Muestra opciones de intercambio y actualiza el inventario del jugador.
    //              No tiene return, es un void.
    //////////////////
    @Override
    public void visitarAsentamientos(Jugador jugador) {
        boolean flag = true;
        while(flag){
            System.out.println("--------------------------------");
            System.out.println("---Que te gustaría intercambiar?");
            System.out.println("---1. Combustible por Cristales de Hidrógeno");
            System.out.println("---2. Energía exotraje por Flores de Sodio");
            System.out.println("---3. Eficiencia Propulsores extra por Uranio");
            System.out.println("---4. Eficiencia Exotraje extra por Platino");
            System.out.println("---5. Salir.");
            System.out.println("--------------------------------");
            System.out.print("~~Elige una opción: ");
            Scanner scanner = new Scanner(System.in);
            int eleccionIntercambio = scanner.nextInt();
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("----------Tu inventario---------");
            System.out.println("---Flores de Sodio: " + jugador.getCantSodio());
            System.out.println("---Cristales de Hidrógeno: " + jugador.getCantHidrogeno());
            System.out.println("---Uranio: " + jugador.getCantUranio());
            System.out.println("---Platino: " + jugador.getCantPlatino());
            System.out.println("---Combustible: " + jugador.getNave().getCombustible());
            System.out.println("--------------------------------");

            if (eleccionIntercambio == 1){
                System.out.print("~~¿Cuanta cantidad quieres intercambiar?:");
                int cantidadRequerida = scanner.nextInt();
                System.out.println();
                if(cantidadRequerida > jugador.getCantHidrogeno()){
                    System.out.println("~~No tienes suficientes Cristales de Hidrógeno para intercambiar");
                } else {
                    float combAntes = jugador.getNave().getCombustible();
                    jugador.getNave().recargarPropulsores(cantidadRequerida);
                    float combDespues = jugador.getNave().getCombustible();
                    float combTotal = combDespues - combAntes;
                    jugador.aumentarHidrogeno((-1)*cantidadRequerida);
                    System.out.println("-----------------------------------");
                    System.out.println("---El combustible de la nave a aumentado en: " + combTotal + " L.");
                    System.out.println("---Ahora el combustible total de tu nave es de " + jugador.getNave().getCombustible() + " L.");
                    System.out.println("-----------------------------------");
                }
            } else if (eleccionIntercambio == 2){
                System.out.print("~~¿Cuanta cantidad quieres intercambiar?:");
                int cantidadRequerida = scanner.nextInt();
                System.out.println();
                if(cantidadRequerida > jugador.getCantSodio()){
                    System.out.println("~~No tienes suficientes Flores de Sodio para intercambiar");
                } else{
                    float nrgAntes = jugador.getEnergia();
                    jugador.recargarEnergiaProteccion(cantidadRequerida);
                    float nrgDespues = jugador.getEnergia();
                    float nrgTotal = nrgDespues - nrgAntes;
                    jugador.aumentarSodio((-1)*cantidadRequerida);
                    System.out.println("-----------------------------------");
                    System.out.println("---Tu energía del exotraje a aumentado en: " + nrgTotal + " unidades.");
                    System.out.println("---Ahora tu energía total es de " + jugador.getEnergia() + " unidades.");
                    System.out.println("-----------------------------------");
                }

            } else if (eleccionIntercambio == 3) {
                System.out.print("~~¿Cuanta cantidad quieres intercambiar?:");
                int cantidadRequerida = scanner.nextInt();
                System.out.println();
                if (cantidadRequerida > jugador.getCantUranio()) {
                    System.out.println("~~No tienes suficiente Uranio para intercambiar");
                } else {
                    float EficAntes = jugador.getEficiencia();
                    jugador.getNave().aumentarEficPropulsores(cantidadRequerida);
                    float EficDespues = jugador.getEficiencia();
                    float EficTotal = EficDespues - EficAntes;
                    jugador.aumentarUranio((-1) * cantidadRequerida);
                    System.out.println("-----------------------------------");
                    System.out.println("---La eficiencia de los propulsores de tu nave a aumentado un: " + EficTotal + "%");
                    System.out.println("---Ahora tal eficiencia total es del " + jugador.getNave().getEficienciaPropulsor() + "%");
                    System.out.println("-----------------------------------");
                }
            } else if(eleccionIntercambio == 4){
                System.out.print("~~¿Cuanta cantidad quieres intercambiar?:");
                int cantidadRequerida = scanner.nextInt();
                System.out.println();
                if (cantidadRequerida > jugador.getCantPlatino()) {
                    System.out.println("~~No tienes suficiente Platino para intercambiar");
                } else {
                    float EficAntes = jugador.getEficiencia();
                    jugador.aumentarEficienciaExotraje(cantidadRequerida);
                    float EficDespues = jugador.getEficiencia();
                    float EficTotal = EficDespues - EficAntes;
                    jugador.aumentarPlatino((-1) * cantidadRequerida);
                    System.out.println("-----------------------------------");
                    System.out.println("---Tu eficiencia del exotraje a aumentado un: " + EficTotal + "%");
                    System.out.println("---Ahora tu eficiencia del exotraje total es del " + jugador.getEficiencia() + "%");
                    System.out.println("-----------------------------------");
                }
            } else if (eleccionIntercambio == 5) {
                flag = false;
            }
        }
    }

    //////////////////
    // visitar
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: El jugador que visita el planeta Helado.
    //////////////////
    // DESCRIPCION: Este metodo permite al jugador interactuar con el planeta Helado,
    //              proporcionando opciones para extraer materiales o visitar los asentamientos del planeta.
    //              También muestra información sobre el planeta y gestiona el estado de energía del jugador.
    //              Return tipo boolean.
    //////////////////
    @Override
    public boolean visitar(Jugador jugador){
        if(jugador.getEnergia() <= 0){
            jugador.emergencia();

            return false;
        }

        System.out.println();
        System.out.println("-----Información del planeta Oceanico-----");
        System.out.println("---Radio: " + getRadio());
        System.out.println("---Profunidad: " + getProfundidad());
        System.out.println("---Cantidad de Hidrógeno: " + getCristales());
        System.out.println("---Cantidad de Sodio: " + getFloresSodio());
        System.out.println("---Energía consumida: " + getConsumoEnergia());
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Qué es lo que quieres hacer?");
        System.out.println("1. Extraer materiales");
        System.out.println("2. Intercambiar con los habitantes del planeta.");
        System.out.println("3. Salir");
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        if (eleccion == 1) {
            boolean flag_intercambio = true;
            while(flag_intercambio){
                System.out.println();
                System.out.println("~~~~~~~~Buscando minerales...~~~~~~~~~~");
                System.out.println("---------------------------------------");
                System.out.println("---Que minerales quieres extraer?");
                System.out.println("---1. Flores de Sodio: " + getFloresSodio());
                System.out.println("---2. Cristales de Hidrógeno:" + getCristales());
                System.out.println("---3. Uranio: (No existe en este planeta)");
                System.out.println("---4. Platino: (No existe en este planeta)");
                System.out.println("---------------------------------------");
                System.out.println("---5. No quiero extraer materiales.");
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
                    System.out.println("---WARNING: Dependiendo de la cantidad de material que extraigas");
                    System.out.println("---la energía de tu ExoTraje irá disminuyendo.");
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
                } else {
                    System.out.println("---No existe este mineral en este planeta---");
                }
            }
        } else if (eleccion == 2) {
            System.out.println();
            System.out.println("---Los habitantes del planeta Oceanico te están saludando!!!");
            visitarAsentamientos(jugador);
        } else if (eleccion == 3) {
            return salir();
        }
        return true;
    }

    //////////////////
    // darNombre
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada
    //////////////////
    // DESCRIPCION: Este metodo asigna un nombre específico al planeta.
    //              En este caso, se establece como "Oceanico".
    //              Return tipo String
    //////////////////
    public String darNombre(){
        return "Oceanico";
    }
}
