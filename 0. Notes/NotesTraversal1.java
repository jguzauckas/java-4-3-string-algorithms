public class NotesTraversal1 {
    public static void main(String[] args) {
        String strHello = "Hello, World!";

        int index = 0;
        while (index < strHello.length()) {
            System.out.println(strHello.substring(index, index + 1));
            index++;
        }

        for(int i = 0; i < strHello.length(); i++) {
            System.out.println(strHello.substring(i, i + 1));
        }
    }
}
