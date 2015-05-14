package com.example;

import java.util.ArrayList;

/**
 * Created by Nate on 5/13/15.
 *
 * This class expects a dictionary class and a string as input.
 * Output will be an arrayList of strings parsed from the input string,
 * based on the dictionary class's contents
 */
public class wordFinder {
    private wordDict dictionary;

    public void setDictionary(wordDict w) {
        dictionary = w;
    }

    public ArrayList<String> findWords(String input) {
        String working_word = ""; // gets truncated to what we believe is the word we are working on building
        String possible_word = ""; // maintains a static first guess at a word
        String progress_string = "";  // maintains the current progress of string parsing
        ArrayList<String> results = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            progress_string += a;
            working_word += a;

            if(!possible_word.equals("")) {
                if (dictionary.checkWord(progress_string) && !dictionary.checkWord((working_word))) {
                    possible_word = progress_string;
                    working_word = "";
                } else if (dictionary.checkWord(working_word) && !dictionary.checkWord(progress_string)) {
                    results.add(possible_word);
                    possible_word = working_word;
                    progress_string = working_word;
                    working_word = "";
                }

                if((i + 1) == input.length()) {
                    results.add(possible_word);
                }
            } else {
                if (dictionary.checkWord(progress_string)) {
                    possible_word = progress_string;
                    working_word = "";

                    if((i + 1) == input.length()) {
                        results.add(possible_word);
                    }
                }
            }
        }
        return results;
    }
}
