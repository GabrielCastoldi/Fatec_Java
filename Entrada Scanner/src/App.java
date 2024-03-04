import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String nome;
        int idade;
        double altura;
        char sexo;

        System.out.println("\nDigite seu nome:");
        nome = scan.next();

        System.out.println("\nDigite a Idade:");
        idade = scan.nextInt();

        System.out.println("\nDigite sua altura:");
        altura = scan.nextDouble();

        System.out.println("\nDigite o Sexo");
        sexo = scan.next().charAt(0);

        System.out.println("\nDados da pessoa:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Sexo: " + sexo);

    }
}