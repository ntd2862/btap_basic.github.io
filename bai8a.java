public class bai8a {
    public static void main(String[] args) {
        System.out.println("Palindrome numbers with six digits:");
        for (int number = 100000; number < 1000000; number++) {
            if (isPalindrome(number)) {
                System.out.println(number);
            }
        }
    }

    public static boolean isPalindrome(int number) {
        int[] digits = new int[6];
        int index = 0;
        while (number > 0) {
            digits[index++] = number % 10;
            number /= 10;
        }
        for (int i = 0; i < 3; i++) {
            if (digits[i] != digits[5 - i]) {
                return false;
            }
        }
        return true;
    }
}


