package jugador;

import eleccionPlaneta.MapaGalactico;

public class Jugador {
    private final Nave nave;
    private float energiaExotraje;
    private float eficienciaExotraje;
    private int cantHidrogeno;
    private int cantSodio;
    private int cantUranio;
    private int cantPlatino;
    private final MapaGalactico mapa;
    private boolean rendirse;

    /* Metodos */

    //////////////////
    // Jugador (constructor)
    //////////////////
    // PARAMETROS:
    // - float energiaExotraje: La energía inicial del exotraje del jugador.
    // - float eficienciaExotraje: La eficiencia del exotraje del jugador.
    // - int cantHidrogeno: La cantidad inicial de hidrógeno del jugador.
    // - int cantSodio: La cantidad inicial de sodio del jugador.
    // - int cantUranio: La cantidad inicial de uranio del jugador.
    // - int cantPlatino: La cantidad inicial de platino del jugador.
    // - Nave nave: La nave asociada al jugador.
    // - MapaGalactico mapa: El mapa galáctico que en el que estará el jugador durante la partida.
    //////////////////
    // DESCRIPCION: Constructor de la clase Jugador que inicializa sus atributos como la energía,
    //              eficiencia del exotraje, cantidades de recursos, y la nave.
    //              No tiene return, es un constructor.
    //////////////////
    public Jugador(float energiaExotraje, float eficienciaExotraje, int cantHidrogeno, int cantSodio, int cantUranio, int cantPlatino, Nave nave, MapaGalactico mapa) {
        this.energiaExotraje = energiaExotraje;
        this.eficienciaExotraje = eficienciaExotraje;
        this.cantSodio = cantSodio;
        this.cantHidrogeno = cantHidrogeno;
        this.cantUranio = cantUranio;
        this.cantPlatino = cantPlatino;
        this.nave = nave;
        this.mapa = mapa;
        this.rendirse = false;
    }

    //////////////////
    // setEnergia
    //////////////////
    // PARAMETROS:
    // - float energiaExotraje: La nueva cantidad de energía para el exotraje del jugador.
    //////////////////
    // DESCRIPCION: Establece el valor de energía del exotraje del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void setEnergia(float energiaExotraje) {
        this.energiaExotraje = energiaExotraje;
    }

    //////////////////
    // getEnergia
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad actual de energía del exotraje del jugador.
    //              Retorna un float.
    //////////////////
    public float getEnergia() {
        return energiaExotraje;
    }

    //////////////////
    // setEficiencia
    //////////////////
    // PARAMETROS:
    // - float eficienciaExotraje: La nueva eficiencia del exotraje del jugador.
    //////////////////
    // DESCRIPCION: Establece el valor de eficiencia del exotraje del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void setEficiencia(float eficienciaExotraje) {
        this.eficienciaExotraje = eficienciaExotraje;
    }

    //////////////////
    // getEficiencia
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la eficiencia actual del exotraje del jugador.
    //              Retorna un float.
    //////////////////
    public float getEficiencia() {
        return eficienciaExotraje;
    }

    //////////////////
    // getCantHidrogeno
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad actual de hidrógeno del jugador.}
    //              Retorna un float.
    //////////////////
    public float getCantHidrogeno() {
        return cantHidrogeno;
    }

    //////////////////
    // setCantHidrogeno
    //////////////////
    // PARAMETROS:
    // - int cantHidrogeno: La nueva cantidad de hidrógeno.
    //////////////////
    // DESCRIPCION: Establece la cantidad de hidrógeno del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void setCantHidrogeno(int cantHidrogeno) {
        this.cantHidrogeno = cantHidrogeno;
    }

    //////////////////
    // getCantSodio
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad actual de sodio del jugador.
    //              Retorna un float.
    //////////////////
    public float getCantSodio() {
        return cantSodio;
    }

    //////////////////
    // setCantSodio
    //////////////////
    // PARAMETROS:
    // - int cantSodio: La nueva cantidad de sodio.
    //////////////////
    // DESCRIPCION: Establece la cantidad de sodio del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void setCantSodio(int cantSodio) {
        this.cantSodio = cantSodio;
    }

    //////////////////
    // getCantUranio
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad actual de uranio del jugador.
    //              Retorna un float.
    //////////////////
    public float getCantUranio() {
        return cantUranio;
    }

    //////////////////
    // setCantUranio
    //////////////////
    // PARAMETROS:
    // - int cantUranio: La nueva cantidad de uranio.
    //////////////////
    // DESCRIPCION: Establece la cantidad de uranio del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void setCantUranio(int cantUranio){
        this.cantUranio = cantUranio;
    }

    //////////////////
    // getCantPlatino
    //////////////////
    // PARAMETROS:
    // -
    // -
    //////////////////
    // DESCRIPCION: Retorna la cantidad actual de platino del jugador.
    //              Retorna un float.
    //////////////////
    public float getCantPlatino(){
        return cantPlatino;
    }

    //////////////////
    // setCantPlatino
    //////////////////
    // PARAMETROS:
    // - int cantPlatino: La nueva cantidad de platino.
    //////////////////
    // DESCRIPCION: Establece la cantidad de platino del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void setCantPlatino(int cantPlatino){
        this.cantPlatino = cantPlatino;
    }

    //////////////////
    // aumentarSodio
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de sodio a aumentar.
    //////////////////
    // DESCRIPCION: Aumenta (o disminuye en caso de que se entregue un numero negativo) la cantidad de sodio del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void aumentarSodio(int cant){
        this.cantSodio += cant;
    }

    //////////////////
    // aumentarHidrogeno
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de hidrógeno a aumentar.
    //////////////////
    // DESCRIPCION: Aumenta (o disminuye en caso de que se entregue un numero negativo) la cantidad de hidrógeno del jugador.
    //              No tiene return, es un void.
    //////////////////
    public void aumentarHidrogeno(int cant){
        this.cantHidrogeno += cant;
    }

    //////////////////
    // aumentarUranio
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de uranio a aumentar.
    //////////////////
    // DESCRIPCION: Aumenta (o disminuye en caso de que se entregue un numero negativo) la cantidad de uranio del jugador.
    //              No tiene return es un void.
    //////////////////
    public void aumentarUranio(int cant){
        this.cantUranio += cant;
    }

    //////////////////
    // aumentarPlatino
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de platino a aumentar.
    //////////////////
    // DESCRIPCION: Aumenta la cantidad de platino del jugador.
    //              No tiene return es un void.
    //////////////////
    public void aumentarPlatino(int cant){
        this.cantPlatino += cant;
    }

    //////////////////
    // recargarEnergiaProteccion
    //////////////////
    // PARAMETROS:
    // - int sodio: La cantidad de sodio utilizada para recargar energía.
    //////////////////
    // DESCRIPCION: Recarga la energía del exotraje utilizando una cantidad de sodio, respetando el límite de 100 unidades.
    //              No tiene return, es un void.
    //////////////////
    public void recargarEnergiaProteccion(int sodio){
        double unidadesRecargadas = 0.65*sodio*(1+getEficiencia());
        if((unidadesRecargadas + getEnergia()) > 100)
            energiaExotraje = 100;
        else{
            energiaExotraje += (float)unidadesRecargadas;
        }
    }

    //////////////////
    // disminuirEnergiaProteccion
    //////////////////
    // PARAMETROS:
    // - float unidadesRecurso: Cantidad de recurso consumido.
    // - float consumoEnergia: Consumo energético proporcional al uso de recursos.
    //////////////////
    // DESCRIPCION: Disminuye la energía del exotraje según los recursos utilizados y la eficiencia del exotraje mediante la formula entregada.
    //              No tiene return, es un void.
    //////////////////
    public void disminuirEnergiaProteccion(float unidadesRecurso, float consumoEnergia){
        double energia = 0.5*unidadesRecurso*(consumoEnergia/100)*(1-eficienciaExotraje*0.01);
        energiaExotraje -= (float)energia;
    }

    //////////////////
    // disminuirEnergiaViajar
    //////////////////
    // PARAMETROS:
    // - int cantidad: Cantidad de energía disminuida al viajar.
    //////////////////
    // DESCRIPCION: Disminuye la energía del exotraje cuando el jugador viaja.
    //              No tiene return, es un void.
    //////////////////
    public void disminuirEnergiaViajar(int cantidad){
        energiaExotraje -= cantidad;
    }

    //////////////////
    // aumentarEficienciaExotraje
    //////////////////
    // PARAMETROS:
    // - int platino: Cantidad de platino utilizada para mejorar la eficiencia.
    //////////////////
    // DESCRIPCION: Aumenta la eficiencia del exotraje utilizando platino, respetando el límite de 100.
    //              No tiene return, es un void.
    //////////////////
    public void aumentarEficienciaExotraje(int platino){
        double unidadesAumentadas = 0.7*platino;
        if((unidadesAumentadas + getEficiencia()) > 100)
            eficienciaExotraje = 100;
        else{
            eficienciaExotraje += (float)unidadesAumentadas;
        }
    }

    //////////////////
    // getNave
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la nave del jugador.
    //              Retorna el objeto Nave.
    //////////////////
    public Nave getNave(){
        return nave;
    }


    //////////////////
    // setRendirse
    //////////////////
    // PARAMETROS:
    // - boolean rendirse: Indica si el jugador se rinde o no.
    // DESCRIPCION: Este metodo establece el estado de rendición del jugador
    //              asignando el valor proporcionado al atributo rendirse.
    //              No tiene return, es un void.
    //////////////////
    public void setRendirse(boolean rendirse){
        this.rendirse = rendirse;
    }

    //////////////////
    // getRendirse
    //////////////////
    // PARAMETROS:
    // - Ninguno
    // DESCRIPCION: Este metodo devuelve el estado de rendición del jugador.
    //              Retorna un booleano que indica si el jugador se ha rendido (true) o no (false).
    //////////////////
    public boolean getRendirse(){
        return rendirse;
    }

    //////////////////
    // emergencia
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Activa el modo de emergencia del jugador cuando la energía del exotraje o el combustible de la nave llega a cero. Restablece los valores y regresa al planeta 0.
    //              imprimiendo en pantalla la razón de por qué perdió.
    //              No tiene return, es un void.
    //////////////////
    public void emergencia(){
        if(getEnergia() <= 0){
            System.out.println("---------------------------------------");
            System.out.println("~~~Cuidado! No te queda energía en tu exotraje. RETIRADA DE EMERGENCIA");
            System.out.println("---------------------------------------");
            setCantHidrogeno(0);
            setCantSodio(0);
            setCantPlatino(0);
            setCantUranio(0);
            setEnergia(100);
            setEficiencia(0);
            nave.setCombustible(100);
            mapa.setPosicion(0);
            nave.setEficienciaPropulsor(0);

        } else if (nave.getCombustible() <= (float)0) {
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println("~~~Cuidado! Te quedaste sin combustible. RETIRADA DE EMERGENCIA");
            System.out.println("---------------------------------------");
            setCantHidrogeno(0);
            setCantSodio(0);
            setCantPlatino(0);
            setCantUranio(0);
            setEnergia(100);
            setEficiencia(0);
            nave.setCombustible(100);
            mapa.setPosicion(0);
            nave.setEficienciaPropulsor(0);

        } else if(getRendirse()){
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println("~~~Afirmate!! Volverás al planeta 0");
            System.out.println("---------------------------------------");
            setCantHidrogeno(0);
            setCantSodio(0);
            setCantPlatino(0);
            setCantUranio(0);
            setEnergia(100);
            setEficiencia(0);
            nave.setCombustible(100);
            mapa.setPosicion(0);
            nave.setEficienciaPropulsor(0);
            setRendirse(false);
        }

    }
}
