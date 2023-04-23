#!/bin/bash

#a = 10 # invalid because of spaces 
a=10 #valid We must not provide any space during assignment
echo $a
a="Siddhant"
echo $a
a='Sid'
echo $a
a=0.10
echo $a

echo "THis is $a" #here it can print the value of $a  beacause of double quotes
echo 'This is $a' #here it'll treat $a part of string because of single quotes
