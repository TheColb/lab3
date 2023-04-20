import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }

  // @Test
  // public void realTest1(){
  //   int[] input1 = {5, 10};
  //   assertArrayEquals(new int[]{10, 5}, ArrayExamples.reverseInPlace(input1));
  // }

  //   @TeSSst
  // public void realTest2(){
  //   int[] input2 = {1,2,3,4,5};
  //   assertArrayEquals(new int[]{5,4,3,2,1}, ArrayExamples.reversed(input2));
  // }

  // @Test
  // public void smallDuplicate(){
  //   double[] array = {1,1,16,18,21};
  //   assertEquals(14.00, ArrayExamples.averageWithoutLowest(array), 0.005);
  // }

@Test
  public void smallNoDuplicate(){
    double[] array = {0,1,16,18,21};
    assertEquals(14.00, ArrayExamples.averageWithoutLowest(array), 0.005);
  }
}
