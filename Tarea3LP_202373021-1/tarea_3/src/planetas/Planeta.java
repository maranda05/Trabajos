package planetas;

import jugador.Jugador;
import java.util.Random;

public abstract class Planeta {
    protected int radio;
    protected int CantFloresSodio;
    protected int CantCristalesHidrogeno;
    protected int CantPlatino;
    protected int CantUranio;
    protected int ConsumoEnergia;
    private boolean EntrarCG;

    //////////////////
    // Planeta (constructor)
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Constructor de la clase Planeta que inicializa sus atributos
    //              realizando los cálculos iniciales de recursos y energía.
    //              No tiene return, es un constructor.
    //////////////////
    public Planeta() {
        calculoRadio();
        calculoCristalesHidrogeno();
        calculoFloresSodio();
        calculoConsumoEnergia();
        this.EntrarCG = true;
    }

    //////////////////
    // setEntrarCG
    //////////////////
    // PARAMETROS:
    // - boolean flag: Indica si se pudo o no entrar al Centro Galáctico.
    //////////////////
    // DESCRIPCION: Establece si el jugador pudo acceder al Centro Galáctico (CG).
    //              No tiene return, es void.
    //////////////////
    public void setEntrarCG(boolean flag){
        this.EntrarCG = flag;
    }

    //////////////////
    // getEntrarCG
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna el valor booleano que indica si se pudo entrar al Centro Galáctico o aún no se entra.
    //////////////////
    public boolean getEntrarCG(){
        return EntrarCG;
    }

    //////////////////
    // darNombre
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Metodo abstracto que debe ser implementado por las subclases para retornar el nombre del planeta.
    //              Retorna un String.
    //////////////////
    public abstract String darNombre();

    //////////////////
    // calculoRadio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula y asigna un valor aleatorio al radio.
    //              Esta función será reescrita por cada sub clase de planeta.
    //              No tiene return, es void.
    //////////////////
    protected void calculoRadio() {
        Random rand = new Random();
        this.radio = rand.nextInt(1000000 - 1000 + 1) - 1000;
    }

    //////////////////
    // calculoFloresSodio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula y asigna la cantidad de Flores de Sodio al planeta (por defecto 0).
    //              Esta función será reescrita por cada sub clase de planeta.
    //              No tiene return, es void.
    //////////////////
    protected void calculoFloresSodio() {
        this.CantFloresSodio = 0;
    }

    //////////////////
    // getFloresSodio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad de Flores de Sodio en el planeta.
    //              Retorna un int.
    //////////////////
    public int getFloresSodio(){
        return CantFloresSodio;
    }

    //////////////////
    // calculoCristalesHidrogeno
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula y asigna la cantidad de Cristales de Hidrógeno (por defecto 0).
    //              Esta función será reescrita por cada sub clase de planeta.
    //              No tiene return, es void.
    //////////////////
    protected void calculoCristalesHidrogeno() {
        this.CantFloresSodio = 0;
    }

    //////////////////
    // getCristales
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad de Cristales de Hidrógeno en el planeta.
    //              Retorna un int.
    //////////////////
    public int getCristales(){
        return CantCristalesHidrogeno;
    }

    //////////////////
    // calculoConsumoEnergia
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Calcula el consumo de energía del planeta (por defecto 0).
    //              Esta función será reescrita por cada sub clase de planeta.
    //              No tiene return, es void.
    //////////////////
    protected void calculoConsumoEnergia(){
        this.ConsumoEnergia = 0;
    }

    //////////////////
    // getConsumoEnergia
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna el consumo de energía del planeta.
    //              Retorna un float.
    //////////////////
    public float getConsumoEnergia(){
        return ConsumoEnergia;
    }

    //////////////////
    // setFloresSodio
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de Flores de Sodio a establecer en el planeta.
    //////////////////
    // DESCRIPCION: Establece la cantidad de Flores de Sodio en el planeta.
    //              No tiene return, es void.
    //////////////////
    public void setFloresSodio(int cant){
        this.CantFloresSodio = cant;
    }

    //////////////////
    // setCristales
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de Cristales de Hidrógeno a establecer.
    //////////////////
    // DESCRIPCION: Establece la cantidad de Cristales de Hidrógeno en el planeta.
    //              No tiene return, es void.
    //////////////////
    public void setCristales(int cant){
        this.CantCristalesHidrogeno = cant;
    }

    //////////////////
    // setUranio
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de Uranio a establecer.
    //////////////////
    // DESCRIPCION: Establece la cantidad de Uranio en el planeta.
    //              No tiene return, es void.
    //////////////////
    public void setUranio(int cant){
        this.CantUranio = cant;
    }


    //////////////////
    // getUranio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad de Uranio en el planeta.
    //              Retorna un int.
    //////////////////
    public int getUranio(){
        return CantUranio;
    }

    //////////////////
    // setPlatino
    //////////////////
    // PARAMETROS:
    // - int cant: La cantidad de Platino a establecer.
    //////////////////
    // DESCRIPCION: Establece la cantidad de Platino en el planeta.
    //              No tiene return, es void.
    //////////////////
    public void setPlatino(int cant){
        this.CantPlatino = cant;
    }

    //////////////////
    // getPlatino
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna la cantidad de Platino en el planeta.
    //              Retorna un int.
    //////////////////
    public int getPlatino(){
        return CantPlatino;
    }

    //////////////////
    // getRadio
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Retorna el radio del planeta.
    //              Retorna un int.
    //////////////////
    public int getRadio() {
        return radio;
    }


    //////////////////
    // visitar
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: El jugador que visita el planeta.
    //////////////////
    // DESCRIPCION: Proceso de interacción cuando un jugador visita el planeta.
    //              Esta función será reescrita en cada sub clase de planeta.
    //              Retorna un boolean.
    //////////////////
    public abstract boolean visitar(Jugador jugador);

    //////////////////
    // salir
    //////////////////
    // PARAMETROS:
    // - No posee parámetros de entrada.
    //////////////////
    // DESCRIPCION: Imprime un mensaje indicando que el jugador vuelve a la órbita y termina el proceso de visita
    //              retornando un false.
    //              Retorna un boolean.
    //////////////////
    public boolean salir(){
        System.out.println("---------------------");
        System.out.println("Volviendo a la orbita");
        System.out.println("---------------------");
        return false;
    }

    //////////////////
    // extraerRecursos
    //////////////////
    // PARAMETROS:
    // - int tipo: Tipo de recurso a extraer (1 para Flores de Sodio, 2 para Cristales de Hidrógeno, 3 para Uranio, 4 para Platino).
    //////////////////
    // DESCRIPCION: Extrae recursos del planeta según el tipo especificado (Flores de Sodio, Cristales de Hidrógeno, Uranio o Platino).
    //              Retorna un int que corresponde a la cantidad total de cierto recurso en el planeta.
    //////////////////
    public int extraerRecursos(int tipo){
        if(tipo == 1){ //Flores de sodio.
            return getFloresSodio();
        } else if (tipo == 2){ //Cristales de hidrogeno
            return getCristales();
        } else if(tipo == 3){ //Uranio
            return getUranio();
        } else if (tipo == 4) { //Platino
            return getPlatino();
        }
        return tipo;
    }
}