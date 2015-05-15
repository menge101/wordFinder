package com.example;

import org.junit.Before;
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

    @Before
    public void setup() {
        String[] wordArray = new String[]{"mouse", "dog", "dogs", "cat", "cats", "caterpillar"};
        dict = new dictionAerie(wordArray);
        systemUnderTest = new wordFinder();
        systemUnderTest.setDictionary(dict);
    }

    @Test
    public void test_empty() {
        ArrayList<String> result = systemUnderTest.findWords("");
        assertEquals(0, result.size());
    }

    @Test
    public void test_singleWord() {
        // process 'dog'
        ArrayList<String> result = systemUnderTest.findWords("dog");
        assertEquals(1, result.size());
        assertEquals("dog", result.get(0));
    }

    @Test
    public void test_doubleWord() {
        // process 'catdog'
        ArrayList<String> result = systemUnderTest.findWords("catdog");
        assertEquals(2, result.size());
        assertEquals("cat", result.get(0));
        assertEquals("dog", result.get(1));
    }

    @Test
    public void test_tripleWord() {
        //process mousecatdog
        ArrayList<String> result = systemUnderTest.findWords("mousecatdog");
        assertEquals(3, result.size());
        assertEquals("mouse", result.get(0));
        assertEquals("cat", result.get(1));
        assertEquals("dog", result.get(2));
    }

    @Test
    public void test_longerTrueWord() {
        // process dogscat
        ArrayList<String> result = systemUnderTest.findWords("dogscat");
        assertEquals(2, result.size());
        assertEquals("dogs", result.get(0));
        assertEquals("cat", result.get(1));
    }

    @Test
    public void test_longerDoubleWord() {
        //process catsdogsmouse
        ArrayList<String> result = systemUnderTest.findWords("catsdogsmouse");
        assertEquals(3, result.size());
        assertEquals("cats", result.get(0));
        assertEquals("dogs", result.get(1));
        assertEquals("mouse", result.get(2));
    }

    @Test
    public void test_muchLongerDoubleWord() {
        ArrayList<String> result = systemUnderTest.findWords("caterpillardog");
        assertEquals(2, result.size());
        assertEquals("caterpillar", result.get(0));
        assertEquals("dog", result.get(1));
    }

}