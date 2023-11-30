# Understanding Check

Use the knowledge from the standard algorithms in the notes to finish the `replaceWithHi` method.

The goal of the `replaceWithHi` method is to modify a provided `String` value and replace all instances of the `substring()` `"Hello"` with the word `"Hi"`, if any. i.e., `replaceWithHi("Hello, World!")` would return `"Hi, World"`, `replaceWithHi("Hi, what's up?")` wouldn't modify it at all and return `"Hi, what's up?"`, and `replaceWithHi("Hello Hello!")` would return `"Hi Hi"`

This method should not print, it should return!

Some general process tips for this method:
- Use a new `String` variable to slowly build your new `String` using pieces from the original where relevant and putting in new pieces with `"Hi"` when needed.
- When you substitute `"Hi"` in, modify the value of your loop control variable to skip the rest of the word `"Hello"` in the original `String` `str`.
- Use an `if-else` block to either replace with `"Hi"`, or use the current letter.

**This is a hard problem!**

Note that there are pre-loaded tests in the main method. When done correctly, the file should run and print the expected answers.

Once you have gotten to just warnings, save the Java file and commit and push your changes via GitHub Desktop.
