#ifndef H_TABLERO
#define H_TABLERO

typedef struct {
    int haybarco;
    char simbolo;
}Casilla;


extern void *** tablero;
extern int tam;
extern int filas, columnas;
extern int cant_casillas;

/*****
* void inicializarTablero
******
* Esta funcion se encarga de inicializar el tablero (de tamaño nxn, dependiendo de la dificultad) entregando memoria a cada una de las casillas del mismo.
* Cada casilla del tablero se estableció como un struct casilla para poder manejarlo de mejor manera donde las casillas
* se denomina casilla como un ' ' y la separación de casillas como un '|', además se establecio que el estado de una casilla se guarda en el struct casilla "->haybarco", 
* Si hay un barco es 1, en caso contrario 0.
******
* Input:
* int tamano: Se entrega el tamaño del tablero.
******
* Returns:
* void, solamente se asigna memoria mediante malloc al tablero.
*****/
void inicializarTablero(int tamano);

/*****
* void mostrarTablero.
******
* Esta función tiene el propósito de imprimir por pantalla el tablero y todo lo que se haga en él.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente imprime en pantalla el tablero.
*****/
void mostrarTablero();

/*****
* void mostrarTableroFinal
******
* Esta función tiene el propósito de imprimir por pantalla el tablero final una vez terminan todos los turnos.
* Esta función asigna una "O" en la casilla que no había barco, una "F" en donde había un barco y no se destrozó.
* Y una "X" si en los turnos anteriores si se destrozó un barco.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente imprime en pantalla el tablero.
*****/
void mostrarTableroFinal();

/*****
* void liberarTablero
******
* Esta función se encarga de liberar la memoria asignada al tablero, casilla por casilla.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente borra la memoria asignada al tablero.
*****/
void liberarTablero();

#endif
