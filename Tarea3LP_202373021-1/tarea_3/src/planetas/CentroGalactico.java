package planetas;

import jugador.Jugador;
import java.util.Scanner;

public class CentroGalactico extends Planeta{

    //////////////////
    // CentroGalactico
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Constructor de la clase CentroGalactico que llama al constructor de la clase superior.
    //////////////////
    public CentroGalactico(){
        super(); //Llama al constructor de la clase base (Planeta)
    }

    //////////////////
    // darNombre
    //////////////////
    // PARAMETROS:
    // - No recibe parámetros de entrada.
    //////////////////
    // DESCRIPCION: Devuelve el nombre del lugar, en este caso, "Centro Galáctico".
    //////////////////
    public String darNombre(){
        return "Centro Galactico";
    }

    //////////////////
    // visitar
    //////////////////
    // PARAMETROS:
    // - Jugador jugador: Se entrega al jugador que intentará visitar el Centro Galáctico.
    //////////////////
    // DESCRIPCION: Esta función permite al jugador intentar entrar al Centro Galáctico. Si no tiene la eficiencia mínima
    //              de propulsores requerida (>=50), no podrá entrar y se mostrará un mensaje indicando que no cumple los
    //              requisitos. Si cumple los requisitos, puede optar por entrar o salir.
    //////////////////
    @Override
    public boolean visitar(Jugador jugador){
        if(jugador.getNave().getEficienciaPropulsor() < 50){
            System.out.println("AUN NO CUMPLES CON LOS REQUISITOS MINIMOS PARA ENTRAR");
            System.out.println("Necesitas al menos 50% para entrar.");
            System.out.printf("Tienes %f/100 de eficiencia de propulsores"+ "\n", jugador.getNave().getEficienciaPropulsor());
            System.out.println("-----------------------------------------------------");
            System.out.println("----1. Entrar al Centro Galáctico  (BLOQUEADO)");
            System.out.println("----2. Salir.");
            Scanner scanner = new Scanner(System.in);
            int eleccionCG = scanner.nextInt();
            if(eleccionCG == 1){
                System.out.println("---Aun no puedes entrar. Vuelve cuando cumplas la condición!!");
            } else if (eleccionCG == 2){
                return salir();
            }
        } else{
            System.out.printf("Puedes entrar al Centro Galáctico con %f/100 de eficiencia de propulsores." +"\n", jugador.getNave().getEficienciaPropulsor());
            System.out.println("-----------------------------------------------------");
            System.out.println("----1. Entrar al Centro Galáctico");
            System.out.println("----2. Salir.");
            Scanner scanner = new Scanner(System.in);
            int eleccionCG = scanner.nextInt();
            if(eleccionCG == 1){
                System.out.println("MUCHAS FELICIDADES HAS PODIDO ENTRAR AL CENTRO GALACTICO!!");
                System.out.println("~~~~~¡¡GANASTE!!~~~~~");
                setEntrarCG(false);
                return false;
            } else if (eleccionCG == 2){
                return salir();
            }
        }
        return true;
    }
}
