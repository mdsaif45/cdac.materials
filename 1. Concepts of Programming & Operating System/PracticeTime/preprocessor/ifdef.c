#include <stdio.h>

#define DEBUG 56
#define size 20
int main()
{
    #undef DEBUG
   char buff[size];
   #ifdef DEBUG
	printf("the printf prompt for input will now appear\n");
   #endif
   printf("enter you string\n");

   #ifdef DEBUG
	printf("scanf will now be called\n");
   #endif

   scanf("%s", buff);

   #ifdef DEBUG
	printf("the output will be displayed\n");
   #endif
   printf("you entered: %s\n", buff);
     


   return 0;
}

