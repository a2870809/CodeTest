package com.maotaofeng.code;

import com.maotaofeng.code.strategy.ContinuousStringRemove;
import com.maotaofeng.code.strategy.ContinuousStringReplace;
import com.maotaofeng.code.utils.StringProcessor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test continuous string replace
 */
public class ContinuousStringReplaceTest {

    /**
     * test continuous string replace strategy
     */
    @Test
    public void testReplaceString() {

        //get StringProcessor
        StringProcessor processor = new StringProcessor(new ContinuousStringReplace());

        //test
        assertEquals("d", processor.processString("abcccbad"));
        assertEquals("", processor.processString("aaaaaaa"));
        assertEquals("a", processor.processString("bbbbbbbbb"));
        assertEquals("axxb", processor.processString("bbbbbbbbbxxcccccccccccccccccc"));
        assertEquals("abwcd", processor.processString("abxxxcd"));
        assertEquals("abcdefg", processor.processString("abcdefg"));
        assertEquals("", processor.processString(""));
        assertEquals("", processor.processString(null));

    }
}
