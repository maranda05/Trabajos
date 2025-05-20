#include <stdlib.h>
#include <stdio.h>
#include "Tablero.h"
#include "Barcos.h"

void ***tablero = NULL;
int tam;
int filas;
int columnas;
Casilla casilla;

void inicializarTablero(int tamano){
    filas = tamano;
    columnas = 2*tamano + 1;
    tam = tamano;
    tablero = (void***)malloc(sizeof(void**)*filas);

    if(tablero == NULL){
        perror("Error");
        exit(EXIT_FAILURE);
    }

    for(int columna = 0; columna < filas; columna++){
        tablero[columna] = (void**)malloc(columnas*sizeof(void*));

        if(tablero[columna] == NULL){
            perror("Error 2");
            exit(EXIT_FAILURE);
        }

        for(int fila = 0; fila < columnas; fila++){

            tablero[columna][fila] = (Casilla*)malloc(sizeof(Casilla));

            if(tablero[columna][fila] == NULL){
            perror("Error 3");
            exit(EXIT_FAILURE);
            }
            if(fila % 2 == 0){
                ((Casilla*)tablero[columna][fila])->simbolo = '|';
                ((Casilla*)tablero[columna][fila])->haybarco = 1; 
                  
            } else{
                ((Casilla*)tablero[columna][fila])->simbolo = ' ';
                ((Casilla*)tablero[columna][fila])->haybarco = 0;
            }
        }
    }
}

void mostrarTablero(){
    if(tablero == NULL){
        printf("TABLERO NO INICIALIZADO\n");
        exit(EXIT_FAILURE);
    }

    for(int i = 0; i < filas; i++){
        for(int j = 0; j < columnas; j++){
            printf("%c", ((Casilla*)tablero[i][j])->simbolo);
        }
        printf("\n");
    }
}

void mostrarTableroFinal(){
    if(tablero == NULL){
        printf("TABLERO NO INICIALIZADO\n");
        exit(EXIT_FAILURE);
    }

    for(int i = 0; i < filas; i++){
        for(int j = 0; j < columnas; j++){
            if((((Casilla*)tablero[i][j])->simbolo == ' ' || ((Casilla*)tablero[i][j])->simbolo == '~') && ((Casilla*)tablero[i][j])->haybarco == 1){
                ((Casilla*)tablero[i][j])->simbolo ='F';
                printf("%c", ((Casilla*)tablero[i][j])->simbolo);
            } else if(((Casilla*)tablero[i][j])->simbolo == 'X' && ((Casilla*)tablero[i][j])->haybarco == 1){
                printf("%c", ((Casilla*)tablero[i][j])->simbolo);
            } else if(((Casilla*)tablero[i][j])->simbolo == ' ' && ((Casilla*)tablero[i][j])->haybarco == 0){
                ((Casilla*)tablero[i][j])->simbolo ='O';
                printf("%c", ((Casilla*)tablero[i][j])->simbolo);
            } else{
                printf("%c", ((Casilla*)tablero[i][j])->simbolo);
            }
        }
        printf("\n");
    }
}

void liberarTablero() {
    if (tablero != NULL) {
        for (int i = 0; i < filas; i++) { 
            if (tablero[i] != NULL) {
                for (int j = 0; j < columnas; j++) {
                    free(tablero[i][j]);
                }
                free(tablero[i]);
            }
        }
        free(tablero);
    }
    tablero = NULL;
    tam = 0;
}