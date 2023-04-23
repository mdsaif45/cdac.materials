#!/bin/bash


read arg

case $arg in
	"1") echo "THis is number"
		;;
	"str") echo "Matching string here"
		;;
	"str1"|"str2" ) echo "matching two string"
		;;
	*) echo "Wrong choice"
		;;
esac
