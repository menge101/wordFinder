package com.example;

/**
 * Created by Nate on 5/15/15.
 *
 * This is an implementation of a dictionary class, it's pretty high level, like up with the Eagles in their Aery.
 */
public class dictionAerie implements wordDict{
    String[] words;

    public dictionAerie(String[] words) {
        this.words = words;
    }

    @Override
    public boolean checkWord(String checking) {
        boolean result = false;
        for(String word: words) {
            if(word.compareToIgnoreCase(checking) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }
}
