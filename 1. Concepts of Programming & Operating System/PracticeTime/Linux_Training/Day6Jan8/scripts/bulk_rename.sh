#!/bin/bash

#bulk rename 
#Add dir at the end of directory name inside temp

#ls temp/ giving all dir name in seperate lines
#reading file name line by line
ls temp/ | while read line
do
	mv "temp/$line" "temp/$line""dir"
done

#mv temp/1 temp/1dir
#mv temp/2 temp/2dir
