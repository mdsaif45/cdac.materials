#!/bin/bash


cal `date +%Y`

cat /etc/passwd | grep `whoami`
cat /etc/passwd | grep $(whoami)
