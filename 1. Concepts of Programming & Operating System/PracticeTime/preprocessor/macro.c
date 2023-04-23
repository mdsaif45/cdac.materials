#include <stdio.h>
#define PI 3.14159
#define CIRCLE_AREA( x ) ( PI * ( x ) * ( x ) ) 


int main() {
int a;
scanf("%d", &a);
float area = CIRCLE_AREA(a);
printf("area : %f\n", area);
return 0;
}


