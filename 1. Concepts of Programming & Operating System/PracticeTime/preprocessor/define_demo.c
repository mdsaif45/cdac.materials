#include <stdio.h>
#include "custom.h"


#define limit 10
int main() {
	printf("the defined PI value is %f\n", PI);

	for(int i = 0; i < limit; i++) {
		printf("%d ", i);
	}

	return 0;
}
