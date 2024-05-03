import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Nhập số nguyên dương thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên dương thứ hai: ");
        int b = scanner.nextInt();

        
        int ucln = findGCD(a, b);
        int bcnn = findLCM(a, b);

       
        System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + ucln);
        System.out.println("Bội số chung nhỏ nhất của " + a + " và " + b + " là: " + bcnn);
    }

    
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
}
