JFLAGS = -g
JC = javac

build:
	javac Main.java #${ARGS}
clean:
	find . -type f -name '*.class' -delete
