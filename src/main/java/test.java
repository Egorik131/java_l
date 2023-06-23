import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print("Input a number: ");
            int num = in.nextInt();
            System.out.printf("Your number: %d \n", num);
        }
        in.close();
    }
}
