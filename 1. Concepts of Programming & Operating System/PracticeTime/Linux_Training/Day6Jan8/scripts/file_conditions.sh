#!/bin/bash

read path

if [[ -n $path ]];
then
	if [[ -d $path ]];
	then
		echo "$path is directory"
	fi

	if [[ -f $path ]]
	then
		echo "$path is file"
	fi
fi
