import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();
        scanner.close();

        int[] numbers = new int[(n / 2) + 1];
        if (n % 2 == 0) {
            
            for (int i = 0; i <= n / 2; i++) {
                numbers[i] = 2 * i + 2;
            }
        } else {
            
            for (int i = 0; i <= n / 2; i++) {
                numbers[i] = 2 * i + 1;
            }
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Tổng: " + sum);
    }
}
