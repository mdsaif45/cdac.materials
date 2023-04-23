#!/bin/bash


name="Siddhant"
#     01234567 Postive indexing
#     87654321 Negative indexing line -1,-2,-3....
#print string
echo $name
echo ${name}

#Slicing
#Syntax ${variable:startIndex:count}
echo "First Index :  ${name:0:1}"
echo "First three characters : ${name:0:3}"
echo "Two chars from 3 index : ${name:3:2}"
echo "First four chars : ${name::4}" #If startIndex is 0 no need to mention it

#Negative Count slicing
#Negative count means Dont select chars from end
echo "String without last two chars : ${name:0:-2}"

#Negative Indexing
#Put negative index in () always
echo "three Chars from last: ${name:(-3):3}"
echo "Four chars from -6 index: ${name:(-6):4}"

#Length of string
echo "length of string: ${#name}" #Here # before name gives us the length of string

echo  "______________________________________________________"

slice=${name:1:3}
echo $slice




