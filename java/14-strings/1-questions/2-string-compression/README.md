**Problem Statement: String Compression**

Implement a function that performs basic string compression using the counts of consecutive repeated characters. Specifically, replace sequences of the same character with that character followed by the number of times it appears consecutively. If the compressed string is not shorter than the original string, the function should return the original string. Assume the input string consists only of uppercase and lowercase letters (a–z).

**Function Signature:**

```java
public static String compressString(String str)
```

**Input:**

- `str`: A non-null string containing only uppercase and lowercase English letters.

**Output:**

- A string representing the compressed version of the input string. If the compressed string is not shorter than the original, return the original string.

**Examples:**

1. Input: `"aabcccccaaa"`
   Output: `"a2b1c5a3"`

2. Input: `"abcdef"`
   Output: `"abcdef"`

3. Input: `"aa"`
   Output: `"aa"`

**Constraints:**

- The function should handle both uppercase and lowercase letters.
- The function should return the original string if the compressed version is not shorter.

**Note:**

This problem is adapted from "Cracking the Coding Interview" by Gayle Laakmann McDowell. 