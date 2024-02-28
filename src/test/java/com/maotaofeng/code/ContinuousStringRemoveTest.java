package com.maotaofeng.code;

import com.maotaofeng.code.strategy.impl.ContinuousStringRemoveImpl;
import com.maotaofeng.code.utils.StringProcessor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test continuous string remove
 */
public class ContinuousStringRemoveTest {

    /**
     * test continuous string remove strategy
     */
    @Test
    public void testRemoveString() {

        //get StringProcessor
        StringProcessor processor = new StringProcessor(new ContinuousStringRemoveImpl());

        //test
        assertEquals("d", processor.processString("aabcccbbad"));
        assertEquals("", processor.processString("aaaaaaa"));
        assertEquals("s", processor.processString("saaaaaaabbcccb"));
        assertEquals("ss", processor.processString("aaaaassbbbbbb"));
        assertEquals("ab", processor.processString("ab"));
        assertEquals("abcdefg", processor.processString("abcdefg"));
        assertEquals("ss", processor.processString("aaaaaxxxxxxsxxxxsbbbbb"));
        assertEquals("abcdeghljk", processor.processString("abcdeffffffghljk"));
        assertEquals("", processor.processString(""));
        assertEquals("", processor.processString(null));

    }
}
