import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ListTests {

	@Test 
	public void testfilter() {
        StringChecker sc1 = new StringChecker() {
            public boolean checkString(String s) {
                return s.contains("o");
            }
        };
        ArrayList<String> input1 = new ArrayList<String>(Arrays.asList("Bob","Joe","Ronald","Steve"));
        ArrayList<String> expected1 = new ArrayList<String>(Arrays.asList("Bob","Joe","Ronald"));
        assertEquals(expected1,ListExamples.filter(input1, sc1));
	}

    @Test
    public void testMerge() {
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("a","d","e","g","j"));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("b","c","f","h","i"));
        String[] expectedlist = {"a","b","c","d","e","f","g","h","i"};
        assertArrayEquals(expectedlist,ListExamples.merge(list1,list2).toArray());
    }
}