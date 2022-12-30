parser :
	java -jar ./lib/antlr-4.9.2-complete.jar ./expr.g4 -no-listener -no-visitor -o ./src/parser

astparser : 
	java -jar ./lib/antlr-4.9.2-complete.jar ./expr.g4 -no-listener -visitor -o ./src/parser

compile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin

astcompile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/MainAST.java -d ./bin

tdscompile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/MainTDS.java -d ./bin

run :
	make parser
	make compile
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)

astrun :
	make astparser
	make astcompile
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin MainAST $(target)
	echo } >> out/tree.dot
	dot -Tsvg ./out/tree.dot -o ./out/tree.svg
	

tdsrun:
	make astparser
	make tdscompile
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin MainTDS $(target)

clean :
	rm -rf src/parser/
	rm -rf bin/