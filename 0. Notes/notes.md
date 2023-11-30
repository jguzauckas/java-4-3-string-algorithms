# Developing Algorithms Using Strings

Our experiences with iteration so far have been largely with numbers and (obviously) booleans. While not a primitive type, we have done a lot of work with `String` objects in this course, as they are a unique type of object compared to numbers and booleans. The difficulty is, how do `String` objects interact with iteration? We can't exactly just count up like we did with numbers, can we?

---

## `String` Traversal

The way we would want to use `String` objects with a loop is to go through each individual letter of a `String`, to do any number of things, referred to as **`String` traversal** (traverse meaning to move across/through). To accomplish `String` traversal, we utilize our primary way of interacting with the letters of a `String`: indices (plural of index). As established in Unit 2, each character in a `String` object is assigned an index, a unique numeric value that we can use to access that character using methods like `substring()`. As a quick refresher, `String` indices are zero-indexed, meaning that the first character is assigned the value `0`, the second `1`, and so on. Here is an example `String` broken down into its indices:

```java
"  H  e  l  l  o  ,     W  o  r  l  d  !  "
   0  1  2  3  4  5  6  7  8  9  10 11 12
```

The `String` above has a length of `13` when using the `length()` method, but its highest index is 12. `String` traversal then, utilizes this property of `String` objects. We know that loops are good at counting, we've been using it to accomplish numerical tasks. Now, we can use that same counting to go through each character by counting through the indices!

Here is a basic example from the `NotesTraversal1.java` file that demonstrates using a `while` or `for` loop to go through and print out each character of a `String` object:

```java
String strHello = "Hello, World!";

int index = 0;
while (index < strHello.length()) {
    System.out.println(strHello.substring(index, index + 1));
    index++;
}

for(int i = 0; i < strHello.length(); i++) {
    System.out.println(strHello.substring(i, i + 1));
}
```

Like stated in Unit 4 Section 2, `while` and `for` loops can always be used interchangeably and equivalently, so both of the above examples do the exact same task. Some notes on how these loops accomplish their task:
- The loop control variable, `index` for `while` and `i` for `for`, starts at `0` since the first index of a `String` object is `0`.
- The `boolean` condition for each loop is similar as well, they compare the loop control variable against the length of the `String` object being accessed using its `length()` method. This allows our loop to work for a `String` of any length, as it will dynamically understand how long the `String` object it is using is. Using `<` instead of `<=` ensures that we won't try to access an index higher than the last available. The value provided by `length()` is by definition one higher than the last index, so using `<=` would cause a `StringIndexOutOfBoundsError`.
- Finally, the print statement in both utilizes the `substring()` method with a strategy from Unit 2. Anytime you want to access a single character from a `String` object, we can use the `substring()` method with the index we want, represented by the loop control variable and have it stop at the same value plus 1, which since `substring()` doesn't include the ending index, will result in just the single character.

Another way we might consider `String` traversal would be to not look at individual letters, but look at small groups of letters to perform other actions. As an example, here is all the pairs of letters in the order they appear in the `String` `"Hello, World!"`:

```
He
el
ll
lo
o,
, 
 W
Wo
or
rl
ld
d!
```

Note that while there are `13` characters in the `String` `"Hello, World!"` according to `length()`, there are only `12` pairs in a row. This is because while we start at 0, we have to end a letter earlier, since if we went all the way to the `"!"`, there is no letter to come after it to make a pair. We could do the same thing with triplets:

```
Hel
ell
llo
lo,
o, 
, W
 Wo
Wor
orl
rld
ld!
```

Again, the number of options is reduced to `11` because we have to end earlier. Now, we have to end at `"l"` because neither `"d"` nor `"!"` have enough letters after them to make a triplet.

Believe it or not, this is not too different from what we've already done, as it still uses the `substring()` method, but now we need to be more considerate about our ending index when using `substring()`, and how many loops we do! Here is an example from the `NotesTraversal2.java` file that uses a `while` loop to print all the pairs of letters and a `for` loop to print all of the triplets of letters:

```java
String strHello = "Hello, World!";

int index = 0;
while (index < strHello.length() - 1) {
    System.out.println(strHello.substring(index, index + 2));
    index++;
}

for(int i = 0; i < strHello.length() - 2; i++) {
    System.out.println(strHello.substring(i, i + 3));
}
```

This code should look extremely similar to our first example from the `NotesTraversal1.java` file because it is! There are only 4 lines of code that have changed to shape this new kind of output.

1. The first change was to the `boolean` conditions in each of the loops, affecting 2 lines of code. The `boolean` condition for `while` was originally `index < strHello.length()`, but it has been modified to be `index < strHello.length() - 1`. The `- 1` reflects what we noticed about the number of pairs of letters, where we need to stop earlier since the last letter, `"!"`, doesn't have a letter after it to make a pair. The `- 1` cuts it off after the letter `"d"` so that we don't cause a `StringIndexOutOfBoundsError`. Similarly in the `for` loop, the `boolean` condition was `i < strHello.length()` and it has been modified to `i < strHello.length() - 3` for the same reason! We need to stop two letters early to prevent an error.
2. The second change was to the `substring()` method calls in the print statements, affecting the other 2 lines of code. The `substring()` in the `while` loop was originally `strHello.substring(index, index + 1)`, since we only wanted one letter. Since now we wanted two letters, we can modify the ending index to be `index + 2` instead of `index + 1`. Similarly in the `for` loop, we can change the ending index from `i + 1` to `i + 3` to include three letters!

---

## Standard Algorithms

With `String` traversal available to us, we can use loops to solve some standard problems with `String` objects.

### Algorithm 1: Find if one or more substrings has a particular property

In this kind of algorithm, *particular property* refers to the idea of a substring meeting some condition. A specific example for us to try and solve for is "does the given `String` include the word `"or"`?". There is some emphasis here on "find *if* one or more substrings has a particular property". This kind of algorithm isn't wondering *how many* substrings meet a requirement, just whether or not any do.

To do this, we can just use our `String` traversal to go through each pair of letters (since `"or"` has two letters), and inside of the loop we can check whether or not the current pair of letters is equivalent to `"or"` using the `equals()` method. If we ever find one that is equivalent, we can `return true;` and call it a day. After the loop, we should have a `return false;` in case it goes through every combination and doesn't find any matches.

```java
public static boolean containsOr(String str) {
    for (int i = 0; i < str.length() - 1; i++) {
        if (str.substring(i, i + 2).equals("or")) {
            return true;
        }
    }
    return false;
}
```

Our `for` loop will go through each index of the `String` `str`. As it goes through each index, it uses `substring()` to create the letter pair with the letter after our current one. It then compares that to `"or"` to determine if they are equal. If they are equal, we `return true`, and if not, we just continue the loop. If the loop successfully exits, it means we have gone through all the pairs of letters and have not found any equal to `"or"`, so this `String` does not contain `"or"` and we `return false`.

Using this on the `String` `"Hello, World!"` should return `true`, as the indices 8 and 9 make the pair `"or"`, which is what we are looking for. Using this on the `String` `"Hi, what's up?"` would return `false`, as none of the pairs of letters are `"or"`.

### Algorithm 2: Determine the number of substrings that meet specific criteria

This is a problem very similar to Algorithm 1, except now we want to count how many substrings meet a criteria. A specific example for us to solve would be "how many times does the space character `" "` appear in a given `String`." The previous algorithm would have just asked if there is a space character at all, but in this case we want to know how many times it appears.

To do this, we will want to take an approach similar to the last algorithm, where we use traversal this time to go through every letter and check whether or not it is a space character. The difference this time is that we want to count when this happens, as opposed to just returning `true` the first time it happens.

```java
public static int numberOfSpaces(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.substring(i, i + 1).equals(" ")) {
            count++;
        }
    }
    return count;
}
```

Our `for` loop is going through each index of the `String` `str` and using that with `substring()` to get each individual letter. Combining that with the `equals()` method allows it to compare each letter to a space character, and via an `if` statement, decide to increment `count` when the letter is a space character. After the loop ends, we return the value of `count` as the number of space characters we found.

Using this on the `String` `"Hello, World!"` should return `1`, as there will be one space character. Using this on the `String` `"Hi, what's up?"` would return `2`, as there are two space characters in the `String`.

### Algorithm 3: Create a new `String` with the characters reversed

This is a much more specific problem from the start than the previous two examples. In this case, given a `String` object, we just want to return a `String` object with all of the characters provided reversed. For example, if the `String` object was `"Hello, World!"`, our solution should return `"!dlroW ,olleH"`.

The best approach to solve this problem involves building our new `String` object character-by-character by starting with the last character and moving backwards through the original `String` object. This is a great opportunity to demonstrate that loops can count backwards as well by decrementing, not just forwards with incrementing.

```java
public static String reverse(String str) {
    String newStr = "";
    for (int i = str.length() - 1; i >= 0; i--) {
        newStr += str.substring(i, i + 1);
    }
    return newStr;
}
```

In our `for` loop this time, the loop control variable `i` is intialized with the highest index in the provided `String` `str`, which can be found by using the `length()` minus 1. The `boolean` condition shifts to make sure our loop control variable doesn't get too small by checking that it is `>= 0`, and instead of incrementing our loop control variable to go up, we decrement it to move down the indices. With each index, we use `substring()` to get the individual character and concatenation and assignment to add it onto our new `String` `newStr` that we will return once the loop ends.

Using this on the `String` `"Hello, World!"` should return `"!dlroW ,olleH"`, and using this on the `String` `"Hi, what's up?"` would return `"?pu s'tahw ,iH"`.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
