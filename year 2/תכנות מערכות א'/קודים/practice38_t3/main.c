#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int indexAt(char string[], char ch) {
    for(int i = 0; i < strlen(string); i++) {
        if(string[i] == ch) {
            return i;
        }
    }
    return -1;
}

char* add_word(char** pstr) {
	int wlen = 0;
	char* ref = *pstr;
	while(*ref != ' ' && *ref != 0){
		wlen++;
		ref++;
	}
	
	char* word = (char*)malloc(sizeof(char)*wlen +1);
	if (!word) return NULL;
	
	for(int i=0 ; i<wlen ; i++) {
		word[i] = ref[i];
	}
	//move the original pointer wlen + 1 chars forward 
	*pstr=*pstr + wlen + 1;
	
	return word;
}

void clean_up(char** arr, int size){
	for(int i = 0; i<size;i++) {
		if(arr[i] != NULL) {
			free(arr[i]);
			continue;
		}
		break;
	}
	free(arr);
	return;
}



char ** splitString(char * string) {
    int n = strlen(string), space_counter = 0, max_word = 0, word_counter = 0;
    for(int i = 0; i < n; i++) {
        word_counter++;
        if(string[i] == ' ') {
            space_counter++;
            if(max_word < word_counter) {
                max_word = word_counter;
            }
            word_counter = 0;
        }
    }
    printf("count spaces: %d, and max word length is: %d\n", space_counter, max_word);
    char ** arr = (char**)malloc(sizeof(char*)*space_counter + 1);
    if(!arr) {
        return NULL;
    }

    int i = 0;
    while(*string) {
        arr[i] = add_word(&string);
        if(!arr[i]) {
            clean_up(arr, space_counter);
            i++;
        }
    }
    return arr;
}


int main(void) {
    // char string[] = "abcdefghijkmnlopqrstuvwxyz";
    // char ch = 'a';
    // printf("%d\n", indexAt(string, ch));

    char string[] = "this is a string for testing";
    char ** strings = splitString(string);
    for(int i = 0; i < 5; i++) {
        printf("%s\t", strings[i]);
    }
    return 0;
}