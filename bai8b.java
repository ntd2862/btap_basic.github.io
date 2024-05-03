public class bai8b {
    public static void main(String[] args) {
        System.out.println("Palindrome numbers with six digits and divisible by 10:");
        for (int number = 100000; number < 1000000; number++) {
            if (isPalindrome(number) && sumOfDigits(number) % 10 == 0) {
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

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
