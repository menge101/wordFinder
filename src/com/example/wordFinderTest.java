package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * Created by Nate on 5/13/15.
 *
 * This is the testing class for wordFinder.
 */
public class wordFinderTest {

    wordFinder systemUnderTest;
    dictionAerie dict;

    @Test
    public void test_empty() {
        String[] wordArray = new String[]{"dog"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        ArrayList<String> result = systemUnderTest.findWords("");
        assertEquals(0, result.size());
    }

    @Test
    public void test_singleWord() {
        String[] wordArray = new String[]{"dog"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        // process 'dog'
        ArrayList<String> result = systemUnderTest.findWords("dog");
        assertEquals(1, result.size());
        assertEquals("dog", result.get(0));
    }

    @Test
    public void test_doubleWord() {
        String[] wordArray = new String[]{"cat", "dog"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        // process 'catdog'
        ArrayList<String> result = systemUnderTest.findWords("catdog");
        assertEquals(2, result.size());
        assertEquals("cat", result.get(0));
        assertEquals("dog", result.get(1));
    }

    @Test
    public void test_tripleWord() {
        String[] wordArray = new String[]{"cat", "dog", "mouse"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        //process mousecatdog
        ArrayList<String> result = systemUnderTest.findWords("mousecatdog");
        assertEquals(3, result.size());
        assertEquals("mouse", result.get(0));
        assertEquals("cat", result.get(1));
        assertEquals("dog", result.get(2));
    }

    @Test
    public void test_longerTrueWord() {
        String[] wordArray = new String[]{"cat", "dog", "dogs"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        // process dogscat
        ArrayList<String> result = systemUnderTest.findWords("dogscat");
        assertEquals(2, result.size());
        assertEquals("dogs", result.get(0));
        assertEquals("cat", result.get(1));
    }

    @Test
    public void test_longerTrueDoubleWord() {
        String[] wordArray = new String[]{"cat", "cats", "dog", "dogs", "mouse"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        //process catsdogsmouse
        ArrayList<String> result = systemUnderTest.findWords("catsdogsmouse");
        assertEquals(3, result.size());
        assertEquals("cats", result.get(0));
        assertEquals("dogs", result.get(1));
        assertEquals("mouse", result.get(2));
    }

    @Test
    public void test_muchLongerDoubleWord() {
        String[] wordArray = new String[]{"caterpillar", "dog", "cat"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        ArrayList<String> result = systemUnderTest.findWords("caterpillardog");
        assertEquals(2, result.size());
        assertEquals("caterpillar", result.get(0));
        assertEquals("dog", result.get(1));
    }

    @Test
    public void test_multiSubStrings() {
        String[] wordArray = new String[]{"caterpillar", "dog", "cat", "cater", "pillar", "pill"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        ArrayList<String> result = systemUnderTest.findWords("caterpillardog");
        assertEquals(2, result.size());
        assertEquals("caterpillar", result.get(0));
        assertEquals("dog", result.get(1));
    }

    @Test
    public void test_complexSubStringing() {
        String[] wordArray = new String[]{"caterpillar", "chainsaw", "cat", "cater", "pillar", "pill", "saw"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
        ArrayList<String> result = systemUnderTest.findWords("caterpillarchainsaw");
        assertEquals(2, result.size());
        assertEquals("caterpillar", result.get(0));
        assertEquals("chainsaw", result.get(1));
    }

}