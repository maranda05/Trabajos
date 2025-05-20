all: output

CityDefender.o: CityDefender.c
	gcc -c CityDefender.c -I. -o CityDefender.o

Tablero.o: Tablero.c
	gcc -c Tablero.c -I. -o Tablero.o

Cartas.o: Cartas.c
	gcc -c Cartas.c -I. -o Cartas.o

Barcos.o: Barcos.c
	gcc -c Barcos.c -I. -o Barcos.o

output: CityDefender.o Tablero.o Cartas.o Barcos.o
	gcc CityDefender.o Tablero.o Cartas.o Barcos.o -Wall -o output

clean:
	rm -f CityDefender.o Tablero.o Cartas.o Barcos.o output

run: output
	./output