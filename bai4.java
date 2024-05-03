import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        System.out.println("Các cặp số nguyên tố cùng nhau trong đoạn [" + a + ", " + b + "]:");
        printPrimePairs(a, b);
    }

    public static void printPrimePairs(int a, int b) {
        for (int i = a; i <= b; i++) {
            for (int j = i + 1; j <= b; j++) {
                if (isPrime(i) && isPrime(j) && gcd(i, j) == 1) {
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
