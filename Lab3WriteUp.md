# Part 1

import java.io.*;\
import java.net.*;\
import java.util.*;

public class StringServer {\
  private String message = ""; // Keep track of the running message string.

  public void handleRequest(HttpExchange exchange) throws IOException {\
    String method = exchange.getRequestMethod();\
    if (method.equalsIgnoreCase("GET")) {\
      String query = exchange.getRequestURI().getQuery();\
      if (query != null && query.startsWith("s=")) {\
        String newMessage = query.substring(2); // Extract the string after "s=".\
        message += "\n" + newMessage; // Append to the running message string.\
      }\
      String response = message;\
      exchange.sendResponseHeaders(200, response.getBytes().length);\
      OutputStream output = exchange.getResponseBody();\
      output.write(response.getBytes());\
      output.flush();\
      output.close();\
    }\
  }

  public static void main(String[] args) throws IOException {\
    int port = 8000;\
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);\
    System.out.println("Server started on port " + port);

 StringServer stringServer = new StringServer();\
    server.createContext("/add-message", (exchange -> {\
      stringServer.handleRequest(exchange);\
    }));

    server.start();\
  }\
}\
To use this server, you can make requests to the /add-message path with the s parameter set to the string you want to add. For example, you can use the curl command in your terminal:

$ curl http://localhost:8000/add-message?s=Hello
Hello
$ curl http://localhost:8000/add-message?s=How%20are%20you
Hello\
How are you\
Here are the answers to the specific questions for two example instances:

Example 1:\
Command: /add-message?s=Hello

Methods called: handleRequest()

Arguments: exchange is an HttpExchange object representing the incoming request.

Relevant fields: message is an empty string, and it gets changed to "Hello".

Example 2:\
Command: /add-message?s=How%20are%20you

Methods called: handleRequest()

Arguments: exchange is an HttpExchange object representing the incoming request.

Relevant fields: message is "Hello", and it gets changed to "Hello\nHow are you".

# Part 2
Failure-inducing input for the reversed method:


@Test\
public void testReversedFailure() {\
    int[] arr = {1, 2, 3};\
    int[] result = ArrayExamples.reversed(arr);\
    int[] expected = {3, 2, 1};\
    assertArrayEquals(expected, result);\
}\
Input that doesn’t induce a failure for the reversed method:


@Test\
public void testReversedSuccess() {\
    int[] arr = {5, 6, 7};\
    int[] result = ArrayExamples.reversed(arr);\
    int[] expected = {7, 6, 5};\
    assertArrayEquals(expected, result);\
}\
Symptom:\
When we run the JUnit test with the provided failure-inducing input, we will see that the test case will fail with the following message:

java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3\
Bug and fix:\
The bug in the reversed method is that it sets the values in the newArray to the wrong index, resulting in an ArrayIndexOutOfBoundsException when the length of the array is not even. The newArray should be populated with the reversed order of the arr array. Here's the fixed code:

// Returns a *new* array with all the elements of the input array in reversed\
// order\
static int[] reversed(int[] arr) {\
  int[] newArray = new int[arr.length];\
  for(int i = 0; i < arr.length; i += 1) {\
    newArray[i] = arr[arr.length - i - 1];\
  }\
  return newArray;\
}\
In the fixed code, we are assigning the value of arr[arr.length - i - 1] to newArray[i] to create a new array that has the reversed elements of the original array in it. Now, the test case testReversedFailure will pass and the testReversedSuccess will also pass.

The fix addresses the issue by correctly creating a new array with the reversed elements of the original array, rather than modifying the original array itself.

# Part 3

During lab I learned how invaluable collaboration is, as well as very simple ways to identify code.\
Previously I would just input random inputs hoping for an odd output, but after these labs, I've\
learned to better trace the code to find an output.
