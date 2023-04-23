#include <stdio.h>

#define IS_ODD( x ) if( x % 2 == 0) { \
	printf("is even\n"); } \
	else { printf("is odd\n"); }


int main() {
	int a = 0;
	scanf("%d", &a);
	IS_ODD(a)
	return 0;
}
