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
        String working_word = "";
        ArrayList<String> results = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            working_word += input.charAt(i);

            if(dictionary.checkWord(working_word)) {
                results.add(working_word);
                working_word = "";
            }
        }
        return results;
    }
}
