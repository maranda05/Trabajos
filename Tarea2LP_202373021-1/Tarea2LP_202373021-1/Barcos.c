#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "Barcos.h"
#include "Tablero.h"



void insertarBarcos(int cant_barcos[], int tamano) {
    int tamanos[] = {2,3,4,5};
    int filas = tamano;
    int columnas = 2*tamano + 1;
    int fila_a_ubicar;
    int columna_a_ubicar;
    int orientacion; // vemos su orientacion: 0 es vertical y 1 horizontal.
    for(int i = 0; i < 4;i++){
        int barcos_a_posicionar = cant_barcos[i]; //me dice que que numero de barco voy a poner
        int tam_barco = tamanos[i]; //me dice la el largo del barco

        for(int ubicar = 0; ubicar < barcos_a_posicionar; ubicar++){
            int disponible = 0; //verifica si es posible colocar ahi el barco, 0 para no, 1 para si.

            while(!disponible){
                fila_a_ubicar = rand() % filas;
                columna_a_ubicar = (rand() % (columnas/2));
                orientacion = rand()%2;

                if(orientacion == 0 && fila_a_ubicar + tam_barco <=filas){ //vertical
                    disponible = 1;
                    for(int i = 0; i < tam_barco;i++){
                        if(((Casilla*)tablero[fila_a_ubicar+i][columna_a_ubicar])->simbolo != ' ' || ((Casilla*)tablero[fila_a_ubicar+i][columna_a_ubicar])->haybarco == 1){
                            disponible = 0;
                            break;

                        }
                    }
                    if(disponible) {
                        for(int i = 0; i < tam_barco; i++) {
                            ((Casilla*)tablero[fila_a_ubicar + i][columna_a_ubicar])->simbolo = ' ';
                            ((Casilla*)tablero[fila_a_ubicar + i][columna_a_ubicar])->haybarco = 1;
                        }
                    }
                } else if(orientacion == 1 && columna_a_ubicar + (tam_barco*2) <=columnas){
                    disponible = 1; //horizontal
                    for(int i = 0; i < tam_barco;i++){
                        if(((Casilla*)tablero[fila_a_ubicar][columna_a_ubicar+i*2])->simbolo == '|' || ((Casilla*)tablero[fila_a_ubicar][columna_a_ubicar+i*2])->haybarco == 1){
                            disponible = 0;
                            break;
                        }

                    }
                    if(disponible) {
                        for(int i = 0; i < tam_barco; i++) {
                            ((Casilla*)tablero[fila_a_ubicar][columna_a_ubicar+i*2])->simbolo = ' ';
                            ((Casilla*)tablero[fila_a_ubicar][columna_a_ubicar+i*2])->haybarco = 1;
                        }
                    }
                }
                if(disponible){
                    break;
                }
            }
        }
    }
}