rm -R ./bin
javac -cp .:junit-platform-console-standalone.jar:./bin/board:./bin/card:./bin/driver:./bin/test/ --source-path ./src/ ./test/cards/*.java ./test/board/*.java -d ./bin/test/ --module-path ./lib --add-modules=javafx.controls
java -jar junit-platform-console-standalone.jar  --class-path ./bin/board:./bin/card:./bin/driver:./bin/test/ --scan-class-path --fail-if-no-tests