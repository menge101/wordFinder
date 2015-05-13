package com.example;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import java.util.ArrayList;

/**
 * Created by Nate on 5/13/15.
 *
 * This is the testing class for wordFinder.
 */
@RunWith(EasyMockRunner.class)
public class wordFinderTest {

    wordFinder systemUnderTest;
    wordDict mockedDict;

    @Before
    public void setup() {
        systemUnderTest = new wordFinder();
        mockedDict = EasyMock.createMock(wordDict.class);
        systemUnderTest.setDictionary(mockedDict);

        // setting expectations on checking chars in the word 'mouse'
        EasyMock.expect(mockedDict.checkWord("m")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("mo")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("mou")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("mous")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("mouse")).andReturn(true);
        // setting expectations on checking chars in the word 'dog'
        EasyMock.expect(mockedDict.checkWord("d")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("do")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("dog")).andReturn(true);
        // setting expectations on checking chars in the word 'cat'
        EasyMock.expect(mockedDict.checkWord("c")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("ca")).andReturn(false);
        EasyMock.expect(mockedDict.checkWord("cat")).andReturn(true);
        // set mock to testing mode
        EasyMock.replay(mockedDict);
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

}