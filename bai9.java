public class bai9 {
    public static void main(String[] args) {
        findThuanNghich();
    }

    public static void findThuanNghich() {
        for (int i = 7; i <= 999999999; i++) {
            if (isThuanNghich(i) && containsOnly068(i) && sumOfDigitsDivisibleBy10(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isThuanNghich(int num) {
        int reverse = 0;
        int originalNum = num;

        while (num != 0) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }

        return originalNum == reverse;
    }

    public static boolean containsOnly068(int num) {
        while (num != 0) {
            int digit = num % 10;
            if (digit != 0 && digit != 6 && digit != 8) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static boolean sumOfDigitsDivisibleBy10(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 10 == 0;
    }
}
