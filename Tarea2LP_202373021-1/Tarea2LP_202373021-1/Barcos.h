#ifndef H_BARCOS
#define H_BARCOS

/*****
* void insertarBarcos.
******
* Esta funcion se encarga de insertar los distintos barcos en el tablero además de ubicarlos horizontal o verticalmente
* en el mismo, tal proceso de orientación se realizo un rand()%2.  
******
* Input:
* int cant_barcos[]: Recibe un arreglo de tal forma que esta conformado por {cantidad_barcos2x1, cantidad_barcos2x1, cantidad_barcos2x1, cantidad_barcos2x1, cantidad_barcos2x1} donde
  cantidad_barcos es la cantidad de barcos de cada tipo que existen, ya sea 2x1, 3x1, 4x1, 5x1. 
* int tamano: la función se le entrega el tamaño del tablero para definir las filas y las columnas
*
******
* Returns:
* void, solamente agrega los barcos en el tablero.
*****/
void insertarBarcos(int cant_barcos[], int tamano);

#endif