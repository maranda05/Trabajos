JFLAGS = -g
JC = javac
JVM = java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

ELECCIONPLANETA = eleccionPlaneta/MapaGalactico.java eleccionPlaneta/tieneAsentamientos.java
JUGADOR = jugador/Jugador.java jugador/Nave.java
MAIN = main/NoJavaSky.java
PLANETAS = planetas/CentroGalactico.java planetas/Helado.java planetas/Oceanico.java planetas/Planeta.java planetas/Radiactivo.java planetas/Volcanico.java

CLASSES = $(ELECCIONPLANETA) $(JUGADOR) $(MAIN) $(PLANETAS)

default: clean classes

classes: $(CLASSES:.java=.class)

run: classes
	@$(JVM) main.NoJavaSky

clean:
	$(RM) eleccionPlaneta/*.class jugador/*.class main/*.class planetas/*.class
