import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n;
        int maior, menor;

        System.out.println("\nDigite o 1º número:");
        n = scan.nextInt();

        maior = n;
        menor = n;

        for(int i=1; i<5; i++)
        {
            System.out.println("\nDigite o " + (i+1) + "º número:");
            n = scan.nextInt();

            if(n > maior){
                maior = n;
            }
            if(n < menor){
                menor = n;

            }

            System.out.println("\n Maior = " + maior);
            System.out.println("\n Menor = " + menor);

        }
    }
}