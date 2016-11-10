jc:
	javac ./src/*.java -d ./bin
clean:
	rm ./bin/*.class
jr: 
	java ./bin/Main
crm:
	javac ./src/Main.java jr
