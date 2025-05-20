Nombre: Martín Ignacio Aranda Hernández.
ROL: 202373021-1

INSTRUCCIONES: Para compilar y ejecutar el código se utilizó el makefile creado, por favor para compilar escriba en la terminal correspondiente la palabra make y para ejecutar el código escriba en la terminal correspondiente la palabra make run.

-Para realizar mi tarea se utilizó "Java 21" por lo que para su correcto funcionamiento utilice una version que permita compilar y ejecutar mi código.


---------
CONSIDERACIONES DE TAREA
---------

-Por favor respetar los inputs que se solicitan en mi código a la hora de ejecutar mi código.

-Para la tarea se consideraron todos los archivos solicitados en la guía e la tarea. Nada más.

-Como no se menciona en la guía en que momento se intercambian las flores de sodio y los cristales de hidrógeno por aumentos de la energía del ExoTraje y más combustible respectivamente, implementé en mi juego que tales intercambios se hacen en los asentamientos.

-Para agregar un poco más de dificultad, en mi juego se reutilizó la formula de "Consumo de energía" al momento de visitar el planeta. Por lo que para disminuir la energía del ExoTraje se debe extrar materiales o entrar a un planeta.

-La indicación en que planeta uno se encuentra está en la lista de planetas en "3. Viajar a otro planeta", esto se indica con un "(ESTAS AQUÍ)" en el planeta respectivo en el que estés.

-Para aumentar la eficiencia del ExoTraje se utilizó como intercambio el mineral "Platino", la formula utilizada está descrita "unidadesIntercambiadas = 0.7*CantPlatino" donde unidadesIntercambiadas es la eficiencia extra del ExoTraje. Esta implementación fue creada por mi debido a que en la guía no se menciona nada al respecto.

-Para aumentar la eficiencia de los propulsores se utilizó como intercambio el mineral "Uranio", la formula utilizada está descrita "unidadesIntercambiadas = 0.6*CantUranio" donde unidadesIntercambiadas es la eficiencia extra de los propulsores obtenida de la formula. De igual manera que el punto anterior, esta implementación fue creada por mi debido a que en la guía no se menciona nada al respecto.

-Cuando el jugador queda sin energía del ExoTraje o se queda sin combustible. Se activa un estado de emergencia donde jugador vuelve al planeta 0 donde se reinicia todo su inventario  0, su eficiencia de los propulsores o del ExoTraje también lo hace. No obstante la lista de los planeta no es reiniciada, por lo que estarán todos los planetas recorridos.

-En el caso específico que el jugador se quede sin el combustible sufienciente para viajar a otro planeta y se encuentre en un planeta sin asentamientos. La unica opción que le queda es utilizar la opción "4. Rendirse" el cual funciona como la opción de "GAME OVER" pero con consentimiento. Este "GAME OVER" es de las mismas características que se mencionan en la guía.
