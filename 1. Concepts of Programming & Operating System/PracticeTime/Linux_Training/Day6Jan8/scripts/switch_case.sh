#!/bin/bash

read day

case $day in 
	"1") echo "Monday"
		;;
	"2") echo "Tuesday"
		;;
	"3"|"4") echo "Wednesday" #for 3 and 4 we are getting Wednesday
		;;
	*) echo "Wrong choice"
		;;
esac
