#!/bin/bash


read a
read b

if (( $a > $b ))
then
	echo "$a is greater"
else
	echo "$b is greater"
fi
