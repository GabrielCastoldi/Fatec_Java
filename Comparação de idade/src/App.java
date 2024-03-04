import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String nome1;
        String nome2;
        int idade1;
        int idade2;

        System.out.println("\nDigite o nome da primera pessoa: ");
        nome1 = scan.next();

        System.out.println("\nDigite a idade da primeira pessoa: ");
        idade1 = scan.nextInt();

        System.out.println("\nDigite o nome da segunda pessoa: ");
        nome2 = scan.next();

        System.out.println("\nDigite a idade da segunda pessoa: ");
        idade2 = scan.nextInt();

        if (idade1 > idade2) {
            System.out.println("O " + nome1 + " é mais velho que " + nome2);
        } else {
            System.out.println("O " + nome2 + " é mais velho que " + nome1);
        }
    }
}