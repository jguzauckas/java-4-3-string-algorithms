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

Our `for` loop




# `while` Loops

Just like `if` statements and its counterparts can change the flow of control in a program, another way to adjust the flow of control is to try and repeat certain lines of code some number of times. Depending on how it is set up, this means we could run a line of code no times (kind of like skipping with an `if` satement), one time (like just running it normally), or many times (this is actual repeating!).

There are two primary types of loops we will be looking at in this unit: `while` loops and `for` loops. In this section, we'll be learning about the `while` loop.

---

## `while` Loops

A `while` loop functions much like an `if` statement, as it has a `boolean` condition. In an `if` statement, if the `boolean` condition is `true`, we execute the line(s) of code, and if it is `false`, we skip the line(s) of code. In a `while` loop, the `boolean` condition controls whether we execute the line(s) of code in the exact same way at the beginning. The difference is if the `boolean` condition was `true` and we ran the line(s) of code, then we go back up and check the `boolean` condition again and continue. The `while` loop will continue to execute the line(s) of code until the `boolean` condition is `false`, then it moves on.

The simplest `while` loops would run forever, repeating the line(s) of code until the program is closed by the user. Here is an example that prints out `"Hello, World!"` over and over from the `NotesWhile1.java` file by setting the `while` `boolean` condition to be `true`:

```java
while(true) {
    System.out.println("Hello, World!");
}
```

Just like an `if` statement, we rarely write in `true` or `false` and expect the computer to calculate a `boolean` value using relational or logical operators. In this example from the `NotesWhile2.java` file, we can see it still creates an infinite loop because the relational operator will always return `true`:

```java
int x = 10;
while(x > 5) {
    System.out.println("Hello, World!");
}
```

We know that since `x` is defined as `10`, `10 > 5` is always `true`, and so this loop will run infinitely, which we often refer to as an **infinite loop**.

If we modified that example to have a `boolean` condition of `false`, it would not print anything, just like a normal `if` statement. Here is the same example with the value of `x` modified to return `false` instead from the `NotesWhile3.java` file:

```java
int x = 0;
while(x > 5) {
    System.out.println("Hello, World!");
}
```

When this program is run, nothing happens, since `0 < 5` is `false`!

While loops that never run and infinite loops are both possible and do happen sometimes, the more realistic example is one that runs some number of times and stops!

---

## Finite `while` Loops

How would a `boolean` condition change while a loop is running? The power of iteration comes from the fact that we can use it to modify variables as it runs, and those updated values can effect the result of the loop's `boolean` condition.

A great starting example is printing out the whole numbers 1 to 5. This is something we've been able to tackle since Unit 1, since all we need is some print statements (or just one with escape characters!). In the past, this could have looked something like this:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println(4);
System.out.println(5);
```

or like this:

```java
System.out.println("1\n2\n3\n4\n5");
```

These are fine solutions, but what if I want you to print out 1 to 10, or 1 to 100? These two solutions become painful as the number of numbers I want you to print goes up. This is a great place for iteration to help us out. While each print statement needs to be different, they are very similar and follow a clear pattern. What would make sense in this case would be a loop that starts with a variable at `1`, prints its value, increments (adds 1) to its value, and repeats! We can use the `boolean` condition to make sure that the value printed out never goes higher than we want. Here is what this would look like from the `NotesFiniteWhile1.java` file:

```java
int count = 1;
while (count <= 5) {
    System.out.println(count);
    count++;
}
```

This produces the same output as our simpler examples above, meaning it works! The `boolean` condition is a key aspect of this solution. If our goal is to print 1 to 5, then we want to print as long as our variable `count` is less than or equal to 5. Once the variable `count` becomes 6, the `boolean` condition will return `false` and end the loop.

The order of the lines in this example is also important. Since my variable `count` started with a value of 1, I want to make sure I print out the value of `count` *before* I increment, hence the print coming before the increment. If I changed the order of those two lines inside of the loop, this would print out the numbers 2 to 6, since it would increment the 1 to a 2 and start there. It would go up to 6 because `count` would start the block with a value of 5, get incremented to 6, print the 6, and then check the `boolean` condition again. Please use caution when organizing your lines of code and setting up your boolean condition!

The nicest part of this solution is that if I wanted to change how high it counts, I just need to change the `boolean` condition. Modifying it to `count <= 10` would print 1 to 10, and `count <= 100` would print 1 to 100.

---

## Interactions with `return`

Loops can execute lines of code multiple times, but in methods that have a `return` statement, the interaction can get a little strange.

Since `return` changes the control flow of a program by ending a method, it will also end a loop in the process. Here is a method that will try to use a loop to count up to a value, but `return` ends early:

```java
public static int count() {
    int count = 1;
    while (count <= 5) {
        System.out.println(count);
        count++;
        return count;
    }
    return count;
}
```

When we call this method in the `NotesReturn1.java` file, we can see that it does not print out the numbers 1 to 5 as we expect: instead it prints out 1 and returns the value 2:

```java
System.out.println(count());
```

This is the nature of `return`, ending a method ends any loops running inside that method!

---

## Standard Algorithms

Loops offer us a new way to work with information, and thus brings us into the world of algorithms. An algorithm is defined as "a process or set of rules to be followed in calculations or other problem-solving operations, especially by a computer." Many algorithms require repetition from the computer, for it to do something over and over again in order to determine that answer to a problem, and this is the specialty of loops!

In this section, we will introduce **standard algorithms** that use loops, which are traditional ways to use loops to solve certain problems. All of the algorithms found below can be found in the `NotesAlgorithms1.java` file.

### Algorithm 1: Identify if an integer is or is not evenly divisible by another integer

If an integer is evenly divisible by another integer, this means that the division would have no remainder (a remainder of 0).

We want to know given an integer, if anything below it divides nicely into it. If there is an integer between 1 and our number that divides it, we would call our integer **composite**. If there is no number between 1 and our number that divides it nicely, we would call our integer **prime**. Since all numbers are divisible by 1, we should start at 2.

The easiest way to do this is to check each number between 1 and our integer and see if they divide it. If any of them do, we would say it is divisible by another integer, or `true`, and if none of them do, we would say it is not evenly divisible by another integer, or `false`.

```java
public static boolean divisibility(int number) {
    int count = 2;
    while (count < number) {
        if (number % count == 0) {
            return true;
        }
        count++;
    }
    return false;
}
```

Notice that in this algorithm, I used an `if` statement inside of a `while` loop. This will check for divisibility with every number as it counts up, and will break out and return `true` if we find any numbers that it is divisible by. Notice also I didn't use an `else` for `return false`, since we only want to return false after we've checked every option!

Calling this method on 11 by using `divisibility(11)`, we expect the value to be `false`, since 11 is prime and nothing between 1 and 11 divides it evenly. On the other hand, calling this method on 15 by using `divisibility(15)`, we expect the value to be `true`, since 15 is composite and is divisible by 3 and 5.

### Algorithm 2: Identify the individual digits in an integer

By using the remainder operator with 10, we can determine the last place value of a number. For example, in the number 153, `153 % 10` is 3, which tells us that the one's place of this number is 3.

If we then divide our number by 10 with integer division, we effectively cut off its one's place and shift everything over. With the same example number 153, we can do `153 / 10` is 15. Once we've gotten our number to 15, we can do the remainder from above again to get `15 % 10`, which is 5, and now we've gotten what was originally in the ten's place of our number. We can repeat this to get each place value in a number regardless of how big the number is (outside of Java's integer limitations).

```java
public static void places(int number) {
    while (number > 0) {
        System.out.println(number % 10);
        number /= 10;
    }
}
```

The only odd thing about this algorithm is that it prints out the places from right to left, which is counter to what we'd expect, but regardless, it identifies the individual digits in an integer.

Calling this method on 153 by using `places(153)`, we expect it to print `3`, `5`, and `1` on different lines. Calling this method on 123456 by using `places(123456)`, we expect it to print out `6`, `5`, `4`, `3`, `2`, and `1` on different lines.

### Algorithm 3: Determine the frequency with which a certain criteria is met

Sometimes we might ask how many times a condition is met in some set of values. As an example, I might ask how many numbers between 1 and `max` are prime? To do this, we can utilize our first algorithm, that can tell us whether or not an individual number is divisible by anything else. If we utilize that `divisibility` method, we would want to count up the number of times it returns `false` when called with each number between 1 and `max`.

```java
public static int countPrimes(int max) {
    int count = 0;
    int currentNumber = 2;
    while (currentNumber <= max) {
        if (divisibility(currentNumber) == false) {
            count++;
        }
        currentNumber++;
    }
    return count;
}
```

Our `while` loop allows us to go through each possible value of `currentNumber`, which will start at 2 and count up to our `max` number. This approach of using a loop to evaluate each and every option is very common.

Our `if` statement allows us to check a condition every time and determine if it meets the criteria. In this case, the criteria is if the `divisibility` method returns `false`, which would mean the number is prime. Another way to have written the condition would have been `!divisibility(currentNumber)`, since this would become `true`, only when the `divisibility` method returns `false`, which is what we would want.

Calling this method on 100 by using `countPrimes(100)`, we expect it to return 25. Calling this method on 1000 by using `countPrimes(1000)`, we expect it to return 168.

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
