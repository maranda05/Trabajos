#ifndef H_CARTAS
#define H_CARTAS


typedef struct Mano
{
    void ** carta;
    int disponibles;
} Mano;

extern int x, y;
extern int eleccion;
extern Mano Cartas;

/*****
* void inicializarMazo
******
* Esta función tiene el propósito de asignar memoria al arreglo establecido en el struct Mano "carta"
* para luego asignar a cada espacio del arreglo el disparo Simple como se pide en la tarea. 
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente asigna memoria al arreglo mazo.
*****/
void inicializarMazo();

/*****
* void inicializarTablero
******
* Esta función tiene el propósito de mostrar en pantalla el mazo disponible, si la cantidad de cartas
* disponibles (Cartas.disponibles) son 5, entonces mostrará cantidad, en caso de que sean 4, entonces se reducirán a 4.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente imprime en pantalla el mazo.
*****/
void mostrarMazo();

/*****
* void usarCarta
******
* Esta función tiene el propósito de que dependiendo de que carta se llame (del 1 al 5 o del 1 al 4) busque en el arreglo de
* cartas la carta escogida, en conjunto se llama a la función de la carta en específico.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente busca la carta y llama a su función.
*****/
void usarCarta();

/*****
* void liberarMazo
******
* Esta función tiene el propósito de liberar la memoria del mazo que previamente se había pedido.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente libera memoria del arreglo de cartas.
*****/
void liberarMazo(); 

/*****
* void reacomodarCartas
******
* Esta función tiene el propósito de acomodar las cartas cuando se usa el disparo 500kg, desplazando
* las cartas un espacio atrás.
******
* Input:
* No recibe parámetros.
******
* Returns:
* void, solamente acomoda las cartas como se menciono anteriormente.
*****/
void reacomodarCartas();

/*****
* void * disparoSimple
******
* Esta función tiene el propósito de insertar el disparo simple en el tablero en un espacio 1x1, para ello consulta si en la casilla
* está ocupada (con un ' ' y ->haybarco es 1), si está ocupada con un barco marca la casilla con una "X", si no con un "O",
* se imprime por pantalla "HIT!" si se atinó a un barco, en caso contrario imprime "MISS!". 
******
* Input:
* int x: Se entrega la posición en el eje X del tablero donde se quiere insertar el disparo.
* int y: Se entrega la posición en el eje Y del tablero donde se quiere insertar el disparo.
******
* Returns:
* void *, retorna un puntero a una función de algun disparo que dicte las probabilidades de aparición.
*****/
void * disparoSimple(int x, int y);

/*****
* void * disparoGrande
******
* Esta función tiene el propósito de insertar el disparo simple en el tablero en un espacio 3x3, para ello consulta si en 
* cada casilla en esa área está ocupada o no (con un ' ' y ->haybarco es 1), si está ocupada con un barco marca la casilla con
* una "X", si no con un "O", se imprime por pantalla "HIT!" si se atinó a un barco, en caso contrario imprime "MISS!". 
******
* Input:
* int x: Se entrega la posición en el eje X del tablero donde se quiere insertar el disparo.
* int y: Se entrega la posición en el eje Y del tablero donde se quiere insertar el disparo.
******
* Returns:
* void *, retorna un puntero a una función de algun disparo que dicte las probabilidades de aparición.
*****/
void * disparoGrande(int x, int y);

/*****
* void * disparoLineal
******
* Esta función tiene el propósito de insertar el disparo simple en el tablero en un espacio 1x5 o 5x1, para ello consulta si en 
* cada casilla en esa linea está ocupada o no (con un ' ' y ->haybarco es 1), si está ocupada con un barco marca la casilla con
* una "X", si no con un "O", se imprime por pantalla "HIT!" si se atinó a un barco, en caso contrario imprime "MISS!". Consideré
* que el usuario escoja la orientación del disparo ya sea horizontal(1) o vertical(0).
******
* Input:
* int x: Se entrega la posición en el eje X del tablero donde se quiere insertar el disparo.
* int y: Se entrega la posición en el eje Y del tablero donde se quiere insertar el disparo.
******
* Returns:
* void *, retorna un puntero a una función de algun disparo que dicte las probabilidades de aparición.
*****/
void * disparoLineal(int x, int y);

/*****
* void * disparoRadar
******
* Esta función tiene el propósito de insertar el disparo simple en el tablero en un espacio 5x5, para ello consulta si en 
* cada casilla en esa área está ocupada o no (con un ' ' y ->haybarco es 1), si está ocupada con un barco marca la casilla con
* una "~", si no con un "O".
******
* Input:
* int x: Se entrega la posición en el eje X del tablero donde se quiere insertar el disparo.
* int y: Se entrega la posición en el eje Y del tablero donde se quiere insertar el disparo.
******
* Returns:
* void *, retorna un puntero a una función de algun disparo que dicte las probabilidades de aparición.
*****/
void * disparoRadar(int x, int y);

/*****
* void * disparo500KG
******
* Esta función tiene el propósito de insertar el disparo simple en el tablero en un espacio 11x11, para ello consulta si en 
* cada casilla en esa área está ocupada o no (con un ' ' y ->haybarco es 1), si está ocupada con un barco marca la casilla con
* una "X", si no con un "O", se imprime por pantalla "HIT!" si se atinó a un barco, en caso contrario imprime "MISS!". Este disparo
* solamente puede utilizarse una vez.
******
* Input:
* int x: Se entrega la posición en el eje X del tablero donde se quiere insertar el disparo.
* int y: Se entrega la posición en el eje Y del tablero donde se quiere insertar el disparo.
******
* Returns:
* void *, retorna un puntero a una función de algun disparo que dicte las probabilidades de aparición.
*****/
void * disparo500KG(int x, int y);

#endif