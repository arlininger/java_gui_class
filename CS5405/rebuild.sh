#!/bin/sh

#rm source/*.class; 
find . -name "*.class" -exec rm -f {} \;
find . -name "*.jar" -exec rm -f {} \;
rm -rf docs; 
clear; 
javac -d . source/*.java && jar -cvfm Demo.jar m.txt code audio images && javadoc -d docs -author -version -private source/*.java && java -jar Demo.jar
