# Operating Systems course materials

## Some main algorithms we learned:

### Paterson Algorithm:

* Global code:
```
interested[2];
interested[0] = interested[1] = FALSE;
int turn = 0;
```

* Process 0 code:
```
enter_region() {
	interested[0] = TRUE;
	turn = 0;
	while(turn == 0 && interested[1] == TRUE); // await
	--CS--
	exit_region();
}

exit_region() {
	interested[0] = FALSE;
}
```

* Process 1 code:
```
enter_region() {
	interested[1] = TRUE;
	turn = 1;
	while(turn == 1 && interested[0] == TRUE); // await
	--CS--
	exit_region();
}

exit_region() {
	interested[1] = FALSE;
}
```

### Test and Set Algorithm:

```
test_and_set(value&) { // by reference
	int temp = value;
	value& = 1; 
	return temp;
}

for each thread do {
	await(test_and_set(value) = 0);
	--CS--
	value = 0
}
```

### Producer Consumer Problem:

```
#define N 100
Mutex UseQ = 1
semaphore empty = N;
semaphore fill = 0;

void producer(void) {
	int item;
	while(1) {
		produce_item(&item); // generate something
		down(&empty);
		down(&useQ); // enter CS
		enter_item(&item); // --CS--
		up(&useQ); // exit CS
		up(&full);
	}
}
```