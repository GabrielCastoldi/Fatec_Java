import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n1;
        int n2;

        System.out.println("\nDigite um numero inteiro:");
        n1 = scan.nextInt();

        System.out.println("\nDigite outro numero inteiro:");
        n2 = scan.nextInt();

        if (n1 == n2) {
            System.out.println("Numeros Iguais");
        } else {
            System.out.println("Numeros Diferentes");
        }
    }
}