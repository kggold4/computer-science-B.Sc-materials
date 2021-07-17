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

### Binary Semaphores:

```
init(S) {
	S = 1;
}

down(S) {
	if(S == 0) block process;
	S = 0;
}

up(S) {
	S = 1;
	if(thre are blocked process) wake one up;
}
```

### Counting Semaphores:
```
init(S) {
	S = N;
}

down(S) {
	if(S == 0) block process;
	S--;
}

up(S) {
	S++;
	if(thre are blocked process) wake one up;
}
```

### Negative-Value Semaphores:
```
init(S) {
	S = N;
}

down(S) {
	S--;
	if(S < 0) block process;
}

up(S) {
	S++;
	if(S <= 0) wake a process;
}
```

### Creating Counting Semaphore using only Binary Semaphores Solution:
* ```Sint``` - value
* ```S1``` - a binary semaphore, initially = 1
* ```S2``` - a binary semaphore, initially = min(1, value)
```
down(S) {
	down(S2);
	down(S1);
	Sint--;
	if(Sint > 0) {
		up(S2);
	}
	up(S1);
}

up(S) {
	down(S1);
	Sint++;
	if(Sint == 1) {
		up(S2);
	}
	up(S1);
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

void comsumer(void) {
	int item;
	while(1) {
		down(&full);
		down(&useQ);
		consume_item(&item);
		up(&useQ);
		up(&empty);
	}
}
```