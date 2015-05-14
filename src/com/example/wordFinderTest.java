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

        // setting true expectations for valid words
        EasyMock.expect(mockedDict.checkWord("mouse")).andReturn(true).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dog")).andReturn(true).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogs")).andReturn(true).anyTimes();
        EasyMock.expect(mockedDict.checkWord("cat")).andReturn(true).anyTimes();
        EasyMock.expect(mockedDict.checkWord("cats")).andReturn(true).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpillar")).andReturn(true).anyTimes();
        // setting negative expectations on checking chars in the word 'mouse'
        EasyMock.expect(mockedDict.checkWord("m")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("mo")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("mou")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("mous")).andReturn(false).anyTimes();
        // setting negative expectations on checking chars in the word 'dog'
        EasyMock.expect(mockedDict.checkWord("d")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("do")).andReturn(false).anyTimes();
        // setting negative expectations on checking chars in the word 'cat'
        EasyMock.expect(mockedDict.checkWord("c")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("ca")).andReturn(false).anyTimes();
        // setting negative expectations for caterpillar
        EasyMock.expect(mockedDict.checkWord("cate")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("cater")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterp")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpi")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpil")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpill")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpilla")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("er")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erp")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpi")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpil")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpill")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpilla")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpillar")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpillard")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpillardo")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpillardog")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("caterpillardogs")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpillard")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpillardo")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpillardog")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("erpillardogs")).andReturn(false).anyTimes();
        // setting random false permutations of requests to dictionary
        EasyMock.expect(mockedDict.checkWord("e")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("s")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("sc")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("sca")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("scat")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("catd")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("catdo")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("catdog")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("catsd")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("catsdo")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("catsdog")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("o")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("g")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("mousec")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("mouseca")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("mousecat")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogc")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogca")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsc")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsca")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogscat")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsm")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsmo")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsmou")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsmous")).andReturn(false).anyTimes();
        EasyMock.expect(mockedDict.checkWord("dogsmouse")).andReturn(false).anyTimes();
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