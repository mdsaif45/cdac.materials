#include<stdio.h>

#define CAT(a, b) a##b


void main() {
   printf("%d", CAT(10, 20));
}

