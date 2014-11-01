#!/bin/sh

clear; 
checkstyle -c ../checkstyle.xml source/*.java | less
