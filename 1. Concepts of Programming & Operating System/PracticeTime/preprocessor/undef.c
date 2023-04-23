#include <stdio.h>

#define RAJU 20
int main()
{
   #ifdef RAJU
    #undef RAJU
   #endif

     
   #ifdef RAJU
   printf("RAJU is defined. So, this line will be added in " \
          "this C file\n");
   #else
   printf("RAJU is not defined\n");
   #endif
   return 0;
}

