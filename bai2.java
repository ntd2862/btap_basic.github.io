import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tự nhiên n: ");
        int n = scanner.nextInt();
        
        int[] uocSo = new int[n]; 
        int count = 0; 
        
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                uocSo[count++] = i;
            }
        }
        System.out.println("Các ước số của " + n + " là:");
        for (int i = 0; i < count; i++) {
            System.out.print(uocSo[i] + " ");
        }
        System.out.println("\nSố lượng ước số của " + n + " là: " + count);
    }
}
