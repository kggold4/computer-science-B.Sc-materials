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