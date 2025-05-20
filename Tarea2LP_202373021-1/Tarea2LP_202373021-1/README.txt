Nombre: Martín Ignacio Aranda Hernández.
ROL: 202373021-1

INSTRUCCIONES: Para compilar y ejecutar el código se utilizó el makefile creado, por favor para compilar escriba en la terminal correspondiente la palabra make y para ejecutar el código escriba en la terminal correspondiente la palabra make run.


----------
CONSIDERACIONES DE MI TAREA
----------

-Para la tarea se utilizaron 4 archivos .c CityDefender.c Tablero.c Barcos.c Cartas.c y además 3 archivos .h Tablero.h Barcos.h Cartas.h, además del archivo makefile para compilar y ejecutar.

-Para ingresar las coordenadas X e Y en el tablero se consideró lo siguiente:

|1|2|3|4|5|6|7|8|9|... <--(posición en X)
|2|
|3|
|4|
|5|
|6|
|7|
|8|
|9|
 ^
 |
(posición en Y)

Al momento de ingresar las coordenadas se asume que SIEMPRE se ingresará una coordenada valida que esté en el intervalo de 1 a el tamaño de fila o columna. De igual manera que al ingresar la dificultad al comienzo de la ejecución.

-Para el disparo Radar cuando encuentra un barco en la posición (x,y) se denotó con el símbolo "~". Para el disparo Lineal se determinó que su orientación (horizontal o vertical) será escogida por el usuario con un 0 si quiere que el disparo sea horizontal y un 1 si es que quiere que sea vertical.

-Cuando todos los turnos se acaban se imprime el tablero final, donde 'O' es la casilla donde no hubo barco, una 'X' donde se atinó a un barco, una 'F' donde hubo un barco pero no se atinó.