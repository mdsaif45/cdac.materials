#!/bin/bash

read num
i=1

while (( $i <= 10 ))
do
	echo $(( $i * $num )) #here we need the evaluated expression value  for echo  so we must $
	(( i++ )) # if we are not using $ with it means we are assiging or taking the evaluated expression value
done

# use $ with (()) if you want value outside of (())
# Don't use $ if you dont need

#Inside (( )) Don't use $ with variable for unary operations
#Inside (( )) $ is not compulsary
