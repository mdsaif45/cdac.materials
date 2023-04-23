#include <stdio.h>
#include "custom.h"


int BOIL = 100;
int FREEZE = 0;
int ROOM = 30;

int main() {
	int temp;
	printf("enter temperature\n");
	scanf("%d", &temp);

	if(temp > BOIL) {
		printf("temp is above boiling point\n");
	}
	if (temp < FREEZE) {
		printf("temp is below freezing point\n");
	}
	if (temp == ROOM) {
		printf("temp is at room temp\n");
	}


	return 0;
}
