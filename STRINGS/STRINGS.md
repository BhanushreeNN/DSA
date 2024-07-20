# Strings in Java

Generally, a string is a sequence of characters. However, in Java, a string is an object that represents a sequence of characters. The `java.lang.String` class is used to create a string object.

## Ways of Creating a String

There are two ways to create a string in Java:

- String Literal
- Using `new` Keyword

### 1. String Literal

```java
String greeting = "Hello world!";
```

- Each time you create a string literal, the JVM checks the "string constant pool" first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool.
- This mechanism makes Java more memory efficient because no new objects are created if the string already exists in the string constant pool.

### 2. Using `new` Keyword

```java
String s = new String("Welcome");
```

- In this case, the JVM will create a new string object in normal (non-pool) heap memory and the literal `"Welcome"` will be placed in the string constant pool. The variable `s` will refer to the object in the heap (non-pool).

#### Note

The `String` class is immutable, meaning that once a `String` object is created, it cannot be changed. The `String` class has a number of methods, some of which will be discussed below, that appear to modify strings. Since strings are immutable, what these methods really do is create and return a new string that contains the result of the operation.

## Interfaces and Classes in Strings in Java
In Java, interfaces and classes can be used to work with and manipulate strings in various ways. Here are some key concepts and examples:

### Interfaces

1. **`CharSequence` Interface**:
   - The `CharSequence` interface represents a readable sequence of `char` values. This interface is implemented by several classes, including `String`, `StringBuilder`, and `StringBuffer`.
   - Methods defined in the `CharSequence` interface:
     - `int length()`
     - `char charAt(int index)`
     - `CharSequence subSequence(int start, int end)`
     - `String toString()`

   ```java
   CharSequence seq = "Hello, World!";
   System.out.println("Length: " + seq.length());
   System.out.println("Character at index 1: " + seq.charAt(1));
   System.out.println("Subsequence (0, 5): " + seq.subSequence(0, 5));
   ```

2. **`Comparable` Interface**:
   - The `Comparable` interface allows for objects to be compared for order. The `String` class implements this interface to provide natural ordering of strings.
   - Method defined in the `Comparable` interface:
     - `int compareTo(T o)`

   ```java
   String str1 = "apple";
   String str2 = "banana";
   int result = str1.compareTo(str2);
   if (result < 0) {
       System.out.println(str1 + " is less than " + str2);
   } else if (result == 0) {
       System.out.println(str1 + " is equal to " + str2);
   } else {
       System.out.println(str1 + " is greater than " + str2);
   }
   ```

### Classes

1. **`String` Class**:
   - The `String` class represents immutable sequences of characters. Once created, the contents of a `String` cannot be changed.
   - Commonly used methods in the `String` class:
     - `int length()`
     - `char charAt(int index)`
     - `boolean equals(Object anObject)`
     - `boolean equalsIgnoreCase(String anotherString)`
     - `String substring(int beginIndex, int endIndex)`
     - `String concat(String str)`
     - `String replace(CharSequence target, CharSequence replacement)`
     - `String[] split(String regex)`

   ```java
   String str = "Hello, World!";
   System.out.println("Length: " + str.length());
   System.out.println("Character at index 1: " + str.charAt(1));
   System.out.println("Substring (0, 5): " + str.substring(0, 5));
   System.out.println("Concatenation: " + str.concat(" Welcome!"));
   System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));
   ```

2. **`StringBuilder` and `StringBuffer` Classes**:
   - Both `StringBuilder` and `StringBuffer` are used to create mutable sequences of characters. The main difference between them is that `StringBuffer` is synchronized, making it thread-safe, while `StringBuilder` is not.
   - Commonly used methods in the `StringBuilder` and `StringBuffer` classes:
     - `append(String str)`
     - `insert(int offset, String str)`
     - `delete(int start, int end)`
     - `reverse()`

   ```java
   // Using StringBuilder
   StringBuilder sb = new StringBuilder("Hello");
   sb.append(", World!");
   System.out.println("StringBuilder: " + sb.toString());
   
   // Using StringBuffer
   StringBuffer sbf = new StringBuffer("Hello");
   sbf.append(", World!");
   System.out.println("StringBuffer: " + sbf.toString());
   ```

### Practical Example

Here's a practical example that demonstrates the use of interfaces and classes with strings in Java:

```java
public class StringExample {
    public static void main(String[] args) {
        // Using CharSequence interface
        CharSequence seq = "Example";
        System.out.println("CharSequence length: " + seq.length());

        // Using String class
        String str = "Hello, World!";
        System.out.println("String length: " + str.length());
        System.out.println("Substring (0, 5): " + str.substring(0, 5));

        // Using Comparable interface
        String str1 = "apple";
        String str2 = "banana";
        int comparisonResult = str1.compareTo(str2);
        System.out.println("Comparison result: " + comparisonResult);

        // Using StringBuilder class
        StringBuilder sb = new StringBuilder("Mutable");
        sb.append(" String");
        System.out.println("StringBuilder: " + sb.toString());

        // Using StringBuffer class
        StringBuffer sbf = new StringBuffer("Thread-safe");
        sbf.append(" String");
        System.out.println("StringBuffer: " + sbf.toString());
    }
}
```

In this example, we demonstrate the use of the `CharSequence` and `Comparable` interfaces, as well as the `String`, `StringBuilder`, and `StringBuffer` classes to manipulate strings.

## String Class in Java
Java provides a rich set of methods for manipulating strings through the `String` class. Below is a detailed list of commonly used `String` methods along with examples of how to use them:

### Basic Methods

1. **`length()`**
   - Returns the length of the string.
   ```java
   String str = "Hello, World!";
   int length = str.length();
   System.out.println("Length: " + length);  // Output: 13
   ```

2. **`charAt(int index)`**
   - Returns the character at the specified index.
   ```java
   char ch = str.charAt(1);
   System.out.println("Character at index 1: " + ch);  // Output: e
   ```

3. **`substring(int beginIndex)`**
   - Returns a new string that is a substring of this string.
   ```java
   String subStr = str.substring(7);
   System.out.println("Substring from index 7: " + subStr);  // Output: World!
   ```

4. **`substring(int beginIndex, int endIndex)`**
   - Returns a new string that is a substring of this string from `beginIndex` to `endIndex - 1`.
   ```java
   String subStr = str.substring(0, 5);
   System.out.println("Substring (0, 5): " + subStr);  // Output: Hello
   ```

### Comparison Methods

5. **`equals(Object anObject)`**
   - Compares this string to the specified object.
   ```java
   String str1 = "Hello";
   String str2 = "Hello";
   boolean isEqual = str1.equals(str2);
   System.out.println("Is equal: " + isEqual);  // Output: true
   ```

6. **`equalsIgnoreCase(String anotherString)`**
   - Compares this string to another string, ignoring case considerations.
   ```java
   boolean isEqualIgnoreCase = str1.equalsIgnoreCase("hello");
   System.out.println("Is equal ignoring case: " + isEqualIgnoreCase);  // Output: true
   ```

7. **`compareTo(String anotherString)`**
   - Compares two strings lexicographically.
   ```java
   int comparisonResult = str1.compareTo("World");
   System.out.println("Comparison result: " + comparisonResult);  // Output: a negative number
   ```

8. **`compareToIgnoreCase(String str)`**
   - Compares two strings lexicographically, ignoring case considerations.
   ```java
   int comparisonResultIgnoreCase = str1.compareToIgnoreCase("world");
   System.out.println("Comparison result ignoring case: " + comparisonResultIgnoreCase);  // Output: a negative number
   ```

### Searching Methods

9. **`indexOf(int ch)`**
   - Returns the index within this string of the first occurrence of the specified character.
   ```java
   int index = str.indexOf('W');
   System.out.println("Index of 'W': " + index);  // Output: 7
   ```

10. **`indexOf(String str)`**
    - Returns the index within this string of the first occurrence of the specified substring.
    ```java
    int indexSub = str.indexOf("World");
    System.out.println("Index of 'World': " + indexSub);  // Output: 7
    ```

11. **`lastIndexOf(int ch)`**
    - Returns the index within this string of the last occurrence of the specified character.
    ```java
    int lastIndex = str.lastIndexOf('o');
    System.out.println("Last index of 'o': " + lastIndex);  // Output: 8
    ```

### Modification Methods

12. **`concat(String str)`**
    - Concatenates the specified string to the end of this string.
    ```java
    String newStr = str.concat(" Welcome!");
    System.out.println("Concatenated string: " + newStr);  // Output: Hello, World! Welcome!
    ```

13. **`replace(char oldChar, char newChar)`**
    - Returns a new string resulting from replacing all occurrences of `oldChar` in this string with `newChar`.
    ```java
    String replacedStr = str.replace('o', 'a');
    System.out.println("Replaced string: " + replacedStr);  // Output: Hella, Warld!
    ```

14. **`replace(CharSequence target, CharSequence replacement)`**
    - Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.
    ```java
    String replacedStrSeq = str.replace("World", "Java");
    System.out.println("Replaced string: " + replacedStrSeq);  // Output: Hello, Java!
    ```

### Trimming and Stripping

15. **`trim()`**
    - Returns a string whose value is this string, with any leading and trailing whitespace removed.
    ```java
    String strWithSpaces = "   Hello, World!   ";
    String trimmedStr = strWithSpaces.trim();
    System.out.println("Trimmed string: '" + trimmedStr + "'");  // Output: 'Hello, World!'
    ```

16. **`strip()`**
    - Returns a string whose value is this string, with any leading and trailing white space removed. Unlike `trim()`, `strip()` removes all kinds of white spaces.
    ```java
    String strippedStr = strWithSpaces.strip();
    System.out.println("Stripped string: '" + strippedStr + "'");  // Output: 'Hello, World!'
    ```

### Conversion Methods

17. **`toLowerCase()`**
    - Converts all of the characters in this `String` to lower case.
    ```java
    String lowerCaseStr = str.toLowerCase();
    System.out.println("Lower case: " + lowerCaseStr);  // Output: hello, world!
    ```

18. **`toUpperCase()`**
    - Converts all of the characters in this `String` to upper case.
    ```java
    String upperCaseStr = str.toUpperCase();
    System.out.println("Upper case: " + upperCaseStr);  // Output: HELLO, WORLD!
    ```

19. **`toCharArray()`**
    - Converts this string to a new character array.
    ```java
    char[] charArray = str.toCharArray();
    System.out.println("Character array: " + Arrays.toString(charArray));  // Output: [H, e, l, l, o, ,,  , W, o, r, l, d, !]
    ```

20. **`valueOf(...)`**
    - Returns the string representation of the specified argument.
    ```java
    int number = 42;
    String numberStr = String.valueOf(number);
    System.out.println("String value of number: " + numberStr);  // Output: 42
    ```

### Splitting Methods

21. **`split(String regex)`**
    - Splits this string around matches of the given regular expression.
    ```java
    String[] words = str.split(" ");
    System.out.println("Splitted string: " + Arrays.toString(words));  // Output: [Hello,, World!]
    ```

22. **`split(String regex, int limit)`**
    - Splits this string around matches of the given regular expression, with a limit on the number of splits.
    ```java
    String[] limitedSplit = str.split(" ", 2);
    System.out.println("Limited split: " + Arrays.toString(limitedSplit));  // Output: [Hello,, World!]
    ```

### Checking Methods

23. **`startsWith(String prefix)`**
    - Tests if this string starts with the specified prefix.
    ```java
    boolean startsWithHello = str.startsWith("Hello");
    System.out.println("Starts with 'Hello': " + startsWithHello);  // Output: true
    ```

24. **`endsWith(String suffix)`**
    - Tests if this string ends with the specified suffix.
    ```java
    boolean endsWithWorld = str.endsWith("World!");
    System.out.println("Ends with 'World!': " + endsWithWorld);  // Output: true
    ```

25. **`contains(CharSequence s)`**
    - Returns true if and only if this string contains the specified sequence of char values.
    ```java
    boolean containsWorld = str.contains("World");
    System.out.println("Contains 'World': " + containsWorld);  // Output: true
    ```

### Joining Methods

26. **`join(CharSequence delimiter, CharSequence... elements)`**
    - Returns a new `String` composed of copies of the `CharSequence` elements joined together with a copy of the specified delimiter.
    ```java
    String joinedString = String.join(", ", "apple", "banana", "cherry");
    System.out.println("Joined string: " + joinedString);  // Output: apple, banana, cherry
    ```

These are some of the most commonly used methods of the `String` class in Java. Each method provides a powerful way to manipulate and handle strings effectively.

## StringBuffer Class in Java
The `StringBuffer` class in Java is used to create mutable sequences of characters. Unlike the `String` class, which creates immutable strings, `StringBuffer` allows you to modify the contents of the sequence without creating new objects. This makes `StringBuffer` useful when you need to perform many modifications to a string, such as appending, inserting, or deleting characters. Additionally, `StringBuffer` is thread-safe, meaning it is synchronized and can be used safely by multiple threads.

### Key Features of `StringBuffer`:

- **Mutable**: The content of a `StringBuffer` can be changed.
- **Thread-safe**: Methods are synchronized, making it safe for use by multiple threads.
- **Performance**: Provides better performance than `String` when performing many modifications.

### Commonly Used Methods in `StringBuffer`

Here are some of the most commonly used methods in the `StringBuffer` class, along with examples:

1. **Constructor**

   ```java
   // Default constructor with an initial capacity of 16
   StringBuffer sb1 = new StringBuffer();

   // Constructor with a specified capacity
   StringBuffer sb2 = new StringBuffer(50);

   // Constructor with an initial string
   StringBuffer sb3 = new StringBuffer("Hello");
   ```

2. **`append(String str)`**
   - Appends the specified string to this character sequence.
   ```java
   StringBuffer sb = new StringBuffer("Hello");
   sb.append(", World!");
   System.out.println(sb.toString());  // Output: Hello, World!
   ```

3. **`insert(int offset, String str)`**
   - Inserts the specified string at the specified position.
   ```java
   sb.insert(5, " Java");
   System.out.println(sb.toString());  // Output: Hello Java, World!
   ```

4. **`replace(int start, int end, String str)`**
   - Replaces the characters in a substring of this sequence with characters in the specified string.
   ```java
   sb.replace(6, 10, "Awesome");
   System.out.println(sb.toString());  // Output: Hello Awesome, World!
   ```

5. **`delete(int start, int end)`**
   - Removes the characters in a substring of this sequence.
   ```java
   sb.delete(5, 13);
   System.out.println(sb.toString());  // Output: Hello, World!
   ```

6. **`deleteCharAt(int index)`**
   - Removes the character at the specified position.
   ```java
   sb.deleteCharAt(5);
   System.out.println(sb.toString());  // Output: HelloWorld!
   ```

7. **`reverse()`**
   - Reverses the sequence of characters.
   ```java
   sb.reverse();
   System.out.println(sb.toString());  // Output: !dlroWolleH
   ```

8. **`setCharAt(int index, char ch)`**
   - Sets the character at the specified position to the specified character.
   ```java
   sb.setCharAt(0, 'h');
   System.out.println(sb.toString());  // Output: !dlroWolleh
   ```

9. **`toString()`**
   - Converts the `StringBuffer` to a `String`.
   ```java
   String str = sb.toString();
   System.out.println(str);  // Output: !dlroWolleh
   ```

10. **`capacity()`**
    - Returns the current capacity of the `StringBuffer`.
    ```java
    int capacity = sb.capacity();
    System.out.println("Capacity: " + capacity);  // Output: Capacity: 34 (initial capacity + length of string)
    ```

11. **`ensureCapacity(int minimumCapacity)`**
    - Ensures that the capacity is at least equal to the specified minimum.
    ```java
    sb.ensureCapacity(50);
    System.out.println("New Capacity: " + sb.capacity());  // Output: New Capacity: 70
    ```

12. **`setLength(int newLength)`**
    - Sets the length of the character sequence.
    ```java
    sb.setLength(5);
    System.out.println(sb.toString());  // Output: !dlro
    ```

13. **`substring(int start)`**
    - Returns a new `String` that contains a subsequence of characters currently contained in this sequence.
    ```java
    String subStr = sb.substring(1);
    System.out.println(subStr);  // Output: dlro
    ```

14. **`substring(int start, int end)`**
    - Returns a new `String` that contains a subsequence of characters currently contained in this sequence from `start` to `end - 1`.
    ```java
    String subStr = sb.substring(1, 3);
    System.out.println(subStr);  // Output: dl
    ```

### Example Usage of `StringBuffer`

Here's a complete example demonstrating various operations using `StringBuffer`:

```java
public class StringBufferExample {
    public static void main(String[] args) {
        // Create a new StringBuffer with initial content
        StringBuffer sb = new StringBuffer("Hello");

        // Append text
        sb.append(", World!");
        System.out.println("After append: " + sb.toString());

        // Insert text
        sb.insert(5, " Java");
        System.out.println("After insert: " + sb.toString());

        // Replace text
        sb.replace(6, 10, "Awesome");
        System.out.println("After replace: " + sb.toString());

        // Delete text
        sb.delete(5, 13);
        System.out.println("After delete: " + sb.toString());

        // Delete character at a specific position
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb.toString());

        // Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());

        // Set a character at a specific position
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: " + sb.toString());

        // Convert to string
        String str = sb.toString();
        System.out.println("Converted to String: " + str);

        // Get capacity
        int capacity = sb.capacity();
        System.out.println("Capacity: " + capacity);

        // Ensure capacity
        sb.ensureCapacity(50);
        System.out.println("New Capacity: " + sb.capacity());

        // Set length
        sb.setLength(5);
        System.out.println("After setLength: " + sb.toString());

        // Get substring
        String subStr = sb.substring(1, 3);
        System.out.println("Substring (1, 3): " + subStr);
    }
}
```

This example showcases the creation and manipulation of a `StringBuffer` object, demonstrating how to perform various operations such as appending, inserting, replacing, deleting, reversing, and converting to a `String`.

## StringBuilder Class in Java
The `StringBuilder` class in Java is similar to `StringBuffer` in that it is used to create mutable sequences of characters. The primary difference between `StringBuilder` and `StringBuffer` is that `StringBuilder` is not synchronized, which means it is not thread-safe. This makes `StringBuilder` more efficient than `StringBuffer` when used in a single-threaded context.

### Key Features of `StringBuilder`:

- **Mutable**: The content of a `StringBuilder` can be changed.
- **Not Thread-safe**: Methods are not synchronized, making it unsafe for use by multiple threads.
- **Performance**: Provides better performance than `String` and `StringBuffer` when performing many modifications in a single-threaded environment.

### Commonly Used Methods in `StringBuilder`

Here are some of the most commonly used methods in the `StringBuilder` class, along with examples:

1. **Constructor**

   ```java
   // Default constructor with an initial capacity of 16
   StringBuilder sb1 = new StringBuilder();

   // Constructor with a specified capacity
   StringBuilder sb2 = new StringBuilder(50);

   // Constructor with an initial string
   StringBuilder sb3 = new StringBuilder("Hello");
   ```

2. **`append(String str)`**
   - Appends the specified string to this character sequence.
   ```java
   StringBuilder sb = new StringBuilder("Hello");
   sb.append(", World!");
   System.out.println(sb.toString());  // Output: Hello, World!
   ```

3. **`insert(int offset, String str)`**
   - Inserts the specified string at the specified position.
   ```java
   sb.insert(5, " Java");
   System.out.println(sb.toString());  // Output: Hello Java, World!
   ```

4. **`replace(int start, int end, String str)`**
   - Replaces the characters in a substring of this sequence with characters in the specified string.
   ```java
   sb.replace(6, 10, "Awesome");
   System.out.println(sb.toString());  // Output: Hello Awesome, World!
   ```

5. **`delete(int start, int end)`**
   - Removes the characters in a substring of this sequence.
   ```java
   sb.delete(5, 13);
   System.out.println(sb.toString());  // Output: Hello, World!
   ```

6. **`deleteCharAt(int index)`**
   - Removes the character at the specified position.
   ```java
   sb.deleteCharAt(5);
   System.out.println(sb.toString());  // Output: HelloWorld!
   ```

7. **`reverse()`**
   - Reverses the sequence of characters.
   ```java
   sb.reverse();
   System.out.println(sb.toString());  // Output: !dlroWolleH
   ```

8. **`setCharAt(int index, char ch)`**
   - Sets the character at the specified position to the specified character.
   ```java
   sb.setCharAt(0, 'h');
   System.out.println(sb.toString());  // Output: !dlroWolleh
   ```

9. **`toString()`**
   - Converts the `StringBuilder` to a `String`.
   ```java
   String str = sb.toString();
   System.out.println(str);  // Output: !dlroWolleh
   ```

10. **`capacity()`**
    - Returns the current capacity of the `StringBuilder`.
    ```java
    int capacity = sb.capacity();
    System.out.println("Capacity: " + capacity);  // Output: Capacity: 34 (initial capacity + length of string)
    ```

11. **`ensureCapacity(int minimumCapacity)`**
    - Ensures that the capacity is at least equal to the specified minimum.
    ```java
    sb.ensureCapacity(50);
    System.out.println("New Capacity: " + sb.capacity());  // Output: New Capacity: 70
    ```

12. **`setLength(int newLength)`**
    - Sets the length of the character sequence.
    ```java
    sb.setLength(5);
    System.out.println(sb.toString());  // Output: !dlro
    ```

13. **`substring(int start)`**
    - Returns a new `String` that contains a subsequence of characters currently contained in this sequence.
    ```java
    String subStr = sb.substring(1);
    System.out.println(subStr);  // Output: dlro
    ```

14. **`substring(int start, int end)`**
    - Returns a new `String` that contains a subsequence of characters currently contained in this sequence from `start` to `end - 1`.
    ```java
    String subStr = sb.substring(1, 3);
    System.out.println(subStr);  // Output: dl
    ```

### Example Usage of `StringBuilder`

Here's a complete example demonstrating various operations using `StringBuilder`:

```java
public class StringBuilderExample {
    public static void main(String[] args) {
        // Create a new StringBuilder with initial content
        StringBuilder sb = new StringBuilder("Hello");

        // Append text
        sb.append(", World!");
        System.out.println("After append: " + sb.toString());

        // Insert text
        sb.insert(5, " Java");
        System.out.println("After insert: " + sb.toString());

        // Replace text
        sb.replace(6, 10, "Awesome");
        System.out.println("After replace: " + sb.toString());

        // Delete text
        sb.delete(5, 13);
        System.out.println("After delete: " + sb.toString());

        // Delete character at a specific position
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb.toString());

        // Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());

        // Set a character at a specific position
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: " + sb.toString());

        // Convert to string
        String str = sb.toString();
        System.out.println("Converted to String: " + str);

        // Get capacity
        int capacity = sb.capacity();
        System.out.println("Capacity: " + capacity);

        // Ensure capacity
        sb.ensureCapacity(50);
        System.out.println("New Capacity: " + sb.capacity());

        // Set length
        sb.setLength(5);
        System.out.println("After setLength: " + sb.toString());

        // Get substring
        String subStr = sb.substring(1, 3);
        System.out.println("Substring (1, 3): " + subStr);
    }
}
```

This example showcases the creation and manipulation of a `StringBuilder` object, demonstrating how to perform various operations such as appending, inserting, replacing, deleting, reversing, and converting to a `String`. The `StringBuilder` class is a powerful tool for string manipulation in Java, especially in single-threaded environments where performance is critical.