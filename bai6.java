import java.util.Scanner;

public class bai6 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương từ bàn phím: ");
        int number = scanner.nextInt();
        scanner.close();
        
        if (number <= 1) {
            System.out.println("Số bạn nhập phải lớn hơn 1.");
            return;
        }
        
        int[] primeFactors = findPrimeFactors(number);
        
        System.out.print("Phân tích số " + number + " thành các thừa số nguyên tố: ");
        for (int i = 0; i < primeFactors.length; i++) {
            if (primeFactors[i] != 0) {
                System.out.print(primeFactors[i]);
                if (i < primeFactors.length - 1 && primeFactors[i + 1] != 0) {
                    System.out.print(" x ");
                }
            }
        }
    }
    
    public static int[] findPrimeFactors(int number) {
        int[] factors = new int[100]; // Khai báo mảng có thể chứa tối đa 100 thừa số nguyên tố
        int index = 0;
        
        while (number % 2 == 0) {
            factors[index++] = 2;
            number /= 2;
        }
        
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors[index++] = i;
                number /= i;
            }
        }
        
        if (number > 2) {
            factors[index++] = number;
        }
        
        return factors;
    }
}
