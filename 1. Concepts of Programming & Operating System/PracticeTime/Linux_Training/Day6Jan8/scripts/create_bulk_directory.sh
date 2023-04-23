#!/bin/bash

#Creating directory with name 1,2,3,4,5...100 inside temp directory

path="temp"

i=1
while (( i <=100 ))
do
	mkdir "$path/$i"
	((i++))
done

# temp/1
# temp/2
# temp/3.................
