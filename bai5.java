import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên: ");
        int number = scanner.nextInt();

       
        int[] digits = convertToDigits(number);

    
        int sum = calculateSum(digits);

        System.out.println("Tổng các chữ số của số " + number + " là: " + sum);
    }

    
    public static int[] convertToDigits(int number) {
      
        int count = countDigits(number);
        int[] digits = new int[count];
        
       
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        
        return digits;
    }

    
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

   
    public static int calculateSum(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
}
