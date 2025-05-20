#include <stdlib.h>
#include <stdio.h>
#include "Cartas.h"
#include "Tablero.h"
#include <string.h>

Mano Cartas;

void inicializarMazo(){
    Cartas.disponibles = 5;
    Cartas.carta = (void**)malloc(sizeof(void*)*Cartas.disponibles);
    for(int i = 0; i < Cartas.disponibles; i++){
        Cartas.carta[i] = "Simple";
    }
}

void mostrarMazo(){
    if(Cartas.disponibles == 5){
        printf("%s | %s | %s | %s | %s\n", (char*)Cartas.carta[0], (char*)Cartas.carta[1], (char*)Cartas.carta[2], (char*)Cartas.carta[3], (char*)Cartas.carta[4]);
    } else {
        printf("%s | %s | %s | %s\n", (char*)Cartas.carta[0], (char*)Cartas.carta[1], (char*)Cartas.carta[2], (char*)Cartas.carta[3]);
    }
    
}

void usarCarta(){
    char* carta_a_usar = (char*)Cartas.carta[eleccion-1];
    if(strcmp(carta_a_usar, "Simple") == 0){
        disparoSimple(x-1, y-1);
    } else if(strcmp(carta_a_usar, "Grande") == 0){
        disparoGrande(x-1, y-1);
    } else if(strcmp(carta_a_usar, "Lineal") == 0){
        disparoLineal(x-1, y-1);
    } else if(strcmp(carta_a_usar, "Radar") == 0){
        disparoRadar(x-1, y-1);
    } else if(strcmp(carta_a_usar, "500KG") == 0){
        printf("Gran Misil Preparado!!! Se perdera el canon.\n");
        disparo500KG(x-1, y-1);
    }
}

void * disparoSimple(int x, int y){
    int coord_y = y;
    int coord_x = 2*x+1;
    int numero_random = rand()%100 + 1;
    if(((Casilla*)tablero[coord_y][coord_x])->haybarco == 1 && (((Casilla*)tablero[coord_y][coord_x])->simbolo == ' ' || ((Casilla*)tablero[coord_y][coord_x])->simbolo == '~')){
        ((Casilla*)tablero[coord_y][coord_x])->simbolo = 'X';
        cant_casillas--;
        printf("HIT!\n");
    } else if (((Casilla*)tablero[coord_y][coord_x])->simbolo == 'X'){
        cant_casillas = cant_casillas+1-1;
    } else{
        ((Casilla*)tablero[coord_y][coord_x])->simbolo = 'O';
        printf("MISS!\n");
    }
    //probabilidades de aparición de cartas.
    if(numero_random <= 65){
        Cartas.carta[eleccion-1] = "Simple";
        return &disparoSimple;
    } else if (numero_random <= 85){
        Cartas.carta[eleccion-1] = "Grande";
        return &disparoGrande;
    } else if(numero_random <= 90){
        Cartas.carta[eleccion-1] = "Lineal";
        return &disparoLineal;
    }else if(numero_random <=100){
        Cartas.carta[eleccion-1] = "Radar";
        return &disparoRadar;
    }
    return 0;
}

void * disparoGrande(int x, int y){
    int coord_y_centro = y;
    int coord_x_centro = 2*x+1;
    int numero_random = rand()%100 + 1;
    for(int indice_y = -1; indice_y <= 1; indice_y++){
        for(int indice_x = -1; indice_x <= 1; indice_x++){
            int nueva_coord_x = coord_x_centro + 2*indice_x;
            int nueva_coord_y = coord_y_centro + indice_y;
            if(nueva_coord_x >= 0 && nueva_coord_x < columnas && nueva_coord_y >= 0 && nueva_coord_y < filas){
                if(((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->haybarco == 1 && (((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == ' '|| ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == '~')){
                    ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo = 'X';
                    cant_casillas--;
                    printf("HIT!\n");
                } else if (((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == 'X'){
                    cant_casillas = cant_casillas+1-1;
                }else{
                    ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo = 'O';
                    printf("MISS!\n");
                }
            }
        }
    }
    //probabilidades de aparición de cartas.
    if(Cartas.disponibles == 5){
        if(numero_random <= 80){
            Cartas.carta[eleccion-1] = "Simple";
            return &disparoSimple;
        } else if (numero_random <= 83){
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        } else if(numero_random <= 93){
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        } else if(numero_random <=98){
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        } else{
            Cartas.carta[eleccion-1] = "500KG";
            return &disparo500KG;
        }
    } else if(Cartas.disponibles == 4){ 
        if(numero_random <= 80){
            Cartas.carta[eleccion-1] = "Simple";
            return &disparoSimple;
        } else if (numero_random <= 83){
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        } else if(numero_random <= 93){
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        } else if(numero_random <=98){
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        } else{
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        }
    }
    return 0;
}

void * disparoLineal(int x, int y){
    int coord_y_centro = y;
    int coord_x_centro = 2*x+1;
    int numero_random = rand()%100 + 1;
    int orientacion;
    printf("Elija la orientación del disparo (0-Horizontal//1-Vertical): ");
    scanf("%d", &orientacion);
    if(orientacion == 1){ //vertical
        for(int indice_y = -2; indice_y <= 2; indice_y++){
            int nueva_coord_y = coord_y_centro + indice_y;
            if(nueva_coord_y >= 0 && nueva_coord_y < filas){
                if(((Casilla*)tablero[nueva_coord_y][coord_x_centro])->haybarco == 1 && (((Casilla*)tablero[nueva_coord_y][coord_x_centro])->simbolo == ' ' || ((Casilla*)tablero[nueva_coord_y][coord_x_centro])->simbolo == '~')){
                    ((Casilla*)tablero[nueva_coord_y][coord_x_centro])->simbolo = 'X';
                    cant_casillas--;
                    printf("HIT!\n");
                } else if (((Casilla*)tablero[nueva_coord_y][coord_x_centro])->simbolo == 'X'){
                    cant_casillas = cant_casillas+1-1;
                }else{
                    ((Casilla*)tablero[nueva_coord_y][coord_x_centro])->simbolo = 'O';
                    printf("MISS!\n");
                }
            }
        }
    } else{
        for(int indice_x = -2; indice_x <= 2; indice_x++){
            int nueva_coord_x = coord_x_centro + 2*indice_x;
            if(nueva_coord_x >= 0 && nueva_coord_x < columnas){
                if(((Casilla*)tablero[coord_y_centro][nueva_coord_x])->haybarco == 1 && (((Casilla*)tablero[coord_y_centro][nueva_coord_x])->simbolo == ' ' || ((Casilla*)tablero[coord_y_centro][nueva_coord_x])->simbolo == '~')){
                    ((Casilla*)tablero[coord_y_centro][nueva_coord_x])->simbolo = 'X';
                    cant_casillas--;
                    printf("HIT!\n");
                } else{
                    ((Casilla*)tablero[coord_y_centro][nueva_coord_x])->simbolo = 'O';
                    printf("MISS!\n");
                }
            }
        }
    }
    //probabilidades de aparición de cartas.
    if(Cartas.disponibles == 5){
        if(numero_random <= 85){
            Cartas.carta[eleccion-1] = "Simple";
            return &disparoSimple;
        } else if (numero_random <= 90){
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        } else if(numero_random <= 92){
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        } else if(numero_random <= 98){
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        } else{
            Cartas.carta[eleccion-1] = "500KG";
            return &disparo500KG;
        }
    } else if(Cartas.disponibles == 4){
        if(numero_random <= 85){
            Cartas.carta[eleccion-1] = "Simple";
            return &disparoSimple;
        } else if (numero_random <= 90){
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        } else if(numero_random <= 92){
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        } else if(numero_random <= 98){
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        } else{
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        }
    }
    return 0;
}

void * disparoRadar(int x, int y){
    int coord_y_centro = y;
    int coord_x_centro = 2*x+1;
    int numero_random = rand()%100 + 1;
    for(int indice_y = -2; indice_y <= 2; indice_y++){
        for(int indice_x = -2; indice_x <= 2; indice_x++){
            int nueva_coord_x = coord_x_centro + 2*indice_x;
            int nueva_coord_y = coord_y_centro + indice_y;
            if(nueva_coord_x >= 0 && nueva_coord_x < columnas && nueva_coord_y >= 0 && nueva_coord_y < filas){
                if(((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->haybarco == 1 && (((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == ' ' || ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == '~')){
                    ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo = '~';
                } else if (((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == '~' || ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == 'X'){
                    cant_casillas = cant_casillas +1 -1;
                }else{
                    ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo = 'O';
                }
            }
        }
    }
    //probabilidades de aparición de cartas.
    if(Cartas.disponibles == 5){
        if(numero_random <= 75){
            Cartas.carta[eleccion-1] = "Simple";
            return &disparoSimple;
        } else if (numero_random <= 90){
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        } else if(numero_random <= 95){
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        } else if(numero_random <=97){
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        } else{
            Cartas.carta[eleccion-1] = "500KG";
            return &disparo500KG;
        }
    } else if(Cartas.disponibles == 4){
        if(numero_random <= 75){
            Cartas.carta[eleccion-1] = "Simple";
            return &disparoSimple;
        } else if (numero_random <= 90){
            Cartas.carta[eleccion-1] = "Grande";
            return &disparoGrande;
        } else if(numero_random <= 95){
            Cartas.carta[eleccion-1] = "Lineal";
            return &disparoLineal;
        } else if(numero_random <=97){
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        } else{
            Cartas.carta[eleccion-1] = "Radar";
            return &disparoRadar;
        }
    }
    return 0;
}

void * disparo500KG(int x, int y){
    int coord_y_centro = y;
    int coord_x_centro = 2*x+1;
    for(int indice_y = -5; indice_y <= 5; indice_y++){
        for(int indice_x = -5; indice_x <= 5; indice_x++){
            int nueva_coord_x = coord_x_centro + 2*indice_x;
            int nueva_coord_y = coord_y_centro + indice_y;
            if(nueva_coord_x >= 0 && nueva_coord_x < columnas && nueva_coord_y >= 0 && nueva_coord_y < filas){
                if(((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->haybarco == 1 && (((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == ' ' || ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == '~')){
                    ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo = 'X';
                    printf("HIT!\n");
                    cant_casillas--;
                } else if (((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo == 'X'){
                    cant_casillas = cant_casillas +1 -1;
                }else{
                    ((Casilla*)tablero[nueva_coord_y][nueva_coord_x])->simbolo = 'O';
                    printf("MISS!\n");
                }
            }
        }
    }
    reacomodarCartas();
    return 0;
}

void reacomodarCartas(){
    for(int indice = eleccion-1;  indice < Cartas.disponibles; indice++){
        Cartas.carta[indice] = Cartas.carta[indice + 1];
    }
    Cartas.disponibles--;
}

void liberarMazo(){
    free(Cartas.carta);
}

