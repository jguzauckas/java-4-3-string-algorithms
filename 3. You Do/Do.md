# You Do

Use the knowledge from the standard algorithms in the notes to finish the `removeLetter` and `doubleEverything` methods.

The goal of the `removeLetter` method is that given a `String` `str` and a single character `String` `targetChar`, we want to return the original `String` with the provided character removed. i.e. `removeLetter("Hello, World!", "l")` would return `"Heo, Word!"` since it doesn't include any of the `"l"` characters from the original, `removeLetter("Hi, what's up?", "f")` would return `"Hi, what's up"` without any modifications because it didn't have the letter `"f"` to remove, and `removeLetter("aaaaaa", "a")` would return `""`.

The goal of the `doubleEverything` method is that given a `String` `str` to print out the same `String` but every character is repeated an extra time. i.e. `doubleEverything(Hello, World!")` would print `"HHeelllloo,,  WWoorrlldd!!"`, `doubleEverything("")` would return `""` since there were no letters to double, and `doubleEverything("Hi Hi")` would return `"HHii  HHii"`.

Note that there are pre-loaded tests in the main method. When done correctly, the file should run and print the expected answers.

Once you have gotten to just warnings, save the Java file and commit and push your changes via GitHub Desktop.