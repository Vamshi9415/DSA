# Java String Functions

The Java `String` class provides a wide range of methods for string manipulation and inspection. Below is a comprehensive list of `String` methods along with descriptions and examples.

---

## **1. Character Inspection**

### `char charAt(int index)`
- **Description**: Returns the character at the specified index.
- **Example**:
  ```java
  String str = "Hello";
  char ch = str.charAt(1); // 'e'
  ```

### `int codePointAt(int index)`
- **Description**: Returns the Unicode code point at the specified index.
- **Example**:
  ```java
  int codePoint = "A".codePointAt(0); // 65
  ```

### `int codePointBefore(int index)`
- **Description**: Returns the Unicode code point before the specified index.
- **Example**:
  ```java
  int codePoint = "AB".codePointBefore(1); // 65
  ```

### `int codePointCount(int beginIndex, int endIndex)`
- **Description**: Returns the number of Unicode code points in the specified text range.
- **Example**:
  ```java
  int count = "Hello".codePointCount(0, 5); // 5
  ```

---

## **2. String Comparison**

### `boolean equals(Object anObject)`
- **Description**: Compares this string to the specified object.
- **Example**:
  ```java
  boolean isEqual = "Hello".equals("Hello"); // true
  ```

### `boolean equalsIgnoreCase(String anotherString)`
- **Description**: Compares strings ignoring case considerations.
- **Example**:
  ```java
  boolean isEqual = "hello".equalsIgnoreCase("Hello"); // true
  ```

### `int compareTo(String anotherString)`
- **Description**: Compares two strings lexicographically.
- **Example**:
  ```java
  int result = "apple".compareTo("banana"); // -1
  ```

### `int compareToIgnoreCase(String str)`
- **Description**: Compares two strings lexicographically, ignoring case differences.
- **Example**:
  ```java
  int result = "apple".compareToIgnoreCase("Banana"); // -1
  ```

---

## **3. Searching**

### `boolean contains(CharSequence sequence)`
- **Description**: Checks if the sequence is present in the string.
- **Example**:
  ```java
  boolean contains = "Hello World".contains("World"); // true
  ```

### `boolean startsWith(String prefix)`
- **Description**: Tests if the string starts with the specified prefix.
- **Example**:
  ```java
  boolean starts = "Java".startsWith("Ja"); // true
  ```

### `boolean startsWith(String prefix, int toffset)`
- **Description**: Tests if the string starts with the prefix beginning at the specified index.
- **Example**:
  ```java
  boolean starts = "Hello World".startsWith("World", 6); // true
  ```

### `boolean endsWith(String suffix)`
- **Description**: Tests if the string ends with the specified suffix.
- **Example**:
  ```java
  boolean ends = "Java".endsWith("va"); // true
  ```

### `int indexOf(String str)`
- **Description**: Returns the index of the first occurrence of the substring.
- **Example**:
  ```java
  int index = "Hello World".indexOf("World"); // 6
  ```

### `int lastIndexOf(String str)`
- **Description**: Returns the index of the last occurrence of the substring.
- **Example**:
  ```java
  int lastIndex = "banana".lastIndexOf("na"); // 4
  ```

---

## **4. String Modification**

### `String concat(String str)`
- **Description**: Concatenates the specified string to the end.
- **Example**:
  ```java
  String result = "Hello".concat(" World"); // "Hello World"
  ```

### `String replace(char oldChar, char newChar)`
- **Description**: Replaces all occurrences of a character.
- **Example**:
  ```java
  String replaced = "hello".replace('l', 'p'); // "heppo"
  ```

### `String replace(CharSequence target, CharSequence replacement)`
- **Description**: Replaces each substring matching the target sequence.
- **Example**:
  ```java
  String replaced = "Hello World".replace("World", "Java"); // "Hello Java"
  ```

### `String replaceAll(String regex, String replacement)`
- **Description**: Replaces each substring that matches the regex.
- **Example**:
  ```java
  String replaced = "a1b2c3".replaceAll("\\d", ""); // "abc"
  ```

### `String replaceFirst(String regex, String replacement)`
- **Description**: Replaces the first substring matching the regex.
- **Example**:
  ```java
  String replaced = "a1b2c3".replaceFirst("\\d", ""); // "ab2c3"
  ```

---

## **5. String Splitting and Joining**

### `String[] split(String regex)`
- **Description**: Splits the string around matches of the regex.
- **Example**:
  ```java
  String[] parts = "a,b,c".split(","); // ["a", "b", "c"]
  ```

### `String[] split(String regex, int limit)`
- **Description**: Splits the string around matches of the regex, with a limit on the number of substrings.
- **Example**:
  ```java
  String[] parts = "a,b,c".split(",", 2); // ["a", "b,c"]
  ```

---

## **6. String Trimming**

### `String trim()`
- **Description**: Removes leading and trailing whitespace.
- **Example**:
  ```java
  String trimmed = "  Hello  ".trim(); // "Hello"
  ```

---

## **7. String Case Conversion**

### `String toLowerCase()`
- **Description**: Converts all characters to lowercase.
- **Example**:
  ```java
  String lower = "JAVA".toLowerCase(); // "java"
  ```

### `String toUpperCase()`
- **Description**: Converts all characters to uppercase.
- **Example**:
  ```java
  String upper = "java".toUpperCase(); // "JAVA"
  ```

---

## **8. String Length and Emptiness**

### `int length()`
- **Description**: Returns the length of the string.
- **Example**:
  ```java
  int len = "Hello".length(); // 5
  ```

### `boolean isEmpty()`
- **Description**: Tests if the string is empty.
- **Example**:
  ```java
  boolean empty = "".isEmpty(); // true
  ```

---

## **9. Substrings**

### `String substring(int beginIndex)`
- **Description**: Returns a substring starting from the specified index.
- **Example**:
  ```java
  String sub = "Hello".substring(2); // "llo"
  ```

### `String substring(int beginIndex, int endIndex)`
- **Description**: Returns a substring between the specified indices.
- **Example**:
  ```java
  String sub = "Hello".substring(1, 4); // "ell"
  ```

---

## **10. Conversion**

### `byte[] getBytes()`
- **Description**: Encodes the string into a sequence of bytes.
- **Example**:
  ```java
  byte[] bytes = "Hello".getBytes();
  ```

### `char[] toCharArray()`
- **Description**: Converts the string into a character array.
- **Example**:
  ```java
  char[] chars = "Hello".toCharArray();
  ```

### `static String valueOf(int i
### `static String valueOf(int i)`
- **Description**: Returns the string representation of the int argument.
- **Example**:
    ```java
    String str = String.valueOf(123); // "123"
    ```

### `static String valueOf(char c)`
- **Description**: Returns the string representation of the char argument.
- **Example**:
    ```java
    String str = String.valueOf('a'); // "a"
    ```

### `static String valueOf(boolean b)`
- **Description**: Returns the string representation of the boolean argument.
- **Example**:
    ```java
    String str = String.valueOf(true); // "true"
    ```

### `static String valueOf(double d)`
- **Description**: Returns the string representation of the double argument.
- **Example**:
    ```java
    String str = String.valueOf(1.23); // "1.23"
    ```

### `static String valueOf(Object obj)`
- **Description**: Returns the string representation of the Object argument.
- **Example**:
    ```java
    String str = String.valueOf(new Object()); // "java.lang.Object@<hashcode>"
    ```

---

## **11. Formatting**

### `String format(String format, Object... args)`
- **Description**: Returns a formatted string using the specified format string and arguments.
- **Example**:
    ```java
    String formatted = String.format("Name: %s, Age: %d", "John", 25); // "Name: John, Age: 25"
    ```

### `String join(CharSequence delimiter, CharSequence... elements)`
- **Description**: Returns a new string composed of copies of the CharSequence elements joined together with a copy of the specified delimiter.
- **Example**:
    ```java
    String joined = String.join(", ", "a", "b", "c"); // "a, b, c"
    ```

---

## **12. Miscellaneous**

### `String intern()`
- **Description**: Returns a canonical representation for the string object.
- **Example**:
    ```java
    String str1 = new String("Hello").intern();
    String str2 = "Hello";
    boolean isSame = (str1 == str2); // true
    ```

### `boolean matches(String regex)`
- **Description**: Tells whether or not this string matches the given regular expression.
- **Example**:
    ```java
    boolean matches = "123".matches("\\d+"); // true
    ```

### `String repeat(int count)`
- **Description**: Returns a string whose value is the concatenation of this string repeated count times.
- **Example**:
    ```java
    String repeated = "abc".repeat(3); // "abcabcabc"
    ```

### `String strip()`
- **Description**: Returns a string whose value is this string, with all leading and trailing white space removed.
- **Example**:
    ```java
    String stripped = "  Hello  ".strip(); // "Hello"
    ```

### `String stripLeading()`
- **Description**: Returns a string whose value is this string, with all leading white space removed.
- **Example**:
    ```java
    String strippedLeading = "  Hello  ".stripLeading(); // "Hello  "
    ```

### `String stripTrailing()`
- **Description**: Returns a string whose value is this string, with all trailing white space removed.
- **Example**:
    ```java
    String strippedTrailing = "  Hello  ".stripTrailing(); // "  Hello"
    ```

---

This concludes the list of commonly used Java `String` methods. Each method provides a unique way to manipulate and inspect strings, making the `String` class a powerful tool for developers.







































































































