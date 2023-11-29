public class NotesAlgorithms1 {
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

    public static void places(int number) {
        while (number > 0) {
            System.out.println(number % 10);
            number /= 10;
        }
    }

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

    public static void main(String[] args) {
        System.out.println(divisibility(11));
        System.out.println(divisibility(15));
        places(153);
        places(123456);
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(1000));
    }
}
