public class NotesTraversal2 {
    public static void main(String[] args) {
        String strHello = "Hello, World!";

        int index = 0;
        while (index < strHello.length() - 1) {
            System.out.println(strHello.substring(index, index + 2));
            index++;
        }

        for(int i = 0; i < strHello.length() - 2; i++) {
            System.out.println(strHello.substring(i, i + 3));
        }
    }
}
