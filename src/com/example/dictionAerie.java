package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nate on 5/15/15.
 *
 * This is an implementation of a dictionary class, it's pretty high level, like up with the Eagles in their Aery.
 */
public class dictionAerie implements wordDict{
    Set<String> words;

    public dictionAerie(String[] wordsArray) { words = new HashSet<>(Arrays.asList(wordsArray)); }

    @Override
    public boolean checkWord(String checking) {
        return words.contains(checking);
    }
}
