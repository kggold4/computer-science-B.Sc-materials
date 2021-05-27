package assignment2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q5 {

    public static void report(String[] sArr) {

        // contains the different words for sum them
        LinkedList<String> differentWords = new LinkedList<>();

        // contains the words that appear more than once
        LinkedList<String> containsAtLeastWords = new LinkedList<>();

        // appears is a class i build down below,
        // that can storage Word objects in an arrays list
        // Word is also a class i build down below,
        // word is an object with two parameters:
        // value = string of the word,
        // sum = the time that the word appears
        Appears appears = new Appears();

        // maxappearsWord is the word that appears
        Word maxappearsWord = new Word(sArr[0]);

        // max length word
        String max = sArr[0];
        boolean in = false;

        // going throw the array once
        // let n = sArr.length, loop complexity: O(n)
        for(int i = 0; i < sArr.length; i++) {

            // inserting all the different words to differentWords list
            if(!differentWords.contains(sArr[i])) differentWords.add(sArr[i]);

            // inserting all the words that appear more than once to  containsAtLeastWords list
            else {

                // if containsAtLeastWords is already contains the word:
                // make in to true for delete the word for avoid multype words
                // don't delete here for not make truble by inserting the words
                if(containsAtLeastWords.contains(sArr[i])) in = true;
                containsAtLeastWords.add(sArr[i]);

            }

            //deleting word from containsAtLeastWords by in (if already contain word)
            if(in) containsAtLeastWords.removeLast();
            in = false;

            // checking the String sArr[i] is in appears arrays list by string value
            // if it contains the word, using wordSum metod to add 1 to the sum:
            // counting how much tims the word is appears
            // if it not conatins the word, create new word and add it to the appears array list
            if(appears.wordContains(sArr[i])) {
                appears.wordSum(sArr[i]);
            } else {
                Word word = new Word(sArr[i]);
                appears.add(word);
            }

            // by going throw all appears word,
            // cheking who is the word with max of sum = max apearing
            for(int k = 0; k < appears.mostAppears.size(); k++) {
                if(maxappearsWord.sum < appears.mostAppears.get(k).sum) maxappearsWord = appears.mostAppears.get(k);
            }
            
            // getting the max length word
            if(max.length() < sArr[i].length()) max = sArr[i];
        }

        // output title
        System.out.println("Report:\n");

        // s1
        System.out.println("Number of words: " + sArr.length); // O(1)

        // s2
        System.out.println("Number of different words: " + differentWords.size()); // O(1)

        // s3
        System.out.println("Number of words that appear more than once: " + containsAtLeastWords.size()); // O(1)

        // s4
        System.out.println("Most appears word is: \"" + maxappearsWord.value + "\", time apear: " + maxappearsWord.sum); // O(1)

        // s5
        System.out.println("The longest word is: \"" + max + "\""); // O(1)

    }

    // testing
    public static void main(String[] args) {
        String[] sArr = {"to","and","to","to","good","data","data","or"};
        report(sArr);
    }
}

// Word is also a class i build, word is an object with two parameters:
// value = string of the word, sum = the time that the word appears 
class Word {
    public int sum;
    public String value;
    
    public Word(String value) {
        this.value = value;
        this.sum = 1;
    }

    public boolean same(String word) {
        if(this.value == word) return true;
        return false;
    }

    @Override
    public String toString() {
        return "" + "value: \"" + value + "\", sum: " + this.sum;
    }
}

// appears is a class i build, that can storage Word objects in an arrays list
class Appears {
    public ArrayList<Word> mostAppears;
    
    public Appears() {
        this.mostAppears = new ArrayList<>();
    }

    public void add(Word word) {
        this.mostAppears.add(word);
    }

    public void wordSum(String word) {
        for(int i = 0; i < this.mostAppears.size(); i++) {
            if(this.mostAppears.get(i).same(word)) mostAppears.get(i).sum++;
        }
    }

    public boolean wordContains(String word) {
        for(int i = 0; i < this.mostAppears.size(); i++) {
            if(this.mostAppears.get(i).same(word)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String ans = "";
        ans += "[";
        for(int i = 0; i < this.mostAppears.size(); i++) {
            ans += this.mostAppears.get(i) + ", ";
        }
        ans += "]";
        return ans;
    }
}