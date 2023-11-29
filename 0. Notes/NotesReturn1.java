public class NotesReturn1 {
    public static int count() {
        int count = 1;
        while (count <= 5) {
            System.out.println(count);
            count++;
            return count;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count());
    }
}
