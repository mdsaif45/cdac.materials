#!/bin/bash

read a
read b

#if [[ $a -gt $b ]]
#then
#	echo "$a is greater"
#fi

#if [[ $a -gt $b ]];
#then
#	echo "$a is greater"
#else
#	echo "$b is greater"
#fi

if [[ $a == $b ]]
then
	echo "$a is equal to $b"
elif [[ $a -gt $b ]]
then 
	echo "$a is greater"
else
	echo "$b is greater"
fi
