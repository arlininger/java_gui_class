#!/bin/sh

rm source/*.class; 
rm -rf docs; 
clear; 
javac -d . source/*.java && jar -cvfm Demo.jar m.txt code && javadoc -d docs -author -version -private source/*.java && java -jar Demo.jar
