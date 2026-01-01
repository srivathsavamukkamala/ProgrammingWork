import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class LongestCommonPrefixTest {
    @Test
    public void testTwoStrings() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("flower");
        strings.add("flow");

        String result = app.findLongestCommonPrefix(strings);
        assertEquals("flow", result);
    }

    @Test
    public void testThreeStrings() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("flower");
        strings.add("flow");
        strings.add("flight");

        String result = app.findLongestCommonPrefix(strings);
        assertEquals("fl", result);
    }

    @Test
    public void EmptyStrings() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        String result = app.findLongestCommonPrefix(strings);
        assertEquals("",result);
    }

    @Test
    public void ExtraCredit1() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("r");
        strings.add("e");
        strings.add("x");
        String result = app.findLongestCommonSuffix(strings);
        assertEquals("",result);
    }

    @Test
    public void ExtraCredit2() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("matter");
        strings.add("later");
        strings.add("peter");
        String result = app.findLongestCommonSuffix(strings);
        assertEquals("ter",result);
    }

    @Test
    public void ExtraCredit3() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("c");
        strings.add("pac");
        strings.add("lakc");
        String result = app.findLongestCommonSuffix(strings);
        assertEquals("c",result);
    }

    @Test
    public void ExtraCredit4() {
        LongestCommonPrefix app = new LongestCommonPrefix();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("r");
        strings.add("matter");
        strings.add("peter");
        String result = app.findLongestCommonSuffix(strings);
        assertEquals("r",result);
    }
}