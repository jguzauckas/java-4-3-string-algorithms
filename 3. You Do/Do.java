public class Do {
    public static String removeLetter(String str, String targetChar) {
        // Your work goes here
    }

    public static void doubleEverything(String str) {
        // Your work goes here
    }

    public static void main (String[] args){
        System.out.println(removeLetter("Hello, World!", "l")); // Should be "Heo, Word!"
        System.out.println(removeLetter("Hi, what's up?", "f")); // Should be "Hi, what's up?"
        System.out.println(removeLetter("aaaaaa", "a")); // Should be ""
        doubleEverything("Hello, World!"); // Should be "HHeelllloo,,  WWoorrlldd"
        doubleEverything(""); // Should be ""
        doubleEverything("Hi Hi"); // Should be "HHii HHii"
    }
}
