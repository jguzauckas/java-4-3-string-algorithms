public class NotesAlgorithms1 {
    public static boolean containsOr(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("or")) {
                return true;
            }
        }
        return false;
    }

    public static int numberOfSpaces(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                count++;
            }
        }
        return count;
    }

    public static String reverse(String str) {
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.substring(i, i + 1);
        }
        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(containsOr("Hello, World!"));
        System.out.println(containsOr("Hi, what's up?"));
        System.out.println(numberOfSpaces("Hello, World!"));
        System.out.println(numberOfSpaces("Hi, what's up?"));
        System.out.println(reverse("Hello, World!"));
        System.out.println(reverse("Hi, what's up?"));
    }
}
