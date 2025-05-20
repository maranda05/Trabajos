#include <stdlib.h>
#include <stdio.h>
#include "Tablero.h"
#include "Cartas.h"
#include "Barcos.h"
#include <time.h>

int eleccion;
int x, y;
int cant_casillas;

int main(int argc, char const *argv[]) {
    srand(time(NULL)); 
    int dificultad;
    int tam_tablero;
    
    int cant_barcos_1x5;
    int cant_barcos_1x2;
    int cant_barcos_1x3;
    int cant_barcos_1x4;
    int turno_actual = 0;
    int turno_max;
    
    printf("Selecciona la Dificultad:\n");
    printf("1. Facil -> 11 X 11, 5 Barcos\n");
    printf("2. Medio -> 17 X 17, 7 Barcos\n");
    printf("3. Dificil -> 21 X 21, 9 Barcos\n");
    printf("Ingrese un numero: ");
    scanf("%d", &dificultad);
    switch(dificultad){
        case 1: tam_tablero = 11;
                cant_casillas = 16;
                cant_barcos_1x2 = 2;
                cant_barcos_1x3 = 1;
                cant_barcos_1x4 = 1;
                cant_barcos_1x5 = 1;
                turno_max = 30;
                break;
        case 2: tam_tablero = 17;
                cant_casillas = 21;
                cant_barcos_1x2 = 3;
                cant_barcos_1x3 = 2;
                cant_barcos_1x4 = 1;
                cant_barcos_1x5 = 1;
                turno_max = 25;
                break;
        case 3: tam_tablero = 21;
                cant_casillas = 30;
                cant_barcos_1x2 = 3;
                cant_barcos_1x3 = 2;
                cant_barcos_1x4 = 2;
                cant_barcos_1x5 = 2;
                turno_max = 15;
                break;
    }
    int cant_barcos[] = {cant_barcos_1x2, cant_barcos_1x3, cant_barcos_1x4, cant_barcos_1x5};
    inicializarTablero(tam_tablero);
    insertarBarcos(cant_barcos, tam_tablero);
    inicializarMazo();
    while(cant_casillas > 0 && turno_actual < turno_max){
        turno_actual++;
        printf("Turno %d\n", turno_actual);
        mostrarTablero();
        mostrarMazo();
        printf("Selecciona una Carta: ");
        scanf("%d", &eleccion);
        printf("Selecciona Coordenadas: \n");
        printf("X: ");
        scanf("%d", &x);
        printf("Y: ");
        scanf("%d", &y);
        usarCarta();
    }
    if(cant_casillas == 0){
        printf("ULTRA HIT!\n");
        printf("TODOS LOS BARCOS DESTRUIDOS, DEFENSA EXITOSA!\n");
        printf("TABLERO FINAL\n");
        mostrarTableroFinal();
    }else if(turno_actual == turno_max){
        printf("DEFENSA FALLIDA!\n");
        printf("TABLERO FINAL\n");
        mostrarTableroFinal();
    liberarTablero();
    liberarMazo();
    return 0;
    }
}
