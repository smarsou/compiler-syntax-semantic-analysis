parser :
	java -jar ./lib/antlr-4.9.2-complete.jar ./expr.g4 -no-listener -no-visitor -o ./src/parser

astparser : 
	java -jar ./lib/antlr-4.9.2-complete.jar ./expr.g4 -no-listener -visitor -o ./src/parser

compile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin

astcompile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/MainAST.java -d ./bin

run :
	make parser
	make compile
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)

astrun :
	make astparser
	make astcompile
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin MainAST $(target)

clean :
	rm -rf src/parser/
	rm -rf bin/