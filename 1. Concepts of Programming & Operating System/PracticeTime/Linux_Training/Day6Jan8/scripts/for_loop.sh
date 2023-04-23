#!/bin/bash


read num
for (( i=1;i<10;i++ ))
do
	echo $(( num * i ))
done
