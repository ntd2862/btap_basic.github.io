public class bai7 {
    public static void main(String[] args) {
        System.out.println("Prime numbers with odd digits (6 digits):");
        findPrimeNumbersWithOddDigits();
    }

    public static void findPrimeNumbersWithOddDigits() {
        int count = 0;
        for (int i = 100001; i <= 999999; i += 2) {
            if (isPrime(i) && hasOnlyOddDigits(i)) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No prime numbers with odd digits (6 digits) found.");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasOnlyOddDigits(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
